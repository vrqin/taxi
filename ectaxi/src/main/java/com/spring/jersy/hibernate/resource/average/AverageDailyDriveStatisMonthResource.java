package com.spring.jersy.hibernate.resource.average;

import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisMonth;
import com.spring.jersy.hibernate.model.service.AverageDailyDriveStatisMonthService;
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
@Path("/averageDailyDriveStatisMonth")
@Scope("prototype")
public class AverageDailyDriveStatisMonthResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(AverageDailyDriveStatisMonthResource.class);
    private static final String tabname = "AverageDailyDriveStatisMonth";
    @Context
    private HttpServletResponse response;


    @Resource
    private AverageDailyDriveStatisMonthService averageDailyDriveStatisMonthService;


    private List<AverageDailyDriveStatisMonth> averageDailyDriveStatisMonthList;

    private AverageDailyDriveStatisMonth averageDailyDriveStatisMonth;

    @POST
    @Path("findAverageDailyDriveStatisMonthForPageList")
    @Produces("application/json;charset=utf-8")
    public String findAverageDailyDriveStatisMonthForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("annual") final String annual, @QueryParam("cycle") final int cycle, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = averageDailyDriveStatisMonthService.findList(page, rows, sort, order, key, annual, cycle, type);
            averageDailyDriveStatisMonthList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, averageDailyDriveStatisMonthList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findAverageDailyDriveStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String findAverageDailyDriveStatisMonthByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            averageDailyDriveStatisMonth = averageDailyDriveStatisMonthService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(averageDailyDriveStatisMonth);
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
    @Path("saveorupdateAverageDailyDriveStatisMonth")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateAverageDailyDriveStatisMonth(@QueryParam("id") final Integer id, AverageDailyDriveStatisMonth reaverageDailyDriveStatisMonth) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            averageDailyDriveStatisMonth = averageDailyDriveStatisMonthService.findByid(re_id);
            if (!S.isNull(averageDailyDriveStatisMonth)) {
                averageDailyDriveStatisMonthService.saveOrUpd(reaverageDailyDriveStatisMonth);
            } else {
                averageDailyDriveStatisMonthService.save(reaverageDailyDriveStatisMonth);
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
    @Path("delAverageDailyDriveStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String delAverageDailyDriveStatisMonthByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            averageDailyDriveStatisMonth = averageDailyDriveStatisMonthService.findByid(re_id);
            if (!S.isNull(averageDailyDriveStatisMonth)) {
                averageDailyDriveStatisMonthService.delete(id);
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
