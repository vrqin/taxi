package com.poctalk.protocols.gps;

import com.poctalk.protocols.utils.GPSUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class HB {
    public HB() {
    }

    public static byte[] hbResp(String msID) throws NullPointerException {
        if (msID == null) {
            throw new NullPointerException("MsID为空！");
        } else {
            ByteBuffer hbResp = ByteBuffer.allocate(27);
            hbResp.order(ByteOrder.LITTLE_ENDIAN);
            hbResp.put(GpsConstants.HEAD);
            hbResp.put((byte) 0);
            hbResp.put(msID.getBytes());
            hbResp.put(GPSUtils.totalLenToByte(5));
            hbResp.put((byte) 8);
            hbResp.putInt(0);
            hbResp.put((byte) 0);
            hbResp.put((byte) 59);
            return hbResp.array();
        }
    }
}
