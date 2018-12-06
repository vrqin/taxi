package com.speedtalk.protocol.tscobjs;

public class EditTempGrpResp extends CommonResp {
    public EditTempGrpResp() {
        /* 12 */
        super(64);
    }

    public EditTempGrpResp(byte result) {
        /* 16 */
        super(64, result);
    }

    public String toString() {
        /* 20 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.EditTempGrpResp
 * JD-Core Version:    0.6.0
 */