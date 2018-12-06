package com.spring.jersy.hibernate.resource.discount;

import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.model.entity.DiscountCoupon;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.DiscountCouponService;
import com.spring.jersy.hibernate.publics.bean.DiscountCouponBean;
import com.spring.jersy.hibernate.publics.util.*;
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
@Path("/discountCoupon")
@Scope("prototype")
public class DiscountCouponResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DiscountCouponResource.class);
    private static final String tabname = "discountCoupon";
    @Context
    private HttpServletResponse response;


    @Resource
    private DiscountCouponService discountCouponService;


    @Resource
    private ClientService clientService;

    private List<DiscountCoupon> discountCouponList;

    private DiscountCoupon discountCoupon;

    @POST
    @Path("findDiscountCouponForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDiscountCouponForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = discountCouponService.findList(page, rows, sort, order, key, begintime, endtime, type);
            discountCouponList = pageList.getList();

            if (!S.isListNull(discountCouponList) && discountCouponList.size() > 0) {
                List<Client> clientList = clientService.findList();
                for (DiscountCoupon disc : discountCouponList) {
                    for (Client c : clientList) {
                        if (disc.getClientId() == c.getClientId()) {
                            disc.setClientName(c.getClientName());
                        }
                    }
                }
            }

            total = pageList.getTotalRecord();
            return ReturePageList(total, discountCouponList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "列表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findDiscountCouponByid")
    @Produces("application/json;charset=utf-8")
    public String findDiscountCouponByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            discountCoupon = discountCouponService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(discountCoupon);
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
    @Path("saveorupdateDiscountCoupon")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDiscountCoupon(@QueryParam("id") final Integer id, DiscountCouponBean rebDiscountCoupon) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(rebDiscountCoupon.getId()) ? rebDiscountCoupon.getId() : 0;
            discountCoupon = discountCouponService.findByid(re_id);
            Integer ac_carstatus = !S.isNull(rebDiscountCoupon.getCarstatus()) ? rebDiscountCoupon.getCarstatus() : 0;
            if (!S.isNull(discountCoupon)) {
                DiscountCoupon disc = discountCouponService.findByid(discountCoupon.getId());
                disc.setClientId(rebDiscountCoupon.getClientId());
                disc.setName(rebDiscountCoupon.getName());
                disc.setType(rebDiscountCoupon.getType());
                disc.setValid(rebDiscountCoupon.getValid());
                disc.setDiscNum(-1);
                if (ac_carstatus == 1) {
                    disc.setDiscountPic(DiscountUrl + "" + discountCoupon.getId() + "_discount" + ".png");
                }
                disc.setMoney(rebDiscountCoupon.getMoney());
                disc.setStarttime(DateUtil.stringToDate(rebDiscountCoupon.getStarttime(), "yyyy-MM-dd HH:mm:ss"));
                disc.setEndtime(DateUtil.stringToDate(rebDiscountCoupon.getEndtime(), "yyyy-MM-dd HH:mm:ss"));
                disc.setDaytype(2);
                disc.setIsvalid(1);
                disc.setServiceConditions(rebDiscountCoupon.getServiceConditions());
                disc.setMaxDeduction(rebDiscountCoupon.getMaxDeduction());
                discountCouponService.saveOrUpd(disc);
            } else {
                DiscountCoupon disc = new DiscountCoupon();
                disc.setId(rebDiscountCoupon.getId());
                disc.setClientId(rebDiscountCoupon.getClientId());
                disc.setName(rebDiscountCoupon.getName());
                disc.setType(rebDiscountCoupon.getType());
                disc.setValid(rebDiscountCoupon.getValid());
                disc.setCreattime(new Date());
                disc.setDiscNum(-1);
                if (ac_carstatus == 1) {
                    disc.setDiscountPic(DiscountUrl + "" + rebDiscountCoupon.getId() + "_discount" + ".png");
                }
                disc.setMoney(rebDiscountCoupon.getMoney());
                disc.setStarttime(DateUtil.stringToDate(rebDiscountCoupon.getStarttime(), "yyyy-MM-dd HH:mm:ss"));
                disc.setEndtime(DateUtil.stringToDate(rebDiscountCoupon.getEndtime(), "yyyy-MM-dd HH:mm:ss"));
                disc.setDaytype(2);
                disc.setIsvalid(1);
                disc.setDiscountAddr("/TaxiSMPWS/discountInfos.html");
                disc.setServiceConditions(rebDiscountCoupon.getServiceConditions());
                disc.setMaxDeduction(rebDiscountCoupon.getMaxDeduction());
                discountCouponService.save(disc);
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
    @Path("delDiscountCouponByid")
    @Produces("application/json;charset=utf-8")
    public String delDiscountCouponByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            discountCoupon = discountCouponService.findByid(re_id);
            if (!S.isNull(discountCoupon)) {
                discountCouponService.delete(id);
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
