package com.spring.jersy.hibernate.resource.call;

import com.spring.jersy.hibernate.model.entity.CallBussStat;
import com.spring.jersy.hibernate.model.entity.Callbuss;
import com.spring.jersy.hibernate.model.entity.OperatDetails;
import com.spring.jersy.hibernate.model.entity.PayRecords;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.CallBussStatService;
import com.spring.jersy.hibernate.model.service.PayRecordsService;
import com.spring.jersy.hibernate.publics.bean.*;
import com.spring.jersy.hibernate.publics.util.*;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
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
@Path("/callbuss")
@Scope("prototype")
public class CallbussResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CallbussResource.class);

    @Context
    private HttpServletResponse response;

    @Resource
    private CallBussService callBussService;

    @Resource
    private PayRecordsService payRecordsService;

    @Resource
    private CallBussStatService callBussStatService;

    private List<Callbuss> callbussList;
    private List<CallbussBean> callbussBeenList;
    private List<CallBussStat> callBussStatList;
    private Callbuss callbuss;
    private CallBussStat callBussStat;
    private PayRecords payRecords;


    private String amrurl = "/TaxiSMPWS/amrfile/";

    @GET
    @Path("findCallBussForPageList")
    @Produces("application/json;charset=utf-8")
    public String findCallBussForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("status") final Integer status, @QueryParam("type") final Integer type, @QueryParam("clientid") final Integer clientid, @QueryParam("ordertype") final Integer ordertype, @QueryParam("page") final int page, @QueryParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_type = !S.isNull(type) ? type : -1;
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = callBussService.findList(page, rows, sort, order, key, startime, endtime, status, ordertype, re_type, ac_clientid);
            callbussList = pageList.getList();
            if (!S.isNull(callbussList) && callbussList.size() > 0) {
                for (Callbuss c : callbussList) {
                    //电召单完成
                    if (c.getStatus() == 4) {
                        payRecords = payRecordsService.findByorderid(c.getBillid());
                        if (!S.isNull(payRecords)) {
                            if (!S.isNull(payRecords.getPaytype())) {
                                c.setPaytype(payRecords.getPaytype());
                            }

                        }
                    }
                }
            }


            total = pageList.getTotalRecord();
            return ReturePageList(total, callbussList);

        } catch (Exception e) {
            LOGGER.error("加载电召单数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findCallBussForPageListByDate")
    @Produces("application/json;charset=utf-8")
    public String findCallBussForPageListByDate(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("status") final Integer status, @QueryParam("type") final Integer type, @QueryParam("clientid") final Integer clientid, @QueryParam("ordertype") final Integer ordertype, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_type = !S.isNull(type) ? type : -1;
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = callBussService.findListByDate(page, rows, sort, order, key, startime, endtime, status, ordertype, re_type, ac_clientid);
            callbussList = pageList.getList();
            if (!S.isNull(callbussList) && callbussList.size() > 0) {
                for (Callbuss c : callbussList) {
                    //电召单完成
                    if (c.getStatus() == 4) {
                        payRecords = payRecordsService.findByorderid(c.getBillid());
                        if (!S.isNull(payRecords)) {
                            if (!S.isNull(payRecords.getPaytype())) {
                                c.setPaytype(payRecords.getPaytype());
                            }

                        }
                    }
                }
            }


            total = pageList.getTotalRecord();
            return ReturePageList(total, callbussList);

        } catch (Exception e) {
            LOGGER.error("加载电召单数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }


    }

    @POST
    @Path("findCallBussForPageListByOpruser")
    @Produces("application/json;charset=utf-8")
    public String findCallBussForPageListByOpruser(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("status") final Integer status, @QueryParam("type") final Integer type, @QueryParam("clientid") final Integer clientid, @QueryParam("ordertype") final Integer ordertype, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_type = !S.isNull(type) ? type : -1;
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = callBussService.findListByOpruser(page, rows, sort, order, key, startime, endtime, status, ordertype, re_type, ac_clientid);
            callbussList = pageList.getList();
            if (!S.isNull(callbussList) && callbussList.size() > 0) {
                for (Callbuss c : callbussList) {
                    //电召单完成
                    if (c.getStatus() == 4) {
                        payRecords = payRecordsService.findByorderid(c.getBillid());
                        if (!S.isNull(payRecords)) {
                            if (!S.isNull(payRecords.getPaytype())) {
                                c.setPaytype(payRecords.getPaytype());
                            }

                        }
                    }
                }
            }


            total = pageList.getTotalRecord();
            return ReturePageList(total, callbussList);

        } catch (Exception e) {
            LOGGER.error("加载电召单数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }


    }

    @POST
    @Path("findCallBussForPageListByMsid")
    @Produces("application/json;charset=utf-8")
    public String findCallBussForPageListByMsid(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("status") final Integer status, @QueryParam("type") final Integer type, @QueryParam("clientid") final Integer clientid, @QueryParam("ordertype") final Integer ordertype, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_type = !S.isNull(type) ? type : -1;
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = callBussService.findListByMsid(page, rows, sort, order, key, startime, endtime, status, ordertype, re_type, ac_clientid);
            callbussList = pageList.getList();
            if (!S.isNull(callbussList) && callbussList.size() > 0) {
                for (Callbuss c : callbussList) {
                    //电召单完成
                    if (c.getStatus() == 4) {
                        payRecords = payRecordsService.findByorderid(c.getBillid());
                        if (!S.isNull(payRecords)) {
                            if (!S.isNull(payRecords.getPaytype())) {
                                c.setPaytype(payRecords.getPaytype());
                            }
                        }
                    }
                }
            }


            total = pageList.getTotalRecord();
            return ReturePageList(total, callbussList);

        } catch (Exception e) {
            LOGGER.error("加载电召单数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }


    }

    @GET
    @Path("listcallbuss")
    @Produces("application/json;charset=utf-8")
    public String listcallbuss(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("status") final Integer status) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        if (!S.isNull(startime) && !S.isNull(endtime)) {
            try {
                List<Callbuss> callbussList = callBussService.findCallBussByTime(startime, endtime, status);
                JSONArray array = JSONArray.fromObject(callbussList.toArray());
                return array.toString();
            } catch (Exception e) {
                LOGGER.error("listcallbuss异常：", e);
                return null;
            }
        } else {
            return null;
        }


    }

    @GET
    @Path("callrealtimereport")
    @Produces("application/json;charset=utf-8")
    public String callrealtimereport(@QueryParam("id") final String id, @QueryParam("clientid") final int clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            //取一条数据
            callBussStatList = callBussStatService.findLastCallBussStat(1, clientid);
            JSONArray array = JSONArray.fromObject(callBussStatList.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("callrealtimereport异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findMonitorByClientid")
    @Produces("application/json;charset=utf-8")
    public String findMonitorByClientid(@QueryParam("id") final String id, @QueryParam("clientid") final int clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            //取一条数据

            List<MonitorBean> monitorBeanList = callBussStatService.findLastMonitor(clientid);
            JSONArray array = JSONArray.fromObject(monitorBeanList.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("findMonitorByClientid：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


    @GET
    @Path("callbussnewsta")
    @Produces("application/json;charset=utf-8")
    public String callbussnewsta(@QueryParam("startTime") final String startTime, @QueryParam("length") final int length, @QueryParam("clientid") final int clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : null;
            Integer ac_length = !S.isNull(length) ? length : 6;
            callbussList = callBussService.findCallBussNewStatistical(ac_startTime, ac_length, clientid);
            //            if (!S.isNull(callbussList)&&callbussList.size()>0){
            //                for (Callbuss c: callbussList){
            //                    if (c.getOrderType()==3){
            //                        if (!S.isNull(c.getRemark())){
            //                            Download.downLoadFromUrl(c.getRemark(),c.getBillid()+".amr",Download.ArmUrl());
            //                            c.setRemark(amrurl+""+c.getBillid()+".amr");
            //                        }
            //                    }
            //                }
            //            }

            JSONArray array = JSONArray.fromObject(callbussList.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("callbussnewsta异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("callbusshissta")
    @Produces("application/json;charset=utf-8")
    public String callbusshissta(@QueryParam("startTime") final String startTime, @QueryParam("length") final int length, @QueryParam("clientid") final int clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : null;
            Integer ac_length = !S.isNull(length) ? length : 6;
            callbussBeenList = callBussService.findCallBussHisStatistical(ac_startTime, ac_length, clientid);
            //            if (!S.isNull(callbussBeenList)&&callbussBeenList.size()>0){
            //                for (CallbussBean c: callbussBeenList){
            //                    if (c.getOrderType()==3){
            //                        if (!S.isNull(c.getRemark())){
            //                            Download.downLoadFromUrl(c.getRemark(),c.getBillid()+".amr",Download.ArmUrl());
            //                            c.setRemark(amrurl+""+c.getBillid()+".amr");
            //                        }
            //                    }
            //                }
            //            }
            JSONArray array = JSONArray.fromObject(callbussBeenList.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("callbusshissta异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("callbussprosta")
    @Produces("application/json;charset=utf-8")
    public String callbussprosta(@QueryParam("startTime") final String startTime, @QueryParam("length") final int length, @QueryParam("clientid") final int clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : null;
            Integer ac_length = !S.isNull(length) ? length : 6;
            callbussBeenList = callBussService.findCallBussProStatistical(ac_startTime, ac_length, clientid);
            //            if (!S.isNull(callbussBeenList)&&callbussBeenList.size()>0){
            //                for (CallbussBean c: callbussBeenList){
            //                    if (c.getOrderType()==3){
            //                        if (!S.isNull(c.getRemark())){
            //                            Download.downLoadFromUrl(c.getRemark(),c.getBillid()+".amr",Download.ArmUrl());
            //                            c.setRemark(amrurl+""+c.getBillid()+".amr");
            //                        }
            //                    }
            //                }
            //            }
            JSONArray array = JSONArray.fromObject(callbussBeenList.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("callbussprosta异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("callbussByid")
    @Produces("application/json;charset=utf-8")
    public String callbussByid(@QueryParam("billid") final String billid, @QueryParam("length") final int length) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_billid = !S.isNull(billid) ? billid : null;
            callbuss = callBussService.findBybillId(ac_billid);
            //            if (!S.isNull(callbuss)){
            //                if (callbuss.getOrderType()==3){
            //                    if (!S.isNull(callbuss.getRemark())){
            //                        Download.downLoadFromUrl(callbuss.getRemark(),callbuss.getBillid()+".amr",Download.ArmUrl());
            //                        callbuss.setRemark(amrurl+""+callbuss.getBillid()+".amr");
            //                    }
            //                }
            //            }

            // JSONObject array = JSONObject.fromObject(callbuss);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.writeValueAsString(callbuss);
        } catch (Exception e) {
            LOGGER.error("callbusshissta异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("seatcallbussdetails")
    @Produces("application/json;charset=utf-8")
    public String seatcallbussdetails(@QueryParam("startime") final String startTime, @QueryParam("endtime") final String endTime, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : null;
            String ac_endTime = !S.isNull(endTime) ? endTime : null;
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;

            List<SeatCallBussReport> seatCallBussReportList;
            if (ac_startTime != null && ac_endTime != null) {
                seatCallBussReportList = callBussService.findSeatCallBuss(ac_startTime, ac_endTime, re_clientid);
                total = seatCallBussReportList.size();
                return ReturePageList(total, seatCallBussReportList);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {
            LOGGER.error("seatcallbussdetails异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("passercallbussdetails")
    @Produces("application/json;charset=utf-8")
    public String passercallbussdetails(@QueryParam("startime") final String startTime, @QueryParam("endtime") final String endTime, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : null;
            String ac_endTime = !S.isNull(endTime) ? endTime : null;
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            List<PasserCallBussReport> passerCallBussReportList;
            if (ac_startTime != null && ac_endTime != null) {
                passerCallBussReportList = callBussService.findPasserCallBuss(ac_startTime, ac_endTime, ac_clientid);
                total = passerCallBussReportList.size();
                return ReturePageList(total, passerCallBussReportList);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {
            LOGGER.error("passercallbussdetails异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("drivercallbussdetails")
    @Produces("application/json;charset=utf-8")
    public String drivercallbussdetails(@QueryParam("startime") final String startTime, @QueryParam("endtime") final String endTime, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : null;
            String ac_endTime = !S.isNull(endTime) ? endTime : null;
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            List<DriverCallBussReport> driverCallBussReportList;
            if (ac_startTime != null && ac_endTime != null) {
                driverCallBussReportList = callBussService.findDriverCallBuss(ac_startTime, ac_endTime, ac_clientid, page, rows);
                total = callBussService.findCount(clientid);
                return ReturePageList(total, driverCallBussReportList);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {
            LOGGER.error("drivercallbussdetails 异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("datecallbussdetails")
    @Produces("application/json;charset=utf-8")
    public String datecallbussdetails(@QueryParam("startime") final String startTime, @QueryParam("endtime") final String endTime, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : null;
            String ac_endTime = !S.isNull(endTime) ? endTime : null;
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            List<DateCallBussReport> dateCallBussReportList;
            if (ac_startTime != null && ac_endTime != null) {
                dateCallBussReportList = callBussService.findDateCallBuss(ac_startTime, ac_endTime, ac_clientid);
                total = dateCallBussReportList.size();
                return ReturePageList(total, dateCallBussReportList);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {
            LOGGER.error("datecallbussdetails 异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriveroperatedateails")
    @Produces("application/json;charset=utf-8")
    public String findDriveroperatedateails(@QueryParam("startime") final String startTime, @QueryParam("endtime") final String endTime, @QueryParam("clientid") final int clientid, @QueryParam("key") final String key, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_startTime = !S.isNull(startTime) ? startTime : DateUtil.dateFormatStr("yyyy-MM-dd HH:mm:ss", new Date());
            String ac_endTime = !S.isNull(endTime) ? endTime : DateUtil.dateFormatStr("yyyy-MM-dd HH:mm:ss", new Date());
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            List<OperatDetails> operatDetailsList = callBussService.findOperatsDeails(ac_startTime, ac_endTime, ac_clientid);

            total = operatDetailsList.size();
            return ReturePageList(total, operatDetailsList);
        } catch (Exception e) {
            LOGGER.error("findDriveroperatedateails 异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }
}
