package com.speedtalk.protocol.tscobjs;

public class SMSResp extends CommonResp {
    public SMSResp() {
        /* 12 */
        super(24);
    }

    public SMSResp(byte result) {
        /* 16 */
        super(24, result);
    }

    public String toString() {
        /* 20 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.SMSResp
 * JD-Core Version:    0.6.0
 */