package com.alipay.api.internal.util.json;


import java.text.CharacterIterator;
import java.text.StringCharacterIterator;


public class JSONValidator {
    private JSONErrorListener listener;
    private CharacterIterator it;
    private char c;
    private int col;


    public JSONValidator(JSONErrorListener listener) {
        /*  14 */
        this.listener = listener;

    }


    public boolean validate(String input) {
        /*  18 */
        input = input.trim();
        /*  19 */
        this.listener.start(input);
        /*  20 */
        boolean ret = valid(input);
        /*  21 */
        this.listener.end();
        /*  22 */
        return ret;

    }


    private boolean valid(String input) {
        /*  26 */
        if ("".equals(input))
            return true;

        /*  28 */
        boolean ret = true;
        /*  29 */
        this.it = new StringCharacterIterator(input);
        /*  30 */
        this.c = this.it.first();
        /*  31 */
        this.col = 1;
        /*  32 */
        if (!value()) {
            /*  33 */
            ret = error("value", 1);

        } else {
            /*  35 */
            skipWhiteSpace();
            /*  36 */
            if (this.c != 65535) {
                /*  37 */
                ret = error("end", this.col);

            }

        }

        /*  41 */
        return ret;

    }


    private boolean value() {
        /*  45 */
        return (literal("true")) || (literal("false")) || (literal("null")) || (string()) || (number()) || (object()) || (array());

    }


    private boolean literal(String text) {
        /*  56 */
        CharacterIterator ci = new StringCharacterIterator(text);
        /*  57 */
        char t = ci.first();
        /*  58 */
        if (this.c != t)
            return false;

        /*  60 */
        int start = this.col;
        /*  61 */
        boolean ret = true;
        /*  62 */
        for (t = ci.next(); t != 65535; t = ci.next()) {
            /*  63 */
            if (t != nextCharacter()) {
                /*  64 */
                ret = false;
                /*  65 */
                break;

            }

        }
        /*  68 */
        nextCharacter();

        /*  70 */
        if (!ret)
            error("literal " + text, start);
        /*  71 */
        return ret;

    }


    private boolean array() {
        /*  75 */
        return aggregate('[', ']', false);

    }


    private boolean object() {
        /*  79 */
        return aggregate('{', '}', true);

    }


    private boolean aggregate(char entryCharacter, char exitCharacter, boolean prefix) {
        /*  83 */
        if (this.c != entryCharacter)
            return false;
        /*  84 */
        nextCharacter();
        /*  85 */
        skipWhiteSpace();
        /*  86 */
        if (this.c == exitCharacter) {
            /*  87 */
            nextCharacter();
            /*  88 */
            return true;

        }

        while (true) {
            /*  92 */
            if (prefix) {
                /*  93 */
                int start = this.col;
                /*  94 */
                if (!string())
                    return error("string", start);
                /*  95 */
                skipWhiteSpace();
                /*  96 */
                if (this.c != ':')
                    return error("colon", this.col);
                /*  97 */
                nextCharacter();
                /*  98 */
                skipWhiteSpace();

            }
            /* 100 */
            if (value()) {
                /* 101 */
                skipWhiteSpace();
                /* 102 */
                if (this.c == ',') {
                    /* 103 */
                    nextCharacter();
                } else {
                    /* 104 */
                    if (this.c == exitCharacter) {

                        break;

                    }
                    /* 107 */
                    return error("comma or " + exitCharacter, this.col);

                }

            } else {
                /* 110 */
                return error("value", this.col);

            }
            /* 112 */
            skipWhiteSpace();

        }

        /* 115 */
        nextCharacter();
        /* 116 */
        return true;

    }


    private boolean number() {
        /* 120 */
        if ((!Character.isDigit(this.c)) && (this.c != '-'))
            return false;
        /* 121 */
        int start = this.col;

        /* 123 */
        if (this.c == '-')
            nextCharacter();

        /* 125 */
        if (this.c == '0') {
            /* 126 */
            nextCharacter();
        } else {
            /* 127 */
            if (Character.isDigit(this.c)) {
                /* 128 */
                while (Character.isDigit(this.c))
                    nextCharacter();

            }
            /* 130 */
            return error("number", start);

        }

        /* 133 */
        if (this.c == '.') {
            /* 134 */
            nextCharacter();
            /* 135 */
            if (Character.isDigit(this.c)) {
                /* 136 */
                while (Character.isDigit(this.c))
                    nextCharacter();

            }
            /* 138 */
            return error("number", start);

        }

        /* 142 */
        if ((this.c == 'e') || (this.c == 'E')) {
            /* 143 */
            nextCharacter();
            /* 144 */
            if ((this.c == '+') || (this.c == '-')) {
                /* 145 */
                nextCharacter();

            }
            /* 147 */
            if (Character.isDigit(this.c)) {
                /* 148 */
                while (Character.isDigit(this.c))
                    nextCharacter();

            }
            /* 150 */
            return error("number", start);

        }

        /* 154 */
        return true;

    }


    private boolean string() {
        /* 158 */
        if (this.c != '"')
            return false;

        /* 160 */
        int start = this.col;
        /* 161 */
        boolean escaped = false;

        /* 163 */
        for (nextCharacter(); this.c != 65535; nextCharacter()) {
            /* 164 */
            if ((!escaped) && (this.c == '\\')) {
                /* 165 */
                escaped = true;
                /* 166 */
            } else if (escaped) {
                /* 167 */
                if (!escape()) {
                    /* 168 */
                    return false;

                }
                /* 170 */
                escaped = false;
                /* 171 */
            } else if (this.c == '"') {
                /* 172 */
                nextCharacter();
                /* 173 */
                return true;

            }

        }

        /* 177 */
        return error("quoted string", start);

    }


    private boolean escape() {
        /* 181 */
        int start = this.col - 1;
        /* 182 */
        if ("\\\"/bfnrtu".indexOf(this.c) < 0) {
            /* 183 */
            return error("escape sequence \\\",\\\\,\\/,\\b,\\f,\\n,\\r,\\t or \\uxxxx", start);

        }
        /* 185 */
        if ((this.c == 'u') && (
                /* 186 */       (!ishex(nextCharacter())) || (!ishex(nextCharacter())) || (!ishex(nextCharacter())) || (!ishex(nextCharacter())))) {
            /* 188 */
            return error("unicode escape sequence \\uxxxx", start);

        }

        /* 191 */
        return true;

    }


    private boolean ishex(char d) {
        /* 195 */
        return "0123456789abcdefABCDEF".indexOf(this.c) >= 0;

    }


    private char nextCharacter() {
        /* 199 */
        this.c = this.it.next();
        /* 200 */
        this.col += 1;
        /* 201 */
        return this.c;

    }


    private void skipWhiteSpace() {
        /* 205 */
        while (Character.isWhitespace(this.c))
            /* 206 */
            nextCharacter();

    }


    private boolean error(String type, int col) {
        /* 211 */
        if (this.listener != null)
            this.listener.error(type, col);
        /* 212 */
        return false;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.JSONValidator
 * JD-Core Version:    0.6.0
 */