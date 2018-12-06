package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseCreditFiles;
import com.spring.jersy.hibernate.model.service.EnterpriseCreditFilesService;
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
@Path("/enterpriseCreditFiles")
@Scope("prototype")
public class EnterpriseCreditFilesResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseCreditFilesResource.class);
    private static final String tabname = "EnterpriseCreditFiles";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseCreditFilesService enterpriseCreditFilesService;


    private List<EnterpriseCreditFiles> enterpriseCreditFilesList;

    private EnterpriseCreditFiles enterpriseCreditFiles;

    @POST
    @Path("findEnterpriseCreditFilesForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCreditFilesForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            enterpriseCreditFilesList = enterpriseCreditFilesService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(enterpriseCreditFilesList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findEnterpriseCreditFilesByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseCreditFilesByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditFiles = enterpriseCreditFilesService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseCreditFiles);
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
    @Path("saveorupdateEnterpriseCreditFiles")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseCreditFiles(@QueryParam("id") final Integer id, EnterpriseCreditFiles reenterpriseCreditFiles) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditFiles = enterpriseCreditFilesService.findByid(re_id);
            if (!S.isNull(enterpriseCreditFiles)) {
                enterpriseCreditFilesService.saveOrUpd(reenterpriseCreditFiles);
            } else {
                enterpriseCreditFilesService.save(reenterpriseCreditFiles);
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
    @Path("delEnterpriseCreditFilesByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseCreditFilesByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseCreditFiles = enterpriseCreditFilesService.findByid(re_id);
            if (!S.isNull(enterpriseCreditFiles)) {
                enterpriseCreditFilesService.delete(id);
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
