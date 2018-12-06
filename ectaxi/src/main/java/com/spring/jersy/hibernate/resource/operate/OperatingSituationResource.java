package com.spring.jersy.hibernate.resource.operate;

import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.model.entity.OperatingSituation;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.OperatingSituationService;
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
@Path("/operatingSituation")
@Scope("prototype")
public class OperatingSituationResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(OperatingSituationResource.class);
    private static final String tabname = "OperatingSituation";
    @Context
    private HttpServletResponse response;


    @Resource
    private OperatingSituationService operatingSituationService;

    @Resource
    private ClientService clientService;

    private List<OperatingSituation> operatingSituationList;

    private OperatingSituation operatingSituation;

    @POST
    @Path("findOperatingSituationForPageList")
    @Produces("application/json;charset=utf-8")
    public String findOperatingSituationForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            String ac_key = key;
            if (!S.isNull(key)) {
                Client client = clientService.findbyCompany(ac_key);
                if (!S.isNull(client)) {
                    ac_key = String.valueOf(client.getClientId());
                }
            }
            PageList pageList = operatingSituationService.findList(page, rows, sort, order, ac_key, begintime, endtime, type, clientid);
            operatingSituationList = pageList.getList();
            for (OperatingSituation u : operatingSituationList) {
                if (!S.isNull(clientService.findByid(u.getEnterprise()))) {
                    u.setCompany(clientService.findByid(u.getEnterprise()).getCompany());
                }
            }
            total = pageList.getTotalRecord();
            return ReturePageList(total, operatingSituationList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findOperatingSituationByid")
    @Produces("application/json;charset=utf-8")
    public String findOperatingSituationByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            operatingSituation = operatingSituationService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(operatingSituation);
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
    @Path("saveorupdateOperatingSituation")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateOperatingSituation(@QueryParam("id") final Integer id, OperatingSituation reoperatingSituation) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            operatingSituation = operatingSituationService.findByid(re_id);
            if (!S.isNull(operatingSituation)) {
                operatingSituationService.saveOrUpd(reoperatingSituation);
            } else {
                operatingSituationService.save(reoperatingSituation);
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
    @Path("delOperatingSituationByid")
    @Produces("application/json;charset=utf-8")
    public String delOperatingSituationByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            operatingSituation = operatingSituationService.findByid(re_id);
            if (!S.isNull(operatingSituation)) {
                operatingSituationService.delete(id);
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
