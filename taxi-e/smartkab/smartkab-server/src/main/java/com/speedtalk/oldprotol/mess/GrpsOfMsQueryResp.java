package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.Assistant;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class GrpsOfMsQueryResp extends QueryResp {
    private short grpCount;
    private List<GrpInfo> grpList;

    public GrpsOfMsQueryResp() {
    }

    public GrpsOfMsQueryResp(short result, byte option, short grpCount, List<GrpInfo> grpList) {
        super(result, option);
        this.grpCount = grpCount;
        this.grpList = grpList;
    }

    public short getGrpCount() {
        return grpCount;
    }

    public void setGrpCount(short grpCount) {
        this.grpCount = grpCount;
    }

    public List<GrpInfo> getGrpList() {
        return grpList;
    }

    public void setGrpList(List<GrpInfo> grpList) {
        this.grpList = grpList;
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        byte[] ids = new byte[OptionConstants.ID_LEN], names = new byte[30];
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        ArrayList<GrpInfo> grpList = new ArrayList<GrpInfo>();
        GrpInfo grpInfo = null;
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            this.setResult(buffer.getShort());
            this.setOption(buffer.get());
            buffer.position(buffer.position() + 8);

            if (OptionConstants.SUCCESS_RESULT == this.getResult()) {
                this.setGrpCount(buffer.getShort());

                for (int i = 0; i < this.getGrpCount(); i++) {
                    grpInfo = new GrpInfo(null, null, (byte) 0);
                    buffer.get(ids);
                    grpInfo.setGrpId(new String(ids));

                    buffer.get(names);
                    grpInfo.setGrpName(Assistant.bytesToStr(names, null));

                    buffer.get();
                    grpInfo.setIsCall(buffer.get());
                    buffer.position(buffer.position() + 12);

                    grpList.add(grpInfo);
                }
                this.setGrpList(grpList);
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

    public class GrpInfo {
        private String grpId;
        private String grpName;
        private byte isCall;

        public GrpInfo() {
        }

        public GrpInfo(String grpId, String grpName, byte isCall) {
            this.grpId = grpId;
            this.grpName = grpName;
            this.isCall = isCall;
        }

        public String getGrpId() {
            return grpId;
        }

        public void setGrpId(String grpId) {
            this.grpId = grpId;
        }

        public String getGrpName() {
            return grpName;
        }

        public void setGrpName(String grpName) {
            this.grpName = grpName;
        }

        public byte getIsCall() {
            return isCall;
        }

        public void setIsCall(byte isCall) {
            this.isCall = isCall;
        }

        @Override
        public String toString() {
            return "GrpInfo [grpId=" + grpId + ", grpName=" + grpName + ", isCall=" + isCall + "]";
        }
    }
}
