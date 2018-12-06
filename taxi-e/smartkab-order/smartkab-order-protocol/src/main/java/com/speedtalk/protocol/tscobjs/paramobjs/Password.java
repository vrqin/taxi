package com.speedtalk.protocol.tscobjs.paramobjs;

import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.constants.ParamConstants;

public class Password implements IMsParam {
    private String pwd;

    public Password(String pwd) {
        /* 14 */
        this.pwd = pwd;
    }

    public String getPwd() {
        /* 24 */
        return this.pwd;
    }

    public void setPwd(String pwd) {
        /* 34 */
        this.pwd = pwd;
    }

    public String toString() {
        /* 39 */
        StringBuilder buffer = new StringBuilder();
        /* 40 */
        if (ParamConstants.isDetail()) {
            /* 42 */
            buffer.append(" Terminal password:");
            /* 43 */
            buffer.append(getPwd());
        } else {
            /* 46 */
            buffer.append(getPwd());
            /* 47 */
        }
        return buffer.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.paramobjs.Password
 * JD-Core Version:    0.6.0
 */