package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.*;
import com.spring.jersy.hibernate.model.service.*;
import com.spring.jersy.hibernate.publics.bean.OrderResult;
import com.spring.jersy.hibernate.publics.bean.TreeBean;
import com.spring.jersy.hibernate.publics.util.*;
import com.spring.jersy.hibernate.resource.BaseResource;
import com.spring.jersy.hibernate.synch.Synch;
import com.spring.jersy.hibernate.synch.beans.baseinfo.BaseInfoCompanyStat;
import com.spring.jersy.hibernate.synch.service.baseinfo.BaseInfoCompanyStatService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
@Component
@Path("/driver")
@Scope("prototype")
public class DriverResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverResource.class);
    private static final String tabcontent = "司机信息";

    @Context
    private HttpServletResponse response;

    @Resource
    private DriverService driverService;

    @Resource
    private DriverIntegrityService driverIntegrityService;

    @Resource
    private DefaultPositionService defaultPositionService;
    @Resource
    private ClientService clientService;
    @Resource
    private CarinfoService carinfoService;

    @Resource
    private ClientSettingService clientSettingService;
    @Resource
    private LogAbnormalService logAbnormalService;
    @Resource
    private LogOperationService logOperationService;


    private List<Driver> driverList;
    private DefaultPosition defaultPosition;
    private Driver driver;
    private List<TreeBean> treeBeans;


    @Autowired
    private Synch synch;


    @Resource
    private BaseInfoCompanyStatService baseInfoCompanyStatService;


    @GET
    @Path("findDriverForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("isstop") final Integer isstop, @QueryParam("kabnumid") final Integer kabnumid, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token, @QueryParam("isonline") final Integer isonline, @QueryParam("page") final int page, @QueryParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + tabcontent, clientid);
        try {
            Integer ac_client = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = driverService.findPageList(page, rows, sort, order, key, isstop, isonline, startime, endtime, kabnumid, ac_client);
            driverList = pageList.getList();
            if (!S.isNull(driverList) && driverList.size() > 0) {
                for (Driver d : driverList) {
                    if (d.getCompany() == "" || d.getCompany() == null) {
                        if (!S.isNull(d.getClientid())) {
                            String company = clientService.findByid(d.getClientid()).getCompany();
                            d.setCompany(company);
                        }
                    }
                }
            } else {
                driverList = new ArrayList<Driver>();
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverList);

        } catch (Exception e) {
            LOGGER.error("加载司机数据异常：", e);
            e.printStackTrace();
            logAbnormalService.savelogAbnormal(token, "加载司机数据异常！", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverOnOfflineCar")
    @Produces("application/json;charset=utf-8")
    public String findDriverOnOfflineCar(@QueryParam("kabnum") final String kabnum, @QueryParam("isonline") final Integer isonline, @QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + "查询在线离线车辆信息！", clientid);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            driverList = driverService.findListByOnOffline(kabnum, isonline, ac_clientid);
            total = driverList.size();
            return ReturePageList(total, driverList);
        } catch (Exception e) {
            LOGGER.error("加载在线离线车辆列表表异常：", e);
            e.printStackTrace();
            logAbnormalService.savelogAbnormal(token, "加载在线离线车辆数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("findDriverOnOfflineMsid")
    @Produces("application/json;charset=utf-8")
    public String findDriverOnOfflineMsid(@QueryParam("msid") final String msid, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid, @QueryParam("isonline") final Integer isonline) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + "查询在线离线终端数据！", clientid);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            driverList = driverService.findListByOnOfflineMsid(msid, isonline, ac_clientid);
            if (!S.isListNull(driverList)) {
                for (Driver d : driverList) {
                    if (!S.isNull(clientService.findByid(d.getClientid()))) {
                        d.setCompany(clientService.findByid(d.getClientid()).getCompany());
                    }
                }
            }
            total = driverList.size();
            return ReturePageList(total, driverList);
        } catch (Exception e) {
            LOGGER.error("加载在线离线msid列表表异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载在线离线终端数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("saveorupdateDriver")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriver(@QueryParam("driverid") final Integer driverid, @QueryParam("identity") final String identity, @QueryParam("token") final String token, @QueryParam("account") final String account, @QueryParam("pwd") final String pwd, @QueryParam("kabnum") final int kabnumid, @QueryParam("name") final String name, @QueryParam("sex") final Integer sex, @QueryParam("phone") final String phone, @QueryParam("msid") final String msid, @QueryParam("company") final String company, @QueryParam("operationid") final String OperationID, @QueryParam("licenseid") final String LicenseID, @QueryParam("starlevel") final String starLevel, @QueryParam("drivercardid") final String driverCardID, @QueryParam("serialnum") final String serialNum, @QueryParam("companyid") final int companyid, @QueryParam("clientid") final int clientid, @QueryParam("validitydatetime") final String validityDatetime, @QueryParam("filestute") final int filestute, @QueryParam("idstute") final int idstute, @QueryParam("drivingstute") final int drivingstute) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            ClientSetting clientSetting = clientSettingService.findByid(clientid);


            if (clientSetting != null) {
                System.out.println(clientSetting.getMaxdrivernum());
                System.out.println(driverService.findCount(clientid).longValue());


                if (driverService.findCount(clientid).longValue() >= clientSetting.getMaxdrivernum()) {

                    responseSim.setCode(Constants.FAILURE_RESP);
                    responseSim.setDesc(Constants.FAILURE_MAX_NUM);
                    JSONObject array = JSONObject.fromObject(responseSim);
                    return array.toString();
                }
            }


            Integer ac_driverid = !S.isNull(driverid) ? driverid : 0;
            String ac_account = !S.isNull(account) ? account : null;
            String ac_pwd = !S.isNull(pwd) ? pwd : "123456";
            //            String ac_kabnum = !S.isNull(kabnum) ? kabnum : null;
            String ac_name = !S.isNull(name) ? name : null;
            Integer ac_sex = !S.isNull(sex) ? sex : 0;
            String ac_phone = !S.isNull(phone) ? phone : null;
            String ac_msid = !S.isNull(msid) ? msid : ac_phone;
            //            String ac_company = !S.isNull(company) ? company : null;

            String ac_OperationID = !S.isNull(OperationID) ? OperationID : null;
            String ac_identity = !S.isNull(identity) ? identity : null;
            String ac_LicenseID = !S.isNull(LicenseID) ? LicenseID : null;
            String ac_starLevel = !S.isNull(starLevel) ? starLevel : null;
            String ac_driverCardID = !S.isNull(driverCardID) ? driverCardID : null;
            String ac_serialNum = !S.isNull(serialNum) ? serialNum : null;
            String ac_validityDatetime = !S.isNull(validityDatetime) ? validityDatetime : S.getValidityDatetime(1);
            Integer ac_filestute = !S.isNull(filestute) ? filestute : 0;
            Integer ac_idstute = !S.isNull(idstute) ? idstute : 0;
            Integer ac_drivingstute = !S.isNull(drivingstute) ? drivingstute : 0;

            Carinfo carinfo = null;


            //            Set<Driver> driverSet = driverService.findBySetid(kabnumid);

            if (!S.isNull(driverid)) {
                //                System.out.println(driverid);
                driver = driverService.findByid(ac_driverid);

                if (driver.getCarinfo() == null || kabnumid != driver.getCarinfo().getId())
                    carinfo = carinfoService.findByid(kabnumid);
                else
                    carinfo = driver.getCarinfo();
                //删除原来的关联
                //          delCartoDriverByid(driverid,driver);

                driver.setAccount(ac_account);
                driver.setPwd(ac_pwd);
                //                driver.setMsid(ac_msid);


                driver.setKabnumid(kabnumid);
                if (!S.isNull(kabnumid)) {
                    if (!S.isNull(carinfo)) {
                        driver.setKabnum(carinfo.getKabnum());
                    }

                }
                driver.setName(ac_name);
                driver.setSex(ac_sex);
                driver.setPhone(ac_phone);
                driver.setIdentity(ac_identity);
                driver.setClientid(companyid);
                driver.setIsstop(0);
                driver.setIsdel(0);
                //                driver.setDriverPic(pictureName);
                driver.setDriverCardID(ac_driverCardID);
                driver.setLicenseID(ac_LicenseID);
                driver.setOperationID(ac_OperationID);
                driver.setSerialNum(ac_serialNum);
                driver.setStarLevel(ac_starLevel);
                driver.setCompany(company);
                //                Set<Carinfo> carinfos = new HashSet<Carinfo>();
                //                carinfos.add(carinfo);
                //driver.setCarinfoHashSet(carinfo);
                driver.setCarinfo(carinfo);
                try {
                    driver.setValidityDatetime(DateUtil.stringToDate(ac_validityDatetime, "yyyy-MM-dd HH:mm:ss"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (ac_filestute == 1) {

                    driver.setDriverPic(PrcUrl + "" + ac_account + ".png");
                }
                if (ac_idstute == 1) {

                    driver.setDriveridentityPic(PrcUrl + "" + ac_account + "_identity" + ".png");
                }
                if (ac_drivingstute == 1) {

                    driver.setDrivingPic(PrcUrl + "" + ac_account + "_driving" + ".png");
                }
                carinfoService.saveOrUpd(carinfo);
                driverService.saveOrUpd(driver);

                DriverIntegrity driverIntegrity = driverIntegrityService.findDriverIntegrityByPhone(driver.getPhone());
                if (driverIntegrity != null) {
                    driverIntegrity.setKabnum(driver.getKabnum());
                    driverIntegrity.setClientid(driver.getClientid());
                    driverIntegrity.setName(driver.getName());
                    driverIntegrity.setSex(driver.getSex());
                    driverIntegrityService.saveOrUpd(driverIntegrity);
                }


                //添加关联
                //                if (driverSet.size() > 0) {
                //                    for (Driver d : driverSet) {
                //                        if (d.getDriverid() != driver.getDriverid()) {
                //                            driverSet.add(driver);
                //                        }
                //                    }
                //                } else {
                //                    driverSet.add(driver);
                //                }
                //                if (driverSet.size() > 0) {
                //                    for (Driver d : driverSet) {
                //                        if (d.getDriverid() == driver.getDriverid()) {
                //                            break;
                //                        }
                //                    }
                //                    driverSet.add(driver);
                //                }else{
                //                    driverSet.add(driver);
                //                }

                //                driverSet.add(driver);
                //
                //                carinfo.setDriverHashSet(driverSet);
                //                carinfoService.saveOrUpd(carinfo);

                logOperationService.savelogOperation(token, OPERATION_EDIT, OPERATION_EDIT_NAME + ":" + ac_account + "司机信息！", clientid);
            } else {
                driver = new Driver();
                carinfo = carinfoService.findByid(kabnumid);
                driver.setAccount(ac_account);
                driver.setPwd(ac_pwd);
                driver.setMsid(ac_msid);
                driver.setIdentity(ac_identity);
                driver.setKabnumid(kabnumid);
                if (!S.isNull(kabnumid)) {
                    if (!S.isNull(carinfo)) {
                        driver.setKabnum(carinfo.getKabnum());
                    }

                }
                driver.setName(ac_name);
                driver.setSex(ac_sex);
                driver.setPhone(ac_phone);
                driver.setClientid(companyid);
                driver.setCreatetime(new Date());
                driver.setIsonline(0);
                driver.setIsstop(0);
                driver.setIsdel(0);
                driver.setRemain(1000);
                //                driver.setDriverPic(pictureName);
                driver.setDriverCardID(ac_driverCardID);
                driver.setLicenseID(ac_LicenseID);
                driver.setOperationID(ac_OperationID);
                driver.setSerialNum(ac_serialNum);
                driver.setStarLevel(ac_starLevel);
                try {
                    driver.setValidityDatetime(DateUtil.stringToDate(ac_validityDatetime, "yyyy-MM-dd HH:mm:ss"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (ac_filestute == 1) {

                    driver.setDriverPic(PrcUrl + "" + ac_account + ".png");
                }
                if (ac_idstute == 1) {

                    driver.setDriveridentityPic(PrcUrl + "" + ac_account + "_identity" + ".png");
                }
                if (ac_drivingstute == 1) {

                    driver.setDrivingPic(PrcUrl + "" + ac_account + "_driving" + ".png");
                }
                //                Set<Carinfo> carinfos = new HashSet<Carinfo>();
                //                carinfos.add(carinfo);
                //driver.setCarinfoHashSet(carinfos);
                driver.setCarinfo(carinfo);
                driverService.save(driver);
                DriverIntegrity driverIntegrity = driverIntegrityService.findDriverIntegrityByPhone(driver.getPhone());
                if (driverIntegrity != null) {
                    driverIntegrity.setKabnum(driver.getKabnum());
                    driverIntegrity.setClientid(driver.getClientid());
                    driverIntegrity.setName(driver.getName());
                    driverIntegrity.setSex(driver.getSex());
                    driverIntegrityService.saveOrUpd(driverIntegrity);
                }
                //                //添加关联
                //                if (driverSet.size() > 0) {
                //                    for (Driver d : driverSet) {
                //
                //                        if (d.getDriverid() != driver.getDriverid()) {
                //                            driverSet.add(driver);
                //                        }
                //                    }
                //                } else {
                //                    driverSet.add(driver);
                //                }

                //                if (driverSet.size() > 0) {
                //                    for (Driver d : driverSet) {
                //                        if (d.getDriverid() == driver.getDriverid()) {
                //                            break;
                //                        }
                //                    }
                //                    driverSet.add(driver);
                //                }else{
                //                    driverSet.add(driver);
                //                }

                //                driverSet.add(driver);
                //                carinfo.setDriverHashSet(driverSet);//chucuo
                //                carinfoService.saveOrUpd(carinfo);

                logOperationService.savelogOperation(token, OPERATION_ADD, OPERATION_ADD_NAME + ":" + ac_account + "司机信息！", clientid);
            }
            BaseInfoCompanyStat baseInfoCompanyStat = baseInfoCompanyStatService.synch();
            baseInfoCompanyStat.setFlag(2);
            synch.update(baseInfoCompanyStat);

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("加载添加或修改司机异常：", e);
            e.printStackTrace();
            logAbnormalService.savelogAbnormal(token, "加载添加或修改司机异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

    @DELETE
    @Path("delCarinfoDriverByid")
    @Produces("application/json;charset=utf-8")
    public String delCarinfoDriverByid(@QueryParam("driverid") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByid(id);
            if (!S.isNull(driver)) {
                Boolean bool = carinfoService.deleteCarinfToDriver(driver.getKabnumid(), id);
                if (bool) {
                    driver.setKabnum("");
                    driver.setKabnumid(0);
                    driverService.saveOrUpd(driver);
                    BaseInfoCompanyStat baseInfoCompanyStat = baseInfoCompanyStatService.synch();
                    baseInfoCompanyStat.setFlag(2);
                    synch.update(baseInfoCompanyStat);


                } else {
                    responseSim.setCode(Constants.FAILURE_RESP);
                    responseSim.setDesc(Constants.FAILURE_DESC_RESP);
                }
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + driver.getAccount() + "司机信息！", clientid);
        } catch (Exception e) {
            LOGGER.error("删除车辆与司机关联异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + driver.getAccount() + "司机数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

    @GET
    @Path("findDriverByid")
    @Produces("application/json;charset=utf-8")
    public Driver findDriverByid(@QueryParam("driverid") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            driver = driverService.findByid(id);
            logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + driver.getAccount() + "司机信息！", clientid);
            //            JSONObject array = JSONObject.fromObject(driver);
            return driver;

        } catch (Exception e) {
            LOGGER.error("加载个人司机信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载" + driver.getAccount() + "司机数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return new Driver();
        }

    }

    @DELETE
    @Path("delDriverByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverByid(@QueryParam("driverid") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByid(id);
            if (!S.isNull(driver)) {
                delCartoDriverByid(driver.getDriverid(), driver);
                driverService.delete(id);
                BaseInfoCompanyStat baseInfoCompanyStat = baseInfoCompanyStatService.synch();
                baseInfoCompanyStat.setFlag(2);
                synch.update(baseInfoCompanyStat);


            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + driver.getAccount() + "司机信息！", clientid);
        } catch (Exception e) {
            LOGGER.error("删除司机信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + driver.getAccount() + "司机数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

    @DELETE
    @Path("delDriverByids")
    @Produces("application/json;charset=utf-8")
    public String delDriverByids(@QueryParam("driverids") final String ids, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        Integer[] all = null;

        try {
            String message = "";
            String[] temp = ids.split(",");
            all = new Integer[temp.length];
            for (int i = 0; i < temp.length; i++) {
                all[i] = !S.isNull(temp[i]) ? Integer.valueOf(temp[i]) : 0;
            }
            for (int i = 0; i < all.length; i++) {
                driver = driverService.findByid(all[i]);

                if (!S.isNull(driver)) {
                    // delCartoDriverByid(driver.getDriverid(),driver);
                    driver.setCarinfo(null);
                    driverService.saveOrUpd(driver);
                    driverService.delete(all[i]);


                    BaseInfoCompanyStat baseInfoCompanyStat = baseInfoCompanyStatService.synch();
                    baseInfoCompanyStat.setFlag(2);
                    synch.update(baseInfoCompanyStat);


                } else {
                    message += driver.getAccount();
                    responseSim.setCode(Constants.DELDRIVERS_ERROR);
                    responseSim.setDesc(message + Constants.DELDRIVERS_DESC_ERROR);
                }
                logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + driver.getAccount() + "司机信息！", clientid);
            }

        } catch (Exception e) {
            LOGGER.error("删除司机信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + driver.getAccount() + "司机数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

    @GET
    @Path("isStopbyDriverid")
    @Produces("application/json;charset=utf-8")
    public String isStopbyDriverid(@QueryParam("driverid") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByid(id);
            if (!S.isNull(driver)) {
                if (driver.getIsstop() == 0) {
                    driver.setIsstop(1);
                } else {
                    driver.setIsstop(0);
                }
                driverService.saveOrUpd(driver);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            logOperationService.savelogOperation(token, OPERATION_EDIT, "禁用/启用" + ":" + driver.getAccount() + "司机信息！", clientid);
        } catch (Exception e) {
            LOGGER.error("禁用/启用司机信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "禁用/启用" + driver.getAccount() + "司机数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();
    }

    @GET
    @Path("isStopbyDriverPhone")
    @Produces("application/json;charset=utf-8")
    public String isStopbyDriverPhone(@QueryParam("phone") final String phone, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByPhone(phone);
            if (!S.isNull(driver)) {
                if (driver.getIsstop() == 0) {
                    driver.setIsstop(1);
                } else {
                    driver.setIsstop(0);
                }
                driverService.saveOrUpd(driver);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            logOperationService.savelogOperation(token, OPERATION_EDIT, "禁用/启用" + ":" + driver.getAccount() + "司机信息！", clientid);
        } catch (Exception e) {
            LOGGER.error("禁用/启用司机信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "禁用/启用" + driver.getAccount() + "司机数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();
    }

    @GET
    @Path("setPasswordbyDriverid")
    @Produces("application/json;charset=utf-8")
    public String setPasswordbyDriverid(@QueryParam("driverid") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByid(id);
            if (!S.isNull(driver)) {
                driver.setPwd("123456");
                driverService.saveOrUpd(driver);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            logOperationService.savelogOperation(token, OPERATION_EDIT, "修改密码" + ":" + driver.getAccount() + "司机信息！", clientid);
        } catch (Exception e) {
            LOGGER.error("司机密码异常：", e);
            logAbnormalService.savelogAbnormal(token, driver.getAccount() + "司机设置密码数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();
    }

    @GET
    @Path("findListbyDriverName")
    @Produces("application/json;charset=utf-8")
    public String findListbyDriverName(@QueryParam("kabnum") final String kabnum, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findDriverByCarName(kabnum);
            //            if (driver.getLastlt() != null && driver.getLastlg() != null) {
            //
            //                GpsEntity gpsEntity = ChangeGps.wgs84Tobd09(driver.getLastlt(), driver.getLastlg());
            //                if (!S.isNull(gpsEntity)) {
            //                    driver.setLastlg(gpsEntity.getLongitude());
            //                    driver.setLastlt(gpsEntity.getLatitude());
            //                }
            //            }
            //           JSONObject array = JSONObject.fromObject(driver);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(driver);

        } catch (Exception e) {
            LOGGER.error("根据车牌号列表信息异常：", e);
            logAbnormalService.savelogAbnormal(token, driver.getAccount() + "根据车牌号数据异常", driver.getClientid());
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


    @GET
    @Path("findDriverByStatus")
    @Produces("application/json;charset=utf-8")
    public String findDriverByStatus(@QueryParam("isonline") final Integer isonline, @QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, "查询" + ":" + "司机信息状态！", clientid);
        try {
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            driverList = driverService.findListByStatus(isonline, ac_clientid);
            //  JSONArray array = JSONArray.fromObject(driverList.toArray());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(driverList.toArray());
        } catch (Exception e) {
            LOGGER.error("查询车辆在线状态异常：", e);
            logAbnormalService.savelogAbnormal(token, "查询车辆在线状态异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("checkDriverName")
    @Produces("application/json;charset=utf-8")
    public String checkDriverName(@QueryParam("account") final String account, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByName(account);
            if (!S.isNull(driver)) {
                responseSim.setCode(Constants.EXISR_DRIVER_RESP);
                responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("判断司机是否存在：", e);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();
    }

    @POST
    @Path("findByaccount")
    @Produces("application/json;charset=utf-8")
    public String findByaccount(@QueryParam("account") final String account) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByName(account);
            JSONObject array = JSONObject.fromObject(driver);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("判断司机是否存在：", e);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("checkDriverPhone")
    @Produces("application/json;charset=utf-8")
    public String checkDriverPhone(@QueryParam("phone") final String phone) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driver = driverService.findByPhone(phone);
            if (!S.isNull(driver)) {
                responseSim.setCode(Constants.EXISR_DRIVER_RESP);
                responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("判断司机电话号码是否存在：", e);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();
    }

    @GET
    @Path("loadDriverPosition")
    @Produces("application/json;charset=utf-8")
    public String loadDriverPosition() throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            driverList = driverService.findDriverPosition();
            //            JSONArray array = JSONArray.fromObject(driverList.toArray());
            ObjectMapper array = new ObjectMapper();
            return array.writeValueAsString(driverList);
        } catch (Exception e) {
            LOGGER.error("加载所有司机位置信息异常:", e);

            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);

            ObjectMapper array = new ObjectMapper();

            return array.writeValueAsString(responseSim);
        }

    }

    @GET
    @Path("updataDriverPosition")
    @Produces("application/json;charset=utf-8")
    public String updataDriverPosition(@QueryParam("lasttime") final String lasttime) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            //时间戳转时间

            String re_lasttime = !S.isNull(lasttime) ? S.stampToDate(lasttime) : null;
            if (!S.isNull(re_lasttime)) {
                driverList = driverService.findDriverPositionByTime(re_lasttime);
            } else {
                driverList = new ArrayList<Driver>();
            }

            ObjectMapper array = new ObjectMapper();
            return array.writeValueAsString(driverList);
        } catch (Exception e) {
            LOGGER.error("加载所有司机位置信息异常:", e);
            responseSim.setCode(Constants.PARAM_ERR_RESP);
            responseSim.setDesc(Constants.PARAM_ERR_DESC_RESP);
            ObjectMapper array = new ObjectMapper();
            return array.writeValueAsString(responseSim);
        }

    }

    @GET
    @Path("finddefPosbyUseid")
    @Produces("application/json;charset=utf-8")
    public String finddefPosbyUseid(@QueryParam("SSid") final Integer SSid, @QueryParam("userid") final Integer useid, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer ac_driverid = !S.isNull(SSid) ? SSid : 0;
            defaultPosition = defaultPositionService.findByUseid(useid, ac_driverid);
            JSONObject array = JSONObject.fromObject(defaultPosition);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("根据id设置电召单数异常：", e);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("findDrivertree")
    @Produces("application/json;charset=utf-8")
    public String findDrivertree(@QueryParam("id") final Integer id, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            treeBeans = new ArrayList<TreeBean>();
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            if (ac_clientid == 0) {
                //总公司
                Client cencom = clientService.findListByCityflagId(0);

                TreeBean cencomBean = new TreeBean();
                cencomBean.setId(cencom.getClientId());
                cencomBean.setPid(0);
                cencomBean.setText(cencom.getClientName());


                //子公司
                List<Client> subsidiary = clientService.findListById(1);
                // 总公司 下的孩子
                List<TreeBean> cencomChildren = new ArrayList<TreeBean>();
                //子公司下的孩子
                List<TreeBean> subsidiaryChildren = null;
                //车
                List<Driver> drivers = null;

                TreeBean subsidiaryBean = null;
                TreeBean driverBean = null;

                for (Client s : subsidiary) {
                    subsidiaryBean = new TreeBean();
                    subsidiaryBean.setId(s.getClientId());
                    subsidiaryBean.setPid(cencom.getPid());
                    subsidiaryBean.setText(s.getCompany());

                    //车
                    drivers = driverService.findDriverByClientId(s.getClientId());
                    subsidiaryChildren = new ArrayList<TreeBean>();
                    for (Driver driver : drivers) {
                        driverBean = new TreeBean();
                        driverBean.setId(driver.getDriverid());
                        driverBean.setPid(subsidiaryBean.getPid());
                        driverBean.setText(driver.getKabnum());
                        driverBean.setMsid(driver.getMsid());

                        if (driver.getIsonline() == 0) {
                            driverBean.setIconCls("icon-online");

                        } else {
                            driverBean.setIconCls("icon-inline");
                            driverBean.setChecked(true);
                        }
                        subsidiaryChildren.add(driverBean);
                    }
                    subsidiaryBean.setIconCls("icon-group");
                    subsidiaryBean.setChildren(subsidiaryChildren);
                    cencomChildren.add(subsidiaryBean);
                }
                cencomBean.setIconCls("icon-company");
                cencomBean.setChildren(cencomChildren);
                treeBeans.add(cencomBean);
            } else {
                //总公司
                Client cencom = clientService.findByid(ac_clientid);

                TreeBean cencomBean = new TreeBean();
                cencomBean.setId(cencom.getClientId());
                cencomBean.setPid(cencom.getPid());
                cencomBean.setText(cencom.getClientName());
                //车
                List<Driver> drivers = driverService.findDriverByClientId(cencom.getClientId());
                //子公司下的孩子
                List<TreeBean> subsidiaryChildren = null;
                TreeBean driverBean = null;

                subsidiaryChildren = new ArrayList<TreeBean>();
                for (Driver driver : drivers) {
                    driverBean = new TreeBean();
                    driverBean.setId(driver.getDriverid());
                    driverBean.setPid(cencom.getClientId());
                    driverBean.setText(driver.getKabnum());
                    driverBean.setMsid(driver.getMsid());

                    if (driver.getIsonline() == 0) {
                        driverBean.setIconCls("icon-online");

                    } else {
                        driverBean.setIconCls("icon-inline");
                        driverBean.setChecked(true);
                    }
                    subsidiaryChildren.add(driverBean);
                }
                cencomBean.setIconCls("icon-company");
                cencomBean.setChildren(subsidiaryChildren);
                treeBeans.add(cencomBean);
            }


            //  JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(treeBeans.toArray());
        } catch (Exception e) {
            LOGGER.error("加载所有司机树异常异常:", e);
            logAbnormalService.savelogAbnormal("所有", "加载所有司机树异常异常", clientid);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("findDriverAccountree")
    @Produces("application/json;charset=utf-8")
    public String findDriverAccountree(@QueryParam("id") final Integer id, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            treeBeans = new ArrayList<TreeBean>();
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            if (ac_clientid == 0) {
                //总公司
                Client cencom = clientService.findListByCityflagId(0);

                TreeBean cencomBean = new TreeBean();
                cencomBean.setId(cencom.getClientId());
                cencomBean.setPid(0);
                cencomBean.setText(cencom.getClientName());


                //子公司
                List<Client> subsidiary = clientService.findListById(1);
                // 总公司 下的孩子
                List<TreeBean> cencomChildren = new ArrayList<TreeBean>();
                //子公司下的孩子
                List<TreeBean> subsidiaryChildren = null;
                //车
                List<Driver> drivers = null;

                TreeBean subsidiaryBean = null;
                TreeBean driverBean = null;

                for (Client s : subsidiary) {
                    subsidiaryBean = new TreeBean();
                    subsidiaryBean.setId(s.getClientId());
                    subsidiaryBean.setPid(cencom.getPid());
                    subsidiaryBean.setText(s.getCompany());

                    //车
                    drivers = driverService.findDriverByClientId(s.getClientId());
                    subsidiaryChildren = new ArrayList<TreeBean>();
                    for (Driver driver : drivers) {
                        driverBean = new TreeBean();
                        driverBean.setId(driver.getDriverid());
                        driverBean.setPid(subsidiaryBean.getPid());
                        driverBean.setText(driver.getName() + "--->" + driver.getKabnum());
                        driverBean.setMsid(driver.getMsid());
                        //
                        //                        if (driver.getIsonline() == 0) {
                        //                            driverBean.setIconCls("icon-online");
                        //
                        //                        } else {
                        driverBean.setIconCls("icon-inline");
                        //                            driverBean.setChecked(true);
                        //                        }
                        subsidiaryChildren.add(driverBean);
                    }
                    subsidiaryBean.setIconCls("icon-group");
                    subsidiaryBean.setChildren(subsidiaryChildren);
                    cencomChildren.add(subsidiaryBean);
                }
                cencomBean.setIconCls("icon-company");
                cencomBean.setChildren(cencomChildren);
                treeBeans.add(cencomBean);
            } else {
                //总公司
                Client cencom = clientService.findByid(ac_clientid);

                TreeBean cencomBean = new TreeBean();
                cencomBean.setId(cencom.getClientId());
                cencomBean.setPid(cencom.getPid());
                cencomBean.setText(cencom.getClientName());
                //车
                List<Driver> drivers = driverService.findDriverByClientId(cencom.getClientId());
                //子公司下的孩子
                List<TreeBean> subsidiaryChildren = null;
                TreeBean driverBean = null;

                subsidiaryChildren = new ArrayList<TreeBean>();
                for (Driver driver : drivers) {
                    driverBean = new TreeBean();
                    driverBean.setId(driver.getDriverid());
                    driverBean.setPid(cencom.getClientId());
                    driverBean.setText(driver.getKabnum());
                    driverBean.setMsid(driver.getMsid());

                    if (driver.getIsonline() == 0) {
                        driverBean.setIconCls("icon-online");

                    } else {
                        driverBean.setIconCls("icon-inline");
                        driverBean.setChecked(true);
                    }
                    subsidiaryChildren.add(driverBean);
                }
                cencomBean.setIconCls("icon-company");
                cencomBean.setChildren(subsidiaryChildren);
                treeBeans.add(cencomBean);
            }


            //  JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(treeBeans.toArray());
        } catch (Exception e) {
            LOGGER.error("加载所有司机树异常异常:", e);
            logAbnormalService.savelogAbnormal("所有", "加载所有司机树异常异常", clientid);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @GET
    @Path("findListclientId")
    @Produces("application/json;charset=utf-8")
    public String findListclientId(@QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driverList = driverService.findDriverByClientId(clientid);
            ObjectMapper array = new ObjectMapper();
            // JSONArray array = JSONArray.fromObject(driverList.toArray());
            //System.out.println(array.toString());
            return array.writeValueAsString(driverList.toArray());

        } catch (Exception e) {
            LOGGER.error("根据客户Id查询信息异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    public boolean delCartoDriverByid(Integer id, Driver driver) {
        Boolean b = false;
        try {
            if (!S.isNull(driver)) {
                Boolean bool = carinfoService.deleteCarinfToDriver(driver.getKabnumid(), id);
                if (bool) {
                    driver.setKabnum("");
                    driver.setKabnumid(0);
                    driverService.saveOrUpd(driver);
                    b = true;
                }
            }
        } catch (Exception e) {
            LOGGER.error("删除车辆与司机关联异常：", e);
        }
        return b;
    }

    @POST
    @Path("setRecharg")
    @Produces("application/json;charset=utf-8")
    public String setRecharg(Driver redriver) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer ac_driverid = !S.isNull(redriver.getDriverid()) ? redriver.getDriverid() : 0;
            driver = driverService.findByid(ac_driverid);
            if (!S.isNull(driver)) {
                //System.out.println(redriver.getRemain());
                driver.setRemain(redriver.getRemain());
                driverService.saveOrUpd(driver);
            }

        } catch (Exception e) {
            LOGGER.error("设置使用次数异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }


    @POST
    @Path("updateRemain")
    @Produces("application/json;charset=utf-8")
    public String updateRemain(@QueryParam("ids") final String ids, @QueryParam("remain") final Integer remain) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        Integer[] all = null;


        try {

            Integer ac_remain = !S.isNull(remain) ? remain : 0;
            String message = "";
            String[] temp = ids.split(",");
            all = new Integer[temp.length];

            for (int i = 0; i < temp.length; i++) {
                all[i] = !S.isNull(temp[i]) ? Integer.valueOf(temp[i]) : 0;
            }

            List<Driver> drivers = driverService.findListByIDS(all);


            for (Driver driver : drivers) {
                driver.setRemain(ac_remain);
                driverService.saveOrUpd(driver);
            }
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("updateRemain：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findListremainByZero")
    @Produces("application/json;charset=utf-8")
    public String findListremainByZero(@QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            driverList = driverService.findDriverremainByClientId(clientid);
            StringBuilder driverbui = new StringBuilder();
            if (!S.isListNull(driverList)) {
                for (Driver d : driverList) {
                    driverbui.append(d.getAccount()).append(",");
                }
            }
            System.out.println(driverbui);
            OrderResult orderResult = new OrderResult();
            orderResult.setCode(driverList.size());
            orderResult.setDesc(driverbui.toString());
            JSONObject array = JSONObject.fromObject(orderResult);
            return array.toString();
            //            ObjectMapper array = new ObjectMapper();
            //            return  array.writeValueAsString(driverList.toArray());

        } catch (Exception e) {
            LOGGER.error("findListremainByZero：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }
}

