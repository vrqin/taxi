package com.poctalk.utils;

import com.speedtalk.utils.ExcepPrinter;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class StringUtils {
    public StringUtils() {
    }

    public static String checkStr(String source) {
        String str = "";
        if (source != null) {
            str = source;
        }

        return str;
    }

    public static int exchangeStr(String source) {
        int exStr = -1;
        if (source != null && !source.equals("")) {
            try {
                exStr = Integer.parseInt(source);
            } catch (NumberFormatException var3) {
                ExcepPrinter.print(var3);
                return exStr;
            }
        }

        return exStr;
    }

    public static int exchangeHexStr(String source) {
        int exStr = -1;
        if (source != null && !source.equals("")) {
            try {
                exStr = Integer.parseInt(source, 16);
            } catch (NumberFormatException var3) {
                ExcepPrinter.print(var3);
                return exStr;
            }
        }

        return exStr;
    }

    public static String formatDate(long currentTimeMillis, String pattern) {
        String date = "";
        SimpleDateFormat sdf = null;
        if (pattern != null && !pattern.equals("")) {
            sdf = new SimpleDateFormat(pattern);
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }

        date = sdf.format(currentTimeMillis);
        return date;
    }

    public static String getCurrentUTCTime(String pattern, String timeZone) {
        DateFormat formatter = null;
        TimeZone currentTimeZone = null;

        try {
            if (pattern != null && !pattern.equals("")) {
                formatter = new SimpleDateFormat(pattern);
            } else {
                formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            }

            if (timeZone != null && !timeZone.equals("")) {
                currentTimeZone = TimeZone.getTimeZone(timeZone);
            } else {
                currentTimeZone = TimeZone.getTimeZone("GMT");
            }

            formatter.setTimeZone(currentTimeZone);
        } catch (Exception var5) {
            return null;
        }

        return formatter.format(System.currentTimeMillis());
    }

    public static String string2UTCTime(String timeStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date giveDate = null;

        try {
            giveDate = dateFormat.parse(timeStr);
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            dateFormat.setTimeZone(timeZone);
        } catch (Exception var4) {
            ExcepPrinter.print(var4);
            return null;
        }

        return dateFormat.format(giveDate);
    }

    public static byte[] getMD5(byte[] source) {
        byte[] md5Byte = (byte[]) null;
        if (source != null) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(source);
                md5Byte = md.digest();
            } catch (NoSuchAlgorithmException var3) {
                ;
            }
        }

        return md5Byte;
    }

    public static String getMD5String(String sourceStr) {
        String md5String = null;
        if (sourceStr != null) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] md5Byte = md5.digest(sourceStr.getBytes());
                md5String = buff2HexAsciiString(md5Byte).replace(" ", "").toUpperCase();
            } catch (Exception var4) {
                ;
            }
        }

        return md5String;
    }

    public static int exchangeInt(int input) {
        try {
            return Integer.parseInt(String.valueOf(input), 16);
        } catch (Exception var2) {
            return -1;
        }
    }

    public static String toHexAsciiString(String input) {
        if (input != null && !input.equals("")) {
            StringBuilder hexAscii = new StringBuilder();
            int j = 0;
            char[] inputChar = input.toCharArray();

            for (int i = 0; i < inputChar.length; ++i) {
                int j = inputChar[i];
                hexAscii.append(Integer.toHexString(j));
            }

            return hexAscii.toString();
        } else {
            return "";
        }
    }

    public static String updatePort(String sourceIPort, String port) {
        if (sourceIPort != null && sourceIPort.indexOf(":") != -1 && port != null) {
            int iLocate = sourceIPort.indexOf(":");
            sourceIPort = sourceIPort.substring(0, iLocate);
            return sourceIPort + ":" + port;
        } else {
            return null;
        }
    }

    public static String buff2HexAsciiString(byte[] buff) {
        StringBuilder buffStr = new StringBuilder();
        String tempStr = null;
        if (buff != null) {
            for (int i = 0; i < buff.length; ++i) {
                tempStr = Integer.toHexString(buff[i] & 255);
                if (tempStr.length() == 1) {
                    tempStr = '0' + tempStr;
                }

                buffStr.append(tempStr);
                buffStr.append(" ");
            }
        }

        return buffStr.toString();
    }

    public static String exchangeTimestamp(String timestamp) {
        if (timestamp != null && !timestamp.equals("")) {
            if (timestamp.length() < 10) {
                StringBuilder timestampBuffer = new StringBuilder("0");
                timestampBuffer.append(timestamp);
                return timestampBuffer.toString();
            } else {
                return timestamp;
            }
        } else {
            return null;
        }
    }

    public static String changeCharset(String sourceStr, String charset) {
        try {
            return charset != null && !charset.equals("") ? new String(sourceStr.getBytes(), charset) : new String(sourceStr
                    .getBytes(), "GBK");
        } catch (NullPointerException var3) {
            return null;
        } catch (UnsupportedEncodingException var4) {
            return null;
        }
    }

    public static String exchangelementValue(String eValue) {
        if (eValue != null && !eValue.equals("")) {
            String newElementValue = new String("");
            char[] ev = eValue.toCharArray();

            for (int i = 0; i < eValue.length(); ++i) {
                if (ev[i] == '<') {
                    newElementValue = newElementValue + "&lt;";
                } else if (ev[i] == '>') {
                    newElementValue = newElementValue + "&gt;";
                } else if (ev[i] == '&') {
                    newElementValue = newElementValue + "&amp;";
                } else if (String.valueOf(ev[i]).equals("'")) {
                    newElementValue = newElementValue + "&apos;";
                } else if (ev[i] == '"') {
                    newElementValue = newElementValue + "&quot;";
                } else {
                    newElementValue = newElementValue + ev[i];
                }
            }

            return newElementValue;
        } else {
            return "";
        }
    }

    public static int byte2Int(byte[] data, int start) {
        return data != null && data.length - start > 3 ? data[start] & 255 | data[start + 1] & 255 | data[start + 2] & 255 | data[start + 3] & 255 : -1;
    }

    public static String byte2String(byte[] buff) {
        StringBuilder buffStr = new StringBuilder();
        String tempStr = null;
        if (buff != null) {
            for (int i = 0; i < buff.length; ++i) {
                tempStr = Integer.toHexString(buff[i] & 255);
                if (tempStr.length() == 1) {
                    buffStr.append('0');
                }

                buffStr.append(tempStr);
            }
        }

        return buffStr.toString();
    }

    public static String byteToString(byte b) {
        byte maskHigh = -16;
        byte maskLow = 15;
        byte high = (byte) ((b & maskHigh) >> 4);
        byte low = (byte) (b & maskLow);
        StringBuilder buf = new StringBuilder();
        buf.append(findHex(high));
        buf.append(findHex(low));
        return buf.toString();
    }

    private static char findHex(byte b) {
        int t = (new Byte(b)).intValue();
        t = t < 0 ? t + 16 : t;
        return t >= 0 && t <= 9 ? (char) (t + 48) : (char) (t - 10 + 65);
    }

    public static void main(String[] args) {
    }
}
