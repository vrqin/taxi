package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class PTT extends Mess {
    protected String grpId;

    public PTT() {
    }

    public PTT(int comId, String msId, String grpId) {
        setCommId(comId);
        this.setSrcMsID(msId);
        this.grpId = grpId;
    }

    public String getGrpId() {
        return grpId;
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

    @Override
    public String toString() {
        return "PTT [grpId=" + grpId + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
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
            if (MessComIdConstants.PTT == this.getCommId())
                buffer.get();

            buffer.get(datas);
            this.setSrcMsID(new String(datas));

            buffer.get(datas);
            this.setGrpId(new String(datas));

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        int len = OptionConstants.HEAD_LEN + OptionConstants.ID_LEN + OptionConstants.ID_LEN + OptionConstants.RESERVE_LEN;
        if (MessComIdConstants.PTT == this.getCommId())
            len += 2;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(len);
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            if (MessComIdConstants.PTT == this.getCommId())
                buffer.put((byte) 0);

            buffer.put(getSrcMsID().getBytes());
            buffer.put(getGrpId().getBytes());
            if (MessComIdConstants.PTT == this.getCommId())
                buffer.put((byte) 0);
            list.add(buffer.array());
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
