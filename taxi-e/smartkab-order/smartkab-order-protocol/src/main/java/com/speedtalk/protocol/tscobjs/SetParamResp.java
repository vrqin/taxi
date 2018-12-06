package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.tscobjs.paramobjs.*;
import com.speedtalk.protocol.tscobjs.paramobjs.GPS;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.protocol.utils.StringUtils;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;


public class SetParamResp extends SetParam {
    private byte result;


    public SetParamResp() {
        /*  36 */
        setMessID(22);

    }


    public SetParamResp(byte operation, byte option, IMsParam content, byte result) {
        /*  40 */
        super(operation, option, content);
        /*  41 */
        setMessID(22);
        /*  42 */
        this.result = result;

    }


    public byte getResult() {
        /*  46 */
        return this.result;

    }


    public void setResult(byte result) {
        /*  54 */
        this.result = result;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  59 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  60 */
            throw new NullPointerException("Src ms id is NULL!");
        /*  61 */
        if ((getDstMsID() == null) || (getDstMsID().trim().equals("")))
            /*  62 */
            throw new NullPointerException("Dst ms id is NULL!");

        try {
            /*  65 */
            int contentLen = 0;
            /*  66 */
            ByteBuffer temp = null;
            /*  67 */
            if ((getOperation() == 0) || (
                    /*  68 */         (getOperation() == 1) && (getResult() != 0))) {
                /*  70 */
                contentLen = 5;
                /*  71 */
                temp = ByteBuffer.allocate(contentLen);
                /*  72 */
                temp.order(ByteOrder.LITTLE_ENDIAN);
                /*  73 */
                temp.put(getOperation());
                /*  74 */
                temp.put(getOption());
                /*  75 */
                temp.put(getResult());
                /*  76 */
                temp.putShort(0);

            } else {
                /*  81 */
                short paramLen = 0;
                /*  82 */
                switch (getOption()) {

                    case 0:
                        /*  85 */
                        Version version = (Version) getContent();

                        try {
                            /*  88 */
                            if ((version != null) && (version.getVersion() != null)) {
                                /*  90 */
                                paramLen =
                                        /*  91 */                 (short) version.getVersion().getBytes(
                                        /*  91 */                 StringUtils.getEncoding()).length;

                            }
                            /*  93 */
                            contentLen = 5 + paramLen;
                            /*  94 */
                            temp = ByteBuffer.allocate(contentLen);
                            /*  95 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /*  96 */
                            temp.put(getOperation());
                            /*  97 */
                            temp.put(getOption());
                            /*  98 */
                            temp.put(getResult());
                            /*  99 */
                            temp.putShort(paramLen);
                            /* 100 */
                            if ((version == null) || (paramLen == 0))
                                break;
                            /* 101 */
                            temp.put(StringUtils.strToBytes(version.getVersion(), paramLen));

                        } catch (Exception localException) {

                        }


                    case 1:
                        /* 108 */
                        ISP isp = (ISP) getContent();

                        try {
                            /* 111 */
                            int ispLen = 0;
                            int ispPwdLen = 0;
                            /* 112 */
                            if ((isp != null) && (isp.getIsp() != null))
                                /* 113 */
                                ispLen += isp.getIsp().getBytes(StringUtils.getEncoding()).length;
                            /* 114 */
                            if ((isp != null) && (isp.getIspPwd() != null))
                                /* 115 */
                                ispPwdLen += isp.getIspPwd().getBytes(StringUtils.getEncoding()).length;
                            /* 116 */
                            paramLen = (short) (paramLen + (ispLen + ispPwdLen + 1));
                            /* 117 */
                            contentLen = 5 + paramLen;
                            /* 118 */
                            temp = ByteBuffer.allocate(contentLen);
                            /* 119 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /* 120 */
                            temp.put(getOperation());
                            /* 121 */
                            temp.put(getOption());
                            /* 122 */
                            temp.put(getResult());
                            /* 123 */
                            temp.putShort(paramLen);
                            /* 124 */
                            if ((isp != null) && (ispLen != 0))
                                /* 125 */
                                temp.put(StringUtils.strToBytes(isp.getIsp(), ispLen));
                            /* 126 */
                            temp.put(",".getBytes(StringUtils.getEncoding()));
                            /* 127 */
                            if ((isp == null) || (ispPwdLen == 0))
                                break;
                            /* 128 */
                            temp.put(StringUtils.strToBytes(isp.getIspPwd(), ispPwdLen));

                        } catch (Exception localException1) {

                        }


                    case 2:
                        /* 135 */
                        IP ip = (IP) getContent();

                        try {
                            /* 138 */
                            int ipLen = 0;
                            int portLen = 0;
                            /* 139 */
                            if ((ip != null) && (ip.getIp() != null))
                                /* 140 */
                                ipLen += ip.getIp().getBytes(StringUtils.getEncoding()).length;
                            /* 141 */
                            if ((ip != null) && (ip.getPort() != 0)) {
                                /* 143 */
                                portLen = portLen + String.valueOf(ip.getPort()).getBytes(
                                        /* 143 */                 StringUtils.getEncoding()).length;
                                /* 144 */
                            }
                            paramLen = (short) (paramLen + (ipLen + portLen + 1));
                            /* 145 */
                            contentLen = 5 + paramLen;
                            /* 146 */
                            temp = ByteBuffer.allocate(contentLen);
                            /* 147 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /* 148 */
                            temp.put(getOperation());
                            /* 149 */
                            temp.put(getOption());
                            /* 150 */
                            temp.put(getResult());
                            /* 151 */
                            temp.putShort(paramLen);
                            /* 152 */
                            if ((ip != null) && (ipLen != 0))
                                /* 153 */
                                temp.put(StringUtils.strToBytes(ip.getIp(), ipLen));
                            /* 154 */
                            temp.put(":".getBytes(StringUtils.getEncoding()));
                            /* 155 */
                            if ((ip == null) || (portLen == 0))
                                break;
                            /* 156 */
                            temp.put(StringUtils.strToBytes(String.valueOf(ip.getPort()),
                                    /* 157 */               portLen));

                        } catch (Exception localException2) {

                        }

                    case 3:
                        /* 163 */
                        Password pwd = (Password) getContent();

                        try {
                            /* 166 */
                            if ((pwd != null) && (pwd.getPwd() != null)) {
                                /* 168 */
                                paramLen = (short) pwd.getPwd().getBytes(StringUtils.getEncoding()).length;

                            }
                            /* 170 */
                            contentLen = 5 + paramLen;
                            /* 171 */
                            temp = ByteBuffer.allocate(contentLen);
                            /* 172 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /* 173 */
                            temp.put(getOperation());
                            /* 174 */
                            temp.put(getOption());
                            /* 175 */
                            temp.put(getResult());
                            /* 176 */
                            temp.putShort(paramLen);
                            /* 177 */
                            if ((pwd == null) || (paramLen == 0))
                                break;
                            /* 178 */
                            temp.put(StringUtils.strToBytes(pwd.getPwd(), paramLen));

                        } catch (Exception localException3) {

                        }

                    case 4:
                        /* 184 */
                        GPS gps = (GPS) getContent();

                        /* 186 */
                        paramLen = 12;
                        /* 187 */
                        contentLen = 5 + paramLen;
                        /* 188 */
                        temp = ByteBuffer.allocate(contentLen);
                        /* 189 */
                        temp.order(ByteOrder.LITTLE_ENDIAN);
                        /* 190 */
                        temp.put(getOperation());
                        /* 191 */
                        temp.put(getOption());
                        /* 192 */
                        temp.put(getResult());
                        /* 193 */
                        temp.putShort(paramLen);
                        /* 194 */
                        temp.putInt(gps == null ? 0 : gps.getMove());

                        /* 196 */
                        temp.putInt(gps == null ? 0 : gps.getDistance());

                        /* 198 */
                        temp.putInt(gps == null ? 0 : gps.getStop());
                        /* 199 */
                        break;

                    case 5:
                        /* 202 */
                        SpeedAlarm speedAlarm = (SpeedAlarm) getContent();
                        /* 203 */
                        paramLen = 8;
                        /* 204 */
                        contentLen = 5 + paramLen;
                        /* 205 */
                        temp = ByteBuffer.allocate(contentLen);
                        /* 206 */
                        temp.order(ByteOrder.LITTLE_ENDIAN);
                        /* 207 */
                        temp.put(getOperation());
                        /* 208 */
                        temp.put(getOption());
                        /* 209 */
                        temp.put(getResult());
                        /* 210 */
                        temp.putShort(paramLen);
                        /* 211 */
                        temp.putInt(speedAlarm == null ? 0 : speedAlarm.getSpeed());

                        /* 213 */
                        temp.putInt(speedAlarm == null ? 0 : speedAlarm.getDelay());
                        /* 214 */
                        break;

                    case 6:
                        /* 217 */
                        DangerAlarm dangerAlarm = (DangerAlarm) getContent();
                        /* 218 */
                        paramLen = 4;
                        /* 219 */
                        contentLen = 5 + paramLen;
                        /* 220 */
                        temp = ByteBuffer.allocate(contentLen);
                        /* 221 */
                        temp.order(ByteOrder.LITTLE_ENDIAN);
                        /* 222 */
                        temp.put(getOperation());
                        /* 223 */
                        temp.put(getOption());
                        /* 224 */
                        temp.put(getResult());
                        /* 225 */
                        temp.putShort(paramLen);
                        /* 226 */
                        temp.putInt(dangerAlarm == null ? 0 : dangerAlarm.getDelay());
                        /* 227 */
                        break;

                }


            }

            /* 232 */
            ByteBuffer buffer = MessageUtils.createHead(34 +
                    /* 233 */         contentLen, (short) contentLen, getMessID(), 0, this);
            /* 234 */
            temp.flip();
            /* 235 */
            buffer.put(temp);
            /* 236 */
            buffer.putShort(MessageUtils.getCRC16(buffer, contentLen));
            /* 237 */
            buffer.put(MessIdConstants.ENDING);
            /* 238 */
            ArrayList resultList = new ArrayList();
            /* 239 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 240 */
            return resultList;

        } catch (Exception localException4) {

        }

        /* 246 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 254 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 260 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 267 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 268 */
            setOperation(buffer.get());
            /* 269 */
            setOption(buffer.get());
            /* 270 */
            setResult(buffer.get());
            /* 271 */
            if (getOperation() == 1) {
                /* 273 */
                short contentLen = buffer.getShort();
                /* 274 */
                byte[] temp = null;
                /* 275 */
                switch (getOption()) {

                    case 0:

                        try {
                            /* 280 */
                            if (contentLen == 0) {
                                /* 282 */
                                setContent(null);

                            } else {
                                /* 286 */
                                temp = new byte[contentLen];
                                /* 287 */
                                buffer.get(temp);
                                /* 288 */
                                Version version = new Version(StringUtils.bytesToStr(temp));
                                /* 289 */
                                setContent(version);

                            }

                        } catch (Exception localException2) {

                        }

                    case 1:

                        try {
                            /* 298 */
                            if (contentLen == 0) {
                                /* 300 */
                                setContent(null);

                            } else {
                                /* 304 */
                                temp = new byte[contentLen];
                                /* 305 */
                                buffer.get(temp);
                                /* 306 */
                                String[] contentArr = StringUtils.bytesToStr(temp).split(",");
                                /* 307 */
                                ISP isp = new ISP(contentArr[0], contentArr[1]);
                                /* 308 */
                                setContent(isp);

                            }

                        } catch (Exception localException3) {

                        }

                    case 2:

                        try {
                            /* 317 */
                            if (contentLen == 0) {
                                /* 319 */
                                setContent(null);

                            } else {
                                /* 323 */
                                temp = new byte[contentLen];
                                /* 324 */
                                buffer.get(temp);
                                /* 325 */
                                String[] serverArr = StringUtils.bytesToStr(temp).split(":");
                                /* 326 */
                                IP ip = new IP(serverArr[0], Integer.parseInt(serverArr[1]));
                                /* 327 */
                                setContent(ip);

                            }

                        } catch (Exception localException4) {

                        }

                    case 3:

                        try {
                            /* 336 */
                            if (contentLen == 0) {
                                /* 338 */
                                setContent(null);

                            } else {
                                /* 342 */
                                temp = new byte[contentLen];
                                /* 343 */
                                buffer.get(temp);
                                /* 344 */
                                Password pwd = new Password(StringUtils.bytesToStr(temp));
                                /* 345 */
                                setContent(pwd);

                            }

                        } catch (Exception localException5) {

                        }

                    case 4:

                        try {
                            /* 354 */
                            int move = buffer.getInt();

                            /* 356 */
                            int distance = buffer.getInt();

                            /* 358 */
                            int stop = buffer.getInt();
                            /* 359 */
                            GPS gps = new GPS(move, distance, stop);
                            /* 360 */
                            setContent(gps);

                        } catch (Exception localException6) {

                        }

                    case 5:

                        try {
                            /* 368 */
                            int speed = buffer.getInt();

                            /* 370 */
                            int delay = buffer.getInt();
                            /* 371 */
                            SpeedAlarm speedAlarm = new SpeedAlarm(speed, delay);
                            /* 372 */
                            setContent(speedAlarm);

                        } catch (Exception localException7) {

                        }

                    case 6:

                        try {
                            /* 380 */
                            int delay = buffer.getInt();
                            /* 381 */
                            DangerAlarm dangerAlarm = new DangerAlarm(delay);
                            /* 382 */
                            setContent(dangerAlarm);

                        } catch (Exception localException8) {

                        }

                }


            }


        } catch (BufferUnderflowException bue) {
            /* 394 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 398 */
            throw e;

        } catch (Exception localException9) {

        }

        /* 404 */
        return this;

    }


    public String toString() {
        /* 408 */
        StringBuilder buffer = new StringBuilder(super.toString());

        /* 410 */
        buffer.append(",Result:");
        /* 411 */
        buffer.append(getResult());
        /* 412 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.SetParamResp
 * JD-Core Version:    0.6.0
 */