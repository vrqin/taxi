package com.speedtalk.order.driver;

import com.speedtalk.client.ClientInfo;
import com.speedtalk.protocol.tscobjs.GPS;
import com.speedtalk.protocol.tscobjs.VehicleAlarm;
import com.speedtalk.protocol.tscobjs.VehicleStatus;
import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.protocol.utils.MessageUtils;
import org.apache.mina.core.session.IoSession;

public class GpsSender implements Runnable {
    private IoSession session;

    public GpsSender(IoSession session) {
        this.session = session;
    }

    @Override
    public void run() {
        GPS gps;
        while (true) {
            gps = new GPS(23.169429, 113.429257, (short) 21, 25.12f, (short) 121, DateUtils.getCommonTimeFormat()
                    .format(System.currentTimeMillis()), 36.5f, 20f, new VehicleStatus(), new VehicleAlarm());
            gps.setSrcMsID(ClientInfo.getInstance().getId());
            gps.setMessNo(MessageUtils.getMessNo());
            session.write(gps);
            try {
                Thread.sleep(20);
            } catch (Exception e) {

                e.printStackTrace();

            }
        }
    }
}
