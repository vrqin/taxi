package com.speedtalk.protocol.tscobjs;


import com.speedtalk.protocol.TSCObject;
import com.speedtalk.protocol.constants.MessIdConstants;
import com.speedtalk.protocol.constants.ParamConstants;
import com.speedtalk.protocol.exceptions.CheckMistakenException;
import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.protocol.utils.StringUtils;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


public class QueryMemberResp extends QueryMember {
    private byte result;
    private int idCount;
    private List<MemberStatus> memList;


    public QueryMemberResp() {
        /*  34 */
        setMessID(84);

    }


    public QueryMemberResp(byte result, byte type, String grpId, int idCount, List<MemberStatus> memList) {
        /*  38 */
        setMessID(84);
        /*  39 */
        this.result = result;
        /*  40 */
        this.type = type;
        /*  41 */
        this.grpId = grpId;
        /*  42 */
        this.idCount = idCount;
        /*  43 */
        this.memList = memList;

    }


    public byte getResult() {
        /*  52 */
        return this.result;

    }


    public void setResult(byte result) {
        /*  60 */
        this.result = result;

    }


    public int getIdCount() {
        /*  67 */
        return this.idCount;

    }


    public void setIdCount(int idCount) {
        /*  71 */
        this.idCount = idCount;

    }


    public List<MemberStatus> getMemList() {
        /*  78 */
        return this.memList;

    }


