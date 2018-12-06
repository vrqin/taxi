package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.CommonPoint;
import com.spring.jersy.hibernate.model.service.CommonPointService;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
import com.spring.jersy.hibernate.model.service.LogOperationService;
import com.spring.jersy.hibernate.publics.util.Constants;
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

/**
 * Created by Administrator on 2016/9/9.
 */
@Component
@Path("/commonpoint")
@Scope("prototype")
public class CommonPointResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CommonPointResource.class);

    private static final String tabname = "commonpoint";
    private static final String tabcontent = "常用约车点信息";

    @Context
    private HttpServletResponse response;

    @Resource
    private CommonPointService commonPointService;

    @Resource
    private LogOperationService logOperationService;

    @Resource
    private LogAbnormalService logAbnormalService;

    private List<CommonPoint> commonPointList;

    private CommonPoint commonPoint;

    @POST
    @Path("findCommonPointForPageList")
    @Produces("application/json;charset=utf-8")
    public String findCommonPointForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("position") final String position, @QueryParam("phone") final String phone, @QueryParam("type") final Integer type, @QueryParam("clientid") final Integer clientid, @QueryParam("geographical") final String geographical, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + tabcontent, clientid);
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            commonPointList = commonPointService.findList(sort, order, position, phone, type, geographical, ac_clientid);
            JSONArray array = JSONArray.fromObject(commonPointList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "表异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @DELETE
    @Path("delCommonPointByid")
    @Produces("application/json;charset=utf-8")
    public String delCommonPointByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            commonPoint = commonPointService.findByid(re_id);
            if (!S.isNull(commonPoint)) {
                commonPointService.delete(re_id);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        } catch (Exception e) {

            LOGGER.error("删除" + tabname + "信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("saveorupdateCommonPoint")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateCommonPoint(CommonPoint recommpont) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(recommpont.getToken(), OPERATION_ADD, OPERATION_ADD_NAME + ":" + tabcontent, recommpont
                .getClientid());
        try {

            Integer re_id = !S.isNull(recommpont.getId()) ? recommpont.getId() : 0;
            commonPoint = commonPointService.findByid(re_id);

            if (!S.isNull(commonPoint)) {
                commonPointService.saveOrUpd(recommpont);
            } else {
                if (!S.isNull(recommpont.getGeographical())) {
                    CommonPoint cp = commonPointService.findByGeographical(recommpont.getPhone(), recommpont.getGeographical());
                    if (S.isNull(cp)) {
                        commonPointService.save(recommpont);
                    }
                } else {
                    commonPointService.save(recommpont);

                }
            }
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("添加或修改" + tabname + "异常：", e);
            logAbnormalService.savelogAbnormal(recommpont.getToken(), "添加或修改" + tabname + "数据异常", recommpont.getClientid());
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("findCommonPointByid")
    @Produces("application/json;charset=utf-8")
    public String findCommonPointByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + "根据Id查找查询" + tabcontent, clientid);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            commonPoint = commonPointService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(commonPoint);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "根据Id查找：", e);
            logAbnormalService.savelogAbnormal(token, "根据Id查找" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

}
