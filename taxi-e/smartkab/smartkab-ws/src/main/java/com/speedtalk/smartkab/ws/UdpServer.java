package com.speedtalk.smartkab.ws;

import com.speedtalk.protocol.tscobjs.GPS;
import com.speedtalk.protocol.tscobjs.TscObjParser;
import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.protocol.utils.StringUtils;
import com.speedtalk.smartkab.ws.kabs.KabInfo;
import com.speedtalk.smartkab.ws.kabs.KabTeam;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.ParseException;


// 测试的，用MQ
public class UdpServer implements Runnable {
    private static UdpServer instance = new UdpServer();
    private static DatagramSocket server = null;
    private byte[] buf = new byte[1024];
    private DatagramPacket data = null;

    private UdpServer() {
        // init();
    }

    public static UdpServer getInstance() {
        if (instance == null)
            instance = new UdpServer();
        return instance;
    }

    @Override
    public void run() {
        System.out.println(Utils.getLogFix() + "UdpServer is running...");
        init();
        byte[] tempBuf;
        GPS gps;
        while (true) {
            try {
                server.receive(data);
                int len = data.getLength();
                tempBuf = new byte[len];
                System.arraycopy(buf, 0, tempBuf, 0, len);
                gps = (GPS) TscObjParser.getInstance().parse(tempBuf);
                this.updateData(gps);
                System.out.println(Utils.getLogFix() +
                        "Rev udp data:" + StringUtils.bytesToHexStr(tempBuf) + "-->" +
                        gps.toString());
            } catch (IOException e) {
                System.out.println(Utils.getLogFix() + "UdpServer receive data occur exception!");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(Utils.getLogFix() + "UdpServer parse gps data occur exception!");
                e.printStackTrace();
            }
        }
    }

    private void init() {
        try {
            // server = new DatagramSocket(new InetSocketAddress("127.0.0.1", 10091));
            server = new DatagramSocket(10091);
        } catch (SocketException e) {
            System.out.println(Utils.getLogFix() + "UdpServer startup occurt exception!");
            e.printStackTrace();
        }
        data = new DatagramPacket(buf, buf.length);
    }

    private void updateData(GPS gps) {
        KabInfo kabInfo = KabTeam.getInstance().getKab(gps.getSrcMsID());
        try {
            kabInfo.setLg(gps.getLg());
            kabInfo.setLt(gps.getLt());
            kabInfo.setTime(System.currentTimeMillis());
        } catch (Exception e) {
            kabInfo = new KabInfo();
            kabInfo.setAccount(gps.getSrcMsID());
            kabInfo.setMsId(gps.getSrcMsID());
            kabInfo.setName(gps.getDstMsID());
            kabInfo.setCarry(KabTeam.UNCARRY);
            kabInfo.setOnline(KabTeam.ONLINE);
            kabInfo.setLg(gps.getLg());
            kabInfo.setLt(gps.getLt());
            kabInfo.setIsApp(KabTeam.UNAPP);
            try {
                kabInfo.setTime(DateUtils.getGpsTimeFormat().parse(gps.getTime()).getTime());
            } catch (ParseException e1) {
                e1.printStackTrace();
                kabInfo.setTime(System.currentTimeMillis());
            }

            KabTeam.getInstance().updateKab(kabInfo);
        }
    }
}
