package com.spring.jersy.hibernate.resource.notifier;

import com.spring.jersy.hibernate.model.entity.NotifierPlus;
import com.spring.jersy.hibernate.model.entity.NotifierPlusHistory;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.model.service.NotifierHistoryService;
import com.spring.jersy.hibernate.model.service.NotifierPlusService;
import com.spring.jersy.hibernate.publics.bean.NotifierBean;
import com.spring.jersy.hibernate.publics.util.*;
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


@Component
@Path("/notifierPlus")
@Scope("prototype")
public class NotifierPlusResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(NotifierPlusResource.class);
    private static final String tabname = "NotifierPlus";
    @Context
    private HttpServletResponse response;


    @Resource
    private NotifierPlusService notifierPlusService;

    @Resource
    private NotifierHistoryService notifierHistoryService;

    @Resource
    private DriverService driverService;

    private List<NotifierPlus> notifierPlusList;

    private NotifierPlus notifierPlus;

    @POST
    @Path("findNotifierPlusForPageList")
    @Produces("application/json;charset=utf-8")
    public String findNotifierPlusForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = notifierPlusService.findList(page, rows, sort, order, key, begintime, endtime, type, ac_clientid);
            notifierPlusList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, notifierPlusList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "列表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findNotifierPlusByid")
    @Produces("application/json;charset=utf-8")
    public String findNotifierPlusByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            notifierPlus = notifierPlusService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(notifierPlus);
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
    @Path("saveorupdateNotifierPlus")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateNotifierPlus(@QueryParam("id") final Integer id, NotifierPlus renotifierPlus) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(renotifierPlus.getId()) ? renotifierPlus.getId() : 0;
            notifierPlus = notifierPlusService.findByid(re_id);
            if (!S.isNull(notifierPlus)) {
                notifierPlus.setContent(renotifierPlus.getContent());
                notifierPlusService.saveOrUpd(notifierPlus);
            } else {
                notifierPlus = new NotifierPlus();
                notifierPlus.setCreattime(new Date());
                notifierPlus.setContent(renotifierPlus.getContent());
                notifierPlusService.save(notifierPlus);
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
    @Path("sendNotifier")
    @Produces("application/json;charset=utf-8")
    public String sendNotifier(NotifierBean bean) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        Integer[] all = null;
        try {
            Integer re_id = !S.isNull(bean.getId()) ? bean.getId() : 0;
            notifierPlus = notifierPlusService.findByid(re_id);
            if (!S.isNull(notifierPlus)) {

                notifierPlus.setContent(bean.getContent());
                notifierPlus.setExpired(DateUtil.stringToDate(bean.getValidity(), "yyyy-MM-dd HH:mm:ss"));
                notifierPlusService.saveOrUpd(notifierPlus);
            } else {
                notifierPlus = new NotifierPlus();
                notifierPlus.setCreattime(new Date());
                notifierPlus.setExpired(DateUtil.stringToDate(bean.getValidity(), "yyyy-MM-dd HH:mm:ss"));
                notifierPlus.setContent(bean.getContent());
                notifierPlus.setClientid(bean.getClientid());
                notifierPlus.setAccountName(bean.getAccountName());
                notifierPlusService.save(notifierPlus);
            }

            NotifierPlusHistory notifierPlusHistory = null;

            String[] temp = bean.getDirverIds().split(",");
            //            //System.out.println(temp);
            for (String n : temp) {
                if (!S.isNull(driverService.findByMsid(n))) {
                    notifierPlusHistory = new NotifierPlusHistory();
                    notifierPlusHistory.setDirverid(driverService.findByMsid(n).getDriverid());
                    notifierPlusHistory.setNotifierid(notifierPlus.getId());
                    notifierPlusHistory.setClientid(bean.getClientid());
                    notifierPlusHistory.setStatus(0);
                    notifierHistoryService.save(notifierPlusHistory);
                }
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
    @Path("delNotifierPlusByid")
    @Produces("application/json;charset=utf-8")
    public String delNotifierPlusByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            notifierPlus = notifierPlusService.findByid(re_id);
            if (!S.isNull(notifierPlus)) {
                notifierPlusService.delete(id);
                notifierHistoryService.deletebynodtfierid(id);
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
