package com.speedtalk.order.test;

import com.speedtalk.protocol.order.objs.NewOrder;
import com.speedtalk.protocol.utils.MessageUtils;
import com.speedtalk.protocol.utils.StringUtils;

import java.util.List;

public class TestConstants {
    public final static String ACCOUNT = "12345678910";
    public final static String NAME = "chen";

    public static void main(String[] args) throws Exception {
        //		StringUtils.setEncoding("utf-8");
        //		OrderLogout logout = new OrderLogout(ACCOUNT,NAME);
        //		Resp test = new Resp(ACCOUNT,NAME
        //				,OrderMessConstants.UPDATE_PWD_RESP,OrderMessConstants.FAILURE,null);
        //		test.setCode(OrderMessConstants.SUCCESS);
        //		UpdateDriverInfo test = new UpdateDriverInfo(ACCOUNT,NAME,"","粤A12332","1000");
        //		UpdatePwd test = new UpdatePwd(ACCOUNT,NAME,"123","321");
        NewOrder test = new NewOrder(ACCOUNT, NAME, "123456", "天河", "1.1", "1.2", "萝岗", "2.1", "2.2", "2016-04-07 11:38:17", "", "0");
        //		Order test = new Order(ACCOUNT,NAME,OrderMessConstants.DROP_ORDER_RESP,"");
        //		AcceptOrderResp test = new AcceptOrderResp(ACCOUNT,NAME,"16031700000",OrderMessConstants.FAILURE,"kfdi");
        test.setOrderNum("160407113817019");
        //		DropOrder test = new DropOrder(ACCOUNT,NAME,"16031700000","fejij");
        List<byte[]> list = test.objToBytes();
        NewOrder temp = null;
        for (byte[] bs : list) {
            System.out.println("for :" + StringUtils.bytesToHexStr(bs));
            temp = new NewOrder(ACCOUNT, NAME, "", "", "", "", "", "", "", "", "", "0");
            temp.bytesToObj(MessageUtils.encryptAndDecryptMess(bs));
            System.out.println(temp.toString());

        }
    }
}
