package com.spring.jersy.hibernate.resource.car;

import com.spring.jersy.hibernate.model.entity.CarIntegratedQuery;
import com.spring.jersy.hibernate.model.service.CarIntegratedQueryService;
import com.spring.jersy.hibernate.model.service.ClientService;
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
@Path("/carIntegratedQuery")
@Scope("prototype")
public class CarIntegratedQueryResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CarIntegratedQueryResource.class);
    private static final String tabname = "CarIntegratedQuery";
    @Context
    private HttpServletResponse response;


    @Resource
    private CarIntegratedQueryService carIntegratedQueryService;

    @Resource
    private ClientService clientService;

    private List<CarIntegratedQuery> carIntegratedQueryList;

    private CarIntegratedQuery carIntegratedQuery;

    @POST
    @Path("findCarIntegratedQueryForPageList")
    @Produces("application/json;charset=utf-8")
    public String findCarIntegratedQueryForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = carIntegratedQueryService.findList(page, rows, sort, order, key, begintime, endtime, type, clientid);
            carIntegratedQueryList = pageList.getList();
            if (!S.isListNull(carIntegratedQueryList) && carIntegratedQueryList.size() > 0) {
                for (CarIntegratedQuery d : carIntegratedQueryList) {
                    if (!S.isNull(clientService.findByid(d.getClientid()))) {
                        d.setCompany(clientService.findByid(d.getClientid()).getCompany());
                    }
                }
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, carIntegratedQueryList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findCarIntegratedQueryByid")
    @Produces("application/json;charset=utf-8")
    public String findCarIntegratedQueryByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            carIntegratedQuery = carIntegratedQueryService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(carIntegratedQuery);
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
    @Path("saveorupdateCarIntegratedQuery")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateCarIntegratedQuery(@QueryParam("id") final Integer id, CarIntegratedQuery recarIntegratedQuery) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            carIntegratedQuery = carIntegratedQueryService.findByid(re_id);
            if (!S.isNull(carIntegratedQuery)) {
                carIntegratedQueryService.saveOrUpd(recarIntegratedQuery);
            } else {
                carIntegratedQueryService.save(recarIntegratedQuery);
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
    @Path("delCarIntegratedQueryByid")
    @Produces("application/json;charset=utf-8")
    public String delCarIntegratedQueryByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            carIntegratedQuery = carIntegratedQueryService.findByid(re_id);
            if (!S.isNull(carIntegratedQuery)) {
                carIntegratedQueryService.delete(id);
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
