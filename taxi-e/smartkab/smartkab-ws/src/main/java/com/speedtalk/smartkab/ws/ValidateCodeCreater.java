package com.speedtalk.smartkab.ws;

import java.util.Random;

public class ValidateCodeCreater {
    private static Random random = new Random();

    public static String getCode() {
        StringBuilder buf = new StringBuilder();
        int i = 0;
        do {
            i = random.nextInt(10);
        } while (i < 1);
        buf.append(i).append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10));
        return buf.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getCode());
        }
    }
}
