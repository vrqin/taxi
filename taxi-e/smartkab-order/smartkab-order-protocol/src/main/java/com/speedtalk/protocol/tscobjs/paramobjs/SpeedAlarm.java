package com.speedtalk.protocol.tscobjs.paramobjs;

import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.constants.ParamConstants;

public class SpeedAlarm implements IMsParam {
    private int speed;
    private int delay;

    public SpeedAlarm(int speed, int delay) {
        /* 15 */
        this.speed = speed;
        /* 16 */
        this.delay = delay;
    }

    public int getSpeed() {
        /* 26 */
        return this.speed;
    }

    public void setSpeed(int speed) {
        /* 36 */
        this.speed = speed;
    }

    public int getDelay() {
        /* 46 */
        return this.delay;
    }

    public void setDelay(int delay) {
        /* 56 */
        this.delay = delay;
    }

    public String toString() {
        /* 61 */
        StringBuilder buffer = new StringBuilder();
        /* 62 */
        if (ParamConstants.isDetail()) {
            /* 64 */
            buffer.append(" Speed Alarm，speed:");
            /* 65 */
            buffer.append(getSpeed());

            /* 67 */
            buffer.append(",delay(Millis):");
            /* 68 */
            buffer.append(getDelay());
        } else {
            /* 72 */
            buffer.append(" ");
            /* 73 */
            buffer.append(getSpeed());
            /* 74 */
            buffer.append(",");
            /* 75 */
            buffer.append(getDelay());
        }

        /* 78 */
        return buffer.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.paramobjs.SpeedAlarm
 * JD-Core Version:    0.6.0
 */