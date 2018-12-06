package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverIncomeStatisDay;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.DriverIncomeStatisDayService;
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
@Path("/driverIncomeStatisDay")
@Scope("prototype")
public class DriverIncomeStatisDayResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverIncomeStatisDayResource.class);
    private static final String tabname = "DriverIncomeStatisDay";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverIncomeStatisDayService driverIncomeStatisDayService;

    @Resource
    private CallBussService callBussService;


    private List<DriverIncomeStatisDay> driverIncomeStatisDayList;

    private DriverIncomeStatisDay driverIncomeStatisDay;

    @POST
    @Path("findDriverIncomeStatisDayForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeStatisDayForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            //            PageList pageList =driverIncomeStatisDayService.findList(page, rows, sort, order, key, begintime, endtime, type);
            driverIncomeStatisDayList = callBussService.findDriverIncomeStatisDay(begintime, endtime, ac_clientid, key);
            total = driverIncomeStatisDayList.size();
            return ReturePageList(total, driverIncomeStatisDayList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverIncomeStatisDayByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeStatisDayByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatisDay = driverIncomeStatisDayService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverIncomeStatisDay);
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
    @Path("saveorupdateDriverIncomeStatisDay")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverIncomeStatisDay(@QueryParam("id") final Integer id, DriverIncomeStatisDay redriverIncomeStatisDay) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatisDay = driverIncomeStatisDayService.findByid(re_id);
            if (!S.isNull(driverIncomeStatisDay)) {
                driverIncomeStatisDayService.saveOrUpd(redriverIncomeStatisDay);
            } else {
                driverIncomeStatisDayService.save(redriverIncomeStatisDay);
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
    @Path("delDriverIncomeStatisDayByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverIncomeStatisDayByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeStatisDay = driverIncomeStatisDayService.findByid(re_id);
            if (!S.isNull(driverIncomeStatisDay)) {
                driverIncomeStatisDayService.delete(id);
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
