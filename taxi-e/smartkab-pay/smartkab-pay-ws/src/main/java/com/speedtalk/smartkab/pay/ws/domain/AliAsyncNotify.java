package com.speedtalk.smartkab.pay.ws.domain;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import javax.ws.rs.FormParam;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class AliAsyncNotify {
    @FormParam("notify_time")
    private String notify_time;
    @FormParam("notify_type")
    private String notify_type;
    @FormParam("notify_id")
    private String notify_id;
    @FormParam("sign_type")
    private String sign_type;
    @FormParam("sign")
    private String sign;
    @FormParam("trade_no")
    private String trade_no;
    @FormParam("app_id")
    private String app_id;
    @FormParam("out_trade_no")
    private String out_trade_no;
    @FormParam("out_biz_no")
    private String out_biz_no;
    @FormParam("buyer_id")
    private String buyer_id;
    @FormParam("buyer_logon_id")
    private String buyer_logon_id;
    @FormParam("seller_id")
    private String seller_id;
    @FormParam("seller_email")
    private String seller_email;
    @FormParam("trade_status")
    private String trade_status;
    @FormParam("total_amount")
    private float total_amount;
    @FormParam("receipt_amount")
    private float receipt_amount;
    @FormParam("invoice_amount")
    private float invoice_amount;
    @FormParam("buyer_pay_amount")
    private float buyer_pay_amount;
    @FormParam("point_amount")
    private float point_amount;
    @FormParam("refund_fee")
    private float refund_fee;
    @FormParam("send_back_fee")
    private float send_back_fee;
    @FormParam("subject")
    private String subject;
    @FormParam("body")
    private String body;
    @FormParam("gmt_create")
    private String gmt_create;
    @FormParam("gmt_payment")
    private String gmt_payment;
    @FormParam("gmt_refund")
    private String gmt_refund;
    @FormParam("gmt_close")
    private String gmt_close;
    @FormParam("fund_bill_list")
    private String fund_bill_list;

    public AliAsyncNotify() {
    }

    public static void main(String[] args) throws AlipayApiException {
        Map<String, String> signMap = new HashMap<String, String>();
        //		signMap.put("notify_time","2016-10-11 16:39:56");
        //		signMap.put("notify_type","trade_status_sync");
        //		signMap.put("notify_id","ba22c83ac8a0dc3664c879996c9dbc3j5y");
        //		signMap.put("sign_type","RSA");
        //		signMap.put("sign","oaruJtgwqEYSKl38azlGyiTztYiAPPrFrN4RwI5FHf+tfhiAu2mqv2TVxStGpcrxzfH6Ab9G9em81rfh352wJkRul8aaQRg+BGqlOKpHyjuT9hPxgFeaogmET9I4sbW0v8dHm+T7KxDH01pqjtlMXHOQ0OlciTU5eQb46yeWM/Y=");
        //		signMap.put("trade_no","2016101121001004410224120078");
        //		signMap.put("app_id","2016080901723758");
        //		signMap.put("out_trade_no","20160829150001006abc_26");
        //		signMap.put("out_biz_no","null");
        //		signMap.put("buyer_id","2088222946149412");
        //		signMap.put("buyer_logon_id","159****5544");
        //		signMap.put("seller_id","2088421601667173");
        //		signMap.put("seller_email","server@speedtalk.cn");
        //		signMap.put("trade_status","TRADE_SUCCESS");
        //		signMap.put("total_amount","0.01");
        //		signMap.put("receipt_amount","0.01");
        //		signMap.put("invoice_amount","0.01");
        //		signMap.put("buyer_pay_amount","0.01");
        //		signMap.put("point_amount","0.0");
        //		signMap.put("refund_fee","0.0");
        //		signMap.put("send_back_fee","0.0");
        //		signMap.put("subject","打车:粤A123456-电话:13012345678");
        //		signMap.put("body","null");
        //		signMap.put("gmt_create","2016-10-11 16:39:43");
        //		signMap.put("gmt_payment","2016-10-11 16:39:56");
        //		signMap.put("gmt_refund","null");
        //		signMap.put("gmt_close","null");
        //		signMap.put("fund_bill_list","[{\"amount\":\"0.01\",\"fundChannel\":\"ALIPAYACCOUNT\"}]");

        signMap.put("buyer_id", "2088222946149412");
        signMap.put("total_amount", "0.01");
        signMap.put("trade_no", "2016101121001004410224119264");
        signMap.put("notify_time", "2016-10-11 16:17:34");
        signMap.put("open_id", "20880073920006966552017100911741");
        signMap.put("subject", "打车:粤A123456-电话:13012345678");
        signMap.put("sign_type", "RSA");
        signMap.put("buyer_logon_id", "159****5544");
        signMap.put("notify_type", "trade_status_sync");
        signMap.put("invoice_amount", "0.01");
        signMap.put("out_trade_no", "20160829150001006abc_24");
        signMap.put("trade_status", "TRADE_SUCCESS");
        signMap.put("gmt_payment", "2016-10-11 16:17:34");
        signMap.put("point_amount", "0.0");
        signMap.put("sign", "L2KHJvBoS0/v08/gcHEu9ZoQNqiq9ctYaVMyQGgiSZ4nt6ls86iHoWYE2qNRmk6hvaen+mUzu+lGoEjZjgE1969Xkk4orMkUl0DgQe6uSGboROrNCB82UCvSUJmHHiQEzftzD+nL9TQKGweR4XKtOrX58tTRHz+BL1/sM2gLbXE=");
        signMap.put("gmt_create", "2016-10-11 16:17:26");
        signMap.put("buyer_pay_amount", "0.01");
        signMap.put("receipt_amount", "0.01");
        signMap.put("fund_bill_list", "[{\"amount\":\"0.01\",\"fundChannel\":\"ALIPAYACCOUNT\"}]");
        signMap.put("app_id", "2016080901723758");
        signMap.put("seller_id", "2088421601667173");
        signMap.put("notify_id", "9299c85e3530dee633ff317506e8c4fj5y");
        signMap.put("seller_email", "server@speedtalk.cn");

        boolean isOk = AlipaySignature.rsaCheckV2(signMap, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB", "utf-8");
        System.out.println(isOk);
    }

    public String getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(String notify_time) {
        this.notify_time = notify_time;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public float getReceipt_amount() {
        return receipt_amount;
    }

    public void setReceipt_amount(float receipt_amount) {
        this.receipt_amount = receipt_amount;
    }

    public float getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(float invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public float getBuyer_pay_amount() {
        return buyer_pay_amount;
    }

    public void setBuyer_pay_amount(float buyer_pay_amount) {
        this.buyer_pay_amount = buyer_pay_amount;
    }

    public float getPoint_amount() {
        return point_amount;
    }

    public void setPoint_amount(float point_amount) {
        this.point_amount = point_amount;
    }

    public float getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(float refund_fee) {
        this.refund_fee = refund_fee;
    }

    public float getSend_back_fee() {
        return send_back_fee;
    }

    public void setSend_back_fee(float send_back_fee) {
        this.send_back_fee = send_back_fee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(String gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public String getGmt_refund() {
        return gmt_refund;
    }

    public void setGmt_refund(String gmt_refund) {
        this.gmt_refund = gmt_refund;
    }

    public String getGmt_close() {
        return gmt_close;
    }

    public void setGmt_close(String gmt_close) {
        this.gmt_close = gmt_close;
    }

    public String getFund_bill_list() {
        return fund_bill_list;
    }

    public void setFund_bill_list(String fund_bill_list) {
        this.fund_bill_list = fund_bill_list;
    }

    public Map<String, String> getSignMap() {
        Map<String, String> map = new HashMap<String, String>();
        Class<AliAsyncNotify> notice = (Class<AliAsyncNotify>) this.getClass();
        Field[] fields = notice.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            //			if(f.getName().equals("sign_type"))
            //				continue;
            try {
                map.put(f.getName(), (String) f.get(this));
            } catch (Exception e) {
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return "AliAsyncNotify [notify_time=" + notify_time + ", notify_type=" + notify_type + ", notify_id=" + notify_id + ", sign_type=" + sign_type + ", sign=" + sign + ", trade_no=" + trade_no + ", app_id=" + app_id + ", out_trade_no=" + out_trade_no + ", out_biz_no=" + out_biz_no + ", buyer_id=" + buyer_id + ", buyer_logon_id=" + buyer_logon_id + ", seller_id=" + seller_id + ", seller_email=" + seller_email + ", trade_status=" + trade_status + ", total_amount=" + total_amount + ", receipt_amount=" + receipt_amount + ", invoice_amount=" + invoice_amount + ", buyer_pay_amount=" + buyer_pay_amount + ", point_amount=" + point_amount + ", refund_fee=" + refund_fee + ", send_back_fee=" + send_back_fee + ", subject=" + subject + ", body=" + body + ", gmt_create=" + gmt_create + ", gmt_payment=" + gmt_payment + ", gmt_refund=" + gmt_refund + ", gmt_close=" + gmt_close + ", fund_bill_list=" + fund_bill_list + "]";
    }
}
