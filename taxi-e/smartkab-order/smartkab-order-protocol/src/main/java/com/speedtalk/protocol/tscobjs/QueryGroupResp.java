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


public class QueryGroupResp extends TSCObject {
    private byte queryType;
    private byte totalGRP;
    private String currentGRP;
    private List<String> remainGRPList;


    public QueryGroupResp() {
        /*  91 */
        setMessID(56);

    }


    public QueryGroupResp(byte queryType, byte totalGRP, String currentGRP, List<String> remainGRPList) {
        /*  95 */
        setMessID(56);
        /*  96 */
        this.queryType = queryType;
        /*  97 */
        this.totalGRP = totalGRP;
        /*  98 */
        this.currentGRP = currentGRP;
        /*  99 */
        this.remainGRPList = remainGRPList;

    }


    public byte getQueryType() {
        /*  39 */
        return this.queryType;

    }


    public void setQueryType(byte queryType) {
        /*  43 */
        this.queryType = queryType;

    }


    public byte getTotalGRP() {
        /*  51 */
        return this.totalGRP;

    }


    public void setTotalGRP(byte totalGRP) {
        /*  55 */
        this.totalGRP = totalGRP;

    }


    public String getCurrentGRP() {
        /*  63 */
        return this.currentGRP;

    }


    public void setCurrentGRP(String currentGRP) {
        /*  71 */
        this.currentGRP = currentGRP;

    }


    public List<String> getRemainGRPList() {
        /*  79 */
        return this.remainGRPList;

    }


    public void setRemainGRPList(List<String> remainGRPList) {
        /*  87 */
        this.remainGRPList = remainGRPList;

    }


