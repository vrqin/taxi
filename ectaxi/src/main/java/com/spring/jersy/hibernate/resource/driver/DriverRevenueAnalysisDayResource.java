package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverRevenueAnalysisDay;
import com.spring.jersy.hibernate.model.service.DriverRevenueAnalysisDayService;
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
@Path("/driverRevenueAnalysisDay")
@Scope("prototype")
public class DriverRevenueAnalysisDayResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverRevenueAnalysisDayResource.class);
    private static final String tabname = "DriverRevenueAnalysisDay";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverRevenueAnalysisDayService driverRevenueAnalysisDayService;


    private List<DriverRevenueAnalysisDay> driverRevenueAnalysisDayList;

    private DriverRevenueAnalysisDay driverRevenueAnalysisDay;

    @POST
    @Path("findDriverRevenueAnalysisDayForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverRevenueAnalysisDayForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = driverRevenueAnalysisDayService.findList(page, rows, sort, order, key, begintime, endtime, type);
            driverRevenueAnalysisDayList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverRevenueAnalysisDayList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverRevenueAnalysisDayByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverRevenueAnalysisDayByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverRevenueAnalysisDay = driverRevenueAnalysisDayService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverRevenueAnalysisDay);
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
    @Path("saveorupdateDriverRevenueAnalysisDay")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverRevenueAnalysisDay(@QueryParam("id") final Integer id, DriverRevenueAnalysisDay redriverRevenueAnalysisDay) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverRevenueAnalysisDay = driverRevenueAnalysisDayService.findByid(re_id);
            if (!S.isNull(driverRevenueAnalysisDay)) {
                driverRevenueAnalysisDayService.saveOrUpd(redriverRevenueAnalysisDay);
            } else {
                driverRevenueAnalysisDayService.save(redriverRevenueAnalysisDay);
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
    @Path("delDriverRevenueAnalysisDayByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverRevenueAnalysisDayByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverRevenueAnalysisDay = driverRevenueAnalysisDayService.findByid(re_id);
            if (!S.isNull(driverRevenueAnalysisDay)) {
                driverRevenueAnalysisDayService.delete(id);
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
