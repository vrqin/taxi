package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.model.entity.UsagePlatform;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.UsagePlatformService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONArray;
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


@Component
@Path("/usagePlatform")
@Scope("prototype")
public class UsagePlatformResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UsagePlatformResource.class);
    private static final String tabname = "UsagePlatform";
    @Context
    private HttpServletResponse response;


    @Resource
    private UsagePlatformService usagePlatformService;

    @Resource
    private ClientService clientService;

    private List<UsagePlatform> usagePlatformList;

    private UsagePlatform usagePlatform;

    @POST
    @Path("findUsagePlatformForPageList")
    @Produces("application/json;charset=utf-8")
    public String findUsagePlatformForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final int clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_key = key;
            if (!S.isNull(key)) {
                Client client = clientService.findbyCompany(ac_key);
                if (!S.isNull(client)) {
                    ac_key = String.valueOf(client.getClientId());
                }
            }
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = usagePlatformService.findList(page, rows, sort, order, ac_key, begintime, endtime, type, ac_clientid);
            usagePlatformList = pageList.getList();

            for (UsagePlatform u : usagePlatformList) {
                if (!S.isNull(clientService.findByid(u.getEnterprise()))) {
                    u.setCompany(clientService.findByid(u.getEnterprise()).getCompany());
                }
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, usagePlatformList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findUsagePlatformByid")
    @Produces("application/json;charset=utf-8")
    public String findUsagePlatformByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            usagePlatform = usagePlatformService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(usagePlatform);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "根据Id查找：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("saveorupdateUsagePlatform")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateUsagePlatform(@QueryParam("id") final Integer id, UsagePlatform reusagePlatform) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            usagePlatform = usagePlatformService.findByid(re_id);
            if (!S.isNull(usagePlatform)) {
                usagePlatformService.saveOrUpd(reusagePlatform);
            } else {
                usagePlatformService.save(reusagePlatform);
            }
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("添加或修改" + tabname + "异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @DELETE
    @Path("delUsagePlatformByid")
    @Produces("application/json;charset=utf-8")
    public String delUsagePlatformByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            usagePlatform = usagePlatformService.findByid(re_id);
            if (!S.isNull(usagePlatform)) {
                usagePlatformService.delete(id);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("删除" + tabname + "信息异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


}
