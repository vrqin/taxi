package com.spring.jersy.hibernate.resource.client;

import com.spring.jersy.hibernate.model.entity.ClientSetting;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.ClientSettingService;
import com.spring.jersy.hibernate.publics.bean.OrderResult;
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
@Path("/clientSetting")
@Scope("prototype")
public class ClientSettingResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ClientSettingResource.class);
    private static final String tabname = "ClientSetting";
    @Context
    private HttpServletResponse response;


    @Resource
    private ClientSettingService clientSettingService;

    @Resource
    private ClientService clientService;

    private List<ClientSetting> clientSettingList;

    private ClientSetting clientSetting;

    @POST
    @Path("findClientSettingForPageList")
    @Produces("application/json;charset=utf-8")
    public String findClientSettingForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = clientSettingService.findList(page, rows, sort, order, key, begintime, endtime, type);
            clientSettingList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, clientSettingList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "列表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findClientSettingByid")
    @Produces("application/json;charset=utf-8")
    public String findClientSettingByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            clientSetting = clientSettingService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(clientSetting);
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
    @Path("saveorupdateClientSetting")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateClientSetting(ClientSetting reclientSetting) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(reclientSetting.getClientId()) ? reclientSetting.getClientId() : 0;
            clientSetting = clientSettingService.findByid(re_id);
            if (!S.isNull(clientSetting)) {
                clientSetting.setClientId(reclientSetting.getClientId());
                clientSetting.setMessagenum(reclientSetting.getMessagenum());
                clientSetting.setOrderovertime(reclientSetting.getOrderovertime());
                clientSetting.setDroporder(reclientSetting.getDroporder());
                clientSetting.setWaitminute(reclientSetting.getWaitminute());
                clientSetting.setSmscancelid(reclientSetting.getSmscancelid());
                clientSetting.setSmsid(reclientSetting.getSmsid());
                clientSetting.setSmskey(reclientSetting.getSmskey());
                clientSetting.setDistance(reclientSetting.getDistance());
                clientSetting.setAreaname(reclientSetting.getAreaname());
                clientSetting.setSysname(reclientSetting.getSysname());
                clientSetting.setWeixinname(reclientSetting.getWeixinname());
                clientSetting.setServerIp(reclientSetting.getServerIp());
                clientSetting.setServerPort(reclientSetting.getServerPort());
                clientSetting.setMaxdrivernum(reclientSetting.getMaxdrivernum());
                clientSettingService.saveOrUpd(clientSetting);
            } else {
                ClientSetting clientSetting = new ClientSetting();
                clientSetting.setClientId(reclientSetting.getClientId());
                clientSetting.setMessagenum(reclientSetting.getMessagenum());
                clientSetting.setOrderovertime(reclientSetting.getOrderovertime());
                clientSetting.setDroporder(reclientSetting.getDroporder());
                clientSetting.setWaitminute(reclientSetting.getWaitminute());
                clientSetting.setSmscancelid(reclientSetting.getSmscancelid());
                clientSetting.setSmsid(reclientSetting.getSmsid());
                clientSetting.setSmskey(reclientSetting.getSmskey());
                clientSetting.setDistance(reclientSetting.getDistance());
                clientSetting.setAreaname(reclientSetting.getAreaname());
                clientSetting.setSysname(reclientSetting.getSysname());
                clientSetting.setWeixinname(reclientSetting.getWeixinname());
                clientSetting.setServerIp(reclientSetting.getServerIp());
                clientSetting.setServerPort(reclientSetting.getServerPort());
                clientSetting.setMaxdrivernum(reclientSetting.getMaxdrivernum());
                clientSettingService.save(clientSetting);
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

    @POST
    @Path("saveorupdateClientSettingDistance")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateClientSettingDistance(ClientSetting reclientSetting) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(reclientSetting.getClientId()) ? reclientSetting.getClientId() : 0;
            clientSetting = clientSettingService.findByid(re_id);
            if (!S.isNull(clientSetting)) {
                clientSetting.setDistance(reclientSetting.getDistance());
                clientSettingService.saveOrUpd(clientSetting);
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
    @Path("delClientSettingByid")
    @Produces("application/json;charset=utf-8")
    public String delClientSettingByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            clientSetting = clientSettingService.findByid(re_id);
            if (!S.isNull(clientSetting)) {
                clientSettingService.delete(id);
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

    @GET
    @Path("findListMessagesByZero")
    @Produces("application/json;charset=utf-8")
    public String findListMessagesByZero(@QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            clientSettingList = clientSettingService.findListByid(clientid);
            StringBuilder clientbui = new StringBuilder();
            if (!S.isListNull(clientSettingList)) {
                for (ClientSetting c : clientSettingList) {

                    clientbui.append(clientService.findByid(c.getClientId()).getCompany()).append(",");
                }
            }
            System.out.println(clientbui);
            OrderResult orderResult = new OrderResult();
            orderResult.setCode(clientSettingList.size());
            orderResult.setDesc(clientbui.toString());
            JSONObject array = JSONObject.fromObject(orderResult);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("findListMessagesByZero：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

}
