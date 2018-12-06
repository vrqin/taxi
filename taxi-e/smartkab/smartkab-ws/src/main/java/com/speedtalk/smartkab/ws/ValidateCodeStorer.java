package com.speedtalk.smartkab.ws;

import java.util.concurrent.ConcurrentHashMap;

public class ValidateCodeStorer {
    public static final long VALIDATE_CODE_TIME_OUT = 120000;
    private static ConcurrentHashMap<String, ValidateCode> storer = new ConcurrentHashMap<String, ValidateCode>();

    private ValidateCodeStorer() {
    }

    public static ValidateCode store(ValidateCode validateCode) throws IllegalArgumentException {
        if (null == validateCode || null == validateCode.getOwner() || validateCode.getOwner()
                .trim()
                .equals("") || null == validateCode.getCode() || validateCode.getCode().trim().equals(""))
            throw new IllegalArgumentException("validateCode");
        ValidateCode old = storer.get(validateCode.getOwner());
        storer.put(validateCode.getOwner(), validateCode);
        return null == old ? validateCode : old;
    }

    public static ValidateCode get(String owner) throws NullPointerException {
        return storer.get(owner);
    }

    public static void delete(String owner) throws NullPointerException {
        storer.remove(owner);
    }

    public static boolean isTimeout(ValidateCode validateCode) {
        try {
            return System.currentTimeMillis() - validateCode.getTime() > VALIDATE_CODE_TIME_OUT;
        } catch (Exception e) {
            return true;
        }
    }
}
