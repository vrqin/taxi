package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Privilege;
import com.spring.jersy.hibernate.model.service.PrivilegeService;
import com.spring.jersy.hibernate.publics.bean.TreeBean;
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
import java.util.ArrayList;
import java.util.List;


@Component
@Path("/privilege")
@Scope("prototype")
public class PrivilegeResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PrivilegeResource.class);
    private static final String tabname = "Privilege";
    @Context
    private HttpServletResponse response;


    @Resource
    private PrivilegeService privilegeService;


    private List<Privilege> privilegeList;
    private List<TreeBean> treeBeans;
    private Privilege privilege;

    @POST
    @Path("findPrivilegeForPageList")
    @Produces("application/json;charset=utf-8")
    public String findPrivilegeForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = privilegeService.findList(page, rows, sort, order, key, begintime, endtime, type);
            privilegeList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, privilegeList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findPrivilegeByid")
    @Produces("application/json;charset=utf-8")
    public String findPrivilegeByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            privilege = privilegeService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(privilege);
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
    @Path("saveorupdatePrivilege")
    @Produces("application/json;charset=utf-8")
    public String saveorupdatePrivilege(@QueryParam("id") final Integer id, Privilege reprivilege) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            privilege = privilegeService.findByid(re_id);
            if (!S.isNull(privilege)) {
                privilegeService.saveOrUpd(reprivilege);
            } else {
                privilegeService.save(reprivilege);
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
    @Path("delPrivilegeByid")
    @Produces("application/json;charset=utf-8")
    public String delPrivilegeByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            privilege = privilegeService.findByid(re_id);
            if (!S.isNull(privilege)) {
                privilegeService.delete(id);
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

    @GET
    @Path("findprivilegetree")
    @Produces("application/json;charset=utf-8")
    public String findprivilegetree(@QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            treeBeans = new ArrayList<TreeBean>();
            TreeBean tb;
            //查找父亲节点的为1的树
            for (Privilege p : privilegeService.findList()) {
                tb = new TreeBean();
                tb.setId(p.getId());
                tb.setText(p.getPrivilegename());
                treeBeans.add(tb);
            }
            JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("findprivilegetree " + tabname + "异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }
}
