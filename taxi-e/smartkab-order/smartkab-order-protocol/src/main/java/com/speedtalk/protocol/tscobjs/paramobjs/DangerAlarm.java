package com.speedtalk.protocol.tscobjs.paramobjs;

import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.constants.ParamConstants;

public class DangerAlarm implements IMsParam {
    private int delay;

    public DangerAlarm(int delay) {
        /* 13 */
        this.delay = delay;
    }

    public int getDelay() {
        /* 22 */
        return this.delay;
    }

    public void setDelay(int delay) {
        /* 31 */
        this.delay = delay;
    }

    public String toString() {
        /* 37 */
        StringBuilder buffer = new StringBuilder();
        /* 38 */
        if (ParamConstants.isDetail()) {
            /* 40 */
            buffer.append(" Danger alarm delay(Millis):");
            /* 41 */
            buffer.append(getDelay());
        } else {
            /* 44 */
            buffer.append(getDelay());
            /* 45 */
        }
        return buffer.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.paramobjs.DangerAlarm
 * JD-Core Version:    0.6.0
 */