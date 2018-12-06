package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.constants.ParamConstants;

import java.io.Serializable;


public class VehicleAlarm implements Serializable {
    private byte isDanger;
    private byte isHv;
    private byte isTire;
    private byte isGnssModuleFault;
    private byte isGnssCut;
    private byte isGnssShortCircuit;
    private byte isLowPower;
    private byte isNoPower;
    private byte isCameraFault;


    public VehicleAlarm() {

    }


    public VehicleAlarm(byte isDanger, byte isHv, byte isTire, byte isGnssModuleFault, byte isGnssCut, byte isGnssShortCircuit, byte isLowPower, byte isNoPower, byte isCameraFault) {
        /*  38 */
        this.isDanger = isDanger;
        /*  39 */
        this.isHv = isHv;
        /*  40 */
        this.isTire = isTire;
        /*  41 */
        this.isGnssModuleFault = isGnssModuleFault;
        /*  42 */
        this.isGnssCut = isGnssCut;
        /*  43 */
        this.isGnssShortCircuit = isGnssShortCircuit;
        /*  44 */
        this.isLowPower = isLowPower;
        /*  45 */
        this.isNoPower = isNoPower;
        /*  46 */
        this.isCameraFault = isCameraFault;

    }


    public static VehicleAlarm decodeAlarm(int alarm) {
        /* 160 */
        VehicleAlarm vehicleAlarm = new VehicleAlarm();

        /* 162 */
        vehicleAlarm.setDanger((byte) (alarm & 0x1));
        /* 163 */
        vehicleAlarm.setHv((byte) (alarm >>> 1 & 0x1));
        /* 164 */
        vehicleAlarm.setTire((byte) (alarm >>> 2 & 0x1));
        /* 165 */
        vehicleAlarm.setGnssModuleFault((byte) (alarm >>> 3 & 0x1));
        /* 166 */
        vehicleAlarm.setGnssCut((byte) (alarm >>> 4 & 0x1));
        /* 167 */
        vehicleAlarm.setGnssShortCircuit((byte) (alarm >>> 5 & 0x1));
        /* 168 */
        vehicleAlarm.setLowPower((byte) (alarm >>> 6 & 0x1));
        /* 169 */
        vehicleAlarm.setNoPower((byte) (alarm >>> 7 & 0x1));
        /* 170 */
        vehicleAlarm.setCameraFault((byte) (alarm >>> 8 & 0x1));

        /* 172 */
        return vehicleAlarm;
    }


    public byte isDanger() {
        /*  51 */
        return this.isDanger;

    }


    public void setDanger(byte isDanger) {
        /*  59 */
        this.isDanger = isDanger;

    }


    public byte isHv() {
        /*  63 */
        return this.isHv;

    }


    public void setHv(byte isHv) {
        /*  71 */
        this.isHv = isHv;

    }


    public byte isTire() {
        /*  75 */
        return this.isTire;

    }


    public void setTire(byte isTire) {
        /*  83 */
        this.isTire = isTire;

    }


    public byte isGnssModuleFault() {
        /*  87 */
        return this.isGnssModuleFault;

    }


    public void setGnssModuleFault(byte isGnssModuleFault) {
        /*  95 */
        this.isGnssModuleFault = isGnssModuleFault;

    }


    public byte isGnssCut() {
        /*  99 */
        return this.isGnssCut;

    }


    public void setGnssCut(byte isGnssCut) {
        /* 107 */
        this.isGnssCut = isGnssCut;

    }


    public byte isGnssShortCircuit() {
        /* 111 */
        return this.isGnssShortCircuit;

    }


    public void setGnssShortCircuit(byte isGnssShortCircuit) {
        /* 119 */
        this.isGnssShortCircuit = isGnssShortCircuit;

    }


    public byte isLowPower() {
        /* 123 */
        return this.isLowPower;

    }


    public void setLowPower(byte isLowPower) {
        /* 131 */
        this.isLowPower = isLowPower;

    }


    public byte isNoPower() {
        /* 135 */
        return this.isNoPower;

    }


    public void setNoPower(byte isNoPower) {
        /* 143 */
        this.isNoPower = isNoPower;

    }


    public byte isCameraFault() {
        /* 147 */
        return this.isCameraFault;

    }


