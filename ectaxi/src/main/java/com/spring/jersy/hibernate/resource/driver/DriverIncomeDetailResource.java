package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverIncomeDetail;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.DriverIncomeDetailService;
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
@Path("/driverIncomeDetail")
@Scope("prototype")
public class DriverIncomeDetailResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverIncomeDetailResource.class);
    private static final String tabname = "DriverIncomeDetail";
    @Context
    private HttpServletResponse response;


    @Resource
    private DriverIncomeDetailService driverIncomeDetailService;

    @Resource
    private CallBussService callBussService;

    private List<DriverIncomeDetail> driverIncomeDetailList;

    private DriverIncomeDetail driverIncomeDetail;

    @POST
    @Path("findDriverIncomeDetailForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeDetailForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            //            PageList pageList =driverIncomeDetailService.findList(page, rows, sort, order, key, begintime, endtime, type);
            //            driverIncomeDetailList = callBussService.findDriverIncomeDetail(page,rows,begintime,endtime,ac_clientid);
            PageList pageList = callBussService.findDriverIncomeDetail(page, rows, begintime, endtime, ac_clientid);
            driverIncomeDetailList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverIncomeDetailList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findDriverIncomeDetailByid")
    @Produces("application/json;charset=utf-8")
    public String findDriverIncomeDetailByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeDetail = driverIncomeDetailService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(driverIncomeDetail);
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
    @Path("saveorupdateDriverIncomeDetail")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDriverIncomeDetail(@QueryParam("id") final Integer id, DriverIncomeDetail redriverIncomeDetail) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeDetail = driverIncomeDetailService.findByid(re_id);
            if (!S.isNull(driverIncomeDetail)) {
                driverIncomeDetailService.saveOrUpd(redriverIncomeDetail);
            } else {
                driverIncomeDetailService.save(redriverIncomeDetail);
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
    @Path("delDriverIncomeDetailByid")
    @Produces("application/json;charset=utf-8")
    public String delDriverIncomeDetailByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            driverIncomeDetail = driverIncomeDetailService.findByid(re_id);
            if (!S.isNull(driverIncomeDetail)) {
                driverIncomeDetailService.delete(id);
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
