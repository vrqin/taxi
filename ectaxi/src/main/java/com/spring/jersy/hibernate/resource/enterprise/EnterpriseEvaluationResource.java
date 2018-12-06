package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseEvaluation;
import com.spring.jersy.hibernate.model.service.EnterpriseEvaluationService;
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
@Path("/enterpriseEvaluation")
@Scope("prototype")
public class EnterpriseEvaluationResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseEvaluationResource.class);
    private static final String tabname = "EnterpriseEvaluation";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseEvaluationService enterpriseEvaluationService;


    private List<EnterpriseEvaluation> enterpriseEvaluationList;

    private EnterpriseEvaluation enterpriseEvaluation;

    @POST
    @Path("findEnterpriseEvaluationForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseEvaluationForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            //System.out.println(type);
            PageList pageList = enterpriseEvaluationService.findList(page, rows, sort, order, key, begintime, endtime, type);
            enterpriseEvaluationList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, enterpriseEvaluationList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findEnterpriseEvaluationByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseEvaluationByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseEvaluation = enterpriseEvaluationService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseEvaluation);
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
    @Path("saveorupdateEnterpriseEvaluation")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseEvaluation(@QueryParam("id") final Integer id, EnterpriseEvaluation reenterpriseEvaluation) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(reenterpriseEvaluation.getId()) ? reenterpriseEvaluation.getId() : 0;
            enterpriseEvaluation = enterpriseEvaluationService.findByid(re_id);
            if (!S.isNull(enterpriseEvaluation)) {
                enterpriseEvaluationService.saveOrUpd(reenterpriseEvaluation);
            } else {
                enterpriseEvaluationService.save(reenterpriseEvaluation);
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
    @Path("delEnterpriseEvaluationByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseEvaluationByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseEvaluation = enterpriseEvaluationService.findByid(re_id);
            if (!S.isNull(enterpriseEvaluation)) {
                enterpriseEvaluationService.delete(id);
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
