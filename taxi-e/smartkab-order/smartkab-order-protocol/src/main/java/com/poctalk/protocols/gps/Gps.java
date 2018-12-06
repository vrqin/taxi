package com.poctalk.protocols.gps;

import com.poctalk.protocols.exceptions.MessageErrorException;
import com.poctalk.protocols.utils.GPSUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;

public class Gps {
    private String msID;
    private int oil;
    private int curMileage;
    private int totalMileage;
    private float speed;
    private Position position;
    private VehicleState state;

    public Gps() {
        this.msID = "000000000000000000000";
        this.position = new Position();
        this.state = new VehicleState();
    }

    public Gps(String msID, float speed, int oil, int curMileage, int totalMileage, Position position, VehicleState state) {
        this.msID = msID;
        this.speed = speed;
        this.oil = oil;
        this.curMileage = curMileage;
        this.totalMileage = totalMileage;
        this.position = position;
        this.state = state;
    }

    public static Gps parseBkGpsToBytes(byte[] bkGpsData)
            throws NullPointerException, MessageErrorException, ParseException {
        try {
            GPSUtils.check(bkGpsData);
        } catch (NullPointerException var18) {
            throw var18;
        } catch (MessageErrorException var19) {
            throw var19;
        }

        int gpsLen = GPSUtils.parseTotalLen(bkGpsData);
        if (bkGpsData.length - 23 != gpsLen) {
            throw new MessageErrorException("数据不完整！");
        } else {
            byte[] gpsData = new byte[gpsLen];
            System.arraycopy(bkGpsData, 21, gpsData, 0, gpsLen);
            byte[] positionBytes = new byte[gpsLen - 29];
            System.arraycopy(gpsData, 0, positionBytes, 0, gpsLen - 29);
            Position position = Position.parseBytesToPosition(positionBytes);
            byte[] vehicleStateBytes = new byte[15];
            System.arraycopy(gpsData, gpsLen - 29, vehicleStateBytes, 0, 15);
            VehicleState state = VehicleState.parseBytesToState(vehicleStateBytes);
            byte[] oilAndMileBytes = new byte[14];
            System.arraycopy(gpsData, gpsLen - 14, oilAndMileBytes, 0, 14);
            byte[] msIDBytes = new byte[12];
            System.arraycopy(bkGpsData, 5, msIDBytes, 0, 12);
            String shortMsID = new String(msIDBytes);
            String speedStr = (new String(positionBytes)).split(",")[7];
            float tempSpeed = speedStr.equals("") ? 0.0F : Float.parseFloat(speedStr);
            byte[] tempBytes = new byte[4];
            System.arraycopy(oilAndMileBytes, 0, tempBytes, 0, 4);
            ByteBuffer tempBuffer = ByteBuffer.wrap(tempBytes);
            tempBuffer.order(ByteOrder.LITTLE_ENDIAN);
            int tempOil = tempBuffer.getInt();
            System.arraycopy(oilAndMileBytes, 5, tempBytes, 0, 4);
            tempBuffer.clear();
            tempBuffer.put(tempBytes);
            tempBuffer.flip();
            int tempCurrMile = tempBuffer.getInt();
            System.arraycopy(oilAndMileBytes, 10, tempBytes, 0, 4);
            tempBuffer.clear();
            tempBuffer.put(tempBytes);
            tempBuffer.flip();
            int tempTotalMile = tempBuffer.getInt();
            Gps gps = new Gps(shortMsID, tempSpeed, tempOil, tempCurrMile, tempTotalMile, position, state);
            return gps;
        }
    }

    public String getMsID() {
        return this.msID;
    }

    public void setMsID(String msID) {
        this.msID = msID;
    }

    public int getOil() {
        return this.oil;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public int getCurMileage() {
        return this.curMileage;
    }

    public void setCurMileage(int curMileage) {
        this.curMileage = curMileage;
    }

    public int getTotalMileage() {
        return this.totalMileage;
    }

    public void setTotalMileage(int totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public VehicleState getState() {
        return this.state;
    }

    public void setState(VehicleState state) {
        this.state = state;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String toString() {
        StringBuilder objBuffer = new StringBuilder(" 终端ID：");
        objBuffer.append(this.getMsID());
        objBuffer.append(",速度：");
        objBuffer.append(this.getSpeed());
        objBuffer.append(",油量：");
        objBuffer.append(this.getOil());
        objBuffer.append(",当前里程：");
        objBuffer.append(this.getCurMileage());
        objBuffer.append(",总里程：");
        objBuffer.append(this.getTotalMileage());
        objBuffer.append(this.getPosition().toString());
        objBuffer.append(this.getState().toString());
        return objBuffer.toString();
    }

    public byte[] parseToBkGps() throws Exception {
        ByteBuffer gpsBuffer = ByteBuffer.allocate(200);
        gpsBuffer.order(ByteOrder.LITTLE_ENDIAN);

        try {
            gpsBuffer.put(this.position.parsePositionToBytes(this.speed));
        } catch (Exception var6) {
            throw var6;
        }

        gpsBuffer.put(this.state.parseVehicleStateToBytes());
        gpsBuffer.putInt(this.oil);
        gpsBuffer.put(GpsConstants.GPS_DELIMITER);
        gpsBuffer.putInt(this.curMileage);
        gpsBuffer.put(GpsConstants.GPS_DELIMITER);
        gpsBuffer.putInt(this.totalMileage);
        int gpsDataLen = gpsBuffer.position();
        byte[] gpsData = new byte[gpsDataLen];
        System.arraycopy(gpsBuffer.array(), 0, gpsData, 0, gpsDataLen);
        gpsBuffer.clear();
        gpsBuffer.put(GpsConstants.HEAD);
        gpsBuffer.put((byte) 0);
        gpsBuffer.put(this.msID.substring(9).getBytes());
        int tempArraysLen = gpsDataLen + 1;
        gpsBuffer.put(GPSUtils.totalLenToByte(tempArraysLen));
        gpsBuffer.put((byte) -118);
        gpsBuffer.put(gpsData);
        gpsBuffer.put((byte) 0);
        gpsBuffer.put((byte) 59);
        int totalLen = gpsBuffer.position();
        gpsData = new byte[totalLen];
        System.arraycopy(gpsBuffer.array(), 0, gpsData, 0, totalLen);
        return gpsData;
    }

    public byte[] parseBkPositionToBkGps() throws Exception {
        double newLon = Position.dm2Degree(this.position.getLongitude());
        double newLat = Position.dm2Degree(this.position.getLatitude());
        this.position.setLongitude(newLon);
        this.position.setLatitude(newLat);

        try {
            return this.parseToBkGps();
        } catch (Exception var6) {
            throw var6;
        }
    }
}
