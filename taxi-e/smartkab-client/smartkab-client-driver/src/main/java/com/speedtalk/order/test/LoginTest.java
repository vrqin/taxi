package com.speedtalk.order.test;

public class LoginTest {
    public static void main(String[] args) throws Exception {
        // OrderLogin login = new OrderLogin(TestConstants.ACCOUNT, TestConstants.NAME, "123456");
        // List<byte[]> list = login.objToBytes();
        //
        // OrderLoginResp loginResp = new OrderLoginResp(TestConstants.ACCOUNT, TestConstants.NAME, OrderMessConstants.SUCCESS, "", "李师傅", "粤A12345", "1000");
        // List<byte[]> list = loginResp.objToBytes();
        //
        // OrderLoginResp temp = null;
        // for (byte[] bs : list) {
        //     System.out.println(StringUtils.bytesToHexStr(bs));
        //     temp = new OrderLoginResp(TestConstants.ACCOUNT, TestConstants.NAME, OrderMessConstants.SUCCESS, "", "李师傅", "粤A12345", "1000");
        //     temp.bytesToObj(MessageUtils.encryptAndDecryptMess(bs));
        //     System.out.println(temp.toString());
        //
        // }
        //
        // byte[] datas = {(byte) 0xAA, (byte) 0x7F, (byte) 0x2A, (byte) 0x00, (byte) 0x42, (byte) 0xCF, (byte) 0x7B, (byte) 0x65, (byte) 0x23, (byte) 0x09, (byte) 0x5C, (byte) 0x58, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x3E, (byte) 0x83, (byte) 0x0C, (byte) 0x60, (byte) 0xB0, (byte) 0x38, (byte) 0x9F, (byte) 0x76, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x93, (byte) 0x94, (byte) 0x62, (byte) 0x46, (byte) 0x55, (byte) 0x5D, (byte) 0x66, (byte) 0x55, (byte) 0x4C, (byte) 0x5A, (byte) 0x66, (byte) 0x4A, (byte) 0x55, (byte) 0x57, (byte) 0x6E, (byte) 0x50, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0xC6, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0xED, (byte) 0xA1, (byte) 0x0D, (byte) 0x0A, (byte) 0x65, (byte) 0x40, (byte) 0x5D, (byte) 0x57, (byte) 0x60, (byte) 0x50, (byte) 0x58, (byte) 0x5E, (byte) 0x6B, (byte) 0x43, (byte) 0x5D, (byte) 0x54, (byte) 0x63, (byte) 0x58, (byte) 0x27, (byte) 0x90, (byte) 0x0D, (byte) 0x0A};
        // SMS sms = new SMS();
        // sms.bytesToObj(MessageUtils.encryptAndDecryptMess(datas));
        // System.out.println(sms.toString());
        //
        // OrderLoginExt login = new OrderLoginExt("195b52ee", "195b52ee", "123", OrderMessConstants.IC_CARD_LOGIN_TYPE);
        // OrderLogin login = new OrderLogin("195b52ee", "195b52ee", "123");
        // System.out.println(login.toString());
        // System.out.println(StringUtils.bytesToHexStr(login.objToBytes().get(0)));
        //
        // CommonConfirm confirm = new CommonConfirm("123", "123", OrderMessConstants.ACCEPT_ORDER);
        // List<byte[]> list = confirm.objToBytes();
        //
        // System.out.println(confirm.bytesToObj(MessageUtils.encryptAndDecryptMess(list.get(0))));
        //
        // OrderSms sms = new OrderSms("123", "123", "order sms");
        // List<byte[]> list = sms.objToBytes();
        // System.out.println(sms.bytesToObj(MessageUtils.encryptAndDecryptMess(list.get(0))));


        //
        // byte[] datas = {(byte) 0xAA, (byte) 0x7F, (byte) 0x62, (byte) 0x00, (byte) 0x44, (byte) 0x75, (byte) 0x65, (byte) 0x65, (byte) 0x61, (byte) 0x54, (byte) 0x58, (byte) 0x5F, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x6C, (byte) 0x6B, (byte) 0x53, (byte) 0x70, (byte) 0x65, (byte) 0x65, (byte) 0x54, (byte) 0x61, (byte) 0x5D, (byte) 0x5C, (byte) 0x63, (byte) 0x44, (byte) 0x57, (byte) 0x52, (byte) 0x74, (byte) 0x50, (byte) 0x5B, (byte) 0x51, (byte) 0x63, (byte) 0x41, (byte) 0x5F, (byte) 0x51, (byte) 0x64, (byte) 0x45, (byte) 0x03, (byte) 0x19, (byte) 0x37, (byte) 0x15, (byte) 0x17, (byte) 0x19, (byte) 0x64, (byte) 0x50, (byte) 0x10, (byte) 0x5A, (byte) 0x61, (byte) 0x43, (byte) 0x51, (byte) 0x50, (byte) 0x62, (byte) 0x1D, (byte) 0x1A, (byte) 0x59, (byte) 0x7D, (byte) 0x40, (byte) 0x4B, (byte) 0x54, (byte) 0x28, (byte) 0x59, (byte) 0x5A, (byte) 0x53, (byte) 0x63, (byte) 0x49, (byte) 0x55, (byte) 0x55, (byte) 0x66, (byte) 0x57, (byte) 0x5B, (byte) 0x5A, (byte) 0x65, (byte) 0x49, (byte) 0x54, (byte) 0x57, (byte) 0x28, (byte) 0x22, (byte) 0x24, (byte) 0x26, (byte) 0x7E, (byte) 0x24, (byte) 0x29, (byte) 0x55, (byte) 0x64, (byte) 0x29, (byte) 0x10, (byte) 0x2A, (byte) 0x3D, (byte) 0x14, (byte) 0x17, (byte) 0x0A, (byte) 0x3D, (byte) 0x05, (byte) 0x4C, (byte) 0x5F, (byte) 0x7D, (byte) 0x44, (byte) 0x4B, (byte) 0x57, (byte) 0x5A, (byte) 0x3A, (byte) 0x0D, (byte) 0x0A};
        // OrderLogin login = new OrderLogin(null, null, null);
        // login.bytesToObj(MessageUtils.encryptAndDecryptMess(datas));
        // System.out.println(login.toString());


        // DropOrder dropOrder = new DropOrder(null, null, null, null);
        // dropOrder.toOrderMess(sms);
        // System.out.println(dropOrder.toString());
        // OrderLogin login = new OrderLogin("11111", "11111", "123456");
        // List<String> list = new ArrayList<String>();
        // list.add("0");
        // login.setAttach(list);
        // login.toOrderMess(sms);
        // System.out.println(login.toString());
        // System.out.println(StringUtils.bytesToHexStr(login.objToBytes().get(0)));

    }
}
