package com.speedtalk.protocol.tscobjs;

public class PTTResp extends CommonResp {
    public PTTResp() {
        /* 11 */
        super(36);
    }

    public PTTResp(byte result) {
        /* 15 */
        super(36, result);
    }

    public String toString() {
        /* 19 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.PTTResp
 * JD-Core Version:    0.6.0
 */