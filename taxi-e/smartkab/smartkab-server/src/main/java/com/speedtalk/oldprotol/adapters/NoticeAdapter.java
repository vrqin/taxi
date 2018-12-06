package com.speedtalk.oldprotol.adapters;

import com.speedtalk.kabs.KabTeam;
import com.speedtalk.oldprotol.AdaptExcepton;
import com.speedtalk.oldprotol.ProtolAdapter;
import com.speedtalk.oldprotol.mess.Mess;
import com.speedtalk.oldprotol.mess.Notify;
import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.TypeConstants;
import com.speedtalk.protocol.tscobjs.Notice;

import java.util.ArrayList;
import java.util.List;

public class NoticeAdapter implements ProtolAdapter {
    private static final byte MS_STATUS_NOTIFY = 3;

    @Override
    public List<TSCObject> adapt(Mess mess) throws AdaptExcepton {
        if (null == mess)
            throw new AdaptExcepton("Mess is null!");
        Notify notify = (Notify) mess;
        if (notify.getOption() != MS_STATUS_NOTIFY)
            throw new AdaptExcepton("Unknow option!");
        ArrayList<TSCObject> list = new ArrayList<TSCObject>();
        Notice notice = new Notice();
        try {
            //			notice.setSrcMsID(notify.getMsId());
            notice.setMessNo((short) mess.getSerialNo());

            notice.setMsID(notify.getMsId());
            if (notify.getOnLineStatus() == KabTeam.ONLINE)
                notice.setType(TypeConstants.ONLINE_NOTICE);
            else
                notice.setType(TypeConstants.OFFLINE_NOTICE);

            list.add(notice);
        } catch (Exception e) {
            throw new AdaptExcepton(e);
        }

        return list;
    }

    @Override
    public List<Mess> adapt(TSCObject obj) throws AdaptExcepton {
        // TODO Auto-generated method stub
        return null;
    }
}
