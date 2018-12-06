package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverIntegratedQuery;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.DriverIntegratedQueryService;
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
@Path("/driverIntegratedQuery")
@Scope("prototype")
public class DriverIntegratedQueryResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverIntegratedQueryResource.class);
    private static final String tabname = "DriverIntegratedQuery";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverIntegratedQueryService driverIntegratedQueryService;

    @Resource
    private ClientService clientService;

    private List<DriverIntegratedQuery> driverIntegratedQueryList;

    private DriverIntegratedQuery driverIntegratedQuery;

    @POST
    @Path("findDriverIntegratedQueryForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverIntegratedQueryForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = driverIntegratedQueryService.findList(page, rows, sort, order, key, begintime, endtime, type, clientid);
            driverIntegratedQueryList = pageList.getList();
            if (!S.isListNull(driverIntegratedQueryList) && driverIntegratedQueryList.size() > 0) {
                for (DriverIntegratedQuery d : driverIntegratedQueryList) {
                    if (!S.isNull(clientService.findByid(d.getClientid()))) {
                        d.setCompany(clientService.findByid(d.getClientid()).getCompany());
                    }
                }
            }

            total = pageList.getTotalRecord();
            return ReturePageList(total, driverIntegratedQueryList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverIntegratedQueryByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverIntegratedQueryByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverIntegratedQuery = driverIntegratedQueryService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverIntegratedQuery);
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
    @Path("saveorupdateDriverIntegratedQuery")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverIntegratedQuery(@QueryParam("id") final Integer id, DriverIntegratedQuery redriverIntegratedQuery) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIntegratedQuery = driverIntegratedQueryService.findByid(re_id);
            if (!S.isNull(driverIntegratedQuery)) {
                driverIntegratedQueryService.saveOrUpd(redriverIntegratedQuery);
            } else {
                driverIntegratedQueryService.save(redriverIntegratedQuery);
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
    @Path("delDriverIntegratedQueryByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverIntegratedQueryByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIntegratedQuery = driverIntegratedQueryService.findByid(re_id);
            if (!S.isNull(driverIntegratedQuery)) {
                driverIntegratedQueryService.delete(id);
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
