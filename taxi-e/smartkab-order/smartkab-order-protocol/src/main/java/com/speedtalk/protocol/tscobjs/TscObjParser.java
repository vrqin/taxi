package com.speedtalk.protocol.tscobjs;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.protocol.utils.TscObjFactory;

public class TscObjParser {
    /* 10 */   private static TscObjParser instance = new TscObjParser();

    public static TscObjParser getInstance() {
        /* 14 */
        return instance;
    }

    public TSCObject parse(byte[] datas) throws Exception {
        /* 18 */
        TSCObject object = null;
        try {
            /* 21 */
            object = TscObjFactory.getInstance().getObj(datas);
            /* 22 */
            object.setRawData(datas);
            /* 23 */
            object.bytesToObj(MessageUtils.encryptAndDecryptMess(datas));
        } catch (Exception e) {
            /* 27 */
            throw e;
        }
        /* 29 */
        return object;
    }
}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.TscObjParser
 * JD-Core Version:    0.6.0
 */