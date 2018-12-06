package com.poctalk.protocols.demo;

import com.poctalk.protocols.gps.Gps;
import com.poctalk.utils.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class NonParamRespDemo {
    public NonParamRespDemo() {
    }

    public static void main(String[] args) {
        try {
            char tab = '\t';
            File readFile = new File("23.txt");
            File writeFile = new File("23Gps.txt");
            BufferedReader br = new BufferedReader(new FileReader(readFile));
            FileWriter fw = new FileWriter(writeFile);
            String lineStr = null;
            String[] strArray = (String[]) null;
            byte[] byteArray = (byte[]) null;
            Gps gps = null;
            String msIDPrifix = "860311000";
            String msID = null;
            String gpsStr = null;
            String alarm = "0";
            long lineCount = 0L;
            long exceptionCount = 0L;

            while ((lineStr = br.readLine()) != null) {
                ++lineCount;

                try {
                    strArray = lineStr.split(" ");
                    byteArray = new byte[strArray.length];

                    for (int i = 0; i < strArray.length; ++i) {
                        byteArray[i] = Integer.valueOf(strArray[i], 16).byteValue();
                    }

                    gps = Gps.parseBkGpsToBytes(byteArray);
                    if (gps.getPosition().getIsAvailable().equals("V")) {
                        System.out.println("定位无效");
                    } else {
                        msID = msIDPrifix + gps.getMsID();
                        if (gps.getState().getIsDangerAlarm() - 1 == 0) {
                            alarm = "4";
                        } else if (gps.getState().getIsSpeedArlarm() - 1 == 0) {
                            alarm = "3";
                        } else if (gps.getState().getIsInnerAlarm() - 1 == 0) {
                            alarm = "2";
                        } else if (gps.getState().getIsOuterAlarm() - 1 == 0) {
                            alarm = "1";
                        }

                        gpsStr = "0" + tab + msID + tab + StringUtils.formatDate(gps.getPosition()
                                .getGpsDate()
                                .getTimeInMillis(), (String) null) + tab + gps.getPosition()
                                .getLongitude() + tab + gps.getPosition()
                                .getLatitude() + tab + gps.getSpeed() + tab + gps.getPosition()
                                .getDirection() + tab + gps.getCurMileage() + tab + "1" + tab + gps.getState()
                                .getIsMoving() + tab + gps.getState().getIsRuning() + tab + gps.getState()
                                .getIsDoor() + tab + "0" + tab + "0" + tab + "0" + tab + gps.getState()
                                .getIsBusy() + tab + "0" + tab + alarm + tab + gps.getOil() + tab + gps.getTotalMileage() + "\n";
                        fw.write(gpsStr);
                        fw.flush();
                    }
                } catch (Exception var19) {
                    var19.printStackTrace();
                    ++exceptionCount;
                    System.out.println("lineStr:" + lineStr);
                }
            }

            System.out.println("处理完成！总数据:" + lineCount + "异常数据:" + exceptionCount);
        } catch (Exception var20) {
            var20.printStackTrace();
        }

    }
}
