package com.poctalk.protocols.gps;

public class VehicleState {
    private byte isMoving;
    private byte isRuning;
    private byte isDoor;
    private byte isDangerAlarm;
    private byte isSpeedArlarm;
    private byte isInnerAlarm;
    private byte isOuterAlarm;
    private int areaID;
    private byte isAirCon;
    private byte isBusy;
    private byte isElecAlarm;
    private byte isBrokenAlarm;
    private byte isLowerAlarm;
    private byte isOilAlarm;

    public VehicleState() {
    }

    public VehicleState(byte isMoving, byte isRuning, byte isDoor, byte isDangerAlarm, byte isSpeedArlarm, byte isInnerAlarm, byte isOuterAlarm, int areaID, byte isAirCon, byte isBusy, byte isElecAlarm, byte isBrokenAlarm, byte isLowerAlarm, byte isOilAlarm) {
        this.isMoving = isMoving;
        this.isRuning = isRuning;
        this.isDoor = isDoor;
        this.isDangerAlarm = isDangerAlarm;
        this.isSpeedArlarm = isSpeedArlarm;
        this.isInnerAlarm = isInnerAlarm;
        this.isOuterAlarm = isOuterAlarm;
        this.areaID = areaID;
        this.isAirCon = isAirCon;
        this.isBusy = isBusy;
        this.isElecAlarm = isElecAlarm;
        this.isBrokenAlarm = isBrokenAlarm;
        this.isLowerAlarm = isLowerAlarm;
        this.isOilAlarm = isOilAlarm;
    }

    private static char byteToChar(byte b) {
        int t = (new Byte(b)).intValue();
        t = t < 0 ? t + 16 : t;
        return t >= 0 && t <= 9 ? (char) (t + 48) : (char) (t - 10 + 65);
    }

    public static VehicleState parseBytesToState(byte[] datas) {
        VehicleState state = new VehicleState();
        StringBuilder tempBuffer = new StringBuilder();
        tempBuffer.append((char) datas[0]);
        tempBuffer.append((char) datas[1]);

        int stateThree;
        try {
            stateThree = Integer.parseInt(tempBuffer.toString(), 16);
            tempBuffer.delete(0, tempBuffer.length());
            state.setIsMoving((byte) (stateThree & 1));
            state.setIsRuning((byte) ((stateThree & 2) >>> 1));
            state.setIsDoor((byte) ((stateThree & 4) >>> 2));
            state.setIsDangerAlarm((byte) ((stateThree & 8) >>> 3));
            state.setIsSpeedArlarm((byte) ((stateThree & 16) >>> 4));
        } catch (Exception var6) {
            ;
        }

        tempBuffer.append((char) datas[3]);
        tempBuffer.append((char) datas[4]);

        try {
            stateThree = Integer.parseInt(tempBuffer.toString(), 16);
            tempBuffer.delete(0, tempBuffer.length());
            state.setIsInnerAlarm((byte) ((stateThree & 2) >>> 1));
            state.setIsOuterAlarm((byte) ((stateThree & 4) >>> 2));
            state.setAreaID((stateThree & 56) >>> 3);
            state.setIsAirCon((byte) ((stateThree & 128) >>> 7));
        } catch (Exception var5) {
            ;
        }

        tempBuffer.append((char) datas[6]);
        tempBuffer.append((char) datas[7]);
        tempBuffer.append((char) datas[8]);
        tempBuffer.append((char) datas[9]);
        tempBuffer.append((char) datas[10]);
        tempBuffer.append((char) datas[11]);
        tempBuffer.append((char) datas[12]);
        tempBuffer.append((char) datas[13]);

        try {
            stateThree = Integer.parseInt(tempBuffer.toString(), 16);
            state.setIsBusy((byte) (stateThree & 1));
            state.setIsElecAlarm((byte) ((stateThree & 2) >>> 1));
            state.setIsBrokenAlarm((byte) ((stateThree & 4) >>> 2));
            state.setIsLowerAlarm((byte) ((stateThree & 8) >>> 3));
            state.setIsOilAlarm((byte) ((stateThree & 16) >>> 4));
            state.setIsElecAlarm((byte) ((stateThree & 1024) >>> 10));
        } catch (Exception var4) {
            ;
        }

        return state;
    }

