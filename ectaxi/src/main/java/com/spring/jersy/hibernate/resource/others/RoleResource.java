package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Role;
import com.spring.jersy.hibernate.model.service.RoleService;
import com.spring.jersy.hibernate.publics.bean.TreeBean;
import com.spring.jersy.hibernate.publics.util.Constants;
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
import java.util.Date;
import java.util.List;


@Component
@Path("/role")
@Scope("prototype")
public class RoleResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(RoleResource.class);
    private static final String tabname = "Role";
    @Context
    private HttpServletResponse response;


    @Resource
    private RoleService roleService;


    private List<Role> roleList;
    private List<TreeBean> treeBeanList;

    private Role role;

    @POST
    @Path("findRoleForPageList")
    @Produces("application/json;charset=utf-8")
    public String findRoleForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("validity") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            //            PageList pageList =roleService.findList(page, rows, sort, order, key, begintime, endtime, type);
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            roleList = roleService.findRoleList(key, ac_clientid);
            JSONArray array = JSONArray.fromObject(roleList);
            return array.toString();
            //            total = pageList.getTotalRecord();
            //            return ReturePageList(total, roleList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findRoleByid")
    @Produces("application/json;charset=utf-8")
    public String findRoleByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            role = roleService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(role);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "根据Id查找：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


    @GET
    @Path("findRoletree")
    @Produces("application/json;charset=utf-8")
    public String findRoletree(@QueryParam("id") final Integer id, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;
            roleList = roleService.findRoleList(null, re_clientid);
            treeBeanList = new ArrayList<TreeBean>();
            TreeBean tb;
            if (!S.isNull(roleList)) {
                for (Role r : roleList) {
                    if (r.getRoleId() > 1) {
                        tb = new TreeBean();
                        tb.setId(r.getRoleId());
                        tb.setText(r.getName());
                        treeBeanList.add(tb);
                    }

                }
            }
            JSONArray array = JSONArray.fromObject(treeBeanList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "findRoletree：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findRoleSeatstree")
    @Produces("application/json;charset=utf-8")
    public String findRoleSeatstree(@QueryParam("id") final Integer id, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;
            roleList = roleService.findRoleList("人工", re_clientid);
            treeBeanList = new ArrayList<TreeBean>();
            TreeBean tb;
            if (!S.isNull(roleList)) {
                for (Role r : roleList) {
                    if (r.getRoleId() > 1) {
                        tb = new TreeBean();
                        tb.setId(r.getRoleId());
                        tb.setText(r.getName());
                        treeBeanList.add(tb);
                    }

                }
            }
            JSONArray array = JSONArray.fromObject(treeBeanList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "findRoletree：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("saveorupdateRole")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateRole(@QueryParam("id") final Integer id, Role rerole) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(rerole.getRoleId()) ? rerole.getRoleId() : 0;
            role = roleService.findByid(re_id);
            if (!S.isNull(role)) {
                roleService.saveOrUpd(rerole);
            } else {
                rerole.setRegisterTime(new Date());
                roleService.save(rerole);
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
    @Path("delRoleByid")
    @Produces("application/json;charset=utf-8")
    public String delRoleByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            role = roleService.findByid(re_id);
            if (!S.isNull(role)) {
                roleService.delete(id);
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
