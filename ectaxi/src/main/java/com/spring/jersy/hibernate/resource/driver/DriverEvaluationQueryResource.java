package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverEvaluationQuery;
import com.spring.jersy.hibernate.model.service.DriverEvaluationQueryService;
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
@Path("/driverEvaluationQuery")
@Scope("prototype")
public class DriverEvaluationQueryResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverEvaluationQueryResource.class);
    private static final String tabname = "DriverEvaluationQuery";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverEvaluationQueryService driverEvaluationQueryService;


    private List<DriverEvaluationQuery> driverEvaluationQueryList;

    private DriverEvaluationQuery driverEvaluationQuery;

    @POST
    @Path("findDriverEvaluationQueryForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverEvaluationQueryForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("evaluationlevel") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = driverEvaluationQueryService.findList(page, rows, sort, order, key, begintime, endtime, type);
            driverEvaluationQueryList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverEvaluationQueryList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findDriverEvaluationQueryByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverEvaluationQueryByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverEvaluationQuery = driverEvaluationQueryService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverEvaluationQuery);
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
    @Path("saveorupdateDriverEvaluationQuery")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverEvaluationQuery(@QueryParam("id") final Integer id, DriverEvaluationQuery redriverEvaluationQuery) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(redriverEvaluationQuery.getId()) ? redriverEvaluationQuery.getId() : 0;
            driverEvaluationQuery = driverEvaluationQueryService.findByid(re_id);
            if (!S.isNull(driverEvaluationQuery)) {
                driverEvaluationQueryService.saveOrUpd(redriverEvaluationQuery);
            } else {
                driverEvaluationQueryService.save(redriverEvaluationQuery);
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
    @Path("delDriverEvaluationQueryByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverEvaluationQueryByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverEvaluationQuery = driverEvaluationQueryService.findByid(re_id);
            if (!S.isNull(driverEvaluationQuery)) {
                driverEvaluationQueryService.delete(id);
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