    public void setCameraFault(byte isCameraFault) {
        /* 155 */
        this.isCameraFault = isCameraFault;

    }

    // ERROR //

    public int encodeAlarm() { // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: aload_0
        //   3: invokevirtual 82	com/speedtalk/protocol/tscobjs/VehicleAlarm:isDanger	()B
        //   6: iconst_1
        //   7: if_icmpne +6 -> 13
        //   10: iinc 1 1
        //   13: aload_0
        //   14: invokevirtual 84	com/speedtalk/protocol/tscobjs/VehicleAlarm:isHv	()B
        //   17: iconst_1
        //   18: if_icmpne +6 -> 24
        //   21: iinc 1 2
        //   24: aload_0
        //   25: invokevirtual 86	com/speedtalk/protocol/tscobjs/VehicleAlarm:isTire	()B
        //   28: iconst_1
        //   29: if_icmpne +6 -> 35
        //   32: iinc 1 4
        //   35: aload_0
        //   36: invokevirtual 88	com/speedtalk/protocol/tscobjs/VehicleAlarm:isGnssModuleFault	()B
        //   39: iconst_1
        //   40: if_icmpne +6 -> 46
        //   43: iinc 1 8
        //   46: aload_0
        //   47: invokevirtual 90	com/speedtalk/protocol/tscobjs/VehicleAlarm:isGnssCut	()B
        //   50: iconst_1
        //   51: if_icmpne +6 -> 57
        //   54: iinc 1 16
        //   57: aload_0
        //   58: invokevirtual 92	com/speedtalk/protocol/tscobjs/VehicleAlarm:isGnssShortCircuit	()B
        //   61: iconst_1
        //   62: if_icmpne +6 -> 68
        //   65: iinc 1 32
        //   68: aload_0
        //   69: invokevirtual 94	com/speedtalk/protocol/tscobjs/VehicleAlarm:isLowPower	()B
        //   72: iconst_1
        //   73: if_icmpne +6 -> 79
        //   76: iinc 1 64
        //   79: aload_0
        //   80: invokevirtual 96	com/speedtalk/protocol/tscobjs/VehicleAlarm:isNoPower	()B
        //   83: iconst_1
        //   84: if_icmpne +9 -> 93
        //   87: wide
        //   93: aload_0
        //   94: invokevirtual 98	com/speedtalk/protocol/tscobjs/VehicleAlarm:isCameraFault	()B
        //   97: iconst_1
        //   98: if_icmpne +9 -> 107
        //   101: wide
        //   107: iload_1
        //   108: ireturn }
        /* 208 */
        public String toString () {
            StringBuilder buffer = new StringBuilder(",Alarm status(0:Normal;1:Alarm):");
            /* 209 */
            if (ParamConstants.isDetail()) {
                /* 212 */
                buffer.append(",Danger alarm:");
                /* 213 */
                buffer.append(isDanger());

                /* 215 */
                buffer.append(",Speed alarm:");
                /* 216 */
                buffer.append(isHv());

                /* 218 */
                buffer.append(",Tired alarm:");
                /* 219 */
                buffer.append(isTire());

                /* 221 */
                buffer.append(",GNSS Fault:");
                /* 222 */
                buffer.append(isGnssModuleFault());

                /* 224 */
                buffer.append(",GNSS cut:");
                /* 225 */
                buffer.append(isGnssCut());

                /* 227 */
                buffer.append(",GNSS Shortcircuit:");
                /* 228 */
                buffer.append(isGnssShortCircuit());

                /* 230 */
                buffer.append(",Low power:");
                /* 231 */
                buffer.append(isLowPower());

                /* 233 */
                buffer.append(",NoPower:");
                /* 234 */
                buffer.append(isNoPower());

                /* 236 */
                buffer.append(",Camera fault:");
                /* 237 */
                buffer.append(isCameraFault());

            } else {
                /* 241 */
                buffer.append(",Danger:");
                /* 242 */
                buffer.append(isDanger());
                /* 243 */
                buffer.append(",Speed:");
                /* 244 */
                buffer.append(isHv());

            }

            /* 247 */
            return buffer.toString();

        }

    }

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.VehicleAlarm
 * JD-Core Version:    0.6.0
 */