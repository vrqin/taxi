package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Callbuss;
import com.spring.jersy.hibernate.model.entity.Complaint;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.ComplaintService;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
import com.spring.jersy.hibernate.model.service.LogOperationService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.resource.BaseResource;
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
 * Created by Administrator on 2016/9/9.
 */
@Component
@Path("/complaint")
@Scope("prototype")
public class ComplaintResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ComplaintResource.class);
    private static final String tabname = "投诉管理";
    private static final String tabcontent = "投诉管理数据";
    @Context
    private HttpServletResponse response;

    @Resource
    private ComplaintService complaintService;

    @Resource
    private CallBussService callBussService;

    @Resource
    private LogOperationService logOperationService;

    @Resource
    private LogAbnormalService logAbnormalService;

    private List<Complaint> complaintList;

    private Callbuss callbuss;
    private Complaint complaint;

    @POST
    @Path("findComplaintForPageList")
    @Produces("application/json;charset=utf-8")
    public String findComplaintForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("source") final Byte source, @QueryParam("token") final String token, @QueryParam("results") final Byte results, @QueryParam("clientid") final Integer clientid, @QueryParam("state") final Byte state, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = complaintService.findList(page, rows, sort, order, key, startime, endtime, source, results, state, re_clientid);
            complaintList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, complaintList);
        } catch (Exception e) {
            LOGGER.error("加载投诉数据异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


    @GET
    @Path("delComplaintByid")
    @Produces("application/json;charset=utf-8")
    public String delComplaintByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            complaint = complaintService.findByid(re_id);
            if (!S.isNull(complaint)) {
                complaintService.delete(id);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("删除" + tabname + "信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + tabname + "数据异常", complaint.getClientid());
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("saveorupdateComplaint")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateComplaint(@QueryParam("id") final Integer id, @QueryParam("name") final String name, @QueryParam("source") final Byte source, @QueryParam("customername") final String customername, @QueryParam("phone") final String phone, @QueryParam("kabnum") final String kabnum, @QueryParam("results") final Byte results, @QueryParam("clientid") final Integer clientid, @QueryParam("state") final Byte state, @QueryParam("token") final String token, @QueryParam("ordernum") final String ordernum) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;
            complaint = complaintService.findByid(re_id);
            String ac_ordernum = ordernum;
            if (!S.isNull(complaint)) {
                complaint.setName(name);
                complaint.setSource(source);
                complaint.setCustomername(customername);
                complaint.setPhone(phone);
                complaint.setKabnum(kabnum);

                if (results > -1) {
                    complaint.setEndtime(new Date());
                }
                complaint.setResults(results);
                complaint.setState(state);
                callbuss = callBussService.findByKabnumPhone(phone, kabnum);
                if (!S.isNull(callbuss)) {
                    ac_ordernum = callbuss.getBillid();
                }
                complaint.setClientid(re_clientid);
                complaint.setOrdernum(ac_ordernum);
                complaintService.saveOrUpd(complaint);
                logOperationService.savelogOperation(token, OPERATION_EDIT, OPERATION_EDIT_NAME + ":" + tabcontent, clientid);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();

            } else {
                complaint = new Complaint();
                complaint.setName(name);
                complaint.setAcceptime(new Date());
                complaint.setSource(source);
                complaint.setCustomername(customername);
                complaint.setPhone(phone);
                complaint.setKabnum(kabnum);
                complaint.setResults(results);
                complaint.setState((byte) 0);
                if (results > -1) {
                    complaint.setEndtime(new Date());
                }
                callbuss = callBussService.findByKabnumPhone(phone, kabnum);
                if (!S.isNull(callbuss)) {
                    ac_ordernum = callbuss.getBillid();
                }
                complaint.setClientid(re_clientid);
                complaint.setOrdernum(ac_ordernum);
                complaintService.save(complaint);
                logOperationService.savelogOperation(token, OPERATION_ADD, OPERATION_ADD_NAME + ":" + tabcontent, clientid);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {

            LOGGER.error("添加或修改" + tabname + "异常：", e);
            logAbnormalService.savelogAbnormal(token, "添加或修改" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @GET
    @Path("findNameByid")
    @Produces("application/json;charset=utf-8")
    public String findNameByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            complaint = complaintService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(complaint);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("根据id查询：" + tabname + "信息异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


}
