package com.speedtalk.protocol.tscobjs.paramobjs;


import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.constants.ParamConstants;


public class IP implements IMsParam {
    private String ip;
    private int port;


    public IP(String ip, int port) {
        /* 15 */
        this.ip = ip;
        /* 16 */
        this.port = port;

    }


    public String getIp() {
        /* 25 */
        return this.ip;

    }


    public void setIp(String ip) {
        /* 33 */
        this.ip = ip;

    }


    public int getPort() {
        /* 41 */
        return this.port;

    }


    public void setPort(int port) {
        /* 49 */
        this.port = port;

    }


    public String toString() {
        /* 55 */
        StringBuilder buffer = new StringBuilder();
        /* 56 */
        if (ParamConstants.isDetail()) {
            /* 58 */
            buffer.append(" IP:");
            /* 59 */
            buffer.append(getIp());
            /* 60 */
            buffer.append(",PORT:");
            /* 61 */
            buffer.append(getPort());

        } else {
            /* 65 */
            buffer.append(" ");
            /* 66 */
            buffer.append(getIp());
            /* 67 */
            buffer.append(",");
            /* 68 */
            buffer.append(getPort());

        }

        /* 71 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.paramobjs.IP
 * JD-Core Version:    0.6.0
 */