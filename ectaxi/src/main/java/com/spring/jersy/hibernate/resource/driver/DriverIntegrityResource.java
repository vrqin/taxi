package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverIntegrity;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.DriverIntegrityService;
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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * Created by Administrator on 2016/9/10.
 */
@Component
@Path("/driverintegrity")
@Scope("prototype")
public class DriverIntegrityResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverIntegrityResource.class);

    @Context
    private HttpServletResponse response;

    @Resource
    private DriverIntegrityService driverIntegrityService;

    @Resource
    private ClientService clientService;

    private List<DriverIntegrity> driverIntegrityList;

    private DriverIntegrity driverIntegrity;

    @GET
    @Path("findDriverIntegrityForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverIntegrityForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("enterprise") final String enterprise, @QueryParam("kabnum") final String kabnum, @QueryParam("key") final String key, @QueryParam("name") final String name, @QueryParam("isblack") final Integer isblack, @QueryParam("clientid") final Integer clientid, @QueryParam("rating") final Integer rating, @QueryParam("page") final int page, @QueryParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = driverIntegrityService.findList(page, rows, sort, order, key, name, kabnum, enterprise, rating, isblack, ac_clientid);
            driverIntegrityList = pageList.getList();
            if (!S.isListNull(driverIntegrityList) && driverIntegrityList.size() > 0) {
                for (DriverIntegrity drity : driverIntegrityList) {
                    if (!S.isNull(drity.getClientid())) {
                        if (!S.isNull(clientService.findByid(drity.getClientid()))) {
                            drity.setEnterprise(clientService.findByid(drity.getClientid()).getCompany());
                        }
                    }
                }
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverIntegrityList);

        } catch (Exception e) {
            LOGGER.error("加载司机诚信数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }


    }

    @GET
    @Path("findDriverIntegrityPunishmentForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverIntegrityPunishmentForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("enterprise") final String enterprise, @QueryParam("kabnum") final String kabnum, @QueryParam("key") final String key, @QueryParam("name") final String name, @QueryParam("isblack") final Integer isblack, @QueryParam("clientid") final Integer clientid, @QueryParam("rating") final Integer rating, @QueryParam("page") final int page, @QueryParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            driverIntegrityList = driverIntegrityService.findPunishmentList(key, ac_clientid);
            if (!S.isListNull(driverIntegrityList) && driverIntegrityList.size() > 0) {
                for (DriverIntegrity drity : driverIntegrityList) {
                    if (!S.isNull(drity.getClientid())) {
                        if (!S.isNull(clientService.findByid(drity.getClientid()))) {
                            drity.setEnterprise(clientService.findByid(drity.getClientid()).getCompany());
                        }
                    }
                }
            }
            total = driverIntegrityList.size();
            return ReturePageList(total, driverIntegrityList);

        } catch (Exception e) {
            LOGGER.error("加载司机诚信数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }


    }

    @GET
    @Path("driverSetIsblack")
    @Produces("application/json;charset=utf-8")
    public String driverSetIsblack(@QueryParam("phone") final String phone, @QueryParam("isblack") final Integer isblack, @QueryParam("clientid") final int clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driverIntegrity = driverIntegrityService.findDriverIntegrityByPhone(phone);
            if (!S.isNull(driverIntegrity)) {
                driverIntegrity.setIsblacklist(isblack);
                driverIntegrityService.saveOrUpd(driverIntegrity);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("设置司机黑名单异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

}