    public List<byte[]> objToBytes() throws NullPointerException, MessageMistakenException {
        /* 105 */
        if ((getSrcMsID() == null) ||
                /* 106 */       (getSrcMsID().trim().equals("")))
            /* 107 */
            throw new NullPointerException("Src ms id is NULL!");
        /* 108 */
        if (getTotalGRP() < 0)
            /* 109 */
            throw new MessageMistakenException("Grp count error!" +
                    /* 110 */         getTotalGRP());
        /* 111 */
        int realGrpCount = 0;
        /* 112 */
        if ((this.currentGRP != null) && (!this.currentGRP.trim().equals("")))
            /* 113 */
            realGrpCount++;
        /* 114 */
        if ((getRemainGRPList() != null) &&
                /* 115 */       (!getRemainGRPList().isEmpty()))
            /* 116 */
            realGrpCount += getRemainGRPList().size();
        /* 117 */
        if (this.totalGRP != realGrpCount)
            /* 118 */
            throw new MessageMistakenException(
                    /* 119 */         "Count and list size unmatch!");

        try {
            /* 122 */
            ArrayList resultList = new ArrayList();
            /* 123 */
            int constentLen = 0;
            int totalLen = 0;
            /* 124 */
            int packCount = 1;
            int maxGrps = 15;
            /* 125 */
            if (this.queryType == 3)
                /* 126 */
                maxGrps = 11;
            /* 127 */
            if (realGrpCount > maxGrps) {
                /* 129 */
                setIsSplit(1);

                /* 131 */
                packCount = realGrpCount / maxGrps;
                /* 132 */
                if ((realGrpCount > maxGrps) && (realGrpCount % maxGrps != 0))
                    /* 133 */
                    packCount++;

            }
            /* 135 */
            setTotalPack((short) packCount);
            /* 136 */
            if (this.remainGRPList == null)
                /* 137 */
                this.remainGRPList = new ArrayList();
            /* 138 */
            this.remainGRPList.add(0, this.currentGRP);
            /* 139 */
            short packNo = 1;
            /* 140 */
            int grpIndex = 0;
            /* 141 */
            int loopCounter = packCount;
            /* 142 */
            ByteBuffer buffer = null;
            /* 143 */
            String[] grpInfo = null;

            do {
                /* 146 */
                if (realGrpCount > maxGrps) {
                    /* 149 */
                    if (this.queryType == 1) {
                        /* 150 */
                        constentLen = 31 * maxGrps + 2 + 4;

                    } else {
                        /* 155 */
                        constentLen = 42 * maxGrps + 2 + 4;

                    }

                } else {
                    /* 160 */
                    if ((this.queryType == 0) ||
                            /* 161 */             (this.queryType == 1)) {
                        /* 162 */
                        constentLen = 31 * realGrpCount + 2;

                    } else {
                        /* 167 */
                        constentLen = 42 * realGrpCount + 2;
                        /* 168 */
                    }
                    if (getIsSplit() == 1)
                        /* 169 */
                        constentLen += 4;

                }
                /* 171 */
                totalLen = constentLen + 34;

                /* 173 */
                if (getIsSplit() == 1)
                    /* 174 */
                    setPackNo(packNo++);
                /* 175 */
                buffer = MessageUtils.createHead(totalLen, (short) constentLen,
                        /* 176 */           getMessID(), getIsSplit(), this);

                /* 178 */
                buffer.put(getQueryType());
                /* 179 */
                buffer.put(realGrpCount > maxGrps ? (byte) maxGrps :
                        /* 180 */           (byte) realGrpCount);

                /* 189 */
                if (getRemainGRPList() != null) {
                    /* 191 */
                    if ((this.queryType == 2) ||
                            /* 192 */             (this.queryType == 3)) {
                        /* 194 */
                        for (int i = realGrpCount > maxGrps ? maxGrps : realGrpCount; i > 0; grpIndex++) {
                            /* 196 */
                            grpInfo = ((String) getRemainGRPList().get(grpIndex)).split(";");
                            /* 197 */
                            buffer.put(StringUtils.strToBytes(grpInfo[0],
                                    /* 198 */                 11));
                            /* 199 */
                            buffer.put(StringUtils.strToBytes(grpInfo[1],
                                    /* 200 */                 20));
                            /* 201 */
                            buffer.put(StringUtils.strToBytes(grpInfo[2],
                                    /* 202 */                 11));

                            /* 194 */
                            i--;

                        }


                    } else {
                        /* 207 */
                        for (int i = realGrpCount > maxGrps ? maxGrps : realGrpCount; i > 0; grpIndex++) {
                            /* 209 */
                            grpInfo = ((String) getRemainGRPList().get(grpIndex)).split(";");
                            /* 210 */
                            buffer.put(StringUtils.strToBytes(grpInfo[0],
                                    /* 211 */                 11));
                            /* 212 */
                            buffer.put(StringUtils.strToBytes(grpInfo[1],
                                    /* 213 */                 20));

                            /* 207 */
                            i--;

                        }


                    }


                }

                /* 217 */
                buffer.putShort(MessageUtils.getCRC16(buffer, constentLen));
                /* 218 */
                buffer.put(MessIdConstants.ENDING);
                /* 219 */
                resultList.add(MessageUtils.encryptAndDecryptMess(buffer
                        /* 220 */.array()));
                /* 221 */
                realGrpCount -= maxGrps;

                /* 223 */
                loopCounter--;

            }
            /* 144 */       while (
                /* 223 */         loopCounter > 0);
            /* 224 */
            return resultList;

        } catch (Exception localException) {

        }
        /* 227 */
        return null;

    }


