package com.poctalk.protocols.demo;

import com.poctalk.protocols.gps.SMS;
import com.poctalk.utils.StringUtils;

public class SMSDemo {
    public SMSDemo() {
    }

    public static void main(String[] args) {
        try {
            byte[] smsBytes = SMS.smsToBytes("123456789012", "短信测试1332");
            System.out.println("Length:" + smsBytes.length + "," + StringUtils.buff2HexAsciiString(smsBytes));
            byte[] data = new byte[]{-86, 85, -86, 85, 0, 49, 50, 51, 52, 53, 54, 55, 56, 57, 48, 49, 50, 13, 0, 0, 32, -74, -52, -48, -59, -78, -30, -54, -44, 49, 51, 51, 50, 0, 59};
            System.out.println("SMS:" + SMS.getSMSContent(data));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
