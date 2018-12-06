package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverSerStatis;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.DriverSerStatisService;
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
@Path("/driverSerStatis")
@Scope("prototype")
public class DriverSerStatisResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverSerStatisResource.class);
    private static final String tabname = "DriverSerStatis";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverSerStatisService driverSerStatisService;

    @Resource
    private ClientService clientService;


    private List<DriverSerStatis> driverSerStatisList;

    private DriverSerStatis driverSerStatis;

    @POST
    @Path("findDriverSerStatisForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverSerStatisForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = driverSerStatisService.findList(page, rows, sort, order, key, begintime, endtime, ac_clientid);
            driverSerStatisList = pageList.getList();
            if (!S.isListNull(driverSerStatisList)) {
                for (DriverSerStatis d : driverSerStatisList) {
                    if (!S.isNull(clientService.findByid(d.getClientid()))) {
                        d.setCompany(clientService.findByid(d.getClientid()).getCompany());
                    }

                }
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverSerStatisList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "列表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverSerStatisByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverSerStatisByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverSerStatis = driverSerStatisService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverSerStatis);
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
    @Path("saveorupdateDriverSerStatis")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverSerStatis(@QueryParam("id") final Integer id, DriverSerStatis redriverSerStatis) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverSerStatis = driverSerStatisService.findByid(re_id);
            if (!S.isNull(driverSerStatis)) {
                driverSerStatisService.saveOrUpd(redriverSerStatis);
            } else {
                driverSerStatisService.save(redriverSerStatis);
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
    @Path("delDriverSerStatisByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverSerStatisByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverSerStatis = driverSerStatisService.findByid(re_id);
            if (!S.isNull(driverSerStatis)) {
                driverSerStatisService.delete(id);
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