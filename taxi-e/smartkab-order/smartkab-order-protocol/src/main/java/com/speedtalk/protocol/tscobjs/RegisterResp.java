package com.speedtalk.protocol.tscobjs;

public class RegisterResp extends CommonResp {
    public RegisterResp() {
        /* 12 */
        super(2);
    }

    public RegisterResp(byte result) {
        /* 16 */
        super(2, result);
    }

    public String toString() {
        /* 20 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.RegisterResp
 * JD-Core Version:    0.6.0
 */