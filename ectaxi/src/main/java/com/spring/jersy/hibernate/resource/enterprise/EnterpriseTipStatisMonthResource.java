package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatisMonth;
import com.spring.jersy.hibernate.model.service.EnterpriseTipStatisMonthService;
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
@Path("/enterpriseTipStatisMonth")
@Scope("prototype")
public class EnterpriseTipStatisMonthResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseTipStatisMonthResource.class);
    private static final String tabname = "EnterpriseTipStatisMonth";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseTipStatisMonthService enterpriseTipStatisMonthService;


    private List<EnterpriseTipStatisMonth> enterpriseTipStatisMonthList;

    private EnterpriseTipStatisMonth enterpriseTipStatisMonth;

    @POST
    @Path("findEnterpriseTipStatisMonthForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseTipStatisMonthForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = enterpriseTipStatisMonthService.findList(page, rows, sort, order, key, begintime, endtime, type);
            enterpriseTipStatisMonthList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, enterpriseTipStatisMonthList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findEnterpriseTipStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseTipStatisMonthByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseTipStatisMonth = enterpriseTipStatisMonthService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseTipStatisMonth);
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
    @Path("saveorupdateEnterpriseTipStatisMonth")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseTipStatisMonth(@QueryParam("id") final Integer id, EnterpriseTipStatisMonth reenterpriseTipStatisMonth) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseTipStatisMonth = enterpriseTipStatisMonthService.findByid(re_id);
            if (!S.isNull(enterpriseTipStatisMonth)) {
                enterpriseTipStatisMonthService.saveOrUpd(reenterpriseTipStatisMonth);
            } else {
                enterpriseTipStatisMonthService.save(reenterpriseTipStatisMonth);
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
    @Path("delEnterpriseTipStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseTipStatisMonthByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseTipStatisMonth = enterpriseTipStatisMonthService.findByid(re_id);
            if (!S.isNull(enterpriseTipStatisMonth)) {
                enterpriseTipStatisMonthService.delete(id);
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
