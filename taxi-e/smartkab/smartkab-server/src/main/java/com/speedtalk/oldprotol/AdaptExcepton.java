package com.speedtalk.oldprotol;

public class AdaptExcepton extends Exception {
    private static final long serialVersionUID = -3586701489126764942L;

    public AdaptExcepton() {
        super();
    }

    public AdaptExcepton(String s) {
        super(s);
    }

    public AdaptExcepton(Throwable t) {
        super(t);
    }
}
