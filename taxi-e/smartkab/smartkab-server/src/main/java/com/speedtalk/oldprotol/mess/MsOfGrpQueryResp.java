package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.Assistant;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class MsOfGrpQueryResp extends QueryResp {
    private short msCount;
    private List<MsInfo> msList;

    public MsOfGrpQueryResp() {
    }

    public MsOfGrpQueryResp(short result, byte option, short msCount, List<MsInfo> msList) {
        super(result, option);
        this.msCount = msCount;
        this.msList = msList;
    }

    public short getMsCount() {
        return msCount;
    }

    public void setMsCount(short msCount) {
        this.msCount = msCount;
    }

    public List<MsInfo> getMsList() {
        return msList;
    }

    public void setMsList(List<MsInfo> msList) {
        this.msList = msList;
    }

    @Override
    public String toString() {
        return "MsOfGrpQueryResp [msCount=" + msCount + ", msList=" + msList + ", option=" + option + ", result=" + result + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        ArrayList<MsInfo> list = new ArrayList<MsInfo>();
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            this.setResult(buffer.getShort());
            this.setOption(buffer.get());
            buffer.position(buffer.position() + 8);

            if (OptionConstants.SUCCESS_RESULT == this.getResult()) {
                MsInfo tempMsInfo = null;
                byte[] ids = new byte[OptionConstants.ID_LEN], names = new byte[30];

                this.setMsCount(buffer.getShort());
                buffer.position(buffer.position() - 2);

                for (int i = 0; i < this.getMsCount(); i++) {
                    tempMsInfo = new MsInfo();

                    buffer.position(buffer.position() + 4);

                    buffer.get(ids);
                    tempMsInfo.setMsId(new String(ids));
                    buffer.get(names);
                    tempMsInfo.setMsName(Assistant.bytesToStr(names, null));
                    tempMsInfo.setMsType(buffer.get());
                    tempMsInfo.setOnlineStatus(buffer.get());
                    buffer.get(ids);
                    tempMsInfo.setCurGrpId(new String(ids));

                    list.add(tempMsInfo);
                }
                this.setMsList(list);
            }

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }
}
