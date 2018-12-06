package com.alipay.api.internal.util.json;

public class BufferErrorListener implements JSONErrorListener {
    protected StringBuilder buffer;
    private String input;

    public BufferErrorListener(StringBuilder buffer) {
        /*  9 */
        this.buffer = buffer;
    }

    public BufferErrorListener() {
        /* 13 */
        this(new StringBuilder());
    }

    public void start(String input) {
        /* 17 */
        this.input = input;
        /* 18 */
        this.buffer.setLength(0);
    }

    public void error(String type, int col) {
        /* 22 */
        this.buffer.append("expected ");
        /* 23 */
        this.buffer.append(type);
        /* 24 */
        this.buffer.append(" at column ");
        /* 25 */
        this.buffer.append(col);
        /* 26 */
        this.buffer.append("\n");
        /* 27 */
        this.buffer.append(this.input);
        /* 28 */
        this.buffer.append("\n");
        /* 29 */
        indent(col - 1, this.buffer);
        /* 30 */
        this.buffer.append("^");
    }

    private void indent(int n, StringBuilder ret) {
        /* 34 */
        for (int i = 0; i < n; i++)
            /* 35 */
            ret.append(' ');
    }

    public void end() {
    }
}

/* Location:           C:\Users\huangzhike\Desktop\alipay-sdk-java20160829220059\
 * Qualified Name:     com.alipay.api.internal.util.json.BufferErrorListener
 * JD-Core Version:    0.6.0
 */