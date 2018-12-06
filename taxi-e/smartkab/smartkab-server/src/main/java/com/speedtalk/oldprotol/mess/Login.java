package com.speedtalk.oldprotol.mess;

import com.speedtalk.oldprotol.MessComIdConstants;
import com.speedtalk.oldprotol.OptionConstants;
import com.speedtalk.utils.ExcepPrinter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Login extends Mess {
    SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
    private String pwd;

    public Login() {
        setCommId(MessComIdConstants.CONN);
    }

    public Login(String msId, String pwd) {
        this();
        this.setSrcMsID(msId);
        this.pwd = pwd;
    }

    /**
     * 待验证字符串
     *
     * @param sourceStr
     * @return 例如:E387F769097323F5EF2E874EAFFDE5A5
     * @author chen Apr 2, 2010
     */
    public static String getMD5String(String sourceStr) {

        String md5String = null;

        if (sourceStr != null) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] md5Byte = md5.digest(sourceStr.getBytes());
                md5String = com.speedtalk.utils.StringUtils.buff2HexAsciiString(md5Byte).replace(" ", "").toUpperCase();
            } catch (Exception ex) {
            }
        }

        return md5String;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Login [pwd=" + pwd + ", commId=" + commId + ", serialNo=" + serialNo + ", srcMsID=" + srcMsID + "]";
    }

    @Override
    public Mess bytesToObj(byte[] arg0) throws NullPointerException {
        if (null == arg0)
            throw new NullPointerException("Data is null");
        byte[] datas = new byte[21];
        ByteBuffer buffer = ByteBuffer.wrap(arg0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            this.setTotalLen(buffer.getInt());
            this.setCommId(buffer.getInt());
            this.setSerialNo(buffer.getInt());

            buffer.get();
            buffer.get(datas);
            this.setSrcMsID(new String(datas));

            buffer.get(datas);
            this.setPwd(new String(datas));

            return this;
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null;
    }

    @Override
    /**
     * 登录到GPM
     */ public List<byte[]> objToBytes() throws NullPointerException {
        List<byte[]> list = new ArrayList<byte[]>();
        int len = OptionConstants.HEAD_LEN + 12 + 32 + 4 + OptionConstants.RESERVE_LEN;
        ByteBuffer buffer = ByteBuffer.allocate(len);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        try {
            buffer.putInt(len);
            buffer.putInt(getCommId());
            buffer.putInt(getSerialNo());

            int timestamp = Integer.parseInt(sdf.format(System.currentTimeMillis()));

            buffer.put(getSrcMsID().getBytes());
            buffer.put(getMD5String(getPwd() + timestamp).getBytes());
            buffer.putInt(timestamp);
            list.add(buffer.array());

        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }
}
