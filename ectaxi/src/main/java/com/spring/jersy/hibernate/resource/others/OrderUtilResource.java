package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.publics.bean.OrderBean;
import com.spring.jersy.hibernate.publics.bean.OrderResult;
import com.spring.jersy.hibernate.publics.util.ClientTarget;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.resource.operate.OperatStatisResource;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;

/**
 * Created by Administrator on 2016/10/12.
 */
@Component
@Path("/orderUtil")
@Scope("prototype")
public class OrderUtilResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(OperatStatisResource.class);

    @Context
    private HttpServletResponse response;


    @POST
    @Path("newOrder")
    @Produces("application/json;charset=utf-8")
    public String newOrder(OrderBean orderBean) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            //System.out.println(orderBean.toString());
            Entity<OrderBean> entity = Entity.entity(orderBean, ClientTarget.getInstance().getMediaType());
            OrderResult orderResult = ClientTarget.getInstance()
                    .getTarget()
                    .path("order")
                    .path("new")
                    .request()
                    .post(entity, OrderResult.class);
            //System.out.println(orderResult.toString());
            JSONObject array = JSONObject.fromObject(orderResult);
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("提交电召单异常：", e);

            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);

            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

}
