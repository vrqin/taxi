package com.speedtalk.protocol.tscobjs;

public class UpdateAddrResp extends CommonResp {
    public UpdateAddrResp() {
        /* 11 */
        super(80);
    }

    public UpdateAddrResp(byte result) {
        /* 15 */
        super(80, result);
    }

    public String toString() {
        /* 19 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.UpdateAddrResp
 * JD-Core Version:    0.6.0
 */