package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Privilege;
import com.spring.jersy.hibernate.model.entity.Resource;
import com.spring.jersy.hibernate.model.entity.Role;
import com.spring.jersy.hibernate.model.service.PrivilegeService;
import com.spring.jersy.hibernate.model.service.ResourceService;
import com.spring.jersy.hibernate.model.service.RoleService;
import com.spring.jersy.hibernate.publics.bean.ResToRolBean;
import com.spring.jersy.hibernate.publics.bean.ResourceBean;
import com.spring.jersy.hibernate.publics.bean.RoleidToResourseid;
import com.spring.jersy.hibernate.publics.bean.TreeBean;
import com.spring.jersy.hibernate.publics.util.*;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
@Path("/resource")
@Scope("prototype")
public class ResourceResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ResourceResource.class);
    private static final String tabname = "Resource";
    @Context
    private HttpServletResponse response;


    @javax.annotation.Resource
    private ResourceService resourceService;

    @javax.annotation.Resource
    private PrivilegeService privilegeService;

    @javax.annotation.Resource
    private RoleService roleService;

    private List<Resource> resourceList;
    private List<Privilege> privilegeList;
    private List<ResourceBean> resourceBeanList;
    private List<RoleidToResourseid> roleidToResourseids;
    private List<TreeBean> treeBeans;
    private Resource resource;

    @POST
    @Path("findResourceForPageList")
    @Produces("application/json;charset=utf-8")
    public String findResourceForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = resourceService.findListByorder(page, rows, sort, order);
            resourceList = pageList.getList();
            JSONArray array = JSONArray.fromObject(resourceList.toArray());
            return array.toString();
            //            total = pageList.getTotalRecord();
            //            return ReturePageList(total, resourceList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "列表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findResourcetreeGrid")
    @Produces("application/json;charset=utf-8")
    public String findResourcetreeGrid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            privilegeList = privilegeService.findList();
            resourceBeanList = new ArrayList<ResourceBean>();
            //设置所属系统孩子
            List<ResourceBean> privilegeChildren = null;
            ResourceBean resourceBean = null;
            if (!S.isListNull(privilegeList) && privilegeList.size() > 0) {
                //设置所属系统
                for (Privilege p : privilegeList) {
                    resourceBean = new ResourceBean();
                    resourceBean.setId(p.getId());
                    resourceBean.setPowerName(p.getPrivilegename());
                    resourceBean.setPiconCls("");
                    resourceBean.setIconCls("icon-title");
                    resourceBean.setPid(p.getId());
                    resourceBean.setPowerRemark("");
                    resourceBean.setPpid(p.getId());

                    //设置菜单
                    List<Resource> resourceMenu = resourceService.findListByPid(0, p.getId());

                    //设置所属系统孩子
                    privilegeChildren = new ArrayList<ResourceBean>();

                    ResourceBean menu = null;
                    if (!S.isListNull(resourceMenu) && resourceMenu.size() > 0) {
                        for (Resource r : resourceMenu) {
                            menu = new ResourceBean();
                            menu.setId(p.getId());
                            menu.setIconCls("icon-menu");
                            menu.setPowerName(r.getPowerName());
                            menu.setPowerUrl(r.getPowerUrl());
                            menu.setPiconCls(r.getIconCls());
                            menu.setPid(r.getPid());
                            menu.setPpid(r.getPpid());
                            //设置页面
                            List<Resource> resourcePage = resourceService.findListByPid(r.getId(), p.getId());
                            //                            //System.out.println(r.getId()+","+p.getId());
                            //菜单下孩子
                            List<ResourceBean> resourceMenuChildren = new ArrayList<ResourceBean>();
                            ResourceBean page = null;
                            if (!S.isListNull(resourcePage) && resourcePage.size() > 0) {
                                for (Resource rg : resourcePage) {
                                    //System.out.println(rg);
                                    page = new ResourceBean();
                                    page.setId(menu.getId());
                                    page.setIconCls("icon-imenu");
                                    page.setPowerName(rg.getPowerName());
                                    page.setPowerUrl(rg.getPowerUrl());
                                    page.setPiconCls(rg.getIconCls());
                                    page.setPid(rg.getPid());
                                    page.setPpid(rg.getPpid());
                                    resourceMenuChildren.add(page);
                                }

                            }
                            menu.setChildren(resourceMenuChildren);
                            privilegeChildren.add(menu);
                        }
                        resourceBean.setChildren(privilegeChildren);
                    }
                    resourceBeanList.add(resourceBean);

                }
            } else {
                //System.out.println("数据库异常：请检测 tab_privilege 表");

            }
            //System.out.println(resourceBeanList);
            JSONArray array = JSONArray.fromObject(resourceBeanList.toArray());
            return array.toString();


        } catch (Exception e) {
            LOGGER.error("加载客户异常异常:", e);
            //            logAbnormalService.savelogAbnormal("所有","加载所有客户树异常异常");
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findResourcetree")
    @Produces("application/json;charset=utf-8")
    public String findResourcetree(@QueryParam("roleid") final Integer roleid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            privilegeList = privilegeService.findList();
            treeBeans = new ArrayList<TreeBean>();
            if (roleid != 0) {
                roleidToResourseids = roleService.findRoleidToResourseidList(roleid);
            }
            //设置所属系统孩子
            List<TreeBean> privilegeChildren = null;
            TreeBean resourceBean = null;
            if (!S.isListNull(privilegeList) && privilegeList.size() > 0) {
                //设置所属系统
                for (Privilege p : privilegeList) {

                    //                    //System.out.println("---------设置所属系统----------");
                    //                    //System.out.println(p);

                    resourceBean = new TreeBean();
                    resourceBean.setId(p.getId() * 1000);
                    resourceBean.setText(p.getPrivilegename());
                    resourceBean.setIconCls("icon-title");
                    resourceBean.setPid(p.getId());
                    resourceBean.setMsid(String.valueOf(p.getId()));

                    //设置菜单
                    List<Resource> resourceMenu = resourceService.findListByPid(0, p.getId());

                    //设置所属系统孩子
                    privilegeChildren = new ArrayList<TreeBean>();

                    TreeBean menu = null;
                    if (!S.isListNull(resourceMenu) && resourceMenu.size() > 0) {
                        for (Resource r : resourceMenu) {

                            //                            //System.out.println("---------设置所属系统孩子----------");
                            //                            //System.out.println(r);

                            menu = new TreeBean();
                            menu.setId(r.getId());
                            menu.setIconCls("icon-menu");
                            menu.setText(r.getPowerName());
                            menu.setPid(r.getPid());
                            menu.setMsid(String.valueOf(r.getPpid()));

                            //设置页面
                            List<Resource> resourcePage = resourceService.findListByPid(r.getId(), p.getId());
                            //                            //System.out.println(r.getId()+","+p.getId());
                            //菜单下孩子
                            List<TreeBean> resourceMenuChildren = new ArrayList<TreeBean>();
                            TreeBean page = null;
                            if (!S.isListNull(resourcePage) && resourcePage.size() > 0) {
                                for (Resource rg : resourcePage) {
                                    //                                    //System.out.println("---------菜单下孩子----------");
                                    //                                    //System.out.println(rg);
                                    page = new TreeBean();
                                    page.setId(rg.getId());
                                    page.setIconCls("icon-imenu");
                                    page.setText(rg.getPowerName());
                                    page.setPid(rg.getPid());
                                    page.setMsid(String.valueOf(rg.getPpid()));
                                    if (!S.isListNull(roleidToResourseids) && roleidToResourseids.size() > 0) {
                                        for (RoleidToResourseid rtr : roleidToResourseids) {
                                            if (rg.getId() == rtr.getResourseid()) {
                                                page.setChecked(true);
                                            }
                                        }
                                    }


                                    resourceMenuChildren.add(page);
                                }

                            }
                            menu.setChildren(resourceMenuChildren);
                            privilegeChildren.add(menu);
                        }
                        resourceBean.setChildren(privilegeChildren);
                    }
                    treeBeans.add(resourceBean);

                }
            } else {
                //System.out.println("数据库异常：请检测 tab_privilege 表");

            }
            //System.out.println(treeBeans);
            JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            return array.toString();


        } catch (Exception e) {
            LOGGER.error("加载客户异常异常:", e);
            //            logAbnormalService.savelogAbnormal("所有","加载所有客户树异常异常");
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


    @POST
    @Path("saveorupdateResourceToRol")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateResourceToRol(ResToRolBean rolBean) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            //System.out.println("-----------开始--------------");
            //System.out.println(rolBean);
            Role role = roleService.findByid(rolBean.getRoleid());
            if (!S.isNull(role)) {
                //删除原来绑定
                roleidToResourseids = roleService.findRoleidToResourseidList(role.getRoleId());
                if (!S.isListNull(roleidToResourseids) && roleidToResourseids.size() > 0) {
                    roleService.delRoleidReoursid(role.getRoleId());
                }

                String resourceIdList[] = rolBean.getResourcelist().trim().split(",");
                Set<Resource> resourceSet = new HashSet<Resource>();//清空当前的资源信息  添加新的资源信息
                if (!S.isNull(rolBean.getResourcelist().trim())) {
                    for (String id : resourceIdList) {
                        //System.out.println(id);
                        Resource resource = resourceService.findByid(Integer.valueOf(id));
                        if (!S.isNull(resource)) {
                            resourceSet.add(resource);
                        }
                    }
                    role.setTbResources(resourceSet);
                    roleService.saveOrUpd(role);
                    //System.out.println("-----------结束--------------");
                }

            } else {
                //System.out.println("没有当前角色");
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

    @POST
    @Path("findResourceByPPid")
    @Produces("application/json;charset=utf-8")
    public String findResourceByPPid(@QueryParam("ppid") final Integer ppid, @QueryParam("roleid") final Integer roleid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_ppid = !S.isNull(ppid) ? ppid : 0;
            Integer re_roleid = !S.isNull(roleid) ? roleid : 0;
            resourceList = new ArrayList<Resource>();
            Resource resource = null;

            roleidToResourseids = roleService.findRoleidToResourseidList(re_roleid);
            if (!S.isListNull(roleidToResourseids) && roleidToResourseids.size() > 0) {
                //System.out.println("-------测试开始----");
                for (RoleidToResourseid ctr : roleidToResourseids) {

                    resource = resourceService.findByid(ctr.getResourseid());

                    if (!S.isNull(resource)) {
                        if (resource.getPpid() == re_ppid) {
                            resourceList.add(resource);
                        }
                    }

                }

            }

            //排序
            ListSortUtil<Resource> sortList = new ListSortUtil<Resource>();
            sortList.sort(resourceList, "resourceNum", "asc");
            JSONArray array = JSONArray.fromObject(resourceList.toArray());
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
    @Path("findResourceByPPidtoPid")
    @Produces("application/json;charset=utf-8")
    public String findResourceByPPidtoPid(@QueryParam("pid") final Integer pid, @QueryParam("ppid") final Integer ppid, @QueryParam("roleid") final Integer roleid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_pid = !S.isNull(pid) ? pid : 0;
            Integer re_ppid = !S.isNull(ppid) ? ppid : 0;
            Integer re_roleid = !S.isNull(roleid) ? roleid : 0;
            //            resourceList = resourceService.findListByPid(re_pid,re_ppid);
            resourceList = new ArrayList<Resource>();
            Resource resource = null;

            roleidToResourseids = roleService.findRoleidToResourseidList(re_roleid);
            if (!S.isListNull(roleidToResourseids) && roleidToResourseids.size() > 0) {
                //System.out.println("-------测试开始----");
                for (RoleidToResourseid ctr : roleidToResourseids) {

                    resource = resourceService.findByid(ctr.getResourseid());

                    if (!S.isNull(resource)) {
                        if ((resource.getPpid() == re_ppid) && (resource.getPid() == 0)) {
                            resourceList.add(resource);
                        }
                    }

                }

            }
            JSONArray array = JSONArray.fromObject(resourceList.toArray());
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
    @Path("findResourceByid")
    @Produces("application/json;charset=utf-8")
    public String findResourceByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            resource = resourceService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(resource);
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
    @Path("saveorupdateResource")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateResource(@QueryParam("id") final Integer id, Resource reresource) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(reresource.getId()) ? reresource.getId() : 0;
            resource = resourceService.findByid(re_id);
            if (!S.isNull(resource)) {

                resourceService.saveOrUpd(reresource);
            } else {
                reresource.setResourceNum(RandomUtils.nextInt());
                resourceService.save(reresource);
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
    @Path("delResourceByid")
    @Produces("application/json;charset=utf-8")
    public String delResourceByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            resource = resourceService.findByid(re_id);
            if (!S.isNull(resource)) {
                resourceService.delete(id);
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
    @Path("findresourcegetree")
    @Produces("application/json;charset=utf-8")
    public String findresourcegetree(@QueryParam("ppid") final Integer ppid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            treeBeans = new ArrayList<TreeBean>();
            TreeBean tb;
            //查找父亲节点的为1的树
            List<Resource> resources = resourceService.findListByPid(0, ppid);
            if (!S.isListNull(resources) && resources.size() > 0) {
                for (Resource r : resources) {
                    tb = new TreeBean();
                    tb.setId(r.getId());
                    tb.setText(r.getPowerName());
                    treeBeans.add(tb);
                }
                //添加功能
                TreeBean tbs = new TreeBean();
                tbs.setId(0);
                tbs.setText("===新建新菜单===");
                treeBeans.add(tbs);
            } else {
                //添加功能
                TreeBean tbs = new TreeBean();
                tbs.setId(0);
                tbs.setText("===新建新菜单===");
                treeBeans.add(tbs);
            }

            JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("findresourcegetree " + tabname + "异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

}
