package com.speedtalk.oldprotol;

import com.speedtalk.oldprotol.mess.Mess;

public class MessParser {
    private static MessParser instance = new MessParser();

    private MessParser() {
    }

    public static MessParser getInstance() {
        return instance;
    }

    public Mess parse(byte[] datas) throws Exception {
        Mess object = null;
        try {
            object = MessFactory.getInstance().getMess(datas);
            object.bytesToObj(datas);
        } catch (Exception e) {
            throw e;
        }
        return object;
    }
}
