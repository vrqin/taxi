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


public class GPS extends TSCObject {
    private static final int TIME_STR_LEN = 14;
    private double lt;
    private double lg;
    private short hight;
    private float speed;
    private short direction;
    private String time;
    private float mileage;
    private float oil;
    private VehicleStatus status;
    private VehicleAlarm alarm;


    public GPS() {
        /* 197 */
        setMessID(17);

    }


    public GPS(double lt, double lg, short hight, float speed, short direction, String time, float mileage, float oil, VehicleStatus status, VehicleAlarm alarm) {
        /* 202 */
        setMessID(17);
        /* 203 */
        this.lt = lt;
        /* 204 */
        this.lg = lg;
        /* 205 */
        this.hight = hight;
        /* 206 */
        this.speed = speed;
        /* 207 */
        this.direction = direction;
        /* 208 */
        this.time = time;
        /* 209 */
        this.mileage = mileage;
        /* 210 */
        this.oil = oil;
        /* 211 */
        this.status = status;
        /* 212 */
        this.alarm = alarm;

    }


    public double getLt() {
        /*  40 */
        return this.lt;

    }


    public void setLt(double lt) {
        /*  48 */
        this.lt = lt;

    }


    public double getLg() {
        /*  56 */
        return this.lg;

    }


    public void setLg(double lg) {
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


    public float getSpeed() {
        /*  88 */
        return this.speed;

    }


    public void setSpeed(float speed) {
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


    public float getMileage() {
        /* 137 */
        return this.mileage;

    }


    public void setMileage(float mileage) {
        /* 145 */
        this.mileage = mileage;

    }


    public float getOil() {
        /* 153 */
        return this.oil;

    }


    public void setOil(float oil) {
        /* 161 */
        this.oil = oil;

    }


    public VehicleStatus getStatus() {
        /* 169 */
        return this.status;

    }


    public void setStatus(VehicleStatus status) {
        /* 177 */
        this.status = status;

    }


    public VehicleAlarm getAlarm() {
        /* 185 */
        return this.alarm;

    }


    public void setAlarm(VehicleAlarm alarm) {
        /* 193 */
        this.alarm = alarm;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /* 217 */
        ArrayList resultList = new ArrayList();
        /* 218 */
        if (getRawData() == null) {
            /* 220 */
            if (getSrcMsID() == null)
                /* 221 */
                throw new NullPointerException("Src ms id is NULL!");
            /* 222 */
            if (this.status == null)
                /* 223 */
                throw new NullPointerException("Vehicle status is NULL!");
            /* 224 */
            if (this.alarm == null)
                /* 225 */
                throw new NullPointerException("Vehicle alarm is NULL!");

            try {
                /* 228 */
                ByteBuffer buffer = MessageUtils.createHead(76,
                        /* 229 */           42, getMessID(), 0, this);
                /* 230 */
                buffer.putInt((int) (getLt() * 1000000.0D));
                /* 231 */
                buffer.putInt((int) (getLg() * 1000000.0D));
                /* 232 */
                buffer.putShort(getHight());
                /* 233 */
                buffer.putShort((short) (int) (getSpeed() * 10.0F));
                /* 234 */
                buffer.putShort(getDirection());
                /* 235 */
                buffer.put(StringUtils.strToBytes(getTime(), 14));
                /* 236 */
                buffer.putInt((int) (getMileage() * 10.0F));
                /* 237 */
                buffer.putShort((short) (int) (getOil() * 10.0F));
                /* 238 */
                buffer.putInt(getStatus().encodeStatus());
                /* 239 */
                buffer.putInt(getAlarm().encodeAlarm());
                /* 240 */
                buffer.putShort(MessageUtils.getCRC16(buffer, 42));
                /* 241 */
                buffer.put(MessIdConstants.ENDING);

                /* 243 */
                resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));

                /* 245 */
                return resultList;

            } catch (Exception e) {
                /* 249 */
                return null;

            }


        }

        /* 254 */
        resultList.add(getRawData());
        /* 255 */
        return resultList;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 264 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 270 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 278 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 279 */
            setLt(buffer.getInt() / 1000000.0D);
            /* 280 */
            setLg(buffer.getInt() / 1000000.0D);
            /* 281 */
            setHight(buffer.getShort());
            /* 282 */
            setSpeed(buffer.getShort() / 10.0F);
            /* 283 */
            setDirection(buffer.getShort());
            /* 284 */
            byte[] temp = new byte[14];
            /* 285 */
            buffer.get(temp);
            /* 286 */
            setTime(StringUtils.bytesToStr(temp));
            /* 287 */
            setMileage(buffer.getInt() / 10.0F);
            /* 288 */
            setOil(buffer.getShort() / 10.0F);
            /* 289 */
            setStatus(VehicleStatus.decodeStatus(buffer.getInt()));
            /* 290 */
            setAlarm(VehicleAlarm.decodeAlarm(buffer.getInt()));

        } catch (BufferUnderflowException bue) {
            /* 294 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 298 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 304 */
        return this;

    }


    public String toString() {
        /* 308 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 309 */
        if (ParamConstants.isDetail()) {
            /* 312 */
            buffer.append(",Lt:");
            /* 313 */
            buffer.append(getLt());

            /* 315 */
            buffer.append(",Lg:");
            /* 316 */
            buffer.append(getLg());

            /* 318 */
            buffer.append(",Hight:");
            /* 319 */
            buffer.append(getHight());

            /* 321 */
            buffer.append(",Speed:");
            /* 322 */
            buffer.append(getSpeed());

            /* 324 */
            buffer.append(",Direction:");
            /* 325 */
            buffer.append(getDirection());

            /* 327 */
            buffer.append(",Time:");
            /* 328 */
            buffer.append(getTime());

            /* 330 */
            buffer.append(",Mileage:");
            /* 331 */
            buffer.append(getMileage());

            /* 333 */
            buffer.append(",Oil:");
            /* 334 */
            buffer.append(getOil());

            /* 336 */
            buffer.append(",Status:");
            /* 337 */
            buffer.append(getStatus().toString());

            /* 339 */
            buffer.append(",Alarm:");
            /* 340 */
            buffer.append(getAlarm().toString());

        } else {
            /* 344 */
            buffer.append(",Lt:");
            /* 345 */
            buffer.append(getLt());
            /* 346 */
            buffer.append(",Lg:");
            /* 347 */
            buffer.append(getLg());
            /* 348 */
            buffer.append(",Hight:");
            /* 349 */
            buffer.append(getHight());
            /* 350 */
            buffer.append(",Speed:");
            /* 351 */
            buffer.append(getSpeed());
            /* 352 */
            buffer.append(",Direction:");
            /* 353 */
            buffer.append(getDirection());
            /* 354 */
            buffer.append(",Time:");
            /* 355 */
            buffer.append(getTime());

        }

        /* 358 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.GPS
 * JD-Core Version:    0.6.0
 */