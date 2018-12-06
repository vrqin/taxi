package com.speedtalk.protocol.tscobjs;

public class RemoveTempGrp extends QueryGroup {
    public RemoveTempGrp() {
        /* 16 */
        setMessID(39);
    }

    public RemoveTempGrp(byte type) {
        /* 20 */
        super(type);
        /* 21 */
        setMessID(39);
    }

    public String toString() {
        /* 25 */
        return super.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.RemoveTempGrp
 * JD-Core Version:    0.6.0
 */