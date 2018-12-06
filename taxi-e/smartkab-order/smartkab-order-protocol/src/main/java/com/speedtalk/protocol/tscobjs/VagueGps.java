package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.constants.ParamConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.protocol.utils.StringUtils;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class VagueGps extends TSCObject {
    private static final int TIME_STR_LEN = 14;
    private int lt;
    private int lg;
    private short hight;
    private short speed;
    private short direction;
    private String time;
    private int mileage;
    private short oil;
    private int status;
    private int alarm;


    public VagueGps() {
        /* 201 */
        setMessID(17);

    }


    public VagueGps(int lt, int lg, short hight, short speed, short direction, String time, int mileage, short oil, int status, int alarm) {
        /* 207 */
        this.lt = lt;
        /* 208 */
        this.lg = lg;
        /* 209 */
        this.hight = hight;
        /* 210 */
        this.speed = speed;
        /* 211 */
        this.direction = direction;
        /* 212 */
        this.time = time;
        /* 213 */
        this.mileage = mileage;
        /* 214 */
        this.oil = oil;
        /* 215 */
        this.status = status;
        /* 216 */
        this.alarm = alarm;

    }


    public int getLt() {
        /*  37 */
        return this.lt;

    }


    public void setLt(int lt) {
        /*  46 */
        this.lt = lt;

    }


    public int getLg() {
        /*  55 */
        return this.lg;

    }


    public void setLg(int lg) {
        /*  64 */
        this.lg = lg;

    }


    public short getHight() {
        /*  72 */
        return this.hight;

    }


    public void setHight(short hight) {
        /*  80 */
        this.hight = hight;

    }


    public short getSpeed() {
        /*  88 */
        return this.speed;

    }


    public void setSpeed(short speed) {
        /*  96 */
        this.speed = speed;

    }


    public short getDirection() {
        /* 104 */
        return this.direction;

    }


    public void setDirection(short direction) {
        /* 112 */
        this.direction = direction;

    }


    public String getTime() {
        /* 120 */
        return this.time;

    }


    public void setTime(String time) {
        /* 129 */
        this.time = time;

    }


    public int getMileage() {
        /* 137 */
        return this.mileage;

    }


    public void setMileage(int mileage) {
        /* 145 */
        this.mileage = mileage;

    }


    public short getOil() {
        /* 153 */
        return this.oil;

    }


    public void setOil(short oil) {
        /* 161 */
        this.oil = oil;

    }


    public int getStatus() {
        /* 171 */
        return this.status;

    }


    public void setStatus(int status) {
        /* 179 */
        this.status = status;

    }


    public int getAlarm() {
        /* 189 */
        return this.alarm;

    }


    public void setAlarm(int alarm) {
        /* 197 */
        this.alarm = alarm;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /* 222 */
        if (getSrcMsID() == null)
            /* 223 */
            throw new NullPointerException("Src ms id is NULL!");

        try {
            /* 226 */
            ByteBuffer buffer = MessageUtils.createHead(76,
                    /* 227 */         42, getMessID(), 0, this);
            /* 228 */
            buffer.putInt(getLt());
            /* 229 */
            buffer.putInt(getLg());
            /* 230 */
            buffer.putShort(getHight());
            /* 231 */
            buffer.putShort(getSpeed());
            /* 232 */
            buffer.putShort(getDirection());
            /* 233 */
            buffer.put(StringUtils.strToBytes(getTime(), 14));
            /* 234 */
            buffer.putInt(getMileage());
            /* 235 */
            buffer.putShort(getOil());
            /* 236 */
            buffer.putInt(getStatus());
            /* 237 */
            buffer.putInt(getAlarm());
            /* 238 */
            buffer.putShort(MessageUtils.getCRC16(buffer, 42));
            /* 239 */
            buffer.put(MessIdConstants.ENDING);
            /* 240 */
            ArrayList resultList = new ArrayList();
            /* 241 */
            resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
            /* 242 */
            return resultList;

        } catch (Exception localException) {

        }

        /* 248 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 256 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 262 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 270 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 271 */
            setLt(buffer.getInt());
            /* 272 */
            setLg(buffer.getInt());
            /* 273 */
            setHight(buffer.getShort());
            /* 274 */
            setSpeed(buffer.getShort());
            /* 275 */
            setDirection(buffer.getShort());
            /* 276 */
            byte[] temp = new byte[14];
            /* 277 */
            buffer.get(temp);
            /* 278 */
            setTime(StringUtils.bytesToStr(temp));
            /* 279 */
            setMileage(buffer.getInt());
            /* 280 */
            setOil(buffer.getShort());
            /* 281 */
            setStatus(buffer.getInt());
            /* 282 */
            setAlarm(buffer.getInt());

        } catch (BufferUnderflowException bue) {
            /* 286 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 290 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 296 */
        return this;

    }


    public String toString() {
        /* 301 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 302 */
        if (ParamConstants.isDetail()) {
            /* 305 */
            buffer.append(",Lt:");
            /* 306 */
            buffer.append(getLt());

            /* 308 */
            buffer.append(",Lg:");
            /* 309 */
            buffer.append(getLg());

            /* 311 */
            buffer.append(",Hight:");
            /* 312 */
            buffer.append(getHight());

            /* 314 */
            buffer.append(",Speed:");
            /* 315 */
            buffer.append(getSpeed());

            /* 317 */
            buffer.append(",Direction:");
            /* 318 */
            buffer.append(getDirection());

            /* 320 */
            buffer.append(",Time:");
            /* 321 */
            buffer.append(getTime());

            /* 323 */
            buffer.append(",Mileage:");
            /* 324 */
            buffer.append(getMileage());

            /* 326 */
            buffer.append(",Oil:");
            /* 327 */
            buffer.append(getOil());

            /* 329 */
            buffer.append(",Status:");
            /* 330 */
            buffer.append(getStatus());

            /* 332 */
            buffer.append(",Alarm:");
            /* 333 */
            buffer.append(getAlarm());

        } else {
            /* 337 */
            buffer.append(",Lt:");
            /* 338 */
            buffer.append(getLt());
            /* 339 */
            buffer.append(",Lg:");
            /* 340 */
            buffer.append(getLg());
            /* 341 */
            buffer.append(",Hight:");
            /* 342 */
            buffer.append(getHight());
            /* 343 */
            buffer.append(",Speed:");
            /* 344 */
            buffer.append(getSpeed());
            /* 345 */
            buffer.append(",Direction:");
            /* 346 */
            buffer.append(getDirection());
            /* 347 */
            buffer.append(",Time:");
            /* 348 */
            buffer.append(getTime());

        }

        /* 351 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.VagueGps
 * JD-Core Version:    0.6.0
 */