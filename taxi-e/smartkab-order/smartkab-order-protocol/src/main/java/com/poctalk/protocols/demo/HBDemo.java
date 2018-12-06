package com.poctalk.protocols.demo;

import com.poctalk.protocols.gps.HB;
import com.poctalk.protocols.gps.Position;
import com.poctalk.protocols.utils.GPSUtils;
import com.poctalk.utils.StringUtils;

public class HBDemo {
    public HBDemo() {
    }

    public static void main(String[] args) {
        byte[] hb = new byte[]{-86, 85, -86, 85, 0, 57, 57, 57, 48, 48, 48, 48, 50, 48, 48, 48, 56, 5, 0, 0, 8, -32, 1, 0, 0, 53, 59};
        System.out.println("msID:" + GPSUtils.getShortMsID(hb));
        System.out.println(StringUtils.buff2HexAsciiString(HB.hbResp("999000020001")));
        System.out.println(Position.dm2Degree(2309.678D));
        System.out.println(Position.dm2Degree(11324.8421D));
    }
}
