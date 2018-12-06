package com.spring.jersy.hibernate.resource.operate;

import com.spring.jersy.hibernate.model.entity.OperateRangeTimeCycle;
import com.spring.jersy.hibernate.model.service.OperateRangeTimeCycleService;
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
@Path("/operateRangeTimeCycle")
@Scope("prototype")
public class OperateRangeTimeCycleResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(OperateRangeTimeCycleResource.class);
    private static final String tabname = "OperateRangeTimeCycle";
    @Context
    private HttpServletResponse response;


    @Resource
    private OperateRangeTimeCycleService operateRangeTimeCycleService;


    private List<OperateRangeTimeCycle> operateRangeTimeCycleList;

    private OperateRangeTimeCycle operateRangeTimeCycle;

    @POST
    @Path("findOperateRangeTimeCycleForPageList")
    @Produces("application/json;charset=utf-8")
    public String findOperateRangeTimeCycleForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = operateRangeTimeCycleService.findList(page, rows, sort, order, key, begintime, endtime, type);
            operateRangeTimeCycleList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, operateRangeTimeCycleList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findOperateRangeTimeCycleByid")
    @Produces("application/json;charset=utf-8")
    public String findOperateRangeTimeCycleByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            operateRangeTimeCycle = operateRangeTimeCycleService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(operateRangeTimeCycle);
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
    @Path("saveorupdateOperateRangeTimeCycle")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateOperateRangeTimeCycle(@QueryParam("id") final Integer id, OperateRangeTimeCycle reoperateRangeTimeCycle) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            operateRangeTimeCycle = operateRangeTimeCycleService.findByid(re_id);
            if (!S.isNull(operateRangeTimeCycle)) {
                operateRangeTimeCycleService.saveOrUpd(reoperateRangeTimeCycle);
            } else {
                operateRangeTimeCycleService.save(reoperateRangeTimeCycle);
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
    @Path("delOperateRangeTimeCycleByid")
    @Produces("application/json;charset=utf-8")
    public String delOperateRangeTimeCycleByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            operateRangeTimeCycle = operateRangeTimeCycleService.findByid(re_id);
            if (!S.isNull(operateRangeTimeCycle)) {
                operateRangeTimeCycleService.delete(id);
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
