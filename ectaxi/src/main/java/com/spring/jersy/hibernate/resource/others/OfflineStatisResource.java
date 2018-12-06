package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.OfflineStatis;
import com.spring.jersy.hibernate.model.service.OfflineStatisService;
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
@Path("/offlineStatis")
@Scope("prototype")
public class OfflineStatisResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(OfflineStatisResource.class);
    private static final String tabname = "OfflineStatis";
    @Context
    private HttpServletResponse response;


    @Resource
    private OfflineStatisService offlineStatisService;


    private List<OfflineStatis> offlineStatisList;

    private OfflineStatis offlineStatis;

    @POST
    @Path("findOfflineStatisForPageList")
    @Produces("application/json;charset=utf-8")
    public String findOfflineStatisForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            offlineStatisList = offlineStatisService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(offlineStatisList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findOfflineStatisByid")
    @Produces("application/json;charset=utf-8")
    public String findOfflineStatisByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            offlineStatis = offlineStatisService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(offlineStatis);
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
    @Path("saveorupdateOfflineStatis")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateOfflineStatis(@QueryParam("id") final Integer id, OfflineStatis reofflineStatis) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            offlineStatis = offlineStatisService.findByid(re_id);
            if (!S.isNull(offlineStatis)) {
                offlineStatisService.saveOrUpd(reofflineStatis);
            } else {
                offlineStatisService.save(reofflineStatis);
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
    @Path("delOfflineStatisByid")
    @Produces("application/json;charset=utf-8")
    public String delOfflineStatisByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            offlineStatis = offlineStatisService.findByid(re_id);
            if (!S.isNull(offlineStatis)) {
                offlineStatisService.delete(id);
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
