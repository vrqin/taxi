package com.speedtalk.oldprotol.mess;

import com.poctalk.protocols.gps.Gps;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.protocol.utils.StringUtils;
import com.speedtalk.utils.ExcepPrinter;

public class Position extends MediaMess {
    private Gps gps;

    public Position(byte[] gpsData) {
        super();
        super.setCommId(OptionConstants.GPS);
        super.setData(gpsData);
        toObj();
    }

    public Gps getGps() {
        return gps;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "Position [data=" + StringUtils.bytesToHexStr(getData()) + "," + gps.toString() + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        return null;
    }

    private void toObj() {
        try {
            gps = Gps.parseBkGpsToBytes(getData());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
    }
}
