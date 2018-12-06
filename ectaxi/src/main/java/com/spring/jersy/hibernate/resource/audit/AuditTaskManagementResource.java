package com.spring.jersy.hibernate.resource.audit;

import com.spring.jersy.hibernate.model.entity.AuditTaskManagement;
import com.spring.jersy.hibernate.model.service.AuditTaskManagementService;
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
import org.apache.log4j.Logger;

@Component
@Path("/auditTaskManagement")
@Scope("prototype")
public class AuditTaskManagementResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(AuditTaskManagementResource.class);
    private static final String tabname = "AuditTaskManagement";
    @Context
    private HttpServletResponse response;


    @Resource
    private AuditTaskManagementService auditTaskManagementService;


    private List<AuditTaskManagement> auditTaskManagementList;

    private AuditTaskManagement auditTaskManagement;

    @POST
    @Path("findAuditTaskManagementForPageList")
    @Produces("application/json;charset=utf-8")
    public String findAuditTaskManagementForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("taskstatus") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = auditTaskManagementService.findList(page, rows, sort, order, key, begintime, endtime, type);
            auditTaskManagementList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, auditTaskManagementList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findAuditTaskManagementByid")
    @Produces("application/json;charset=utf-8")
    public String findAuditTaskManagementByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            auditTaskManagement = auditTaskManagementService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(auditTaskManagement);
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
    @Path("saveorupdateAuditTaskManagement")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateAuditTaskManagement(@QueryParam("id") final Integer id, AuditTaskManagement reauditTaskManagement) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(reauditTaskManagement.getId()) ? reauditTaskManagement.getId() : 0;
            auditTaskManagement = auditTaskManagementService.findByid(re_id);
            if (!S.isNull(auditTaskManagement)) {
                auditTaskManagementService.saveOrUpd(reauditTaskManagement);
            } else {
                auditTaskManagementService.save(reauditTaskManagement);
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
    @Path("delAuditTaskManagementByid")
    @Produces("application/json;charset=utf-8")
    public String delAuditTaskManagementByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            auditTaskManagement = auditTaskManagementService.findByid(re_id);
            if (!S.isNull(auditTaskManagement)) {
                auditTaskManagementService.delete(id);
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
