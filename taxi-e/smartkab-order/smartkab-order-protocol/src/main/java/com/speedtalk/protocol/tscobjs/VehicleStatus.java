package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.constants.ParamConstants;

import java.io.Serializable;


public class VehicleStatus implements Serializable {
    private byte acc;
    private byte position;
    private byte ltFlag;
    private byte lgFlag;
    private byte run;
    private byte isOilCut;
    private byte isElecCut;
    private byte isLock;
    private byte door;
    private byte air;


    public VehicleStatus() {
        /*  39 */
        this.acc = 0;
        /*  40 */
        this.position = 1;
        /*  41 */
        this.ltFlag = 0;
        /*  42 */
        this.lgFlag = 0;
        /*  43 */
        this.run = 1;
        /*  44 */
        this.isOilCut = 0;
        /*  45 */
        this.isElecCut = 0;
        /*  46 */
        this.isLock = 1;
        /*  47 */
        this.door = 0;
        /*  48 */
        this.air = 0;

    }


    public VehicleStatus(byte acc, byte position, byte ltFlag, byte lgFlag, byte run, byte isOilCut, byte isElecCut, byte isLock, byte door, byte air) {
        /*  54 */
        this.acc = acc;
        /*  55 */
        this.position = position;
        /*  56 */
        this.ltFlag = ltFlag;
        /*  57 */
        this.lgFlag = lgFlag;
        /*  58 */
        this.run = run;
        /*  59 */
        this.isOilCut = isOilCut;
        /*  60 */
        this.isElecCut = isElecCut;
        /*  61 */
        this.isLock = isLock;
        /*  62 */
        this.door = door;
        /*  63 */
        this.air = air;

    }


    public static VehicleStatus decodeStatus(int status) {
        /* 242 */
        VehicleStatus vehicleStatus = new VehicleStatus();
        /* 243 */
        vehicleStatus.setAcc((byte) (status & 0x1));
        /* 244 */
        vehicleStatus.setPosition((byte) (status >>> 1 & 0x1));
        /* 245 */
        vehicleStatus.setLtFlag((byte) (status >>> 2 & 0x1));
        /* 246 */
        vehicleStatus.setLtFlag((byte) (status >>> 3 & 0x1));
        /* 247 */
        vehicleStatus.setRun((byte) (status >>> 4 & 0x1));
        /* 248 */
        vehicleStatus.setOilCut((byte) (status >>> 5 & 0x1));
        /* 249 */
        vehicleStatus.setElecCut((byte) (status >>> 6 & 0x1));
        /* 250 */
        vehicleStatus.setLock((byte) (status >>> 7 & 0x1));
        /* 251 */
        vehicleStatus.setDoor((byte) (status >>> 8 & 0x1));
        /* 252 */
        vehicleStatus.setAir((byte) (status >>> 9 & 0x1));
        /* 253 */
        return vehicleStatus;
    }


    public byte isAcc() {
        /*  71 */
        return this.acc;

    }


    public void setAcc(byte acc) {
        /*  80 */
        this.acc = acc;

    }


    public byte isPosition() {
        /*  89 */
        return this.position;

    }


    public void setPosition(byte position) {
        /*  98 */
        this.position = position;

    }


    public byte getLtFlag() {
        /* 106 */
        return this.ltFlag;

    }


    public void setLtFlag(byte ltFlag) {
        /* 115 */
        this.ltFlag = ltFlag;

    }


    public byte getLgFlag() {
        /* 123 */
        return this.lgFlag;

    }


    public void setLgFlag(byte lgFlag) {
        /* 132 */
        this.lgFlag = lgFlag;

    }


    public byte getRun() {
        /* 140 */
        return this.run;

    }


    public void setRun(byte run) {
        /* 148 */
        this.run = run;

    }


    public byte isOilCut() {
        /* 157 */
        return this.isOilCut;

    }


    public void setOilCut(byte isOilCut) {
        /* 166 */
        this.isOilCut = isOilCut;

    }


    public byte isElecCut() {
        /* 175 */
        return this.isElecCut;

    }


    public void setElecCut(byte isElecCut) {
        /* 184 */
        this.isElecCut = isElecCut;

    }


    public byte isLock() {
        /* 193 */
        return this.isLock;

    }


    public void setLock(byte isLock) {
        /* 202 */
        this.isLock = isLock;

    }


    public byte isDoor() {
        /* 211 */
        return this.door;

    }


    public void setDoor(byte door) {
        /* 220 */
        this.door = door;

    }


    public byte isAir() {
        /* 229 */
        return this.air;

    }


