package com.speedtalk.utils;

import java.io.*;
import java.text.SimpleDateFormat;

public class ExcepPrinter {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    public static void init(String filename) {

        PrintStream err = null;

        File file = new File(filename);
        try {

            err = new PrintStream(new BufferedOutputStream(new FileOutputStream(file, true)), true);
        } catch (FileNotFoundException fnfex) {

            fnfex.printStackTrace();
        }


        System.setErr(err);
    }

    public static void print(Exception ex) {

        System.err.print(sdf.format(Long.valueOf(System.currentTimeMillis())));

        ex.printStackTrace();
    }

    public static void printThrow(Throwable cause) {

        System.err.print(sdf.format(Long.valueOf(System.currentTimeMillis())));

        cause.printStackTrace();
    }
}
