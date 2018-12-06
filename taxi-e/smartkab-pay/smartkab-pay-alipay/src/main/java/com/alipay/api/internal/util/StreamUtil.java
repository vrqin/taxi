package com.alipay.api.internal.util;


import java.io.*;


public class StreamUtil {
    private static final int DEFAULT_BUFFER_SIZE = 8192;


    public static void io(InputStream in, OutputStream out) throws IOException {
        /*  23 */
        io(in, out, -1);

    }


    public static void io(InputStream in, OutputStream out, int bufferSize) throws IOException {
        /*  27 */
        if (bufferSize == -1) {
            /*  28 */
            bufferSize = 8192;

        }

        /*  31 */
        byte[] buffer = new byte[bufferSize];

        int amount;
        /*  34 */
        while ((amount = in.read(buffer)) >= 0)
            /*  35 */
            out.write(buffer, 0, amount);

    }


    public static void io(Reader in, Writer out) throws IOException {
        /*  40 */
        io(in, out, -1);

    }


    public static void io(Reader in, Writer out, int bufferSize) throws IOException {
        /*  44 */
        if (bufferSize == -1) {
            /*  45 */
            bufferSize = 4096;

        }

        /*  48 */
        char[] buffer = new char[bufferSize];

        int amount;
        /*  51 */
        while ((amount = in.read(buffer)) >= 0)
            /*  52 */
            out.write(buffer, 0, amount);

    }


    public static OutputStream synchronizedOutputStream(OutputStream out) {
        /*  57 */
        return new SynchronizedOutputStream(out);

    }


    public static OutputStream synchronizedOutputStream(OutputStream out, Object lock) {
        /*  61 */
        return new SynchronizedOutputStream(out, lock);

    }


    public static String readText(InputStream in) throws IOException {
        /*  65 */
        return readText(in, null, -1);

    }


    public static String readText(InputStream in, String encoding) throws IOException {
        /*  69 */
        return readText(in, encoding, -1);

    }


    public static String readText(InputStream in, String encoding, int bufferSize) throws IOException {
        /*  74 */
        Reader reader = encoding == null ? new InputStreamReader(in) : new InputStreamReader(in, encoding);

        /*  77 */
        return readText(reader, bufferSize);

    }


    public static String readText(Reader reader) throws IOException {
        /*  81 */
        return readText(reader, -1);

    }


    public static String readText(Reader reader, int bufferSize) throws IOException {
        /*  85 */
        StringWriter writer = new StringWriter();

        /*  87 */
        io(reader, writer, bufferSize);
        /*  88 */
        return writer.toString();

    }

    private static class SynchronizedOutputStream extends OutputStream {
        private OutputStream out;
        private Object lock;


        /*  96 */     SynchronizedOutputStream(OutputStream out) {
            this(out, out);
        }


        SynchronizedOutputStream(OutputStream out, Object lock) {
            /* 100 */
            this.out = out;
            /* 101 */
            this.lock = lock;

        }


        public void write(int datum) throws IOException {
            /* 105 */
            synchronized (this.lock) {
                /* 106 */
                this.out.write(datum);

            }

        }


        public void write(byte[] data) throws IOException {
            /* 111 */
            synchronized (this.lock) {
                /* 112 */
                this.out.write(data);

            }

        }


        public void write(byte[] data, int offset, int length) throws IOException {
            /* 117 */
            synchronized (this.lock) {
                /* 118 */
                this.out.write(data, offset, length);

            }

        }


        public void flush() throws IOException {
            /* 123 */
            synchronized (this.lock) {
                /* 124 */
                this.out.flush();

            }

        }


        public void close() throws IOException {
            /* 129 */
            synchronized (this.lock) {
                /* 130 */
                this.out.close();

            }

        }

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.StreamUtil
 * JD-Core Version:    0.6.0
 */