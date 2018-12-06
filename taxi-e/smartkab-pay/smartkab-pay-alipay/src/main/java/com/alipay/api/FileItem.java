package com.alipay.api;


import com.alipay.api.internal.util.AlipayUtils;

import java.io.*;


public class FileItem {
    private String fileName;
    private String mimeType;
    private byte[] content;
    private File file;


    public FileItem(File file) {
        /*  30 */
        this.file = file;

    }


    public FileItem(String filePath) {
        /*  39 */
        this(new File(filePath));

    }


    public FileItem(String fileName, byte[] content) {
        /*  49 */
        this.fileName = fileName;
        /*  50 */
        this.content = content;

    }


    public FileItem(String fileName, byte[] content, String mimeType) {
        /*  61 */
        this(fileName, content);
        /*  62 */
        this.mimeType = mimeType;

    }


    public String getFileName() {
        /*  66 */
        if ((this.fileName == null) && (this.file != null) && (this.file.exists())) {
            /*  67 */
            this.fileName = this.file.getName();

        }
        /*  69 */
        return this.fileName;

    }


    public String getMimeType() throws IOException {
        /*  73 */
        if (this.mimeType == null) {
            /*  74 */
            this.mimeType = AlipayUtils.getMimeType(getContent());

        }
        /*  76 */
        return this.mimeType;

    }


    public byte[] getContent() throws IOException {
        /*  80 */
        if ((this.content == null) && (this.file != null) && (this.file.exists())) {
            /*  81 */
            InputStream in = null;
            /*  82 */
            ByteArrayOutputStream out = null;

            try {
                /*  85 */
                in = new FileInputStream(this.file);
                /*  86 */
                out = new ByteArrayOutputStream();

                int ch;
                /*  88 */
                while ((ch = in.read()) != -1) {
                    /*  89 */
                    out.write(ch);

                }
                /*  91 */
                this.content = out.toByteArray();

            } finally {
                /*  93 */
                if (out != null) {
                    /*  94 */
                    out.close();

                }
                /*  96 */
                if (in != null) {
                    /*  97 */
                    in.close();

                }

            }

        }
        /* 101 */
        return this.content;

    }

}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.FileItem
 * JD-Core Version:    0.6.0
 */