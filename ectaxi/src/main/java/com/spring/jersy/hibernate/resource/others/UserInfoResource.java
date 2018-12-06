package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.*;
import com.spring.jersy.hibernate.model.service.*;
import com.spring.jersy.hibernate.publics.bean.PrivilegeBean;
import com.spring.jersy.hibernate.publics.bean.ResourceBean;
import com.spring.jersy.hibernate.publics.bean.RoleidToResourseid;
import com.spring.jersy.hibernate.publics.bean.UserBeen;
import com.spring.jersy.hibernate.publics.recep.UserLoginRecep;
import com.spring.jersy.hibernate.publics.resp.UserInfoResp;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.quartz.SpringQtz;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/11.
 */
@Component
@Path("/userinfo")
@Scope("prototype")
public class UserInfoResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UserInfoResource.class);
    private static final String tabname = "User";
    @Context
    private HttpServletResponse response;
    @Resource
    private UserService userService;
    @Resource
    private PassengerService passengerService;
    @Resource
    private LogLoginService logLoginService;
    @Resource
    private PrivilegeService privilegeService;
    @Resource
    private SeatsService seatsService;
    @Resource
    private ResourceService resourceService;
    @Resource
    private ClientService clientService;
    @Resource
    private RoleService roleService;
    private List<User> userList;
    private List<ResourceBean> resourceBeanList;
    private List<RoleidToResourseid> roleidToResourseids;
    private LogLogin logLogin;
    private User user;
    private Passenger passenger;
    private Seats seats;


    UserInfoResource() {
        System.out.println("UserInfoResource");
    }

    @POST
    @Path("findUserForPageList")
    @Produces("application/json;charset=utf-8")
    public String findUserForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("islock") final int type, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            //            PageList pageList =userService.findList(page, rows, sort, order, key, begintime, endtime, type);

            userList = userService.findSqlList(sort, order, key, type, clientid);
            Role role = null;
            if (!S.isListNull(userList) && userList.size() > 0) {
                for (User u : userList) {
                    if (u.getRoleid() > 0) {
                        role = roleService.findByid(u.getRoleid());
                        if (!S.isNull(role)) {
                            u.setRolename(role.getName());
                        } else {
                            u.setRolename("无当前角色");
                        }
                    } else {
                        u.setRolename("无角色(无法登录)");
                    }
                    if (!S.isNull(clientService.findByid(u.getClientId()))) {
                        u.setCompany(clientService.findByid(u.getClientId()).getCompany());
                    }
                }
            }
            total = userList.size();
            return ReturePageList(total, userList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findUserForPageLists")
    @Produces("application/json;charset=utf-8")
    public String findUserForPageLists(@QueryParam("type") final Integer type, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            userList = userService.findList(sort, order, key, type);
            JSONArray array = JSONArray.fromObject(userList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载用户数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("/userlogin")
    @Produces("application/json;charset=utf-8")
    public String userlogin(@QueryParam("username") final String username, @QueryParam("password") final String password, @QueryParam("cgflag") final Integer cgflag) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        UserInfoResp userInfoResp = new UserInfoResp();
        try {
            user = userService.login(username, password);
            if (!S.isNull(user)) {
                for (Privilege p : user.getPrivilegeSet()) {
                    if (p.getId() == cgflag) {
                        userInfoResp.setCode(0);
                        userInfoResp.setDesc("success");

                        savelogLogin(username, 0, username, "", user.getClientId());

                        break;
                    }
                }
                if (S.isNull(userInfoResp.getCode())) {
                    userInfoResp.setCode(1);
                    userInfoResp.setDesc("用户没有登录权限");
                }
            } else {
                userInfoResp.setCode(1);
                userInfoResp.setDesc("error");
            }


            JSONObject array = JSONObject.fromObject(userInfoResp);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("登录异常：", e);
            responseSim.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            responseSim.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("/userloginObject")
    @Produces(MediaType.TEXT_PLAIN)
    public String userloginObject(User reuser) {
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        UserInfoResp userInfoResp = new UserInfoResp();
        boolean flag = true;
        try {
            if (reuser.getCgFlag() == S.SeatsCC) {
                //System.out.println("--------我是坐席--------");
                seats = seatsService.findBySeatlogin(reuser.getAccountName(), reuser.getPasswd());
                if (!S.isNull(seats)) {
                    if (seats.getRoleid() != 0) {
                        roleidToResourseids = roleService.findRoleidToResourseidList(seats.getRoleid());
                        if (!S.isListNull(roleidToResourseids) && roleidToResourseids.size() > 0) {
                            //                        //System.out.println("-------测试开始----");
                            for (RoleidToResourseid ctr : roleidToResourseids) {

                                if (!S.isNull(resourceService.findByid(ctr.getResourseid()))) {
                                    if (resourceService.findByid(ctr.getResourseid()).getPpid() == reuser.getCgFlag()) {
                                        userInfoResp.setCode(0);
                                        userInfoResp.setDesc("success");
                                        userInfoResp.setToken("12345678910");
                                        savelogLogin(reuser.getAccountName(), 0, reuser.getAccountName(), "", seats.getClientid());
                                        break;

                                    } else {
                                        //在循环下没有当前权限
                                        userInfoResp.setCode(1);
                                        userInfoResp.setDesc("用户没有登录权限，请联系管理员！");
                                    }
                                }

                            }

                        } else {
                            userInfoResp.setCode(1);
                            userInfoResp.setDesc("用户没有登录权限，请联系管理员！");
                        }
                    } else {
                        userInfoResp.setCode(1);
                        userInfoResp.setDesc("用户没有登录权限，请联系管理员！");
                    }

                } else {
                    userInfoResp.setCode(1);
                    userInfoResp.setDesc("没有当前用户或用户名和密码错误！");
                }
            } else {
                System.out.println("--------我是其他--------");
                user = userService.login(reuser.getAccountName(), reuser.getPasswd());
                if (!S.isNull(user)) {
                    if (user.getRoleid() != 0) {
                        roleidToResourseids = roleService.findRoleidToResourseidList(user.getRoleid());
                        if (!S.isListNull(roleidToResourseids) && roleidToResourseids.size() > 0) {
                            System.out.println("-------测试开始----");
                            for (RoleidToResourseid ctr : roleidToResourseids) {

                                if (!S.isNull(resourceService.findByid(ctr.getResourseid()))) {
                                    if (resourceService.findByid(ctr.getResourseid()).getPpid() == reuser.getCgFlag()) {
                                        userInfoResp.setCode(0);
                                        userInfoResp.setDesc("success");
                                        userInfoResp.setToken("12345678910");
                                        savelogLogin(reuser.getAccountName(), 0, reuser.getAccountName(), "", user.getClientId());
                                        user.setOnlineStatus(1);
                                        user.setLastLoginTime(new Date());
                                        userService.saveOrUpd(user);
                                        break;

                                    } else {
                                        //在循环下没有当前权限
                                        userInfoResp.setCode(1);
                                        userInfoResp.setDesc("用户没有登录权限，请联系管理员！");
                                    }
                                }

                            }

                        } else {
                            userInfoResp.setCode(1);
                            userInfoResp.setDesc("用户没有登录权限，请联系管理员！");
                        }
                    } else {
                        userInfoResp.setCode(1);
                        userInfoResp.setDesc("用户没有登录权限，请联系管理员！");
                    }

                } else {
                    userInfoResp.setCode(1);
                    userInfoResp.setDesc("没有当前用户或用户名和密码错误！");
                }
            }

            JSONObject array = JSONObject.fromObject(userInfoResp);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("数据库或登录异常：", e);
            responseSim.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            responseSim.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @GET
    @Path("/logOut")
    @Produces(MediaType.TEXT_PLAIN)
    public String logOut(@QueryParam("userid") final Integer userid) {
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        UserInfoResp userInfoResp = new UserInfoResp();
        boolean flag = true;
        try {
            Integer ac_userid = !S.isNull(userid) ? userid : 0;
            user = userService.findByid(ac_userid);
            if (!S.isNull(user)) {
                user.setOnlineStatus(0);
                user.setLastLoginTime(new Date());
                userService.saveOrUpd(user);
            }

            JSONObject array = JSONObject.fromObject(userInfoResp);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("退出异常：", e);
            responseSim.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            responseSim.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("/seatloginObject")
    @Produces("application/json;charset=utf-8")
    public String seatloginObject(User reuser) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        UserInfoResp userInfoResp = new UserInfoResp();
        boolean flag = true;
        try {
            Passenger pa = passengerService.findByid(reuser.getAccountName());
            passenger = passengerService.findByPass(reuser.getAccountName(), reuser.getPasswd());
            if (!S.isNull(pa)) {
                if (!S.isNull(passenger)) {
                    userInfoResp.setCode(0);
                    userInfoResp.setDesc(passenger.getOpruser());
                    userInfoResp.setToken("12345678910");
                } else {
                    userInfoResp.setCode(1);
                    userInfoResp.setDesc("密码错误！");
                }
            } else {
                userInfoResp.setCode(1);
                userInfoResp.setDesc("坐席上没有当前用户");
            }
            JSONObject array = JSONObject.fromObject(userInfoResp);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("坐席登录异常：", e);
            responseSim.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            responseSim.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    //    @POST
    //    @Path("/userloginObject")
    //    @Produces("application/json;charset=utf-8")
    //    public String userloginObject(User reuser) {
    //
    //        response.setHeader("Access-Control-Allow-Origin","*");
    //        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
    //        UserInfoResp userInfoResp = new UserInfoResp();
    //        try {
    //            if (reuser.getCgFlag()==S.SeatsCC){
    //                Passenger pa = passengerService.findByid(reuser.getAccountName());
    //                passenger=passengerService.findByPass(reuser.getAccountName(), reuser.getPasswd());
    //                if (!S.isNull(pa)){
    //                    if (!S.isNull(passenger)){
    //                        userInfoResp.setCode(0);
    //                        userInfoResp.setDesc("success");
    //                        userInfoResp.setToken("12345678910");
    //                    }else{
    //                        userInfoResp.setCode(1);
    //                        userInfoResp.setDesc("密码错误！");
    //                    }
    //                }else{
    //                    userInfoResp.setCode(1);
    //                    userInfoResp.setDesc("坐席上没有当前用户");
    //                }
    //
    //            }else{
    //                user = userService.login(reuser.getAccountName(), reuser.getPasswd());
    //                if (!S.isNull(user)) {
    //                    for (Privilege p : user.getPrivilegeSet()) {
    //                        //为坐席
    //                        if (p.getId() == reuser.getCgFlag()) {
    //                            userInfoResp.setCode(0);
    //                            userInfoResp.setDesc("success");
    //                            userInfoResp.setToken("12345678910");
    //
    //                            savelogLogin(reuser.getAccountName(),0,reuser.getAccountName(),"",user.getClientId());
    //
    //                            break;
    //                        }
    //
    //                    }
    //                    if (S.isNull(userInfoResp.getCode())) {
    //                        userInfoResp.setCode(1);
    //                        userInfoResp.setDesc("用户没有登录权限");
    //                    }
    //                } else {
    //                    userInfoResp.setCode(1);
    //                    userInfoResp.setDesc("error");
    //                }
    //            }
    //
    //
    //
    //            JSONObject array = JSONObject.fromObject(userInfoResp);
    //            return array.toString();
    //
    //        } catch (Exception e) {
    //            LOGGER.error("数据库或登录异常：", e);
    //            responseSim.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
    //            responseSim.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
    //            JSONObject array = JSONObject.fromObject(responseSim);
    //            return array.toString();
    //        }
    //
    //    }

    @GET
    @Path("usersetpassword")
    @Produces("application/json;charset=utf-8")
    public String usersetpassword(@QueryParam("username") final String username, @QueryParam("password") final String password, @QueryParam("newpassword") final String newpassword) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        user = userService.login(username, password);
        try {
            user = userService.login(username, password);
            if (!S.isNull(user)) {
                user.setPasswd(newpassword);
                userService.saveOrUpd(user);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("用户修改密码异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

    @GET
    @Path("findUserById")
    @Produces("application/json;charset=utf-8")
    public String findUserById(@QueryParam("id") final Integer id, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            user = userService.findByid(id);
            JSONObject array = JSONObject.fromObject(user);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载个人信息异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @GET
    @Path("checkUserinfoName")
    @Produces("application/json;charset=utf-8")
    public String checkUserinfoName(@QueryParam("account") final String username, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            user = userService.findUserByaccount(username);
            if (!S.isNull(user)) {
                responseSim.setCode(Constants.EXISR_DRIVER_RESP);
                responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("加载个人信息异常：", e);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

    @POST
    @Path("/testlogin")
    @Produces("application/json;charset=utf-8")
    public String testlogin(final UserLoginRecep userLoginRecep) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        //System.out.println(userLoginRecep.toString());
        //System.out.println("---------------");
        return null;
    }

    public void savelogLogin(String account, Integer type, String name, String loginIP, Integer clientid) {

        try {

            logLogin = new LogLogin();
            logLogin.setAccount(account);
            logLogin.setType(type);
            logLogin.setName(name);
            logLogin.setLoginIP(loginIP);
            logLogin.setClientid(clientid);
            logLogin.setOperattime(new Date());

            logLoginService.save(logLogin);

        } catch (Exception e) {
            LOGGER.error("添加登录日志表异常：", e);
        }
    }

    //根据token 返回用户信息
    @POST
    @Path("/findUserinfoByToken")
    @Produces("application/json;charset=utf-8")
    public String findUserinfoByToken(@QueryParam("token") final String token, @QueryParam("cgflag") final Integer cgflag) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        UserInfoResp userInfoResp = new UserInfoResp();
        try {
            int ac_cgflag = !S.isNull(cgflag) ? cgflag : 0;
            if (ac_cgflag == S.SeatsCC) {
                Seats seats = seatsService.findByAccount(token);
                if (!S.isNull(seats)) {
                    JSONObject array = JSONObject.fromObject(seats);
                    return array.toString();
                } else {
                    userInfoResp.setCode(1);
                    userInfoResp.setDesc("没有用户信息");
                    JSONObject array = JSONObject.fromObject(userInfoResp);
                    return array.toString();
                }

            } else {
                user = userService.findUserByaccount(token);
                if (!S.isNull(user)) {
                    JSONObject array = JSONObject.fromObject(user);
                    return array.toString();
                } else {
                    userInfoResp.setCode(1);
                    userInfoResp.setDesc("没有用户信息");
                    JSONObject array = JSONObject.fromObject(userInfoResp);
                    return array.toString();
                }
            }


        } catch (Exception e) {
            LOGGER.error("登录异常：", e);
            responseSim.setCode(Constants.ACCOUNT_PWD_ERR_RESP);
            responseSim.setDesc(Constants.ACCOUNT_PWD_ERR_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("saveorupdateUserInfo")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateUserInfo(UserBeen userBeen) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(userBeen.getAccountID()) ? userBeen.getAccountID() : 0;
            user = userService.findByid(re_id);
            if (!S.isNull(user)) {
                user.setAccountName(userBeen.getAccountName());
                user.setUserName(userBeen.getUserName());
                user.setClientId(userBeen.getClientid());
                user.setRemark(userBeen.getRemark());
                user.setPasswd(userBeen.getPasswd());
                user.setRoleid(userBeen.getRoleid());
                userService.saveOrUpd(user);
            } else {
                user = new User();
                user.setAccountName(userBeen.getAccountName());
                user.setUserName(userBeen.getUserName());
                user.setClientId(userBeen.getClientid());
                user.setRemark(userBeen.getRemark());
                user.setPasswd(userBeen.getPasswd());
                user.setRegisterTime(new Date());
                user.setLastLoginTime(new Date());
                user.setCgFlag(1);
                user.setIslock(0);
                user.setOnlineStatus(0);
                user.setIsModify(1);
                user.setDependenceId(1);
                user.setRoleid(userBeen.getRoleid());
                userService.save(user);
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
    @Path("saveorupdateUserRole")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateUserRole(PrivilegeBean pbean) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(pbean.getClientid()) ? pbean.getClientid() : 0;
            user = userService.findByid(re_id);
            Set<Privilege> privilegeSet = new HashSet<Privilege>();
            //System.out.println(pbean);
            if (pbean.getCallingss() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getCallingss()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getCallingss()));
                }

            }
            if (pbean.getEnterprisebs() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getEnterprisebs()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getEnterprisebs()));
                }

            }

            if (pbean.getMonitoringss() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getMonitoringss()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getMonitoringss()));
                }

            }
            if (pbean.getSeatscc() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getSeatscc()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getSeatscc()));
                }

            }
            if (pbean.getServicees() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getServicees()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getServicees()));
                }

            }
            if (pbean.getComprehensiveas() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getComprehensiveas()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getComprehensiveas()));
                }

            }
            if (pbean.getDynamicis() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getDynamicis()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getDynamicis()));
                }

            }
            if (pbean.getOperationsc() != 0) {
                if (!S.isNull(privilegeService.findByid(pbean.getOperationsc()))) {
                    privilegeSet.add(privilegeService.findByid(pbean.getOperationsc()));
                }

            }

            if (!S.isNull(user)) {
                //删除原来关联
                userService.deleteUserToPri(user.getAccountID());
                user.setPrivilegeSet(privilegeSet);
                userService.saveOrUpd(user);
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
    @Path("delUserByid")
    @Produces("application/json;charset=utf-8")
    public String delUserByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            user = userService.findByid(id);
            if (!S.isNull(user)) {
                userService.delete(id);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
        } catch (Exception e) {
            LOGGER.error("删除用户信息异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

}
