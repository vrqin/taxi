package com.poctalk.protocols.demo;

import com.poctalk.protocols.gps.Gps;
import com.poctalk.protocols.gps.Position;
import com.poctalk.protocols.gps.VehicleState;
import com.poctalk.utils.StringUtils;

import java.util.Calendar;

public class GpsEncodeDemo {
    public GpsEncodeDemo() {
    }

    public static void main(String[] args) {
        Position position = new Position(Calendar.getInstance(), 123.14325D, "E", 23.84932D, "S", "A", 120.0F);
        VehicleState state = new VehicleState((byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, 6, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1);
        Gps gpsUtils = new Gps("860311000013110080007", 56.12F, 20, 50, 200, position, state);

        try {
            System.out.println(StringUtils.buff2HexAsciiString(gpsUtils.parseToBkGps()));
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }
}
