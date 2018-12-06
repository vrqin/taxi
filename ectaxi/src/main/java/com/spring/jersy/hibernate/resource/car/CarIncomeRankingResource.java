package com.spring.jersy.hibernate.resource.car;

import com.spring.jersy.hibernate.model.entity.CarIncomeRanking;
import com.spring.jersy.hibernate.model.service.CarIncomeRankingService;
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
@Path("/carIncomeRanking")
@Scope("prototype")
public class CarIncomeRankingResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(CarIncomeRankingResource.class);
    private static final String tabname = "CarIncomeRanking";
    @Context
    private HttpServletResponse response;


    @Resource
    private CarIncomeRankingService carIncomeRankingService;


    private List<CarIncomeRanking> carIncomeRankingList;

    private CarIncomeRanking carIncomeRanking;

    @POST
    @Path("findCarIncomeRankingForPageList")
    @Produces("application/json;charset=utf-8")
    public String findCarIncomeRankingForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = carIncomeRankingService.findList(page, rows, sort, order, key, begintime, endtime, type, clientid);
            carIncomeRankingList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, carIncomeRankingList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findCarIncomeRankingByid")
    @Produces("application/json;charset=utf-8")
    public String findCarIncomeRankingByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            carIncomeRanking = carIncomeRankingService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(carIncomeRanking);
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
    @Path("saveorupdateCarIncomeRanking")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateCarIncomeRanking(@QueryParam("id") final Integer id, CarIncomeRanking recarIncomeRanking) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            carIncomeRanking = carIncomeRankingService.findByid(re_id);
            if (!S.isNull(carIncomeRanking)) {
                carIncomeRankingService.saveOrUpd(recarIncomeRanking);
            } else {
                carIncomeRankingService.save(recarIncomeRanking);
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
    @Path("delCarIncomeRankingByid")
    @Produces("application/json;charset=utf-8")
    public String delCarIncomeRankingByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            carIncomeRanking = carIncomeRankingService.findByid(re_id);
            if (!S.isNull(carIncomeRanking)) {
                carIncomeRankingService.delete(id);
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
