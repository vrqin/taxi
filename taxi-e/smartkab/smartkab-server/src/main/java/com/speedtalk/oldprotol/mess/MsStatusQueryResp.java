package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.Assistant;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class MsStatusQueryResp extends QueryResp {
    private MsInfo msInfo;

    public MsStatusQueryResp() {
    }

    public MsStatusQueryResp(short result, byte option, MsInfo msInfo) {
        super(result, option);
        this.msInfo = msInfo;
    }

    public MsInfo getMsInfo() {
        return msInfo;
    }

    public void setMsInfo(MsInfo msInfo) {
        this.msInfo = msInfo;
    }

    @Override
    public String toString() {
        return "MsStatusQueryResp [msInfo=" + msInfo + ", option=" + option + ", result=" + result + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        MsInfo tempMsInfo = new MsInfo();
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            this.setResult(buffer.getShort());
            this.setOption(buffer.get());
            buffer.position(buffer.position() + 8);

            if (OptionConstants.SUCCESS_RESULT == this.getResult()) {
                byte[] ids = new byte[OptionConstants.ID_LEN], names = new byte[30];
                buffer.get(ids);
                tempMsInfo.setMsId(new String(ids));
                buffer.get(names);
                tempMsInfo.setMsName(Assistant.bytesToStr(names, null));
                tempMsInfo.setOnlineStatus(buffer.get());
                buffer.get(ids);
                tempMsInfo.setCurGrpId(new String(ids));

                this.setMsInfo(tempMsInfo);
            }

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        return null;
    }
}
