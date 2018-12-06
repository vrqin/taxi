package com.spring.jersy.hibernate.resource.operate;

import com.spring.jersy.hibernate.model.entity.OperatDetails;
import com.spring.jersy.hibernate.model.service.CallBussService;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.OperatDetailsService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.DateUtil;
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
import java.util.Date;
import java.util.List;


@Component
@Path("/operatDetails")
@Scope("prototype")
public class OperatDetailsResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(OperatDetailsResource.class);
    private static final String tabname = "OperatDetails";
    @Context
    private HttpServletResponse response;


    @Resource
    private OperatDetailsService operatDetailsService;

    @Resource
    private CallBussService callBussService;

    @Resource
    private ClientService clientService;

    private List<OperatDetails> operatDetailsList;

    private OperatDetails operatDetails;

    @POST
    @Path("findOperatDetailsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findOperatDetailsForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("startime") final String begintime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final int clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            String ac_startTime = !S.isNull(begintime) ? begintime : DateUtil.dateFormatStr("yyyy-MM-dd", new Date());
            String ac_endTime = !S.isNull(endtime) ? endtime : DateUtil.dateFormatStr("yyyy-MM-dd", new Date());
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            List<OperatDetails> operatDetailsList = callBussService.findOperatsDeails(ac_startTime, ac_endTime, ac_clientid);
            for (OperatDetails u : operatDetailsList) {
                if (!S.isNull(clientService.findByid(u.getEnterprise()))) {
                    u.setCompany(clientService.findByid(u.getEnterprise()).getCompany());
                }
            }
            total = operatDetailsList.size();
            return ReturePageList(total, operatDetailsList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findOperatDetailsByid")
    @Produces("application/json;charset=utf-8")
    public String findOperatDetailsByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            operatDetails = operatDetailsService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(operatDetails);
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
    @Path("saveorupdateOperatDetails")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateOperatDetails(@QueryParam("id") final Integer id, OperatDetails reoperatDetails) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            operatDetails = operatDetailsService.findByid(re_id);
            if (!S.isNull(operatDetails)) {
                operatDetailsService.saveOrUpd(reoperatDetails);
            } else {
                operatDetailsService.save(reoperatDetails);
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
    @Path("delOperatDetailsByid")
    @Produces("application/json;charset=utf-8")
    public String delOperatDetailsByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            operatDetails = operatDetailsService.findByid(re_id);
            if (!S.isNull(operatDetails)) {
                operatDetailsService.delete(id);
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
