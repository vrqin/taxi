package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class DPTT extends PTT {
    private short msCount;
    private List<String> msList;

    public DPTT() {
        setCommId(MessComIdConstants.DPTT);
    }

    public DPTT(String msId, String grpId, short msCount, List<String> msList) {
        super(MessComIdConstants.DPTT, msId, grpId);
        this.msCount = msCount;
        this.msList = msList;
    }

    public short getMsCount() {
        return msCount;
    }

    public void setMsCount(short msCount) {
        this.msCount = msCount;
    }

    public List<String> getMsList() {
        return msList;
    }

    public void setMsList(List<String> msList) {
        this.msList = msList;
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        byte[] datas = new byte[OptionConstants.ID_LEN];
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            buffer.get(datas);
            this.setSrcMsID(new String(datas));

            buffer.get(datas);
            this.setGrpId(new String(datas));

            this.setMsCount(buffer.getShort());

            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < getMsCount(); i++) {
                buffer.get(datas);
                list.add(new String(datas));
            }
            this.setMsList(list);
            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        int len = OptionConstants.HEAD_LEN + OptionConstants.ID_LEN + OptionConstants.ID_LEN + 2 + getMsCount() * OptionConstants.ID_LEN + OptionConstants.RESERVE_LEN;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(getTotalLen());
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            buffer.put(getSrcMsID().getBytes());
            buffer.put(getGrpId().getBytes());
            buffer.putShort(getMsCount());
            for (String msId : getMsList())
                buffer.put(msId.getBytes());
            list.add(buffer.array());

        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }

    @Override
    public String toString() {
        return "DPTT [msCount=" + msCount + ", msList=" + msList + ", grpId=" + grpId + ", totalLen=" + totalLen + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

}
