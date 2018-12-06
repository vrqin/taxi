package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseCreditDistribu;
import com.spring.jersy.hibernate.model.service.EnterpriseCreditDistribuService;
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
@Path("/enterpriseCreditDistribu")
@Scope("prototype")
public class EnterpriseCreditDistribuResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseCreditDistribuResource.class);
    private static final String tabname = "EnterpriseCreditDistribu";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseCreditDistribuService enterpriseCreditDistribuService;


    private List<EnterpriseCreditDistribu> enterpriseCreditDistribuList;

    private EnterpriseCreditDistribu enterpriseCreditDistribu;

    @POST
    @Path("findEnterpriseCreditDistribuForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCreditDistribuForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            enterpriseCreditDistribuList = enterpriseCreditDistribuService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(enterpriseCreditDistribuList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findEnterpriseCreditDistribuByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCreditDistribuByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditDistribu = enterpriseCreditDistribuService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseCreditDistribu);
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
    @Path("saveorupdateEnterpriseCreditDistribu")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseCreditDistribu(@QueryParam("id") final Integer id, EnterpriseCreditDistribu reenterpriseCreditDistribu) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditDistribu = enterpriseCreditDistribuService.findByid(re_id);
            if (!S.isNull(enterpriseCreditDistribu)) {
                enterpriseCreditDistribuService.saveOrUpd(reenterpriseCreditDistribu);
            } else {
                enterpriseCreditDistribuService.save(reenterpriseCreditDistribu);
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
    @Path("delEnterpriseCreditDistribuByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseCreditDistribuByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditDistribu = enterpriseCreditDistribuService.findByid(re_id);
            if (!S.isNull(enterpriseCreditDistribu)) {
                enterpriseCreditDistribuService.delete(id);
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