    public void setMemList(List<MemberStatus> memList) {
        /*  82 */
        this.memList = memList;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /*  87 */
        if ((getSrcMsID() == null) || (getSrcMsID().trim().equals("")))
            /*  88 */
            throw new NullPointerException("Src msid is NULL!");
        /*  89 */
        if ((getIdCount() > 0) && ((getMemList() == null) || (getMemList().isEmpty())))
            /*  90 */
            throw new NullPointerException("Member is NULL!");

        try {
            /*  93 */
            ArrayList resultList = new ArrayList();
            /*  94 */
            int memberCount = getIdCount();
            /*  95 */
            int constentLen = 0;
            int totalLen = 0;
            /*  96 */
            int packCount = 1;
            int maxMsIds = 13;
            /*  97 */
            if (this.type == 2) {
                /*  98 */
                maxMsIds = 10;

            }
            /* 100 */
            if (getIdCount() > maxMsIds) {
                /* 102 */
                setIsSplit(1);

                /* 104 */
                packCount = memberCount / maxMsIds;
                /* 105 */
                if ((memberCount > maxMsIds) && (memberCount % maxMsIds != 0))
                    /* 106 */
                    packCount++;

            }
            /* 108 */
            setTotalPack((short) packCount);

            /* 110 */
            short packNo = 1;
            /* 111 */
            int memberIndex = 0;
            /* 112 */
            int loopCounter = packCount;
            /* 113 */
            MemberStatus status = null;
            /* 114 */
            ByteBuffer buffer = null;

            do {
                /* 117 */
                if (memberCount > maxMsIds) {
                    /* 120 */
                    constentLen = 34 * maxMsIds + 14 + 4;
                    /* 121 */
                    if (this.type == 2)
                        /* 122 */
                        constentLen += 12 * maxMsIds;

                } else {
                    /* 126 */
                    constentLen = 34 * memberCount + 14;
                    /* 127 */
                    if (this.type == 2)
                        /* 128 */
                        constentLen += 12 * memberCount;
                    /* 129 */
                    if (getIsSplit() == 1)
                        /* 130 */
                        constentLen += 4;

                }
                /* 132 */
                totalLen = constentLen + 34;

                /* 134 */
                if (getIsSplit() == 1) {
                    /* 135 */
                    setPackNo(packNo++);

                }
                /* 137 */
                buffer = MessageUtils.createHead(totalLen, (short) constentLen, getMessID(),
                        /* 138 */           getIsSplit(), this);

                /* 141 */
                buffer.put(getResult());
                /* 142 */
                buffer.put(getType());
                /* 143 */
                buffer.put(StringUtils.strToBytes(getGrpId(), 11));
                /* 144 */
                buffer.put(memberCount > maxMsIds ? (byte) maxMsIds : (byte) memberCount);
                /* 145 */
                for (int i = memberCount > maxMsIds ? maxMsIds : memberCount; i > 0; memberIndex++) {
                    /* 147 */
                    status = (MemberStatus) getMemList().get(memberIndex);
                    /* 148 */
                    if (status == null) {
                        /* 149 */
                        buffer.put(new byte[34]);

                    } else {
                        /* 152 */
                        buffer.put(StringUtils.strToBytes(status.getMsId(),
                                /* 153 */               11));
                        /* 154 */
                        buffer.put(StringUtils.strToBytes(status.getMsName(),
                                /* 155 */               20));
                        /* 156 */
                        buffer.put(status.getOnline());
                        /* 157 */
                        buffer.put(status.getOn_grp());
                        /* 158 */
                        buffer.put(status.getMsType());
                        /* 159 */
                        if (this.type == 2) {
                            /* 161 */
                            buffer.put(status.getCallSet());
                            /* 162 */
                            buffer.put(StringUtils.strToBytes(status.getCurrGrpId(),
                                    /* 163 */                 11));

                        }

                    }
                    /* 145 */
                    i--;

                }

                /* 167 */
                buffer.putShort(MessageUtils.getCRC16(buffer, constentLen));
                /* 168 */
                buffer.put(MessIdConstants.ENDING);
                /* 169 */
                resultList.add(MessageUtils.encryptAndDecryptMess(buffer.array()));
                /* 170 */
                memberCount -= maxMsIds;

                /* 172 */
                loopCounter--;

            }
            /* 115 */       while (
                /* 172 */         loopCounter > 0);
            /* 173 */
            return resultList;

        } catch (Exception localException) {

        }
        /* 176 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 184 */
            MessageUtils.isComplete(MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 190 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 197 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 198 */
            if (getIsSplit() == 1) {
                /* 200 */
                setTotalPack(buffer.getShort());
                /* 201 */
                setPackNo(buffer.getShort());

            }
            /* 203 */
            setResult(buffer.get());
            /* 204 */
            setType(buffer.get());
            /* 205 */
            byte[] idTemp = new byte[11];
            /* 206 */
            buffer.get(idTemp);
            /* 207 */
            setGrpId(StringUtils.bytesToStr(idTemp));
            /* 208 */
            setIdCount(buffer.get());
            /* 209 */
            if ((getResult() == 0) && (getIdCount() != 0)) {
                /* 211 */
                int count = getIdCount();
                /* 212 */
                this.memList = new ArrayList();

                /* 215 */
                byte[] nameTemp = new byte[20];
                /* 216 */
                while (count-- > 0) {
                    /* 218 */
                    buffer.get(idTemp);
                    /* 219 */
                    String tempMsId = StringUtils.bytesToStr(idTemp);
                    /* 220 */
                    buffer.get(nameTemp);
                    /* 221 */
                    String tempMsName = StringUtils.bytesToStr(nameTemp);
                    /* 222 */
                    byte tempOnLine = buffer.get();
                    /* 223 */
                    byte tempOn_Grp = buffer.get();
                    /* 224 */
                    byte tempMsType = buffer.get();
                    /* 225 */
                    this.memList.add(
                            /* 226 */             new MemberStatus(tempMsId, tempMsName, tempOnLine, tempOn_Grp,
                                    /* 226 */             tempMsType));

                }

            }

        } catch (BufferUnderflowException bue) {
            /* 232 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 236 */
            throw e;

        } catch (Exception localException2) {

        }

        /* 242 */
        return this;

    }


    public String toString() {
        /* 246 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 247 */
        buffer.append(",Result:");
        /* 248 */
        buffer.append(getResult());
        /* 249 */
        buffer.append(",IdCount:");
        /* 250 */
        buffer.append(getIdCount());
        /* 251 */
        buffer.append(",MsList:");
        /* 252 */
        if ((this.idCount < 30) && (getMemList() != null) && (!getMemList().isEmpty())) {
            /* 254 */
            for (MemberStatus status : getMemList()) {
                /* 256 */
                buffer.append(status.toString());
                /* 257 */
                buffer.append(";");

            }

        } else
            /* 261 */       buffer.append(this.idCount).append(";");
        /* 262 */
        return buffer.toString();

    }

