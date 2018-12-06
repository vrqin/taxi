package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseCorporateWrongdoing;
import com.spring.jersy.hibernate.model.service.EnterpriseCorporateWrongdoingService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
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
@Path("/enterpriseCorporateWrongdoing")
@Scope("prototype")
public class EnterpriseCorporateWrongdoingResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseCorporateWrongdoingResource.class);
    private static final String tabname = "EnterpriseCorporateWrongdoing";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseCorporateWrongdoingService enterpriseCorporateWrongdoingService;


    private List<EnterpriseCorporateWrongdoing> enterpriseCorporateWrongdoingList;

    private EnterpriseCorporateWrongdoing enterpriseCorporateWrongdoing;

    @POST
    @Path("findEnterpriseCorporateWrongdoingForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCorporateWrongdoingForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            enterpriseCorporateWrongdoingList = enterpriseCorporateWrongdoingService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(enterpriseCorporateWrongdoingList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findEnterpriseCorporateWrongdoingByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCorporateWrongdoingByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCorporateWrongdoing = enterpriseCorporateWrongdoingService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseCorporateWrongdoing);
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
    @Path("saveorupdateEnterpriseCorporateWrongdoing")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseCorporateWrongdoing(@QueryParam("id") final Integer id, EnterpriseCorporateWrongdoing reenterpriseCorporateWrongdoing) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCorporateWrongdoing = enterpriseCorporateWrongdoingService.findByid(re_id);
            if (!S.isNull(enterpriseCorporateWrongdoing)) {
                enterpriseCorporateWrongdoingService.saveOrUpd(reenterpriseCorporateWrongdoing);
            } else {
                enterpriseCorporateWrongdoingService.save(reenterpriseCorporateWrongdoing);
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
    @Path("delEnterpriseCorporateWrongdoingByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseCorporateWrongdoingByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCorporateWrongdoing = enterpriseCorporateWrongdoingService.findByid(re_id);
            if (!S.isNull(enterpriseCorporateWrongdoing)) {
                enterpriseCorporateWrongdoingService.delete(id);
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
