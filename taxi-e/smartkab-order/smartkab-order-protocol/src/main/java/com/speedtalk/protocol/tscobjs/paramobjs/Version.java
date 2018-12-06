package com.speedtalk.protocol.tscobjs.paramobjs;

import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.constants.ParamConstants;

public class Version implements IMsParam {
    private String version;

    public Version(String version) {
        /* 15 */
        this.version = version;
    }

    public String getVersion() {
        /* 24 */
        return this.version;
    }

    public void setVersion(String version) {
        /* 33 */
        this.version = version;
    }

    public String toString() {
        /* 39 */
        StringBuilder buffer = new StringBuilder();
        /* 40 */
        if (ParamConstants.isDetail()) {
            /* 42 */
            buffer.append(" Terminal Version:");
            /* 43 */
            buffer.append(getVersion());
        } else {
            /* 47 */
            buffer.append(getVersion());
        }

        /* 50 */
        return buffer.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.paramobjs.Version
 * JD-Core Version:    0.6.0
 */