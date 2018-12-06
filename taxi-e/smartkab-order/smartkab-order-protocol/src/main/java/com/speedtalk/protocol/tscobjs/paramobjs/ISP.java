package com.speedtalk.protocol.tscobjs.paramobjs;

import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.constants.ParamConstants;

public class ISP implements IMsParam {
    private String isp;
    private String ispPwd;

    public ISP(String isp, String ispPwd) {
        /* 15 */
        this.isp = isp;
        /* 16 */
        this.ispPwd = ispPwd;
    }

    public String getIsp() {
        /* 24 */
        return this.isp;
    }

    public void setIsp(String isp) {
        /* 32 */
        this.isp = isp;
    }

    public String getIspPwd() {
        /* 40 */
        return this.ispPwd;
    }

    public void setIspPwd(String ispPwd) {
        /* 48 */
        this.ispPwd = ispPwd;
    }

    public String toString() {
        /* 53 */
        StringBuilder buffer = new StringBuilder();
        /* 54 */
        if (ParamConstants.isDetail()) {
            /* 56 */
            buffer.append(" ISP user:");
            /* 57 */
            buffer.append(getIsp());

            /* 59 */
            buffer.append(",ISP password:");
            /* 60 */
            buffer.append(getIspPwd());
        } else {
            /* 64 */
            buffer.append(" ");
            /* 65 */
            buffer.append(getIsp());
            /* 66 */
            buffer.append(",");
            /* 67 */
            buffer.append(getIspPwd());
        }

        /* 70 */
        return buffer.toString();
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.paramobjs.ISP
 * JD-Core Version:    0.6.0
 */