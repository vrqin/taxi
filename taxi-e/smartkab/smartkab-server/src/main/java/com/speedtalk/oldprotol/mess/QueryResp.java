package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.MessFactory;
import com.speedtalk.utils.ExcepPrinter;

public class QueryResp extends MessResp {
    protected byte option;

    public QueryResp() {
        this.setCommId(MessComIdConstants.QUERY_RESP);
    }

    public QueryResp(short result, byte option) {
        super(MessComIdConstants.QUERY_RESP, result);
        this.option = option;
    }

    public byte getOption() {
        return option;
    }

    public void setOption(byte option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "QueryResp [option=" + option + ", result=" + result + ", reserve=" + reserve + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        try {
            QueryResp resp = MessFactory.getInstance().getQueryResp(arg0);
            return resp.bytesToObj(arg0);
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }
}
