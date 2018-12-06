package com.spring.jersy.hibernate.resource.illegal;

import com.spring.jersy.hibernate.model.entity.IllegalNumStatistics;
import com.spring.jersy.hibernate.model.service.IllegalNumStatisticsService;
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
@Path("/illegalNumStatistics")
@Scope("prototype")
public class IllegalNumStatisticsResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(IllegalNumStatisticsResource.class);
    private static final String tabname = "IllegalNumStatistics";
    @Context
    private HttpServletResponse response;


    @Resource
    private IllegalNumStatisticsService illegalNumStatisticsService;


    private List<IllegalNumStatistics> illegalNumStatisticsList;

    private IllegalNumStatistics illegalNumStatistics;

    @POST
    @Path("findIllegalNumStatisticsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findIllegalNumStatisticsForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("illegaltype") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = illegalNumStatisticsService.findList(page, rows, sort, order, key, begintime, endtime, type);
            illegalNumStatisticsList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, illegalNumStatisticsList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findIllegalNumStatisticsByid")
    @Produces("application/json;charset=utf-8")
    public String findIllegalNumStatisticsByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            illegalNumStatistics = illegalNumStatisticsService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(illegalNumStatistics);
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
    @Path("saveorupdateIllegalNumStatistics")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateIllegalNumStatistics(@QueryParam("id") final Integer id, IllegalNumStatistics reillegalNumStatistics) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            illegalNumStatistics = illegalNumStatisticsService.findByid(re_id);
            if (!S.isNull(illegalNumStatistics)) {
                illegalNumStatisticsService.saveOrUpd(reillegalNumStatistics);
            } else {
                illegalNumStatisticsService.save(reillegalNumStatistics);
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
    @Path("delIllegalNumStatisticsByid")
    @Produces("application/json;charset=utf-8")
    public String delIllegalNumStatisticsByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            illegalNumStatistics = illegalNumStatisticsService.findByid(re_id);
            if (!S.isNull(illegalNumStatistics)) {
                illegalNumStatisticsService.delete(id);
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