    public class MemberStatus {
        private String msId;
        private String msName;
        private byte online;
        private byte on_grp;
        private byte msType;
        private byte callSet;
        private String currGrpId;


        public MemberStatus(String msId, String msName, byte online, byte on_grp, byte msType) {
            /* 281 */
            this.msId = msId;
            /* 282 */
            this.msName = msName;
            /* 283 */
            this.online = online;
            /* 284 */
            this.on_grp = on_grp;
            /* 285 */
            this.msType = msType;

        }


        public MemberStatus(String msId, String msName, byte online, byte on_grp, byte msType, byte callSet, String currGrpId) {
            /* 290 */
            this.msId = msId;
            /* 291 */
            this.msName = msName;
            /* 292 */
            this.online = online;
            /* 293 */
            this.on_grp = on_grp;
            /* 294 */
            this.msType = msType;
            /* 295 */
            this.callSet = callSet;
            /* 296 */
            this.currGrpId = currGrpId;

        }


        public String getMsId() {
            /* 300 */
            return this.msId;

        }


        public void setMsId(String msId) {
            /* 304 */
            this.msId = msId;

        }


        public String getMsName() {
            /* 308 */
            return this.msName;

        }


        public void setMsName(String msName) {
            /* 312 */
            this.msName = msName;

        }


        public byte getOnline() {
            /* 316 */
            return this.online;

        }


        public void setOnline(byte online) {
            /* 320 */
            this.online = online;

        }


        public byte getOn_grp() {
            /* 324 */
            return this.on_grp;

        }


        public void setOn_grp(byte on_grp) {
            /* 328 */
            this.on_grp = on_grp;

        }


        public byte getMsType() {
            /* 332 */
            return this.msType;

        }


        public void setMsType(byte msType) {
            /* 336 */
            this.msType = msType;

        }


        public byte getCallSet() {
            /* 340 */
            return this.callSet;

        }


        public void setCallSet(byte callSet) {
            /* 344 */
            this.callSet = callSet;

        }


        public String getCurrGrpId() {
            /* 348 */
            return this.currGrpId;

        }


        public void setCurrGrpId(String currGrpId) {
            /* 352 */
            this.currGrpId = currGrpId;

        }


        public String toString() {
            /* 356 */
            StringBuilder buffer = new StringBuilder();
            /* 357 */
            if (ParamConstants.isDetail()) {
                /* 359 */
                buffer.append(" MsId:");
                /* 360 */
                buffer.append(getMsId());
                /* 361 */
                buffer.append(",MsName:");
                /* 362 */
                buffer.append(getMsName());
                /* 363 */
                buffer.append(",Online:");
                /* 364 */
                buffer.append(getOnline() == 1 ? "Y" : "N");
                /* 365 */
                buffer.append(",On Grp:");
                /* 366 */
                buffer.append(getOn_grp() == 1 ? "Y" : "N");
                /* 367 */
                buffer.append(",MsType:");
                /* 368 */
                buffer.append(getMsType());
                /* 369 */
                buffer.append(",CallSet:");
                /* 370 */
                buffer.append(getCallSet());
                /* 371 */
                buffer.append(",CurrGrpId:");
                /* 372 */
                buffer.append(getCurrGrpId());

            } else {
                /* 376 */
                buffer.append(" :");
                /* 377 */
                buffer.append(getMsId());
                /* 378 */
                buffer.append(",");
                /* 379 */
                buffer.append(getMsName());
                /* 380 */
                buffer.append(",");
                /* 381 */
                buffer.append(getOnline());

            }

            /* 384 */
            return buffer.toString();

        }

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.QueryMemberResp
 * JD-Core Version:    0.6.0
 */