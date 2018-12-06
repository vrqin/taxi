package com.spring.jersy.hibernate.resource.enterprise;

import com.spring.jersy.hibernate.model.entity.EnterpriseSatisfacteFunds;
import com.spring.jersy.hibernate.model.service.EnterpriseSatisfacteFundsService;
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
@Path("/enterpriseSatisfacteFunds")
@Scope("prototype")
public class EnterpriseSatisfacteFundsResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EnterpriseSatisfacteFundsResource.class);
    private static final String tabname = "EnterpriseSatisfacteFunds";
    @Context
    private HttpServletResponse response;


    @Resource
    private EnterpriseSatisfacteFundsService enterpriseSatisfacteFundsService;


    private List<EnterpriseSatisfacteFunds> enterpriseSatisfacteFundsList;

    private EnterpriseSatisfacteFunds enterpriseSatisfacteFunds;

    @POST
    @Path("findEnterpriseSatisfacteFundsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseSatisfacteFundsForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = enterpriseSatisfacteFundsService.findList(page, rows, sort, order, key, begintime, endtime, type);
            enterpriseSatisfacteFundsList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, enterpriseSatisfacteFundsList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findEnterpriseSatisfacteFundsByid")
    @Produces("application/json;charset=utf-8")
    public String findEnterpriseSatisfacteFundsByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseSatisfacteFunds = enterpriseSatisfacteFundsService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(enterpriseSatisfacteFunds);
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
    @Path("saveorupdateEnterpriseSatisfacteFunds")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateEnterpriseSatisfacteFunds(@QueryParam("id") final Integer id, EnterpriseSatisfacteFunds reenterpriseSatisfacteFunds) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseSatisfacteFunds = enterpriseSatisfacteFundsService.findByid(re_id);
            if (!S.isNull(enterpriseSatisfacteFunds)) {
                enterpriseSatisfacteFundsService.saveOrUpd(reenterpriseSatisfacteFunds);
            } else {
                enterpriseSatisfacteFundsService.save(reenterpriseSatisfacteFunds);
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
    @Path("delEnterpriseSatisfacteFundsByid")
    @Produces("application/json;charset=utf-8")
    public String delEnterpriseSatisfacteFundsByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            enterpriseSatisfacteFunds = enterpriseSatisfacteFundsService.findByid(re_id);
            if (!S.isNull(enterpriseSatisfacteFunds)) {
                enterpriseSatisfacteFundsService.delete(id);
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
