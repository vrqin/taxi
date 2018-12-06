package com.spring.jersy.hibernate.resource.withdraw;

import com.spring.jersy.hibernate.model.entity.WithdrawStatisMonth;
import com.spring.jersy.hibernate.model.service.WithdrawStatisMonthService;
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
@Path("/withdrawStatisMonth")
@Scope("prototype")
public class WithdrawStatisMonthResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(WithdrawStatisMonthResource.class);
    private static final String tabname = "WithdrawStatisMonth";
    @Context
    private HttpServletResponse response;


    @Resource
    private WithdrawStatisMonthService withdrawStatisMonthService;


    private List<WithdrawStatisMonth> withdrawStatisMonthList;

    private WithdrawStatisMonth withdrawStatisMonth;

    @POST
    @Path("findWithdrawStatisMonthForPageList")
    @Produces("application/json;charset=utf-8")
    public String findWithdrawStatisMonthForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = withdrawStatisMonthService.findList(page, rows, sort, order, key, begintime, endtime, type);
            withdrawStatisMonthList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, withdrawStatisMonthList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findWithdrawStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String findWithdrawStatisMonthByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            withdrawStatisMonth = withdrawStatisMonthService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(withdrawStatisMonth);
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
    @Path("saveorupdateWithdrawStatisMonth")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateWithdrawStatisMonth(@QueryParam("id") final Integer id, WithdrawStatisMonth rewithdrawStatisMonth) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            withdrawStatisMonth = withdrawStatisMonthService.findByid(re_id);
            if (!S.isNull(withdrawStatisMonth)) {
                withdrawStatisMonthService.saveOrUpd(rewithdrawStatisMonth);
            } else {
                withdrawStatisMonthService.save(rewithdrawStatisMonth);
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
    @Path("delWithdrawStatisMonthByid")
    @Produces("application/json;charset=utf-8")
    public String delWithdrawStatisMonthByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            withdrawStatisMonth = withdrawStatisMonthService.findByid(re_id);
            if (!S.isNull(withdrawStatisMonth)) {
                withdrawStatisMonthService.delete(id);
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
