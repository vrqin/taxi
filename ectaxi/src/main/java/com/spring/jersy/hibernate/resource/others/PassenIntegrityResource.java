package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.PassenIntegrity;
import com.spring.jersy.hibernate.model.service.PassenIntegrityService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 */
@Component
@Path("/passentegrity")
@Scope("prototype")
public class PassenIntegrityResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PassenIntegrityResource.class);
    private static final String tabname = "乘客诚信";
    @Context
    private HttpServletResponse response;

    @Resource
    private PassenIntegrityService passenIntegrityService;

    private List<PassenIntegrity> passenIntegrityList;

    private PassenIntegrity passenIntegrity;

    @POST
    @Path("findPassenIntegrityForPageList")
    @Produces("application/json;charset=utf-8")
    public String findPassenIntegrityForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("key") final String key, @QueryParam("isblacklist") final Integer isblacklist, @QueryParam("clientid") final Integer clientid, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = passenIntegrityService.findList(page, rows, sort, order, key, isblacklist, startime, endtime, ac_clientid);
            passenIntegrityList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, passenIntegrityList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("passSetIsblack")
    @Produces("application/json;charset=utf-8")
    public String passSetIsblack(@QueryParam("phone") final String phone, @QueryParam("isblack") final Integer isblack) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            passenIntegrity = passenIntegrityService.findPassenIntegrityByPhone(phone);
            if (!S.isNull(passenIntegrity)) {
                passenIntegrity.setIsblacklist(isblack);
                passenIntegrityService.saveOrUpd(passenIntegrity);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("设置乘客黑名单异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }


}
