package com.spring.jersy.hibernate.resource.notifier;

import com.spring.jersy.hibernate.model.entity.NotifierPlusHistory;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.model.service.NotifierHistoryService;
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


@Component
@Path("/notifierHistory")
@Scope("prototype")
public class NotifierHistoryResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(NotifierHistoryResource.class);
    private static final String tabname = "NotifierHistory";
    @Context
    private HttpServletResponse response;


    @Resource
    private NotifierHistoryService notifierHistoryService;

    @Resource
    private DriverService driverService;

    private List<NotifierPlusHistory> notifierHistoryList;

    private NotifierPlusHistory notifierHistory;

    @POST
    @Path("findNotifierHistoryForPageList")
    @Produces("application/json;charset=utf-8")
    public String findNotifierHistoryForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("notifierid") final int notifierid, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = notifierHistoryService.findList(page, rows, sort, order, key, begintime, endtime, type, notifierid, ac_clientid);
            notifierHistoryList = pageList.getList();
            for (NotifierPlusHistory h : notifierHistoryList) {
                if (!S.isNull(driverService.findByid(h.getDirverid()))) {
                    h.setDrivername(driverService.findByid(h.getDirverid()).getAccount());
                    h.setPhone(driverService.findByid(h.getDirverid()).getPhone());
                }
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, notifierHistoryList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "列表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findNotifierHistoryByid")
    @Produces("application/json;charset=utf-8")
    public String findNotifierHistoryByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            notifierHistory = notifierHistoryService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(notifierHistory);
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
    @Path("saveorupdateNotifierHistory")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateNotifierHistory(@QueryParam("id") final Integer id, NotifierPlusHistory renotifierHistory) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            notifierHistory = notifierHistoryService.findByid(re_id);
            if (!S.isNull(notifierHistory)) {
                notifierHistoryService.saveOrUpd(renotifierHistory);
            } else {
                notifierHistoryService.save(renotifierHistory);
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
    @Path("delNotifierHistoryByid")
    @Produces("application/json;charset=utf-8")
    public String delNotifierHistoryByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            notifierHistory = notifierHistoryService.findByid(re_id);
            if (!S.isNull(notifierHistory)) {
                notifierHistoryService.delete(id);
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
