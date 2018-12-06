package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverCreditStatis;
import com.spring.jersy.hibernate.model.service.DriverCreditStatisService;
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
@Path("/driverCreditStatis")
@Scope("prototype")
public class DriverCreditStatisResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverCreditStatisResource.class);
    private static final String tabname = "DriverCreditStatis";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverCreditStatisService driverCreditStatisService;


    private List<DriverCreditStatis> driverCreditStatisList;

    private DriverCreditStatis driverCreditStatis;

    @POST
    @Path("findDriverCreditStatisForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverCreditStatisForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            driverCreditStatisList = driverCreditStatisService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(driverCreditStatisList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findDriverCreditStatisByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverCreditStatisByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverCreditStatis = driverCreditStatisService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverCreditStatis);
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
    @Path("saveorupdateDriverCreditStatis")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverCreditStatis(@QueryParam("id") final Integer id, DriverCreditStatis redriverCreditStatis) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverCreditStatis = driverCreditStatisService.findByid(re_id);
            if (!S.isNull(driverCreditStatis)) {
                driverCreditStatisService.saveOrUpd(redriverCreditStatis);
            } else {
                driverCreditStatisService.save(redriverCreditStatis);
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
    @Path("delDriverCreditStatisByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverCreditStatisByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverCreditStatis = driverCreditStatisService.findByid(re_id);
            if (!S.isNull(driverCreditStatis)) {
                driverCreditStatisService.delete(id);
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