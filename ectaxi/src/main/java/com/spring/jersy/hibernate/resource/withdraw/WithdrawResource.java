package com.spring.jersy.hibernate.resource.withdraw;

import com.spring.jersy.hibernate.model.entity.Driver;
import com.spring.jersy.hibernate.model.entity.PayRecords;
import com.spring.jersy.hibernate.model.entity.Withdraw;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.model.service.PayRecordsService;
import com.spring.jersy.hibernate.model.service.WithdrawService;
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
import java.util.Date;
import java.util.List;


@Component
@Path("/withdraw")
@Scope("prototype")
public class WithdrawResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(WithdrawResource.class);
    private static final String tabname = "Withdraw";
    @Context
    private HttpServletResponse response;


    @Resource
    private WithdrawService withdrawService;

    @Resource
    private PayRecordsService payRecordsService;

    @Resource
    private DriverService driverService;

    private List<Withdraw> withdrawList;

    private Withdraw withdraw;

    @POST
    @Path("findWithdrawForPageList")
    @Produces("application/json;charset=utf-8")
    public String findWithdrawForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("way") final int way, @QueryParam("state") final int state, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = withdrawService.findList(page, rows, sort, order, key, begintime, endtime, way, state);
            withdrawList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, withdrawList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findwithdrawListForWithdrarwStatistics")
    @Produces("application/json;charset=utf-8")
    public String findwithdrawListForWithdrarwStatistics() {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            List<Withdraw> withdrawList = withdrawService.findListbyWithdrarwStatistics();
            total = withdrawList.size();
            return ReturePageList(total, withdrawList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findWithdrawByid")
    @Produces("application/json;charset=utf-8")
    public String findWithdrawByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            withdraw = withdrawService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(withdraw);
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
    @Path("saveorupdateWithdraw")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateWithdraw(Withdraw rewithdraw) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        Integer[] all = null;
        try {
            String message = "";


            String re_id = !S.isNull(rewithdraw.getOrderid()) ? rewithdraw.getOrderid() : null;
            System.out.println("---------------提现---------------------");
            //            System.out.println(re_id);
            //            System.out.println(rewithdraw);
            String[] temp = rewithdraw.getOrderid().split(",");
            Date now = new Date();
            for (String n : temp) {
                System.out.println(n);
                withdraw = withdrawService.findByOrderid(re_id);
                PayRecords payRecords = payRecordsService.findByorderid(n);
                if (!S.isNull(payRecords)) {
                    if (!S.isNull(withdraw)) {

                        withdraw.setDealpeople(rewithdraw.getDealpeople());
                        withdraw.setDealtime(now);
                        withdraw.setState(1);
                        //支付宝流水号
                        withdraw.setTransactionnum("0000000000000000000");
                        withdrawService.saveOrUpd(withdraw);

                        if (!S.isNull(payRecords)) {
                            //设置为已提现
                            payRecords.setPaystatus(3);
                            payRecordsService.saveOrUpd(payRecords);
                        }
                    } else {

                        Withdraw wd = new Withdraw();
                        wd.setOrderid(payRecords.getOrderid());
                        wd.setName(payRecords.getAccount());
                        wd.setAmount(payRecords.getMoney());
                        wd.setExtracttime(now);

                        //提现帐号 需要查询司机消息
                        Driver driver = driverService.findByName(payRecords.getAccount());

                        wd.setCashaccount("00000000000000");
                        wd.setPhone("12345678901");
                        wd.setWay(1);

                        wd.setState(0);
                        withdrawService.save(wd);
                        //设置为已申请
                        if (!S.isNull(payRecords)) {
                            payRecords.setPaystatus(1);
                            payRecordsService.saveOrUpd(payRecords);
                        }


                    }
                } else {
                    responseSim.setCode(Constants.FAILURE_RESP);
                    responseSim.setDesc("电召单异常!!!");
                }
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
    @Path("delWithdrawByid")
    @Produces("application/json;charset=utf-8")
    public String delWithdrawByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            withdraw = withdrawService.findByid(re_id);
            if (!S.isNull(withdraw)) {
                withdrawService.delete(id);
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
