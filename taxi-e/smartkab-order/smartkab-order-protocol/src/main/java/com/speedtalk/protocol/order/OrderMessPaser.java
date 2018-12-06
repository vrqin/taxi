package com.speedtalk.protocol.order;

import com.speedtalk.protocol.exceptions.MessageMistakenException;
import com.speedtalk.protocol.order.objs.*;
import com.speedtalk.protocol.tscobjs.SMS;

public class OrderMessPaser {
    private static OrderMessPaser instance = new OrderMessPaser();

    private OrderMessPaser() {
    }

    public static OrderMessPaser getInstance() {
        return instance;
    }

    public OrderMess parse(SMS sms) throws NullPointerException, MessageMistakenException {
        if (null == sms)
            throw new NullPointerException("SMS object is NULL!");
        if (null == sms.getContent() || !sms.getContent().startsWith(OrderMessConstants.HEAD))
            throw new MessageMistakenException("Order message error!");
        try {
            String messId = sms.getContent().split(OrderMessConstants.SPLITTER)[1];
            if (messId.equals(OrderMessConstants.LOGIN))
                return new OrderLogin(null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.LOGIN_EXT))
                return new OrderLoginExt(null, null, null, OrderMessConstants.ACCOUNT_LOGIN_TYPE).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.LOGIN_RESP))
                return new OrderLoginResp(null, null, null, null, null, null, null, null, null, null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.LOGOUT))
                return new OrderLogout(null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.LOGOUT_RESP) || messId.equals(OrderMessConstants.UPDATE_DRIVER_INFO_RESP) || messId
                    .equals(OrderMessConstants.UPDATE_PWD_RESP))
                return new Resp(null, null, messId, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.UPDATE_DRIVER_INFO))
                return new UpdateDriverInfo(null, null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.UPDATE_PWD))
                return new UpdatePwd(null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.NEW_ORDER))
                return new NewOrder(null, null, null, null, null, null, null, null, null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.NEW_ORDER_RESP) || messId.equals(OrderMessConstants.ACCEPT_ORDER) || messId
                    .equals(OrderMessConstants.GET_PASSENGER) || messId.equals(OrderMessConstants.ARRIVED))
                return new Order(null, null, messId, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.ACCEPT_ORDER_RESP))
                return new AcceptOrderResp(null, null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.DROP_ORDER))
                return new DropOrder(null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.DROP_ORDER_RESP))
                return new Order(null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.FORCE_LOGOUT))
                return new ForceLogout(null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.ORDER_INTERACTIVE))
                return new OrderInteractive(null, null, null, (byte) 0, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.COMMOM_CONFIRM))
                return new CommonConfirm(null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.PAY_INFO))
                return new PayInfo(null, null, (byte) 0, null, null, null, null, null, null, null, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.PAY_INFO_RESP))
                return new PayInfoResp(null, null, null, (byte) 0, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.PAY_RESULT))
                return new PayResult(null, null, null, (byte) 0, null).toOrderMess(sms);
            else if (messId.equals(OrderMessConstants.ORDER_SMS))
                return new OrderSms(null, null, null).toOrderMess(sms);
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
}