    public void setAir(byte air) {
        /* 238 */
        this.air = air;

    }

    // ERROR //

    public int encodeStatus() { // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: aload_0
        //   3: invokevirtual 93	com/speedtalk/protocol/tscobjs/VehicleStatus:isAcc	()B
        //   6: iconst_1
        //   7: if_icmpne +6 -> 13
        //   10: iinc 1 1
        //   13: aload_0
        //   14: invokevirtual 95	com/speedtalk/protocol/tscobjs/VehicleStatus:isPosition	()B
        //   17: iconst_1
        //   18: if_icmpne +6 -> 24
        //   21: iinc 1 2
        //   24: aload_0
        //   25: invokevirtual 97	com/speedtalk/protocol/tscobjs/VehicleStatus:getLtFlag	()B
        //   28: iconst_1
        //   29: if_icmpne +6 -> 35
        //   32: iinc 1 4
        //   35: aload_0
        //   36: invokevirtual 99	com/speedtalk/protocol/tscobjs/VehicleStatus:getLgFlag	()B
        //   39: iconst_1
        //   40: if_icmpne +6 -> 46
        //   43: iinc 1 8
        //   46: aload_0
        //   47: invokevirtual 101	com/speedtalk/protocol/tscobjs/VehicleStatus:getRun	()B
        //   50: iconst_1
        //   51: if_icmpne +6 -> 57
        //   54: iinc 1 16
        //   57: aload_0
        //   58: invokevirtual 103	com/speedtalk/protocol/tscobjs/VehicleStatus:isOilCut	()B
        //   61: iconst_1
        //   62: if_icmpne +6 -> 68
        //   65: iinc 1 32
        //   68: aload_0
        //   69: invokevirtual 105	com/speedtalk/protocol/tscobjs/VehicleStatus:isElecCut	()B
        //   72: iconst_1
        //   73: if_icmpne +6 -> 79
        //   76: iinc 1 64
        //   79: aload_0
        //   80: invokevirtual 107	com/speedtalk/protocol/tscobjs/VehicleStatus:isLock	()B
        //   83: iconst_1
        //   84: if_icmpne +9 -> 93
        //   87: wide
        //   93: aload_0
        //   94: invokevirtual 109	com/speedtalk/protocol/tscobjs/VehicleStatus:isDoor	()B
        //   97: iconst_1
        //   98: if_icmpne +9 -> 107
        //   101: wide
        //   107: aload_0
        //   108: invokevirtual 111	com/speedtalk/protocol/tscobjs/VehicleStatus:isAir	()B
        //   111: iconst_1
        //   112: if_icmpne +9 -> 121
        //   115: wide
        //   121: iload_1
        //   122: ireturn }
        /* 287 */
        public String toString () {
            StringBuilder buffer = new StringBuilder(",Vehicle status:");
            /* 288 */
            if (ParamConstants.isDetail()) {
                /* 291 */
                buffer.append(",ACC(0:Off;1:On):");
                /* 292 */
                buffer.append(isAcc());

                /* 294 */
                buffer.append(",Position(0:Invalid;1:valid):");
                /* 295 */
                buffer.append(isPosition());

                /* 297 */
                buffer.append(",LT(0:North;1:South):");
                /* 298 */
                buffer.append(getLtFlag());

                /* 300 */
                buffer.append(",LG(0:Ease;1:West):");
                /* 301 */
                buffer.append(getLgFlag());

                /* 303 */
                buffer.append(",Run(0:Run;1:Stop):");
                /* 304 */
                buffer.append(getRun());

                /* 306 */
                buffer.append(",Oil(0:Normal;1:Cut):");
                /* 307 */
                buffer.append(isOilCut());

                /* 309 */
                buffer.append(",Elec(0:Normal;1:Cut):");
                /* 310 */
                buffer.append(isElecCut());

                /* 312 */
                buffer.append(",Lock(0:Unlock;1:Lock):");
                /* 313 */
                buffer.append(isLock());

                /* 315 */
                buffer.append(",Door(0:Off;1:On):");
                /* 316 */
                buffer.append(isDoor());

                /* 318 */
                buffer.append(",Air-equipment(0:Off;1:On):");
                /* 319 */
                buffer.append(isAir());

            } else {
                /* 323 */
                buffer.append(",Position:");
                /* 324 */
                buffer.append(isPosition());
                /* 325 */
                buffer.append(getLgFlag());
                /* 326 */
                buffer.append(",Run:");
                /* 327 */
                buffer.append(getRun());

            }

            /* 330 */
            return buffer.toString();

        }

    }

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.VehicleStatus
 * JD-Core Version:    0.6.0
 */