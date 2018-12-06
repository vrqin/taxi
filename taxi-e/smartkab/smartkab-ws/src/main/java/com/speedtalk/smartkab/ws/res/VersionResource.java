package com.speedtalk.smartkab.ws.res;

import com.speedtalk.smartkab.ws.*;
import com.speedtalk.smartkab.ws.domain.Response;
import com.speedtalk.smartkab.ws.domain.Version;
import com.speedtalk.utils.LoadXmlConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("version")
public class VersionResource {
    @GET
    @Path("getiosv")
    @Produces(MediaType.APPLICATION_JSON)
    public Version getVersion(@QueryParam("mark") final String mark) {
        Version version = new Version();
        if (mark == null) {
            version.setV(LoadXmlConfig.getConfigHash().get("ios-version"));
            version.setUurl(LoadXmlConfig.getConfigHash().get("ios-update-url"));
            version.setFv(LoadXmlConfig.getConfigHash().get("ios-force-version"));
            version.setUdesc(LoadXmlConfig.getConfigHash().get("ios-update-desc"));
        } else if (mark.equals("p")) {
            version.setV(LoadXmlConfig.getConfigHash().get("ios-p-version"));
            version.setUurl(LoadXmlConfig.getConfigHash().get("ios-p-update-url"));
            version.setFv(LoadXmlConfig.getConfigHash().get("ios-p-force-version"));
            version.setUdesc(LoadXmlConfig.getConfigHash().get("ios-p-update-desc"));
        } else {
        }
        return version;
    }

    @GET
    @Path("getandroidv")
    @Produces(MediaType.APPLICATION_JSON)
    public Version getAndroidVersion(@QueryParam("mark") final String mark) {
        Version version = new Version();
        if (mark == null || mark.trim().equals("")) {
            version.setV(LoadXmlConfig.getConfigHash().get("android-version"));
            version.setUurl(LoadXmlConfig.getConfigHash().get("android-update-url"));
            version.setFv(LoadXmlConfig.getConfigHash().get("android-force-version"));
            version.setUdesc(LoadXmlConfig.getConfigHash().get("android-update-desc"));
        } else if (mark.equals("p")) {
            version.setV(LoadXmlConfig.getConfigHash().get("android-p-version"));
            version.setUurl(LoadXmlConfig.getConfigHash().get("android-p-update-url"));
            version.setFv(LoadXmlConfig.getConfigHash().get("android-p-force-version"));
            version.setUdesc(LoadXmlConfig.getConfigHash().get("android-p-update-desc"));
        } else {
            version.setV(LoadXmlConfig.getConfigHash().get(mark + "-android-version"));
            version.setUurl(LoadXmlConfig.getConfigHash().get(mark + "-android-update-url"));
            version.setFv(LoadXmlConfig.getConfigHash().get(mark + "-android-force-version"));
            version.setUdesc(LoadXmlConfig.getConfigHash().get(mark + "-android-update-desc"));
        }
        return version;
    }

    @GET
    @Path("code")
    @Produces(MediaType.APPLICATION_JSON)
    /**
     * 通过手机号码获取验证码
     * @param mobilePhone 手机号码
     * @return 验证码
     */ public Response getCode(@QueryParam("mobile") final String mobile) {
        Response resp = new Response(Constants.SUCCESS_RESP, "");
        boolean isPhone = Utils.isPhone(mobile);
        if (!isPhone) {
            resp.setCode(Constants.PHONE_ERROR_RESP);
            resp.setDesc(Constants.PHOE_ERROR_DESC_RESP);
            System.out.println(Utils.getLogFix() + mobile + "," + resp.getDesc());
            return resp;
        }
        ValidateCode validateCode = ValidateCodeStorer.get(mobile);
        long time = System.currentTimeMillis();
        if (validateCode != null && time - validateCode.getTime() <= ValidateCodeStorer.VALIDATE_CODE_TIME_OUT) {
            resp.setCode(Constants.CODE_SENT_RESP);
            resp.setDesc(Constants.CODE_SENT_DESC_RESP);
            System.out.println(Utils.getLogFix() + mobile + "," + resp.getDesc());
            return resp;
        }

        String code = ValidateCodeCreater.getCode();
        validateCode = new ValidateCode(mobile, code, System.currentTimeMillis());
        ValidateCodeStorer.store(validateCode);
        String result = SmsSender.sendValidateCode(mobile, code);
        System.out.println(Utils.getLogFix() + mobile + ",get validate code:" + code + "\n" + result);
        return resp;
    }
}
