package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.RemindSet;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
import com.spring.jersy.hibernate.model.service.LogOperationService;
import com.spring.jersy.hibernate.model.service.RemindSetService;
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
@Path("/remindset")
@Scope("prototype")
public class RemindSetResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(RemindSetResource.class);
    private static final String tabname = "报警提醒设置";
    private static final String tabcontent = "报警提醒设置数据";
    @Context
    private HttpServletResponse response;

    @Resource
    private RemindSetService remindSetService;

    @Resource
    private LogOperationService logOperationService;

    @Resource
    private LogAbnormalService logAbnormalService;

    @Resource
    private ClientService clientService;

    private List<RemindSet> remindSetList;

    private RemindSet remindSet;

    @POST
    @Path("findRemindSetForPageList")
    @Produces("application/json;charset=utf-8")
    public String findRemindSetForPageList(@QueryParam("type") final Integer type, @QueryParam("extypes") final Integer extypes, @QueryParam("sort") final String sort, @QueryParam("token") final String token, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("enable") final Integer enable, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + tabcontent, clientid);
        try {
            int re_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = remindSetService.findList(page, rows, sort, order, key, type, extypes, enable, re_clientid);
            remindSetList = pageList.getList();
            if (!S.isListNull(remindSetList) && remindSetList.size() > 0) {
                for (RemindSet r : remindSetList) {
                    if (!S.isNull(clientService.findByid(r.getId()))) {
                        r.setCompany(clientService.findByid(r.getId()).getCompany());
                    }
                }
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, remindSetList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("delRemindSetByid")
    @Produces("application/json;charset=utf-8")
    public String delRemindSetByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token, @QueryParam("token") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            remindSet = remindSetService.findByid(re_id);
            if (!S.isNull(remindSet)) {
                remindSetService.delete(id);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }

        } catch (Exception e) {
            LOGGER.error("删除" + tabname + "信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

        }
        JSONObject array = JSONObject.fromObject(responseSim);
        return array.toString();

    }

    @POST
    @Path("saveorupdateRemindSet")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateRemindSet(@QueryParam("id") final Integer id, @QueryParam("extypes") final Byte extypes, @QueryParam("remind") final String remind, @QueryParam("type") final Byte type, @QueryParam("enable") final Byte enable, @QueryParam("token") final String token, @QueryParam("company") final String company, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_ADD, OPERATION_ADD_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            remindSet = remindSetService.findByid(re_id);

            if (!S.isNull(remindSet)) {

                remindSet.setExtypes(extypes);
                remindSet.setRemind(remind);
                remindSet.setCompany(company);
                remindSet.setType(type);
                remindSet.setEnable(enable);
                remindSet.setClientid(clientid);
                remindSetService.save(remindSet);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();

            } else {
                remindSet = new RemindSet();
                remindSet.setExtypes(extypes);
                remindSet.setRemind(remind);
                remindSet.setCompany(company);
                remindSet.setType(type);
                remindSet.setEnable(enable);
                remindSet.setClientid(clientid);
                remindSetService.save(remindSet);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {

            LOGGER.error("添加或修改" + tabname + "异常：", e);
            logAbnormalService.savelogAbnormal(token, "添加或修改" + tabname + "数据异常", 0);//8888888
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


}
