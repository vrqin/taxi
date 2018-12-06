package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverWrongdoing;
import com.spring.jersy.hibernate.model.service.DriverWrongdoingService;
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
@Path("/driverWrongdoing")
@Scope("prototype")
public class DriverWrongdoingResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverWrongdoingResource.class);
    private static final String tabname = "DriverWrongdoing";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverWrongdoingService driverWrongdoingService;


    private List<DriverWrongdoing> driverWrongdoingList;

    private DriverWrongdoing driverWrongdoing;

    @POST
    @Path("findDriverWrongdoingForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverWrongdoingForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            driverWrongdoingList = driverWrongdoingService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(driverWrongdoingList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findDriverWrongdoingByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverWrongdoingByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverWrongdoing = driverWrongdoingService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverWrongdoing);
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
    @Path("saveorupdateDriverWrongdoing")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverWrongdoing(@QueryParam("id") final Integer id, DriverWrongdoing redriverWrongdoing) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverWrongdoing = driverWrongdoingService.findByid(re_id);
            if (!S.isNull(driverWrongdoing)) {
                driverWrongdoingService.saveOrUpd(redriverWrongdoing);
            } else {
                driverWrongdoingService.save(redriverWrongdoing);
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
    @Path("delDriverWrongdoingByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverWrongdoingByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverWrongdoing = driverWrongdoingService.findByid(re_id);
            if (!S.isNull(driverWrongdoing)) {
                driverWrongdoingService.delete(id);
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
