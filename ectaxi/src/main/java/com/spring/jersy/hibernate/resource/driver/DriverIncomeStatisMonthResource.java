package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverIncomeStatisMonth;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.DriverIncomeStatisMonthService;
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
@Path("/driverIncomeStatisMonth")
@Scope("prototype")
public class DriverIncomeStatisMonthResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverIncomeStatisMonthResource.class);
    private static final String tabname = "DriverIncomeStatisMonth";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverIncomeStatisMonthService driverIncomeStatisMonthService;

    @Resource
    private CallBussService callBussService;

    private List<DriverIncomeStatisMonth> driverIncomeStatisMonthList;

    private DriverIncomeStatisMonth driverIncomeStatisMonth;

    @POST
    @Path("findDriverIncomeStatisMonthForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeStatisMonthForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            //            PageList pageList =driverIncomeStatisMonthService.findList(page, rows, sort, order, key, begintime, endtime, type);
            driverIncomeStatisMonthList = callBussService.findDriverIncomeStatisMonth(begintime, endtime, ac_clientid, key);
            total = driverIncomeStatisMonthList.size();
            return ReturePageList(total, driverIncomeStatisMonthList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverIncomeStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeStatisMonthByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatisMonth = driverIncomeStatisMonthService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverIncomeStatisMonth);
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
    @Path("saveorupdateDriverIncomeStatisMonth")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverIncomeStatisMonth(@QueryParam("id") final Integer id, DriverIncomeStatisMonth redriverIncomeStatisMonth) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatisMonth = driverIncomeStatisMonthService.findByid(re_id);
            if (!S.isNull(driverIncomeStatisMonth)) {
                driverIncomeStatisMonthService.saveOrUpd(redriverIncomeStatisMonth);
            } else {
                driverIncomeStatisMonthService.save(redriverIncomeStatisMonth);
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
    @Path("delDriverIncomeStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverIncomeStatisMonthByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatisMonth = driverIncomeStatisMonthService.findByid(re_id);
            if (!S.isNull(driverIncomeStatisMonth)) {
                driverIncomeStatisMonthService.delete(id);
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
