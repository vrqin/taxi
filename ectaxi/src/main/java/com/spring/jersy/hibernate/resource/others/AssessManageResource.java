package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.AssessManage;
import com.spring.jersy.hibernate.model.service.AssessManageService;
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
@Path("/assessManage")
@Scope("prototype")
public class AssessManageResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(AssessManageResource.class);
    private static final String tabname = "AssessManage";
    @Context
    private HttpServletResponse response;
    @Resource
    private AssessManageService assessManageService;
    private List<AssessManage> assessManageList;
    private AssessManage assessManage;

    public AssessManageResource() {
        System.out.println("AssessManageResource");
    }

    @POST
    @Path("findAssessManageForPageList")
    @Produces("application/json;charset=utf-8")
    public String findAssessManageForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("versiontype") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            PageList pageList = assessManageService.findList(page, rows, sort, order, key, begintime, endtime, type);
            assessManageList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, assessManageList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findAssessManageByid")
    @Produces("application/json;charset=utf-8")
    public String findAssessManageByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            assessManage = assessManageService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(assessManage);
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
    @Path("saveorupdateAssessManage")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateAssessManage(@QueryParam("id") final Integer id, AssessManage reassessManage) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(reassessManage.getId()) ? reassessManage.getId() : 0;
            assessManage = assessManageService.findByid(re_id);
            if (!S.isNull(assessManage)) {
                assessManageService.saveOrUpd(reassessManage);
            } else {
                assessManageService.save(reassessManage);
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
    @Path("delAssessManageByid")
    @Produces("application/json;charset=utf-8")
    public String delAssessManageByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            assessManage = assessManageService.findByid(re_id);
            if (!S.isNull(assessManage)) {
                assessManageService.delete(id);
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
