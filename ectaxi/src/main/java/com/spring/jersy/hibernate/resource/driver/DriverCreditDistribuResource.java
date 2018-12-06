package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverCreditDistribu;
import com.spring.jersy.hibernate.model.service.DriverCreditDistribuService;
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
@Path("/driverCreditDistribu")
@Scope("prototype")
public class DriverCreditDistribuResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverCreditDistribuResource.class);
    private static final String tabname = "DriverCreditDistribu";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverCreditDistribuService driverCreditDistribuService;


    private List<DriverCreditDistribu> driverCreditDistribuList;

    private DriverCreditDistribu driverCreditDistribu;

    @POST
    @Path("findDriverCreditDistribuForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverCreditDistribuForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            driverCreditDistribuList = driverCreditDistribuService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(driverCreditDistribuList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findDriverCreditDistribuByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverCreditDistribuByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverCreditDistribu = driverCreditDistribuService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverCreditDistribu);
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
    @Path("saveorupdateDriverCreditDistribu")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverCreditDistribu(@QueryParam("id") final Integer id, DriverCreditDistribu redriverCreditDistribu) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverCreditDistribu = driverCreditDistribuService.findByid(re_id);
            if (!S.isNull(driverCreditDistribu)) {
                driverCreditDistribuService.saveOrUpd(redriverCreditDistribu);
            } else {
                driverCreditDistribuService.save(redriverCreditDistribu);
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
    @Path("delDriverCreditDistribuByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverCreditDistribuByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverCreditDistribu = driverCreditDistribuService.findByid(re_id);
            if (!S.isNull(driverCreditDistribu)) {
                driverCreditDistribuService.delete(id);
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
