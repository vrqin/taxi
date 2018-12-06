package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisRegion;
import com.spring.jersy.hibernate.model.service.DriverInformationAnalysisRegionService;
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
@Path("/driverInformationAnalysisRegion")
@Scope("prototype")
public class DriverInformationAnalysisRegionResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverInformationAnalysisRegionResource.class);
    private static final String tabname = "DriverInformationAnalysisRegion";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverInformationAnalysisRegionService driverInformationAnalysisRegionService;


    private List<DriverInformationAnalysisRegion> driverInformationAnalysisRegionList;

    private DriverInformationAnalysisRegion driverInformationAnalysisRegion;

    @POST
    @Path("findDriverInformationAnalysisRegionForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverInformationAnalysisRegionForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = driverInformationAnalysisRegionService.findList(page, rows, sort, order, key, begintime, endtime, type);
            driverInformationAnalysisRegionList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverInformationAnalysisRegionList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverInformationAnalysisRegionByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverInformationAnalysisRegionByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverInformationAnalysisRegion = driverInformationAnalysisRegionService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverInformationAnalysisRegion);
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
    @Path("saveorupdateDriverInformationAnalysisRegion")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverInformationAnalysisRegion(@QueryParam("id") final Integer id, DriverInformationAnalysisRegion redriverInformationAnalysisRegion) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverInformationAnalysisRegion = driverInformationAnalysisRegionService.findByid(re_id);
            if (!S.isNull(driverInformationAnalysisRegion)) {
                driverInformationAnalysisRegionService.saveOrUpd(redriverInformationAnalysisRegion);
            } else {
                driverInformationAnalysisRegionService.save(redriverInformationAnalysisRegion);
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
    @Path("delDriverInformationAnalysisRegionByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverInformationAnalysisRegionByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverInformationAnalysisRegion = driverInformationAnalysisRegionService.findByid(re_id);
            if (!S.isNull(driverInformationAnalysisRegion)) {
                driverInformationAnalysisRegionService.delete(id);
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
