package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.IMsParam;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.constants.ParamConstants;
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


public class SetParam extends TSCObject {
    private byte operation;
    private byte option;
    private IMsParam content;


    public SetParam() {
        /*  36 */
        setMessID(21);

    }


    public SetParam(byte operation, byte option, IMsParam content) {
        /*  40 */
        setMessID(21);
        /*  41 */
        this.operation = operation;
        /*  42 */
        this.option = option;
        /*  43 */
        this.content = content;

    }


    public SetParam(IMsParam content) {
        /*  47 */
        setMessID(21);
        /*  48 */
        this.content = content;

    }


    public byte getOperation() {
        /*  57 */
        return this.operation;

    }


    public void setOperation(byte operation) {
        /*  66 */
        this.operation = operation;

    }


    public byte getOption() {
        /*  78 */
        return this.option;

    }


    public void setOption(byte option) {
        /*  86 */
        this.option = option;

    }


    public IMsParam getContent() {
        /*  94 */
        return this.content;

    }


    public void setContent(IMsParam content) {
        /* 102 */
        this.content = content;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /* 107 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /* 108 */
            throw new NullPointerException("Src ms id is NULL!");
        /* 109 */
        if ((getDstMsID() == null) || (getDstMsID().trim().equals("")))
            /* 110 */
            throw new NullPointerException("Dst ms id is NULL!");

        try {
            /* 113 */
            int contentLen = 0;
            /* 114 */
            ByteBuffer temp = null;
            /* 115 */
            if (getOperation() == 1) {
                /* 117 */
                contentLen = 4;
                /* 118 */
                temp = ByteBuffer.allocate(contentLen);
                /* 119 */
                temp.order(ByteOrder.LITTLE_ENDIAN);
                /* 120 */
                temp.put(getOperation());
                /* 121 */
                temp.put(getOption());
                /* 122 */
                temp.putShort(0);

            } else {
                /* 127 */
                short paramLen = 0;
                /* 128 */
                switch (getOption()) {

                    case 0:
                        /* 131 */
                        Version version = (Version) getContent();
                        /* 132 */
                        if ((version == null) || (version.getVersion() == null))
                            /* 133 */
                            throw new NullPointerException("Version is NULL!");

                        try {
                            /* 136 */
                            paramLen =
                                    /* 137 */               (short) version.getVersion().getBytes(
                                    /* 137 */               StringUtils.getEncoding()).length;
                            /* 138 */
                            contentLen = 4 + paramLen;
                            /* 139 */
                            temp = ByteBuffer.allocate(contentLen);
                            /* 140 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /* 141 */
                            temp.put(getOperation());
                            /* 142 */
                            temp.put(getOption());
                            /* 143 */
                            temp.putShort(paramLen);
                            /* 144 */
                            if (paramLen == 0)
                                break;
                            /* 145 */
                            temp.put(StringUtils.strToBytes(version.getVersion(), paramLen));

                        } catch (Exception localException) {

                        }


                    case 1:
                        /* 152 */
                        ISP isp = (ISP) getContent();
                        /* 153 */
                        if ((isp == null) || (isp.getIsp() == null) || (isp.getIsp().trim().equals("")) ||
                                /* 154 */             (isp.getIspPwd() == null) || (isp.getIspPwd().trim().equals("")))
                            /* 155 */
                            throw new NullPointerException("ISP is NULL!");

                        try {
                            /* 158 */
                            int ispLen = 0;
                            int ispPwdLen = 0;
                            /* 159 */
                            ispLen += isp.getIsp().getBytes(StringUtils.getEncoding()).length;
                            /* 160 */
                            ispPwdLen += isp.getIspPwd().getBytes(StringUtils.getEncoding()).length;
                            /* 161 */
                            paramLen = (short) (paramLen + (ispLen + ispPwdLen + 1));
                            /* 162 */
                            contentLen = 4 + paramLen;
                            /* 163 */
                            temp = ByteBuffer.allocate(contentLen);
                            /* 164 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /* 165 */
                            temp.put(getOperation());
                            /* 166 */
                            temp.put(getOption());
                            /* 167 */
                            temp.putShort(paramLen);
                            /* 168 */
                            temp.put(StringUtils.strToBytes(isp.getIsp(), ispLen));
                            /* 169 */
                            temp.put(",".getBytes(StringUtils.getEncoding()));
                            /* 170 */
                            temp.put(StringUtils.strToBytes(isp.getIspPwd(), ispPwdLen));

                        } catch (Exception localException1) {

                        }


                    case 2:
                        /* 177 */
                        IP ip = (IP) getContent();
                        /* 178 */
                        if ((ip == null) || (ip.getIp() == null) || (ip.getIp().trim().equals("")))
                            /* 179 */
                            throw new NullPointerException("IP is NULL!");

                        try {
                            /* 182 */
                            int ipLen = 0;
                            int portLen = 0;
                            /* 183 */
                            ipLen += ip.getIp().getBytes(StringUtils.getEncoding()).length;

                            /* 185 */
                            portLen = portLen + String.valueOf(ip.getPort()).getBytes(
                                    /* 185 */               StringUtils.getEncoding()).length;
                            /* 186 */
                            paramLen = (short) (paramLen + (ipLen + portLen + 1));
                            /* 187 */
                            contentLen = 4 + paramLen;
                            /* 188 */
                            temp = ByteBuffer.allocate(contentLen);
                            /* 189 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /* 190 */
                            temp.put(getOperation());
                            /* 191 */
                            temp.put(getOption());
                            /* 192 */
                            temp.putShort(paramLen);
                            /* 193 */
                            temp.put(StringUtils.strToBytes(ip.getIp(), ipLen));
                            /* 194 */
                            temp.put(":".getBytes(StringUtils.getEncoding()));
                            /* 195 */
                            temp.put(StringUtils.strToBytes(String.valueOf(ip.getPort()), portLen));

                        } catch (Exception localException2) {

                        }

                    case 3:
                        /* 201 */
                        Password pwd = (Password) getContent();
                        /* 202 */
                        if ((pwd == null) || (pwd.getPwd() == null) || (pwd.getPwd().trim().equals("")))
                            /* 203 */
                            throw new NullPointerException("Password is NULL!");

                        try {
                            /* 206 */
                            paramLen = (short) pwd.getPwd().getBytes(StringUtils.getEncoding()).length;
                            /* 207 */
                            contentLen = 4 + paramLen;
                            /* 208 */
                            temp = ByteBuffer.allocate(contentLen);
                            /* 209 */
                            temp.order(ByteOrder.LITTLE_ENDIAN);
                            /* 210 */
                            temp.put(getOperation());
                            /* 211 */
                            temp.put(getOption());
                            /* 212 */
                            temp.putShort(paramLen);
                            /* 213 */
                            temp.put(StringUtils.strToBytes(pwd.getPwd(), paramLen));

                        } catch (Exception localException3) {

                        }

                    case 4:
                        /* 219 */
                        GPS gps = (GPS) getContent();
                        /* 220 */
                        if (gps == null) {
                            /* 221 */
                            throw new NullPointerException("GPS is NULL!");

                        }
                        /* 223 */
                        paramLen = 12;
                        /* 224 */
                        contentLen = 4 + paramLen;
                        /* 225 */
                        temp = ByteBuffer.allocate(contentLen);
                        /* 226 */
                        temp.order(ByteOrder.LITTLE_ENDIAN);
                        /* 227 */
                        temp.put(getOperation());
                        /* 228 */
                        temp.put(getOption());
                        /* 229 */
                        temp.putShort(paramLen);
                        /* 230 */
                        temp.putInt(gps.getMove());

                        /* 232 */
                        temp.putInt(gps.getDistance());

                        /* 234 */
                        temp.putInt(gps.getStop());
                        /* 235 */
                        break;

                    case 5:
                        /* 238 */
                        SpeedAlarm speedAlarm = (SpeedAlarm) getContent();
                        /* 239 */
                        if (speedAlarm == null)
                            /* 240 */
                            throw new NullPointerException("SpeedAlarm is NULL!");
                        /* 241 */
                        paramLen = 8;
                        /* 242 */
                        contentLen = 4 + paramLen;
                        /* 243 */
                        temp = ByteBuffer.allocate(contentLen);
                        /* 244 */
                        temp.order(ByteOrder.LITTLE_ENDIAN);
                        /* 245 */
                        temp.put(getOperation());
                        /* 246 */
                        temp.put(getOption());
                        /* 247 */
                        temp.putShort(paramLen);
                        /* 248 */
                        temp.putInt(speedAlarm.getSpeed());

                        /* 250 */
                        temp.putInt(speedAlarm.getDelay());
                        /* 251 */
                        break;

                    case 6:
                        /* 253 */
                        DangerAlarm dangerAlarm = (DangerAlarm) getContent();
                        /* 254 */
                        if (dangerAlarm == null) {
                            /* 255 */
                            throw new NullPointerException("DangerAlarm is NULL!");

                        }
                        /* 257 */
                        paramLen = 4;
                        /* 258 */
                        contentLen = 4 + paramLen;
                        /* 259 */
                        temp = ByteBuffer.allocate(contentLen);
                        /* 260 */
                        temp.order(ByteOrder.LITTLE_ENDIAN);
                        /* 261 */
                        temp.put(getOperation());
                        /* 262 */
                        temp.put(getOption());
                        /* 263 */
                        temp.putShort(paramLen);
                        /* 264 */
                        temp.putInt(dangerAlarm.getDelay());
                        /* 265 */
                        break;

                }


            }

            /* 270 */
            ByteBuffer buffer = MessageUtils.createHead(34 +
                    /* 271 */         contentLen, (short) contentLen, getMessID(), 0, this);
            /* 272 */
            temp.flip();
            /* 273 */
            buffer.put(temp);
            /* 274 */
            buffer.putShort(MessageUtils.getCRC16(buffer, contentLen));
            /* 275 */
            buffer.put(MessIdConstants.ENDING);
            /* 276 */
            ArrayList resultList = new ArrayList();
            /* 277 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 278 */
            return resultList;

        } catch (Exception localException4) {

        }

        /* 284 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 292 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 298 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 305 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 306 */
            setOperation(buffer.get());
            /* 307 */
            setOption(buffer.get());
            /* 308 */
            if (getOperation() == 0) {
                /* 310 */
                short contentLen = buffer.getShort();
                /* 311 */
                byte[] temp = null;
                /* 312 */
                switch (getOption()) {

                    case 0:
                        /* 315 */
                        break;

                    case 1:

                        try {
                            /* 319 */
                            if (contentLen == 0) {
                                /* 321 */
                                setContent(null);

                            } else {
                                /* 325 */
                                temp = new byte[contentLen];
                                /* 326 */
                                buffer.get(temp);
                                /* 327 */
                                String[] contentArr = StringUtils.bytesToStr(temp).split(",");
                                /* 328 */
                                ISP isp = new ISP(contentArr[0], contentArr[1]);
                                /* 329 */
                                setContent(isp);

                            }

                        } catch (Exception localException2) {

                        }

                    case 2:

                        try {
                            /* 338 */
                            if (contentLen == 0) {
                                /* 340 */
                                setContent(null);

                            } else {
                                /* 344 */
                                temp = new byte[contentLen];
                                /* 345 */
                                buffer.get(temp);
                                /* 346 */
                                String[] serverArr = StringUtils.bytesToStr(temp).split(":");
                                /* 347 */
                                IP ip = new IP(serverArr[0], Integer.parseInt(serverArr[1]));
                                /* 348 */
                                setContent(ip);

                            }

                        } catch (Exception localException3) {

                        }

                    case 3:

                        try {
                            /* 357 */
                            if (contentLen == 0) {
                                /* 359 */
                                setContent(null);

                            } else {
                                /* 363 */
                                temp = new byte[contentLen];
                                /* 364 */
                                buffer.get(temp);
                                /* 365 */
                                Password pwd = new Password(StringUtils.bytesToStr(temp));
                                /* 366 */
                                setContent(pwd);

                            }

                        } catch (Exception localException4) {

                        }

                    case 4:

                        try {
                            /* 375 */
                            int move = buffer.getInt();

                            /* 377 */
                            int distance = buffer.getInt();

                            /* 379 */
                            int stop = buffer.getInt();
                            /* 380 */
                            GPS gps = new GPS(move, distance, stop);
                            /* 381 */
                            setContent(gps);

                        } catch (Exception localException5) {

                        }

                    case 5:

                        try {
                            /* 389 */
                            int speed = buffer.getInt();

                            /* 391 */
                            int delay = buffer.getInt();
                            /* 392 */
                            SpeedAlarm speedAlarm = new SpeedAlarm(speed, delay);
                            /* 393 */
                            setContent(speedAlarm);

                        } catch (Exception localException6) {

                        }

                    case 6:

                        try {
                            /* 401 */
                            int delay = buffer.getInt();
                            /* 402 */
                            DangerAlarm dangerAlarm = new DangerAlarm(delay);
                            /* 403 */
                            setContent(dangerAlarm);

                        } catch (Exception localException7) {

                        }

                }


            }


        } catch (BufferUnderflowException bue) {
            /* 415 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 419 */
            throw e;

        } catch (Exception localException8) {

        }

        /* 425 */
        return this;

    }


    public String toString() {
        /* 429 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 430 */
        if (ParamConstants.isDetail()) {
            /* 433 */
            buffer.append(",Operation:");
            /* 434 */
            buffer.append(getOperation());

            /* 436 */
            buffer.append(",Option:");
            /* 437 */
            buffer.append(getOption());
            /* 438 */
            buffer.append(",Content:");
            /* 439 */
            buffer.append(getContent() == null ? "" : getContent().toString());

        } else {
            /* 443 */
            buffer.append(",");
            /* 444 */
            buffer.append(getOperation());

            /* 446 */
            buffer.append(",");
            /* 447 */
            buffer.append(getOption());
            /* 448 */
            buffer.append(",");
            /* 449 */
            buffer.append(getContent() == null ? "" : getContent().toString());

        }

        /* 452 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.SetParam
 * JD-Core Version:    0.6.0
 */