    public TSCObject bytesToObj(byte[] datas)
            throws NullPointerException, CheckMistakenException, MessageMistakenException {

        try {
            /* 292 */
            MessageUtils.isComplete(
                    /* 293 */         MessageUtils.encryptAndDecryptMess(datas));

        } catch (Exception e) {

            try {
                /* 299 */
                throw e;

            } catch (Exception localException1) {

            }

        }

        try {
            /* 306 */
            ByteBuffer buffer = MessageUtils.parseHead(datas, this);
            /* 307 */
            setQueryType(buffer.get());
            /* 308 */
            setTotalGRP(buffer.get());
            /* 309 */
            byte[] grpIDTemp = new byte[11];
            byte[] grpNameTemp = new byte[20];
            byte[] fatherGrpIDTemp = new byte[11];
            /* 310 */
            buffer.get(grpIDTemp);
            /* 311 */
            buffer.get(grpNameTemp);
            /* 312 */
            if ((2 == this.queryType) ||
                    /* 313 */         (3 == this.queryType)) {
                /* 315 */
                buffer.get(fatherGrpIDTemp);
                /* 316 */
                setCurrentGRP(StringUtils.bytesToStr(grpIDTemp) + ";" +
                        /* 317 */           StringUtils.bytesToStr(grpNameTemp) + ";" +
                        /* 318 */           StringUtils.bytesToStr(fatherGrpIDTemp));

            } else {
                /* 321 */
                setCurrentGRP(StringUtils.bytesToStr(grpIDTemp) + ";" +
                        /* 322 */           StringUtils.bytesToStr(grpNameTemp));
                /* 323 */
            }
            int i = getTotalGRP() - 1;
            /* 324 */
            List grpList = new ArrayList();
            /* 325 */
            if (((this.queryType == 0) ||
                    /* 326 */         (3 == this.queryType)) &&
                    /* 327 */         (i > 0)) {
                /* 329 */
                while (i > 0) {
                    /* 331 */
                    buffer.get(grpIDTemp);
                    /* 332 */
                    buffer.get(grpNameTemp);
                    /* 333 */
                    buffer.get(fatherGrpIDTemp);
                    /* 334 */
                    grpList.add(StringUtils.bytesToStr(grpIDTemp) + ";" +
                            /* 335 */             StringUtils.bytesToStr(grpNameTemp) + ";" +
                            /* 336 */             StringUtils.bytesToStr(fatherGrpIDTemp));
                    /* 337 */
                    i--;

                }
                /* 339 */
                setRemainGRPList(grpList);

            }
            /* 341 */
            else if ((1 == this.queryType) && (i > 0)) {
                /* 343 */
                while (i > 0) {
                    /* 345 */
                    buffer.get(grpIDTemp);
                    /* 346 */
                    buffer.get(grpNameTemp);
                    /* 347 */
                    grpList.add(StringUtils.bytesToStr(grpIDTemp) + ";" +
                            /* 348 */             StringUtils.bytesToStr(grpNameTemp));
                    /* 349 */
                    i--;

                }
                /* 351 */
                setRemainGRPList(grpList);

            }

        } catch (BufferUnderflowException bue) {
            /* 356 */
            throw new MessageMistakenException("Message byte array error!");

        } catch (NullPointerException e) {
            /* 360 */
            throw e;

        } catch (Exception e) {

            try {
                /* 366 */
                throw e;

            } catch (Exception localException2) {

            }

        }
        /* 370 */
        return this;

    }


    public String toString() {
        /* 374 */
        StringBuilder buffer = new StringBuilder(super.toString());
        /* 375 */
        if (ParamConstants.isDetail()) {
            /* 378 */
            buffer.append(",Query type(0:Current;1:All):");
            /* 379 */
            buffer.append(getQueryType());

            /* 381 */
            buffer.append(",Grp count:");
            /* 382 */
            buffer.append(getTotalGRP());

            /* 384 */
            buffer.append(",Current grp:");
            /* 385 */
            buffer.append(getCurrentGRP());

            /* 387 */
            buffer.append(",Other grps:");
            /* 388 */
            if (getRemainGRPList() != null) {
                /* 390 */
                for (String string : getRemainGRPList()) {
                    /* 392 */
                    buffer.append(string);
                    /* 393 */
                    buffer.append(",");

                }

            }

        } else {
            /* 399 */
            buffer.append(",");
            /* 400 */
            buffer.append(getQueryType());

            /* 402 */
            buffer.append(",");
            /* 403 */
            buffer.append(getTotalGRP());

            /* 405 */
            buffer.append(",");
            /* 406 */
            buffer.append(getCurrentGRP());

            /* 408 */
            buffer.append(",Others:");
            /* 409 */
            if (getRemainGRPList() != null) {
                /* 411 */
                for (String string : getRemainGRPList()) {
                    /* 413 */
                    buffer.append(string);
                    /* 414 */
                    buffer.append(",");

                }

            }

        }
        /* 418 */
        return buffer.toString();

    }

}

/* Location:           C:\Users\huangzhike\Desktop\protocol-1.1\
 * Qualified Name:     com.speedtalk.protocol.tscobjs.QueryGroupResp
 * JD-Core Version:    0.6.0
 */