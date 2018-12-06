package com.speedtalk.protocol.utils;

import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.tscobjs.*;

public class TscObjFactory {
    private static TscObjFactory instance;
    private Object[] OBJ_TABLE = new Object[88];

    private TscObjFactory() {
        this.OBJ_TABLE[1] = Register.class;
        this.OBJ_TABLE[2] = RegisterResp.class;
        this.OBJ_TABLE[3] = Login.class;
        this.OBJ_TABLE[4] = LoginResp.class;
        this.OBJ_TABLE[5] = ApplyJoinGrp.class;
        this.OBJ_TABLE[16] = AllowJoinGrpResp.class;
        this.OBJ_TABLE[7] = CreateGrp.class;
        this.OBJ_TABLE[8] = CreateGrpResp.class;
        this.OBJ_TABLE[9] = AllowJoinGrp.class;
        this.OBJ_TABLE[16] = AllowJoinGrpResp.class;
        this.OBJ_TABLE[17] = GPS.class;
        this.OBJ_TABLE[19] = GPS.class;
        this.OBJ_TABLE[21] = SetParam.class;
        this.OBJ_TABLE[22] = SetParamResp.class;
        this.OBJ_TABLE[23] = SMS.class;
        this.OBJ_TABLE[24] = SMSResp.class;
        this.OBJ_TABLE[37] = CreateTempGrp.class;
        this.OBJ_TABLE[38] = CreateTempGrpResp.class;
        this.OBJ_TABLE[39] = RemoveTempGrp.class;
        this.OBJ_TABLE[40] = RemoveTempGrpResp.class;
        this.OBJ_TABLE[41] = Notice.class;
        this.OBJ_TABLE[49] = HUP.class;
        this.OBJ_TABLE[50] = HUPResp.class;
        this.OBJ_TABLE[51] = Voice.class;
        this.OBJ_TABLE[52] = VoiceResp.class;
        this.OBJ_TABLE[53] = ChangeGroup.class;
        this.OBJ_TABLE[54] = ChangeGroupResp.class;
        this.OBJ_TABLE[55] = QueryGroup.class;
        this.OBJ_TABLE[56] = QueryGroupResp.class;
        this.OBJ_TABLE[57] = EditTempGrp.class;
        this.OBJ_TABLE[64] = EditTempGrpResp.class;
        this.OBJ_TABLE[65] = HB.class;
        this.OBJ_TABLE[66] = HBResp.class;
        this.OBJ_TABLE[73] = UpdateAddr.class;
        this.OBJ_TABLE[80] = UpdateAddrResp.class;
        this.OBJ_TABLE[81] = Upgrade.class;
        this.OBJ_TABLE[83] = QueryMember.class;
        this.OBJ_TABLE[84] = QueryMemberResp.class;
        this.OBJ_TABLE[85] = CallSet.class;
        this.OBJ_TABLE[86] = CallSetResp.class;
        this.OBJ_TABLE[87] = Detection.class;
    }

    public static TscObjFactory getInstance() {
        if (instance == null) {
            instance = new TscObjFactory();
        }

        return instance;
    }

    public TSCObject getObj(byte[] datas) throws Exception {
        byte messId = MessageUtils.encryptAndDecryptMess(datas)[4];
        return (TSCObject) ((Class) this.OBJ_TABLE[messId]).newInstance();
    }
}
