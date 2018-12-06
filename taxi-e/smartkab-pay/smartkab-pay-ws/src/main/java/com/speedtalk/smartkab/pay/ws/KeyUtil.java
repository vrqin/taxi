package com.speedtalk.smartkab.pay.ws;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

public class KeyUtil {
    private static KeyUtil instance = new KeyUtil();
    private Key key;

    private KeyUtil() {
        try {
            key = KeyStorer.getInstance().getKey();
        } catch (Exception e) {
            e.printStackTrace();
            key = MacProvider.generateKey(SignatureAlgorithm.HS256);
            KeyStorer.getInstance().storeKey(key);
        }
    }

    public static KeyUtil getInstance() {
        if (null == instance)
            instance = new KeyUtil();
        return instance;
    }

    public Key getKey() {
        return key;
    }
}
