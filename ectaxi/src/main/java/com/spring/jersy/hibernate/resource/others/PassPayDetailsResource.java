package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.PassPayDetails;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.PassPayDetailsService;
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
@Path("/passPayDetails")
@Scope("prototype")
public class PassPayDetailsResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PassPayDetailsResource.class);
    private static final String tabname = "PassPayDetails";
    @Context
    private HttpServletResponse response;


    @Resource
    private PassPayDetailsService passPayDetailsService;

    @Resource
    private CallBussService callBussService;

    private List<PassPayDetails> passPayDetailsList;

    private PassPayDetails passPayDetails;

    @POST
    @Path("findPassPayDetailsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findPassPayDetailsForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("payment") final int type, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            //            PageList pageList =passPayDetailsService.findList(page, rows, sort, order, key, begintime, endtime, type);
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = callBussService.findPassPayDetails(page, rows, begintime, endtime, ac_clientid);
            passPayDetailsList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, passPayDetailsList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findPassPayDetailsByid")
    @Produces("application/json;charset=utf-8")
    public String findPassPayDetailsByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            passPayDetails = passPayDetailsService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(passPayDetails);
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
    @Path("saveorupdatePassPayDetails")
    @Produces("application/json;charset=utf-8")
    public String saveorupdatePassPayDetails(@QueryParam("id") final Integer id, PassPayDetails repassPayDetails) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            passPayDetails = passPayDetailsService.findByid(re_id);
            if (!S.isNull(passPayDetails)) {
                passPayDetailsService.saveOrUpd(repassPayDetails);
            } else {
                passPayDetailsService.save(repassPayDetails);
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
    @Path("delPassPayDetailsByid")
    @Produces("application/json;charset=utf-8")
    public String delPassPayDetailsByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            passPayDetails = passPayDetailsService.findByid(re_id);
            if (!S.isNull(passPayDetails)) {
                passPayDetailsService.delete(id);
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
