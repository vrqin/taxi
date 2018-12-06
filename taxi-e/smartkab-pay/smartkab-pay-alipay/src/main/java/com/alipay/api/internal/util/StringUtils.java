package com.alipay.api.internal.util;


public abstract class StringUtils {

    public static boolean isEmpty(String value) {

        int strLen;
        /*  27 */
        if ((value == null) || ((strLen = value.length()) == 0))
            /*  28 */
            return true;

        int strLen;
        /*  30 */
        for (int i = 0; i < strLen; i++) {
            /*  31 */
            if (!Character.isWhitespace(value.charAt(i))) {
                /*  32 */
                return false;

            }

        }
        /*  35 */
        return true;

    }


    public static boolean isNumeric(Object obj) {
        /*  42 */
        if (obj == null) {
            /*  43 */
            return false;

        }
        /*  45 */
        char[] chars = obj.toString().toCharArray();
        /*  46 */
        int length = chars.length;
        /*  47 */
        if (length < 1) {
            /*  48 */
            return false;

        }
        /*  50 */
        int i = 0;
        /*  51 */
        if ((length > 1) && (chars[0] == '-')) {
            /*  52 */
            i = 1;

        }
        /*  54 */
        for (; i < length; i++) {
            /*  55 */
            if (!Character.isDigit(chars[i])) {
                /*  56 */
                return false;

            }

        }
        /*  59 */
        return true;

    }


    public static boolean areNotEmpty(String[] values) {
        /*  66 */
        boolean result = true;
        /*  67 */
        if ((values == null) || (values.length == 0))
            /*  68 */
            result = false;

        else {
            /*  70 */
            for (String value : values) {
                /*  71 */
                result &= !isEmpty(value);

            }

        }
        /*  74 */
        return result;

    }


    public static String unicodeToChinese(String unicode) {
        /*  81 */
        StringBuilder out = new StringBuilder();
        /*  82 */
        if (!isEmpty(unicode)) {
            /*  83 */
            for (int i = 0; i < unicode.length(); i++) {
                /*  84 */
                out.append(unicode.charAt(i));

            }

        }
        /*  87 */
        return out.toString();

    }


    public static String stripNonValidXMLCharacters(String input) {
        /*  94 */
        if ((input == null) || ("".equals(input)))
            /*  95 */
            return "";
        /*  96 */
        StringBuilder out = new StringBuilder();

        /*  98 */
        for (int i = 0; i < input.length(); i++) {
            /*  99 */
            char current = input.charAt(i);
            /* 100 */
            if ((current != '\t') && (current != '\n') && (current != '\r') && ((current < ' ') || (current > 55295)) && ((current < 57344) || (current > 65533)) && ((current < 65536) || (current > 1114111))) {

                continue;

            }
            /* 104 */
            out.append(current);

        }
        /* 106 */
        return out.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.StringUtils
 * JD-Core Version:    0.6.0
 */