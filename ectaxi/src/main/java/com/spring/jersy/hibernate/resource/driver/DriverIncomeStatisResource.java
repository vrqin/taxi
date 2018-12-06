package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverIncomeStatis;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.DriverIncomeStatisService;
import com.spring.jersy.hibernate.publics.util.Constants;
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
@Path("/driverIncomeStatis")
@Scope("prototype")
public class DriverIncomeStatisResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverIncomeStatisResource.class);
    private static final String tabname = "DriverIncomeStatis";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverIncomeStatisService driverIncomeStatisService;
    @Resource
    private CallBussService callBussService;

    private List<DriverIncomeStatis> driverIncomeStatisList;

    private DriverIncomeStatis driverIncomeStatis;

    @POST
    @Path("findDriverIncomeStatisForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeStatisForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("clientit") final int clientit, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientit) ? clientit : 0;
            //            PageList pageList =driverIncomeStatisService.findList(page, rows, sort, order, key, begintime, endtime, type);
            driverIncomeStatisList = callBussService.findDriverIncomeStatis(begintime, endtime, ac_clientid, key);
            total = driverIncomeStatisList.size();
            return ReturePageList(total, driverIncomeStatisList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverIncomeStatisByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeStatisByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatis = driverIncomeStatisService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverIncomeStatis);
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
    @Path("saveorupdateDriverIncomeStatis")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverIncomeStatis(@QueryParam("id") final Integer id, DriverIncomeStatis redriverIncomeStatis) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatis = driverIncomeStatisService.findByid(re_id);
            if (!S.isNull(driverIncomeStatis)) {
                driverIncomeStatisService.saveOrUpd(redriverIncomeStatis);
            } else {
                driverIncomeStatisService.save(redriverIncomeStatis);
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
    @Path("delDriverIncomeStatisByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverIncomeStatisByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatis = driverIncomeStatisService.findByid(re_id);
            if (!S.isNull(driverIncomeStatis)) {
                driverIncomeStatisService.delete(id);
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
