package com.spring.jersy.hibernate.resource.others;


import com.spring.jersy.hibernate.model.entity.PayRecords;
import com.spring.jersy.hibernate.model.service.PayRecordsService;
import com.spring.jersy.hibernate.publics.bean.PayrecordsBean;
import com.spring.jersy.hibernate.publics.bean.WalletBean;
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
@Path("/payrecords")
@Scope("prototype")
public class PayrecordsResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PayrecordsResource.class);
    private static final String tabname = "Payrecords";
    @Context
    private HttpServletResponse response;


    @Resource
    private PayRecordsService payRecordsService;


    private List<PayRecords> payrecordsList;

    private PayRecords payrecords;

    @POST
    @Path("findPayrecordsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findPayrecordsForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            PageList pageList = payRecordsService.findPageList(page, rows, sort, order, key, begintime, endtime);
            payrecordsList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, payrecordsList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @GET
    @Path("findPayrecordsByList")
    @Produces("application/json;charset=utf-8")
    public String findPayrecordsByList(@QueryParam("key") final String key) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            payrecordsList = payRecordsService.findList(key);
            JSONArray array = JSONArray.fromObject(payrecordsList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "findPayrecordsByList：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findPayrecordsForWalletList")
    @Produces("application/json;charset=utf-8")
    public String findPayrecordsForWalletList() {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            List<WalletBean> walletBeanList = payRecordsService.findListbyPayRecordsWallet();
            total = walletBeanList.size();
            return ReturePageList(total, walletBeanList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findPayrecordsByid")
    @Produces("application/json;charset=utf-8")
    public String findPayrecordsByid(@QueryParam("id") final String id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            String re_id = !S.isNull(id) ? id : null;
            payrecords = payRecordsService.findByorderid(re_id);
            JSONObject array = JSONObject.fromObject(payrecords);
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
    @Path("saveorupdatePayrecords")
    @Produces("application/json;charset=utf-8")
    public String saveorupdatePayrecords(@QueryParam("id") final Integer id, PayRecords repayrecords) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            payrecords = payRecordsService.findByid(re_id);
            if (!S.isNull(payrecords)) {
                payRecordsService.saveOrUpd(repayrecords);
            } else {
                payRecordsService.save(repayrecords);
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
    @Path("delPayrecordsByid")
    @Produces("application/json;charset=utf-8")
    public String delPayrecordsByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            payrecords = payRecordsService.findByid(re_id);
            if (!S.isNull(payrecords)) {
                payRecordsService.delete(id);
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

    @POST
    @Path("findPayrecordsList")
    @Produces("application/json;charset=utf-8")
    public String findPayrecordsList(PayrecordsBean bean) {

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            List<PayRecords> payRecordses = payRecordsService.findListbyPayRecords(bean.getAccount(), bean.getStatus());
            JSONArray array = JSONArray.fromObject(payRecordses.toArray());
            return array.toString();

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(tabname + "findPayrecordsList：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

}
