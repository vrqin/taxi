package com.poctalk.protocols.exceptions;

public class MessageErrorException extends Exception {
    private static final long serialVersionUID = -4188580501788631298L;

    public MessageErrorException() {
    }

    public MessageErrorException(String mess) {
        super(mess);
    }
}
