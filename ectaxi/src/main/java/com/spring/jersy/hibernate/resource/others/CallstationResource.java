package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Callstation;
import com.spring.jersy.hibernate.model.service.CallstationService;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
import com.spring.jersy.hibernate.model.service.LogOperationService;
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

/**
 * Created by Administrator on 2016/9/9.
 */
@Component
@Path("/callstation")
@Scope("prototype")
public class CallstationResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CallstationResource.class);
    private static final String tabname = "电召站";
    private static final String tabcontent = "电召站数据";
    @Context
    private HttpServletResponse response;


    @Resource
    private CallstationService callstationService;

    @Resource
    private LogOperationService logOperationService;

    @Resource
    private LogAbnormalService logAbnormalService;

    private List<Callstation> callstationList;

    private Callstation callstation;

    @POST
    @Path("findCallstationForPageList")
    @Produces("application/json;charset=utf-8")
    public String findCallstationForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("position") final String position, @QueryParam("token") final String token, @QueryParam("phone") final String phone, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + tabcontent, clientid);
        try {
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = callstationService.findList(page, rows, sort, order, position, phone, ac_clientid);
            callstationList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, callstationList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }


    @POST
    @Path("findCallstationByid")
    @Produces("application/json;charset=utf-8")
    public String findCallstationByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + "根据Id查找" + tabcontent, clientid);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            callstation = callstationService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(callstation);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "根据Id查找：", e);
            logAbnormalService.savelogAbnormal(token, "根据Id查找" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("saveorupdateCallstation")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateCallstation(@QueryParam("id") final Integer id, @QueryParam("callstationId") final String callstationId, @QueryParam("name") final String name, @QueryParam("phone") final String phone, @QueryParam("position") final String position, @QueryParam("clientid") final Integer clientid, @QueryParam("line") final String line, @QueryParam("token") final String token, @QueryParam("geographical") final String geographical) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            callstation = callstationService.findByid(re_id);
            int re_clientid = !S.isNull(clientid) ? clientid : 0;
            if (!S.isNull(callstation)) {

                callstation.setCallstationId(callstationId);
                callstation.setName(name);
                callstation.setLine(line);
                callstation.setGeographical(geographical);
                callstation.setPhone(phone);
                callstation.setPosition(position);
                callstation.setClientid(re_clientid);
                callstationService.save(callstation);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();

            } else {
                callstation = new Callstation();
                callstation.setCallstationId(callstationId);
                callstation.setName(name);
                callstation.setLine(line);
                callstation.setGeographical(geographical);
                callstation.setPhone(phone);
                callstation.setPosition(position);
                callstation.setClientid(re_clientid);
                callstationService.save(callstation);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {

            LOGGER.error("添加或修改" + tabname + "异常：", e);

            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("saveorupdateCallstationObject")
    @Produces("application/json;charset=utf-8")
    //添加
    public String saveorupdateCallstationObject(Callstation cstation) {
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(cstation.getToken(), OPERATION_ADD, OPERATION_ADD_NAME + ":" + tabcontent, cstation
                .getClientid());
        try {
            Integer re_id = !S.isNull(cstation.getId()) ? cstation.getId() : 0;
            callstation = callstationService.findByid(re_id);
            if (!S.isNull(callstation)) {
                callstationService.saveOrUpd(cstation);
            } else {
                callstationService.save(cstation);
            }
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("添加或修改" + tabname + "异常：", e);
            logAbnormalService.savelogAbnormal(cstation.getToken(), "添加或修改" + tabname + "数据异常", cstation.getClientid());
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @DELETE
    @Path("delCallstationByid")
    @Produces("application/json;charset=utf-8")
    public String delCallstationByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            callstation = callstationService.findByid(re_id);
            if (!S.isNull(callstation)) {
                callstationService.delete(id);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("删除" + tabname + "信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


}
