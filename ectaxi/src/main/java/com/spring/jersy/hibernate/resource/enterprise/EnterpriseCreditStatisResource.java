package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseCreditStatis;
import com.spring.jersy.hibernate.model.service.EnterpriseCreditStatisService;
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
@Path("/enterpriseCreditStatis")
@Scope("prototype")
public class EnterpriseCreditStatisResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseCreditStatisResource.class);
    private static final String tabname = "EnterpriseCreditStatis";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseCreditStatisService enterpriseCreditStatisService;


    private List<EnterpriseCreditStatis> enterpriseCreditStatisList;

    private EnterpriseCreditStatis enterpriseCreditStatis;

    @POST
    @Path("findEnterpriseCreditStatisForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCreditStatisForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            enterpriseCreditStatisList = enterpriseCreditStatisService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(enterpriseCreditStatisList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findEnterpriseCreditStatisByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCreditStatisByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditStatis = enterpriseCreditStatisService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseCreditStatis);
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
    @Path("saveorupdateEnterpriseCreditStatis")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseCreditStatis(@QueryParam("id") final Integer id, EnterpriseCreditStatis reenterpriseCreditStatis) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditStatis = enterpriseCreditStatisService.findByid(re_id);
            if (!S.isNull(enterpriseCreditStatis)) {
                enterpriseCreditStatisService.saveOrUpd(reenterpriseCreditStatis);
            } else {
                enterpriseCreditStatisService.save(reenterpriseCreditStatis);
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
    @Path("delEnterpriseCreditStatisByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseCreditStatisByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditStatis = enterpriseCreditStatisService.findByid(re_id);
            if (!S.isNull(enterpriseCreditStatis)) {
                enterpriseCreditStatisService.delete(id);
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
