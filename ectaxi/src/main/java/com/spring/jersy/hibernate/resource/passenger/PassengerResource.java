package com.spring.jersy.hibernate.resource.passenger;

import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.model.entity.Passenger;
import com.spring.jersy.hibernate.model.entity.Seats;
import com.spring.jersy.hibernate.model.service.*;
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
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
@Component
@Path("/passenger")
@Scope("prototype")
public class PassengerResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PassengerResource.class);
    private static final String tabcontent = "乘客信息";
    //
    @Context
    private HttpServletResponse response;

    @Resource
    private PassengerService passengerService;

    @Resource
    private SeatsService seatsService;

    @Resource
    private ClientService clientService;

    @Resource
    private LogAbnormalService logAbnormalService;
    @Resource
    private LogOperationService logOperationService;

    private Passenger passenger;
    private Seats seats;

    private List<Passenger> passengerList;
    private List<Seats> seatsList;

    @GET
    @Path("findPassengerForPageList")
    @Produces("application/json;charset=utf-8")
    public String findPassengerForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final Integer type, @QueryParam("token") final String token, @QueryParam("page") final int page, @QueryParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + tabcontent, 0);//88888888
        try {
            PageList pageList = passengerService.findPageList(page, rows, sort, order, key, type, startime, endtime);
            passengerList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, passengerList);

        } catch (Exception e) {
            LOGGER.error("加载乘客数据异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载乘客数据异常！", 0);//8888888

            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }


    }

    @POST
    @Path("findSeatsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findSeatsForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("clientid") final int clientid, @QueryParam("key") final String key, @QueryParam("type") final Integer type, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = seatsService.findPageList(page, rows, sort, order, key, type, startime, endtime, ac_clientid);
            seatsList = pageList.getList();
            if (!S.isListNull(seatsList) && seatsList.size() > 0) {
                for (Seats s : seatsList) {
                    if (!S.isNull(s.getClientid()) && s.getClientid() != 0) {
                        Client client = clientService.findByid(s.getClientid());
                        if (!S.isNull(client)) {
                            s.setUnit(client.getCompany());

                        }
                    }

                }
            }

            total = pageList.getTotalRecord();
            return ReturePageList(total, seatsList);

        } catch (Exception e) {
            LOGGER.error("加载乘客数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }


    }


    @GET
    @Path("passengerlist")
    @Produces("application/json;charset=utf-8")
    public String passengerlist(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("type") final Integer type, @QueryParam("key") final String key) {
        //类型type0：乘客  1：坐席
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            passengerList = passengerService.findAllList(startime, endtime);
            JSONArray array = JSONArray.fromObject(passengerList.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("passengerlist异常：", e);
            return null;
        }
    }


    @POST
    @Path("saveorupdatePassenger")
    @Produces("application/json;charset=utf-8")
    public String saveorupdatePassenger(@QueryParam("name") final String username, @QueryParam("opruser") final String opruser, @QueryParam("extensionnum") final String extensionnum, @QueryParam("roleid") final Integer roleid, @QueryParam("company") final int company, @QueryParam("assign") final int assign, @QueryParam("seatsnum") final String seatsnum, @QueryParam("mobile") final String mobile, @QueryParam("sex") final Integer sex, @QueryParam("token") final String token, @QueryParam("password") final String password) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {

            String ac_username = !S.isNull(username) ? username : null;
            String ac_mobile = !S.isNull(mobile) ? mobile : null;
            String ac_password = !S.isNull(password) ? password : "123456";
            Integer ac_sex = !S.isNull(sex) ? sex : 1;
            Integer ac_roleid = !S.isNull(roleid) ? roleid : 0;
            Integer ac_assign = !S.isNull(assign) ? assign : 0;
            passenger = passengerService.findByid(opruser);
            seats = seatsService.findByName(opruser);
            if (!S.isNull(passenger)) {
                passenger.setName(ac_username);
                passenger.setPassword(ac_password);
                passenger.setMobile(ac_mobile);
                passenger.setEnterpriseid(1);
                passenger.setSex(ac_sex);
                passenger.setType(1);//类型0：乘客  1：坐席
                passengerService.saveOrUpd(passenger);

                if (!S.isNull(seats)) {
                    seats.setName(ac_username);
                    seats.setExtensionnum(extensionnum);
                    seats.setSeatsnum(seatsnum);
                    seats.setClientid(company);
                    seats.setSex(ac_sex);
                    seats.setAccount(ac_mobile);
                    seats.setPassword(ac_password);
                    seats.setRoleid(ac_roleid);
                    seats.setAssign(ac_assign);
                    seatsService.saveOrUpd(seats);
                } else {
                    seats = new Seats();
                    seats.setAccount(ac_mobile);
                    seats.setOpruser(ac_mobile);
                    seats.setName(ac_username);
                    seats.setExtensionnum(extensionnum);
                    seats.setSeatsnum(seatsnum);
                    seats.setClientid(company);
                    seats.setSex(ac_sex);
                    seats.setPassword(ac_password);
                    seats.setRoleid(ac_roleid);
                    seats.setAssign(ac_assign);
                    seatsService.save(seats);

                }
                logOperationService.savelogOperation(token, OPERATION_EDIT, OPERATION_EDIT_NAME + ":" + tabcontent, 0);//88888888
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();

            } else {
                passenger = new Passenger();
                passenger.setOpruser(ac_mobile);
                passenger.setName(ac_username);
                passenger.setPassword(ac_password);
                passenger.setOpenId("");
                passenger.setMobile(ac_mobile);
                passenger.setEnterpriseid(1);
                passenger.setSex(ac_sex);
                passenger.setCreatedate(new Date());
                passenger.setType(1);//类型0：乘客  1：坐席
                passenger.setIslock(0);
                passengerService.save(passenger);

                seats = new Seats();
                seats.setOpruser(ac_mobile);
                seats.setAccount(ac_mobile);
                seats.setName(ac_username);
                seats.setExtensionnum(extensionnum);
                seats.setSeatsnum(seatsnum);
                seats.setClientid(company);
                seats.setSex(ac_sex);
                seats.setPassword(ac_password);
                seats.setRoleid(ac_roleid);
                seats.setAssign(ac_assign);
                seatsService.save(seats);
                logOperationService.savelogOperation(token, OPERATION_ADD, OPERATION_ADD_NAME + ":" + tabcontent, 0);//88888888
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {
            LOGGER.error("坐席列表表异常：", e);
            logAbnormalService.savelogAbnormal(token, "坐席列表表异数据异常", 0);//8888888
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @GET
    @Path("setPasswordbyPassid")
    @Produces("application/json;charset=utf-8")
    public String setPasswordbyPassid(@QueryParam("opruser") final String id, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_ADD, OPERATION_ADD_NAME + ":" + tabcontent, 0);//88888888
        try {
            passenger = passengerService.findByid(id);
            if (!S.isNull(passenger)) {
                passenger.setPassword("123456");
                passengerService.saveOrUpd(passenger);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        } catch (Exception e) {

            LOGGER.error("乘客设置密码异常：", e);
            logAbnormalService.savelogAbnormal(token, "坐席设置密码异常", 0);//8888888
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        }

    }

    @GET
    @Path("delPassByid")
    @Produces("application/json;charset=utf-8")
    public String delPassByid(@QueryParam("opruser") final String opruser, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + "坐席", 0);//88888888
        try {
            passenger = passengerService.findByid(opruser);
            if (!S.isNull(passenger)) {
                passengerService.delete(opruser);
                seatsService.delete(opruser);

            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("删除乘客信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除坐席数据异常", 0);//8888888
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @GET
    @Path("checkPassName")
    @Produces("application/json;charset=utf-8")
    public String checkPassName(@QueryParam("opruser") final String opruser) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            passenger = passengerService.findByid(opruser);
            if (!S.isNull(passenger)) {
                responseSim.setCode(Constants.EXISR_DRIVER_RESP);
                responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            } else {
                seats = seatsService.findByAccount(opruser);
                if (!S.isNull(seats)) {
                    responseSim.setCode(Constants.EXISR_DRIVER_RESP);
                    responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
                }
            }


        } catch (Exception e) {
            LOGGER.error("判断乘客是否存在：", e);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();
    }

    @GET
    @Path("findPassByid")
    @Produces("application/json;charset=utf-8")
    public String findPassByid(@QueryParam("opruser") final String opruser) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            seats = seatsService.findByOpruser(opruser);
            JSONObject array = JSONObject.fromObject(seats);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("加载个人司机信息异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


}
