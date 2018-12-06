package com.alipay.api.internal.util.json;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class JSONReader {
    public static final int FIRST = 0;
    public static final int CURRENT = 1;
    public static final int NEXT = 2;
    /*  19 */   private static final Object OBJECT_END = new Object();
    /*  20 */   private static final Object ARRAY_END = new Object();
    /*  21 */   private static final Object COLON = new Object();
    /*  22 */   private static final Object COMMA = new Object();
    /*  27 */   private static Map<Character, Character> escapes = new HashMap();


    static {
        /*  29 */
        escapes.put(Character.valueOf('"'), Character.valueOf('"'));
        /*  30 */
        escapes.put(Character.valueOf('\\'), Character.valueOf('\\'));
        /*  31 */
        escapes.put(Character.valueOf('/'), Character.valueOf('/'));
        /*  32 */
        escapes.put(Character.valueOf('b'), Character.valueOf('\b'));
        /*  33 */
        escapes.put(Character.valueOf('f'), Character.valueOf('\f'));
        /*  34 */
        escapes.put(Character.valueOf('n'), Character.valueOf('\n'));
        /*  35 */
        escapes.put(Character.valueOf('r'), Character.valueOf('\r'));
        /*  36 */
        escapes.put(Character.valueOf('t'), Character.valueOf('\t'));

    }

    private CharacterIterator it;
    private char c;
    private Object token;
    /*  42 */   private StringBuilder buf = new StringBuilder();


    private char next() {
        /*  45 */
        this.c = this.it.next();
        /*  46 */
        return this.c;

    }


    private void skipWhiteSpace() {
        /*  50 */
        while (Character.isWhitespace(this.c))
            /*  51 */
            next();

    }


    public Object read(CharacterIterator ci, int start) {
        /*  56 */
        this.it = ci;
        /*  57 */
        switch (start) {

            case 0:
                /*  59 */
                this.c = this.it.first();
                /*  60 */
                break;

            case 1:
                /*  62 */
                this.c = this.it.current();
                /*  63 */
                break;

            case 2:
                /*  65 */
                this.c = this.it.next();

        }

        /*  68 */
        return read();

    }


    public Object read(CharacterIterator it) {
        /*  72 */
        return read(it, 2);

    }


    public Object read(String string) {
        /*  76 */
        return read(new StringCharacterIterator(string), 0);

    }


    private Object read() {
        /*  80 */
        skipWhiteSpace();
        /*  81 */
        char ch = this.c;
        /*  82 */
        next();
        /*  83 */
        switch (ch) {
            case '"':
                /*  84 */
                this.token = string();
                break;

            case '[':
                /*  85 */
                this.token = array();
                break;

            case ']':
                /*  86 */
                this.token = ARRAY_END;
                break;

            case ',':
                /*  87 */
                this.token = COMMA;
                break;

            case '{':
                /*  88 */
                this.token = object();
                break;

            case '}':
                /*  89 */
                this.token = OBJECT_END;
                break;

            case ':':
                /*  90 */
                this.token = COLON;
                break;

            case 't':
                /*  92 */
                next();
                next();
                next();
                /*  93 */
                this.token = Boolean.TRUE;
                /*  94 */
                break;

            case 'f':
                /*  96 */
                next();
                next();
                next();
                next();
                /*  97 */
                this.token = Boolean.FALSE;
                /*  98 */
                break;

            case 'n':
                /* 100 */
                next();
                next();
                next();
                /* 101 */
                this.token = null;
                /* 102 */
                break;

            default:
                /* 104 */
                this.c = this.it.previous();
                /* 105 */
                if ((!Character.isDigit(this.c)) && (this.c != '-'))
                    break;
                /* 106 */
                this.token = number();

        }

        /* 110 */
        return this.token;

    }


    private Object object() {
        /* 114 */
        Map ret = new HashMap();
        /* 115 */
        Object key = read();
        /* 116 */
        while (this.token != OBJECT_END) {
            /* 117 */
            read();
            /* 118 */
            if (this.token != OBJECT_END) {
                /* 119 */
                ret.put(key, read());
                /* 120 */
                if (read() == COMMA) {
                    /* 121 */
                    key = read();

                }

            }

        }

        /* 126 */
        return ret;

    }


    private Object array() {
        /* 130 */
        List ret = new ArrayList();
        /* 131 */
        Object value = read();
        /* 132 */
        while (this.token != ARRAY_END) {
            /* 133 */
            ret.add(value);
            /* 134 */
            if (read() == COMMA) {
                /* 135 */
                value = read();

            }

        }
        /* 138 */
        return ret;

    }


    private Object number() {
        /* 142 */
        int length = 0;
        /* 143 */
        boolean isFloatingPoint = false;
        /* 144 */
        this.buf.setLength(0);

        /* 146 */
        if (this.c == '-') {
            /* 147 */
            add();

        }
        /* 149 */
        length += addDigits();
        /* 150 */
        if (this.c == '.') {
            /* 151 */
            add();
            /* 152 */
            length += addDigits();
            /* 153 */
            isFloatingPoint = true;

        }
        /* 155 */
        if ((this.c == 'e') || (this.c == 'E')) {
            /* 156 */
            add();
            /* 157 */
            if ((this.c == '+') || (this.c == '-')) {
                /* 158 */
                add();

            }
            /* 160 */
            addDigits();
            /* 161 */
            isFloatingPoint = true;

        }

        /* 164 */
        String s = this.buf.toString();
        /* 165 */
        return length < 19 ? Long.valueOf(s) : isFloatingPoint ? new BigDecimal(s) : length < 17 ? Double.valueOf(s) : new BigInteger(s);

    }


    private int addDigits() {
        /* 172 */
        for (int ret = 0; Character.isDigit(this.c); ret++) {
            /* 173 */
            add();

        }
        /* 175 */
        return ret;

    }


    private Object string() {
        /* 179 */
        this.buf.setLength(0);
        /* 180 */
        while (this.c != '"') {
            /* 181 */
            if (this.c == '\\') {
                /* 182 */
                next();
                /* 183 */
                if (this.c == 'u') {
                    /* 184 */
                    add(unicode());
                    continue;

                }
                /* 186 */
                Object value = escapes.get(Character.valueOf(this.c));
                /* 187 */
                if (value != null) {
                    /* 188 */
                    add(((Character) value).charValue());

                }
                /* 190 */
                continue;

            }
            /* 192 */
            add();

        }

        /* 195 */
        next();

        /* 197 */
        return this.buf.toString();

    }


    private void add(char cc) {
        /* 201 */
        this.buf.append(cc);
        /* 202 */
        next();

    }


    private void add() {
        /* 206 */
        add(this.c);

    }


    private char unicode() {
        /* 210 */
        int value = 0;
        /* 211 */
        for (int i = 0; i < 4; i++)
            /* 212 */
            switch (next()) {
                case '0':

                case '1':

                case '2':

                case '3':

                case '4':

                case '5':

                case '6':

                case '7':

                case '8':

                case '9':
                    /* 215 */
                    value = (value << 4) + this.c - 48;
                    /* 216 */
                    break;

                case 'a':

                case 'b':

                case 'c':

                case 'd':

                case 'e':

                case 'f':
                    /* 218 */
                    value = (value << 4) + this.c - 107;
                    /* 219 */
                    break;

                case 'A':

                case 'B':

                case 'C':

                case 'D':

                case 'E':

                case 'F':
                    /* 221 */
                    value = (value << 4) + this.c - 75;

                case ':':

                case ';':

                case '<':

                case '=':

                case '>':

                case '?':

                case '@':

                case 'G':

                case 'H':

                case 'I':

                case 'J':

                case 'K':

                case 'L':

                case 'M':

                case 'N':

                case 'O':

                case 'P':

                case 'Q':

                case 'R':

                case 'S':

                case 'T':

                case 'U':

                case 'V':

                case 'W':

                case 'X':

                case 'Y':

                case 'Z':

                case '[':

                case '\\':

                case ']':

                case '^':

                case '_':
                    /* 225 */
                case '`':
            }
        return (char) value;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.JSONReader
 * JD-Core Version:    0.6.0
 */