package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseEvaluationQuery;
import com.spring.jersy.hibernate.model.service.EnterpriseEvaluationQueryService;
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
@Path("/enterpriseEvaluationQuery")
@Scope("prototype")
public class EnterpriseEvaluationQueryResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseEvaluationQueryResource.class);
    private static final String tabname = "EnterpriseEvaluationQuery";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseEvaluationQueryService enterpriseEvaluationQueryService;


    private List<EnterpriseEvaluationQuery> enterpriseEvaluationQueryList;

    private EnterpriseEvaluationQuery enterpriseEvaluationQuery;

    @POST
    @Path("findEnterpriseEvaluationQueryForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseEvaluationQueryForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("evaluationlevel") final int level, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            PageList pageList = enterpriseEvaluationQueryService.findList(page, rows, sort, order, key, begintime, endtime, level);
            enterpriseEvaluationQueryList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, enterpriseEvaluationQueryList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findEnterpriseEvaluationQueryByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseEvaluationQueryByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseEvaluationQuery = enterpriseEvaluationQueryService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseEvaluationQuery);
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
    @Path("saveorupdateEnterpriseEvaluationQuery")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseEvaluationQuery(@QueryParam("id") final Integer id, EnterpriseEvaluationQuery reenterpriseEvaluationQuery, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(reenterpriseEvaluationQuery.getId()) ? reenterpriseEvaluationQuery.getId() : 0;
            enterpriseEvaluationQuery = enterpriseEvaluationQueryService.findByid(re_id);
            if (!S.isNull(enterpriseEvaluationQuery)) {
                enterpriseEvaluationQueryService.saveOrUpd(reenterpriseEvaluationQuery);
            } else {
                enterpriseEvaluationQueryService.save(reenterpriseEvaluationQuery);
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
    @Path("delEnterpriseEvaluationQueryByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseEvaluationQueryByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseEvaluationQuery = enterpriseEvaluationQueryService.findByid(re_id);
            if (!S.isNull(enterpriseEvaluationQuery)) {
                enterpriseEvaluationQueryService.delete(id);
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
