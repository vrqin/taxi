package com.speedtalk.protocol.exceptions;

public class CheckMistakenException extends Exception {
    private static final long serialVersionUID = 2273322836698298075L;

    public CheckMistakenException() {
    }

    public CheckMistakenException(String str) {
        super(str);
    }
}
