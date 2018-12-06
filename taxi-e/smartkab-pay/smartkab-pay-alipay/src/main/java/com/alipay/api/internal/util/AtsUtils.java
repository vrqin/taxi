package com.alipay.api.internal.util;


import com.alipay.api.AlipayApiException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public abstract class AtsUtils {
    private static final String CTYPE_OCTET = "application/octet-stream";
    /*  33 */   private static final Pattern REGEX_FILE_NAME = Pattern.compile("attachment;filename=\"([\\w\\-]+)\"");


    public static File ungzip(File gzip, File toDir) throws IOException {
        /*  47 */
        toDir.mkdirs();
        /*  48 */
        File out = new File(toDir, gzip.getName());
        /*  49 */
        GZIPInputStream gin = null;
        /*  50 */
        FileOutputStream fout = null;

        try {
            /*  52 */
            FileInputStream fin = new FileInputStream(gzip);
            /*  53 */
            gin = new GZIPInputStream(fin);
            /*  54 */
            fout = new FileOutputStream(out);
            /*  55 */
            copy(gin, fout);
            /*  56 */
            gin.close();
            /*  57 */
            fout.close();

        } finally {
            /*  59 */
            closeQuietly(gin);
            /*  60 */
            closeQuietly(fout);

        }
        /*  62 */
        return out;

    }


    public static List<File> unzip(File zip, File toDir) throws IOException {
        /*  73 */
        ZipFile zf = null;
        /*  74 */
        List files = null;

        try {
            /*  76 */
            zf = new ZipFile(zip);
            /*  77 */
            files = new ArrayList();
            /*  78 */
            Enumeration entries = zf.entries();
            /*  79 */
            while (entries.hasMoreElements()) {
                /*  80 */
                ZipEntry entry = (ZipEntry) entries.nextElement();
                /*  81 */
                if (entry.isDirectory()) {
                    /*  82 */
                    new File(toDir, entry.getName()).mkdirs();
                    /*  83 */
                    continue;

                }

                /*  86 */
                InputStream input = null;
                /*  87 */
                OutputStream output = null;

                try {
                    /*  89 */
                    File f = new File(toDir, entry.getName());
                    /*  90 */
                    input = zf.getInputStream(entry);
                    /*  91 */
                    output = new FileOutputStream(f);
                    /*  92 */
                    copy(input, output);
                    /*  93 */
                    files.add(f);

                } finally {
                    /*  95 */
                    closeQuietly(output);
                    /*  96 */
                    closeQuietly(input);

                }

            }

        } finally {
            /* 100 */
            if (zf != null) {
                /* 101 */
                zf.close();

            }

        }
        /* 104 */
        return files;

    }


    public static File download(String url, File toDir) throws AlipayApiException {
        /* 115 */
        toDir.mkdirs();
        /* 116 */
        HttpURLConnection conn = null;
        /* 117 */
        OutputStream output = null;
        /* 118 */
        File file = null;

        try {
            /* 120 */
            conn = getConnection(new URL(url));
            /* 121 */
            String ctype = conn.getContentType();
            /* 122 */
            if ("application/octet-stream".equals(ctype)) {
                /* 123 */
                String fileName = getFileName(conn);
                /* 124 */
                file = new File(toDir, fileName);
                /* 125 */
                output = new FileOutputStream(file);
                /* 126 */
                copy(conn.getInputStream(), output);

            } else {
                /* 128 */
                String rsp = WebUtils.getResponseAsString(conn);
                /* 129 */
                throw new AlipayApiException(rsp);

            }

        } catch (IOException e) {
            /* 132 */
            throw new AlipayApiException(e.getMessage());

        } finally {
            /* 134 */
            closeQuietly(output);
            /* 135 */
            if (conn != null) {
                /* 136 */
                conn.disconnect();

            }

        }
        /* 139 */
        return file;

    }


    public static boolean checkMd5sum(File file, String checkCode) throws IOException {
        /* 150 */
        DigestInputStream dInput = null;

        try {
            /* 152 */
            FileInputStream fInput = new FileInputStream(file);
            /* 153 */
            dInput = new DigestInputStream(fInput, getMd5Instance());
            /* 154 */
            byte[] buf = new byte[8192];
            /* 155 */
            while (dInput.read(buf) > 0)
                ;
            /* 157 */
            byte[] bytes = dInput.getMessageDigest().digest();
            /* 158 */
            boolean bool = bytes2hex(bytes).equals(checkCode);

            return bool;
        } finally {
            closeQuietly(dInput);
        }
        throw localObject;

    }


    private static String bytes2hex(byte[] bytes) {
        /* 168 */
        StringBuilder sb = new StringBuilder();
        /* 169 */
        for (int i = 0; i < bytes.length; i++) {
            /* 170 */
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            /* 171 */
            if (hex.length() == 1)
                /* 172 */
                sb.append("0").append(hex);

            else {
                /* 174 */
                sb.append(hex);

            }

        }
        /* 177 */
        return sb.toString();

    }


    private static MessageDigest getMd5Instance() {

        try {
            /* 182 */
            return MessageDigest.getInstance("md5");
        } catch (Exception e) {

        }
        /* 184 */
        throw new RuntimeException(e);

    }


    private static String getFileName(HttpURLConnection conn) {
        /* 189 */
        String fileName = conn.getHeaderField("Content-Disposition");
        /* 190 */
        Matcher matcher = REGEX_FILE_NAME.matcher(fileName);
        /* 191 */
        if (matcher.find()) {
            /* 192 */
            return matcher.group(1);

        }
        /* 194 */
        return null;

    }


    private static HttpURLConnection getConnection(URL url) throws IOException {
        /* 199 */
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        /* 200 */
        conn.setRequestMethod("GET");
        /* 201 */
        conn.setDoInput(true);
        /* 202 */
        conn.setDoOutput(true);
        /* 203 */
        conn.setRequestProperty("Accept", "application/zip;text/html");
        /* 204 */
        return conn;

    }


    private static int copy(InputStream input, OutputStream output) throws IOException {
        /* 208 */
        long count = copyStream(input, output);
        /* 209 */
        if (count > 2147483647L) {
            /* 210 */
            return -1;

        }
        /* 212 */
        return (int) count;

    }


    private static long copyStream(InputStream input, OutputStream output) throws IOException {
        /* 216 */
        byte[] buffer = new byte[1024];
        /* 217 */
        long count = 0L;
        /* 218 */
        int n = 0;
        /* 219 */
        while (-1 != (n = input.read(buffer))) {
            /* 220 */
            output.write(buffer, 0, n);
            /* 221 */
            count += n;

        }
        /* 223 */
        return count;

    }


    private static void closeQuietly(OutputStream output) {

        try {
            /* 228 */
            if (output != null)
                /* 229 */
                output.close();

        } catch (IOException ioe) {

        }

    }


    private static void closeQuietly(InputStream input) {

        try {
            /* 238 */
            if (input != null)
                /* 239 */
                input.close();

        } catch (IOException ioe) {

        }

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.AtsUtils
 * JD-Core Version:    0.6.0
 */