package com.spring.jersy.hibernate.resource.car;

import com.spring.jersy.hibernate.model.entity.Carinfo;
import com.spring.jersy.hibernate.model.entity.Driver;
import com.spring.jersy.hibernate.model.entity.DriverIntegrity;
import com.spring.jersy.hibernate.model.service.CarinfoService;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.DriverIntegrityService;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.publics.bean.TreeBean;
import com.spring.jersy.hibernate.publics.util.*;
import com.spring.jersy.hibernate.resource.BaseResource;
import com.spring.jersy.hibernate.synch.Synch;
import com.spring.jersy.hibernate.synch.beans.baseinfo.BaseInfoCompanyStat;
import com.spring.jersy.hibernate.synch.service.baseinfo.BaseInfoCompanyStatService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Component
@Path("/carinfo")
@Scope("prototype")
public class CarinfoResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CarinfoResource.class);
    private static final String tabname = "Carinfo";
    @Context
    private HttpServletResponse response;


    @Resource
    private CarinfoService carinfoService;
    @Resource
    private ClientService clientService;

    @Resource
    private DriverService driverService;
    private List<Carinfo> carinfoList;
    private List<TreeBean> treeBeans;
    private Carinfo carinfo;


    @Resource
    private DriverIntegrityService driverIntegrityService;

    @Autowired
    private Synch synch;


    @Resource
    private BaseInfoCompanyStatService baseInfoCompanyStatService;
    @POST
    @Path("findCarinfoForPageList")
    @Produces("application/json;charset=utf-8")
    public String findCarinfoForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("clientid") final Integer clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = carinfoService.findSqlPageList(page, rows, sort, order, key, begintime, endtime, type, ac_clientid);
            //            carinfoList =carinfoService.findSqlList(page, rows, sort, order, key, begintime, endtime, type,ac_clientid);
            //            PageList pageList =carinfoService.findList(page, rows, sort, order, key, begintime, endtime, type);
            carinfoList = pageList.getList();
            total = pageList.getTotalRecord();
            //            total = carinfoList.size();
            return ReturePageList(total, carinfoList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findCarinfoByid")
    @Produces("application/json;charset=utf-8")
    public Carinfo findCarinfoByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            carinfo = carinfoService.findByid(re_id);

            //           ObjectMapper mapper = new ObjectMapper();
            return carinfo;

        } catch (Exception e) {
            LOGGER.error(tabname + "根据Id查找：", e);
            e.printStackTrace();
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return new Carinfo();
        }
    }

    @GET
    @Path("findCarinfoByKabnum")
    @Produces("application/json;charset=utf-8")
    public Carinfo findCarinfoByKabnum(@QueryParam("kabnum") final String kabnum) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            String carkabnum = !S.isNull(kabnum) ? kabnum.trim() : "";
            carinfo = carinfoService.findByKabnum(carkabnum);

            //            JSONObject array = JSONObject.fromObject(carinfo);
            return carinfo;

        } catch (Exception e) {
            LOGGER.error(tabname + "根据车牌查找：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return new Carinfo();
        }
    }

    @POST
    @Path("saveorupdateCarinfo")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateCarinfo(@QueryParam("carinfid") final Integer carinfid, @QueryParam("token") final String token, @QueryParam("kabnum") final String kabnum, @QueryParam("devIdno") final String devIdno, @QueryParam("vehicleid") final String vehicleid, @QueryParam("mileage") final Double mileage, @QueryParam("models") final String models, @QueryParam("displacement") final Double displacement, @QueryParam("yearcareful") final String yearcareful, @QueryParam("carstatus") final int carstatus, @QueryParam("vehtatus") final int vehstatus, @QueryParam("company") final int company) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(carinfid) ? carinfid : 0;
            Integer ac_carstatus = !S.isNull(carstatus) ? carstatus : 0;
            Integer ac_vehstatus = !S.isNull(vehstatus) ? vehstatus : 0;
            carinfo = carinfoService.findByid(re_id);

            if (!S.isNull(carinfo)) {
                carinfo.setKabnum(kabnum);
                carinfo.setDevIdno(devIdno);
                carinfo.setMileage(mileage);
                carinfo.setModels(models);
                carinfo.setClientid(company);
                if (!S.isNull(company)) {
                    carinfo.setCompany(clientService.findByid(company).getCompany());
                }
                carinfo.setVehicleid(vehicleid);
                carinfo.setYearcareful(DateUtil.stringToDate(yearcareful, "yyyy-MM-dd HH:mm:ss"));
                carinfo.setDisplacement(displacement);
                if (ac_carstatus == 1) {
                    carinfo.setCarPic(PrcUrl + "" + vehicleid + "_carinfo" + ".png");
                }
                if (ac_vehstatus == 1) {
                    carinfo.setVehPic(PrcUrl + "" + vehicleid + "_vehic" + ".png");
                }
                Set<Driver> driverSet = carinfo.getDriverHashSet();
                if (driverSet != null && !driverSet.isEmpty()) {
                    for (Driver driver : driverSet) {
                        driver.setKabnum(carinfo.getKabnum());
                        DriverIntegrity driverIntegrity = driverIntegrityService.findDriverIntegrityByPhone(driver.getPhone());
                        if (driverIntegrity != null) {
                            driverIntegrity.setKabnum(driver.getKabnum());
                            driverIntegrity.setClientid(driver.getClientid());
                            driverIntegrity.setName(driver.getName());
                            driverIntegrity.setSex(driver.getSex());
                            driverIntegrityService.saveOrUpd(driverIntegrity);
                        }
                    }
                }
                carinfo.setDriverHashSet(driverSet);
                carinfoService.saveOrUpd(carinfo);
            } else {
                carinfo = new Carinfo();
                carinfo.setKabnum(kabnum);
                carinfo.setDevIdno(devIdno);
                carinfo.setMileage(mileage);
                carinfo.setModels(models);
                carinfo.setClientid(company);
                if (!S.isNull(company)) {
                    carinfo.setCompany(clientService.findByid(company).getCompany());
                }
                carinfo.setVehicleid(vehicleid);
                carinfo.setYearcareful(DateUtil.stringToDate(yearcareful, "yyyy-MM-dd HH:mm:ss"));
                carinfo.setDisplacement(displacement);
                if (ac_carstatus == 1) {
                    carinfo.setCarPic(PrcUrl + "" + vehicleid + "_carinfo" + ".png");
                }
                if (ac_vehstatus == 1) {
                    carinfo.setVehPic(PrcUrl + "" + vehicleid + "_vehic" + ".png");
                }
                Set<Driver> driverSet = carinfo.getDriverHashSet();
                if (driverSet != null && !driverSet.isEmpty()) {
                    for (Driver driver : driverSet) {
                        driver.setKabnum(carinfo.getKabnum());
                    }
                }
                carinfo.setDriverHashSet(driverSet);
                carinfoService.save(carinfo);

            }

            BaseInfoCompanyStat baseInfoCompanyStat = baseInfoCompanyStatService.synch();
            baseInfoCompanyStat.setFlag(2);
            synch.update(baseInfoCompanyStat);

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
    @Path("delCarinfoByid")
    @Produces("application/json;charset=utf-8")
    public String delCarinfoByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            carinfo = carinfoService.findByid(re_id);
            if (!S.isNull(carinfo)) {
                if (carinfo.getDriverHashSet().size() == 0) {
                    carinfoService.delete(id);
                    BaseInfoCompanyStat baseInfoCompanyStat = baseInfoCompanyStatService.synch();
                    baseInfoCompanyStat.setFlag(2);
                    synch.update(baseInfoCompanyStat);


                } else {
                    responseSim.setCode(Constants.DELDRIVER_RESP);
                    responseSim.setDesc(Constants.DELDRIVER_DESC_RESP);
                }

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


    @DELETE
    @Path("delCarinfoList")
    @Produces("application/json;charset=utf-8")
    public String delCarinfoList(@QueryParam("ids") final String ids) {
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

            List<Carinfo> carinfos = carinfoService.findListByIDS(all);
            all = new Integer[temp.length];

            if (!S.isNull(carinfos) && !carinfos.isEmpty()) {
                for (int i = carinfos.size() - 1; i >= 0; i--) {
                    carinfo = carinfos.get(i);
                    if (carinfo.getDriverHashSet().size() != 0) {
                        message += carinfo.getKabnum() + " ";
                        responseSim.setCode(Constants.DELDRIVERS_RESP);
                        responseSim.setDesc(message + Constants.DELDRIVERS_DESC_RESP);
                        carinfos.remove(i);
                        continue;
                    }
                }
                if (carinfos.size() == 0) {
                    JSONObject array = JSONObject.fromObject(responseSim);
                    return array.toString();
                }

                for (int i = 0; i < carinfos.size(); i++) {
                    all[i] = carinfos.get(i).getId();
                }
                carinfoService.deleteBatch(all);
                BaseInfoCompanyStat baseInfoCompanyStat = baseInfoCompanyStatService.synch();
                baseInfoCompanyStat.setFlag(2);
                synch.update(baseInfoCompanyStat);



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
    @Path("findcarinfotree")
    @Produces("application/json;charset=utf-8")
    public String findcarinfotree(@QueryParam("clientid") final int clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            carinfo = carinfoService.findBycilentid(clientid);
            treeBeans = new ArrayList<TreeBean>();
            if (!S.isNull(carinfo)) {
                TreeBean tb;
                //查找父亲节点的为1的树
                for (Carinfo c : carinfoService.findListTreeByPid(carinfo.getCompany())) {
                    tb = new TreeBean();
                    tb.setId(c.getId());
                    tb.setText(c.getKabnum());
                    treeBeans.add(tb);
                }
            }

            JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("findcarinfotree " + tabname + "异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    //检查车牌是否重复

    @POST
    @Path("checkKabnum")
    @Produces("application/json;charset=utf-8")
    public String checkDriverName(@QueryParam("kabnum") final String kabnum) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);


        try {

            carinfo = carinfoService.findByKabnum(kabnum);
            //System.out.println(carinfo);
            if (!S.isNull(carinfo)) {
                responseSim.setCode(Constants.EXISR_CARINFO_KABNUM_RESP);
                responseSim.setDesc(Constants.EXISR_CARINFO_KABNUM_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("判断车牌号是否存在：", e);
            responseSim.setCode(Constants.EXISR_CARINFO_KABNUM_RESP);
            responseSim.setDesc(Constants.EXISR_CARINFO_KABNUM_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();
    }


}
