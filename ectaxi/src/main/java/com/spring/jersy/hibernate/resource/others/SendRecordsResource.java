package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.SendRecords;
import com.spring.jersy.hibernate.model.service.SendRecordsService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
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


@Component
@Path("/sendRecords")
@Scope("prototype")
public class SendRecordsResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(SendRecordsResource.class);
    private static final String tabname = "SendRecords";
    @Context
    private HttpServletResponse response;


    @Resource
    private SendRecordsService sendRecordsService;


    private List<SendRecords> sendRecordsList;

    private SendRecords sendRecords;

    @POST
    @Path("findSendRecordsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findSendRecordsForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            sendRecordsList = sendRecordsService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(sendRecordsList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findSendRecordsByid")
    @Produces("application/json;charset=utf-8")
    public String findSendRecordsByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            sendRecords = sendRecordsService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(sendRecords);
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
    @Path("saveorupdateSendRecords")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateSendRecords(@QueryParam("id") final Integer id, SendRecords resendRecords) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            sendRecords = sendRecordsService.findByid(re_id);
            if (!S.isNull(sendRecords)) {
                sendRecordsService.saveOrUpd(resendRecords);
            } else {
                sendRecordsService.save(resendRecords);
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
    @Path("delSendRecordsByid")
    @Produces("application/json;charset=utf-8")
    public String delSendRecordsByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            sendRecords = sendRecordsService.findByid(re_id);
            if (!S.isNull(sendRecords)) {
                sendRecordsService.delete(id);
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