    public static void main(String[] args) {
        VehicleState vehic = new VehicleState();
        System.out.println(vehic.getVehicleStateStr((byte) 2));
        System.out.println(vehic.getVehicleStateStr((byte) 3));
        System.out.println(vehic.getVehicleStateThree(123));
        System.out.println(vehic.getVehicleStateThree(254));
    }

    public byte[] parseVehicleStateToBytes() {
        StringBuilder tempBuffer = new StringBuilder();
        tempBuffer.append(this.vehicleStateByteToStr(this.parseStateOneToByte()));
        tempBuffer.append(",");
        tempBuffer.append(this.vehicleStateByteToStr(this.parseStateTwoToByte()));
        tempBuffer.append(",");
        tempBuffer.append(this.getVehicleStateThree(this.parseStateThreeToByte()));
        tempBuffer.append(",");
        return tempBuffer.toString().getBytes();
    }

    public byte parseStateOneToByte() {
        byte vehicleState = 0;
        if (this.isMoving == 1) {
            ++vehicleState;
        }

        if (this.isRuning == 1) {
            vehicleState = (byte) (vehicleState + 2);
        }

        if (this.isDoor == 1) {
            vehicleState = (byte) (vehicleState + 4);
        }

        if (this.isDangerAlarm == 1) {
            vehicleState = (byte) (vehicleState + 8);
        }

        if (this.isSpeedArlarm == 1) {
            vehicleState = (byte) (vehicleState + 16);
        }

        return vehicleState;
    }

    public byte parseStateTwoToByte() {
        byte vehicleState = 0;
        if (this.isInnerAlarm == 1) {
            vehicleState = (byte) (vehicleState + 2);
        }

        if (this.isOuterAlarm == 1) {
            vehicleState = (byte) (vehicleState + 4);
        }

        vehicleState = (byte) (vehicleState + (this.areaID << 3));
        if (this.isAirCon == 1) {
            vehicleState = (byte) (vehicleState + 128);
        }

        return vehicleState;
    }

    public int parseStateThreeToByte() {
        int vehicleState = 0;
        if (this.isBusy == 1) {
            ++vehicleState;
        }

        if (this.isBrokenAlarm == 1) {
            vehicleState += 4;
        }

        if (this.isLowerAlarm == 1) {
            vehicleState += 8;
        }

        if (this.isOilAlarm == 1) {
            vehicleState += 16;
        }

        if (this.isElecAlarm == 1) {
            vehicleState += 2;
            vehicleState += 1024;
        }

        return vehicleState;
    }

    private String vehicleStateByteToStr(byte vehicleState) {
        byte high = (byte) ((vehicleState & 240) >>> 4);
        byte low = (byte) (vehicleState & 15);
        StringBuilder stateBuffer = new StringBuilder();
        stateBuffer.append(byteToChar(high));
        stateBuffer.append(byteToChar(low));
        return stateBuffer.toString();
    }

    public String getVehicleStateStr(byte vehicleState) {
        return this.vehicleStateByteToStr(vehicleState);
    }

    public String getVehicleStateThree(int vehicleState) {
        Integer integer = null;
        StringBuilder stateBuffer = new StringBuilder();
        integer = new Integer((vehicleState & -16777216) >>> 24);
        stateBuffer.append(this.vehicleStateByteToStr(integer.byteValue()));
        integer = new Integer((vehicleState & 16711680) >>> 16);
        stateBuffer.append(this.vehicleStateByteToStr(integer.byteValue()));
        integer = new Integer((vehicleState & '\uff00') >>> 8);
        stateBuffer.append(this.vehicleStateByteToStr(integer.byteValue()));
        integer = new Integer(vehicleState & 255);
        stateBuffer.append(this.vehicleStateByteToStr(integer.byteValue()));
        return stateBuffer.toString();
    }

