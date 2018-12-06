package com.speedtalk.protocol.tscobjs;

public class HUPResp extends CommonResp {
    public HUPResp() {
        /* 12 */
        super(50);
    }

    public HUPResp(byte result) {
        /* 16 */
        super(50, result);
    }

    public String toString() {
        /* 20 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.HUPResp
 * JD-Core Version:    0.6.0
 */