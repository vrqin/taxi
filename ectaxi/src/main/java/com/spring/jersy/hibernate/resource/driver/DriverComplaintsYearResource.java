package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverComplaintsYear;
import com.spring.jersy.hibernate.model.service.DriverComplaintsYearService;
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
@Path("/driverComplaintsYear")
@Scope("prototype")
public class DriverComplaintsYearResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverComplaintsYearResource.class);
    private static final String tabname = "DriverComplaintsYear";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverComplaintsYearService driverComplaintsYearService;


    private List<DriverComplaintsYear> driverComplaintsYearList;

    private DriverComplaintsYear driverComplaintsYear;

    @POST
    @Path("findDriverComplaintsYearForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverComplaintsYearForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = driverComplaintsYearService.findList(page, rows, sort, order, key, begintime, endtime, type);
            driverComplaintsYearList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverComplaintsYearList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverComplaintsYearByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverComplaintsYearByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverComplaintsYear = driverComplaintsYearService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverComplaintsYear);
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
    @Path("saveorupdateDriverComplaintsYear")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverComplaintsYear(@QueryParam("id") final Integer id, DriverComplaintsYear redriverComplaintsYear) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverComplaintsYear = driverComplaintsYearService.findByid(re_id);
            if (!S.isNull(driverComplaintsYear)) {
                driverComplaintsYearService.saveOrUpd(redriverComplaintsYear);
            } else {
                driverComplaintsYearService.save(redriverComplaintsYear);
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
    @Path("delDriverComplaintsYearByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverComplaintsYearByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverComplaintsYear = driverComplaintsYearService.findByid(re_id);
            if (!S.isNull(driverComplaintsYear)) {
                driverComplaintsYearService.delete(id);
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