    public String toString() {
        StringBuilder objBuffer = new StringBuilder();
        objBuffer.append("  行走:");
        objBuffer.append(this.getIsMoving());
        objBuffer.append(",引擎:");
        objBuffer.append(this.getIsRuning());
        objBuffer.append(",前门:");
        objBuffer.append(this.getIsDoor());
        objBuffer.append(",紧急报警:");
        objBuffer.append(this.getIsDangerAlarm());
        objBuffer.append(",超速报警:");
        objBuffer.append(this.getIsSpeedArlarm());
        objBuffer.append(",进区域报警:");
        objBuffer.append(this.getIsInnerAlarm());
        objBuffer.append(",出区域报警:");
        objBuffer.append(this.getIsOuterAlarm());
        objBuffer.append(",区域ID:");
        objBuffer.append(this.getAreaID());
        objBuffer.append(",空调:");
        objBuffer.append(this.getIsAirCon());
        objBuffer.append(",载客:");
        objBuffer.append(this.getIsBusy());
        objBuffer.append(",断电报警:");
        objBuffer.append(this.getIsElecAlarm());
        objBuffer.append(",机头断开报警:");
        objBuffer.append(this.getIsBrokenAlarm());
        objBuffer.append(",低电压报警:");
        objBuffer.append(this.getIsLowerAlarm());
        objBuffer.append(",偷油报警:");
        objBuffer.append(this.getIsOilAlarm());
        return objBuffer.toString();
    }

    public byte getIsMoving() {
        return this.isMoving;
    }

    public void setIsMoving(byte isMoving) {
        this.isMoving = isMoving;
    }

    public byte getIsRuning() {
        return this.isRuning;
    }

    public void setIsRuning(byte isRuning) {
        this.isRuning = isRuning;
    }

    public byte getIsDoor() {
        return this.isDoor;
    }

    public void setIsDoor(byte isDoor) {
        this.isDoor = isDoor;
    }

    public byte getIsDangerAlarm() {
        return this.isDangerAlarm;
    }

    public void setIsDangerAlarm(byte isDangerAlarm) {
        this.isDangerAlarm = isDangerAlarm;
    }

    public byte getIsSpeedArlarm() {
        return this.isSpeedArlarm;
    }

    public void setIsSpeedArlarm(byte isSpeedArlarm) {
        this.isSpeedArlarm = isSpeedArlarm;
    }

    public byte getIsInnerAlarm() {
        return this.isInnerAlarm;
    }

    public void setIsInnerAlarm(byte isInnerAlarm) {
        this.isInnerAlarm = isInnerAlarm;
    }

    public byte getIsOuterAlarm() {
        return this.isOuterAlarm;
    }

    public void setIsOuterAlarm(byte isOuterAlarm) {
        this.isOuterAlarm = isOuterAlarm;
    }

    public int getAreaID() {
        return this.areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public byte getIsAirCon() {
        return this.isAirCon;
    }

    public void setIsAirCon(byte isAirCon) {
        this.isAirCon = isAirCon;
    }

    public byte getIsBusy() {
        return this.isBusy;
    }

    public void setIsBusy(byte isBusy) {
        this.isBusy = isBusy;
    }

    public byte getIsElecAlarm() {
        return this.isElecAlarm;
    }

    public void setIsElecAlarm(byte isElecAlarm) {
        this.isElecAlarm = isElecAlarm;
    }

    public byte getIsBrokenAlarm() {
        return this.isBrokenAlarm;
    }

    public void setIsBrokenAlarm(byte isBrokenAlarm) {
        this.isBrokenAlarm = isBrokenAlarm;
    }

    public byte getIsLowerAlarm() {
        return this.isLowerAlarm;
    }

    public void setIsLowerAlarm(byte isLowerAlarm) {
        this.isLowerAlarm = isLowerAlarm;
    }

    public byte getIsOilAlarm() {
        return this.isOilAlarm;
    }

    public void setIsOilAlarm(byte isOilAlarm) {
        this.isOilAlarm = isOilAlarm;
    }
}
