package com.spring.jersy.hibernate.resource.client;

import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.model.entity.Driver;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
import com.spring.jersy.hibernate.model.service.LogOperationService;
import com.spring.jersy.hibernate.publics.bean.ClientBean;
import com.spring.jersy.hibernate.publics.bean.TreeBean;
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
import java.util.ArrayList;
import java.util.List;


@Component
@Path("/client")
@Scope("prototype")
public class ClientResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ClientResource.class);
    private static final String tabname = "Client";
    @Context
    private HttpServletResponse response;


    @Resource
    private ClientService clientService;
    @Resource
    private LogAbnormalService logAbnormalService;
    @Resource
    private LogOperationService logOperationService;
    @Resource
    private DriverService driverService;

    private List<Client> clientList;
    private List<ClientBean> clientBeanList;
    private Client client;
    private List<TreeBean> treeBeans;

    @POST
    @Path("findClientForPageList")
    @Produces("application/json;charset=utf-8")
    public String findClientForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("cityFlag") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = clientService.findList(page, rows, sort, order, key, begintime, endtime, type);
            clientList = pageList.getList();
            total = pageList.getTotalRecord();

            return ReturePageList(total, clientList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findClientByid")
    @Produces("application/json;charset=utf-8")
    public String findClientByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            client = clientService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(client);
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
    @Path("findClientBycompany")
    @Produces("application/json;charset=utf-8")
    public String findClientBycompany(@QueryParam("company") final String company) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            client = clientService.findbyCompany(company);
            JSONObject array = JSONObject.fromObject(client);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "根据公司查询查找：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("saveorupdateClient")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateClient(@QueryParam("id") final Integer id, Client reclient) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(reclient.getClientId()) ? reclient.getClientId() : 0;
            client = clientService.findByid(re_id);
            if (!S.isNull(client)) {
                clientService.saveOrUpd(reclient);
            } else {
                clientService.save(reclient);
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
    @Path("delClientByid")
    @Produces("application/json;charset=utf-8")
    public String delClientByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            client = clientService.findByid(re_id);
            if (!S.isNull(client)) {
                clientService.delete(id);
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
    @Path("findclienttree")
    @Produces("application/json;charset=utf-8")
    public String findclienttree(@QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            treeBeans = new ArrayList<TreeBean>();
            TreeBean tb;
            //查找父亲节点的为1的树
            if (clientid == 0) {
                for (Client c : clientService.findList()) {
                    tb = new TreeBean();
                    tb.setId(c.getClientId());
                    tb.setText(c.getCompany());
                    treeBeans.add(tb);
                }
            } else {
                Client c = clientService.findByid(clientid);
                tb = new TreeBean();
                tb.setId(c.getClientId());
                tb.setText(c.getCompany());
                treeBeans.add(tb);
            }
            JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("findclienttree " + tabname + "异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("findClienttreegril")
    @Produces("application/json;charset=utf-8")
    public String findClienttreegril(@QueryParam("id") final Integer id, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            clientBeanList = new ArrayList<ClientBean>();
            if (clientid == 0) {
                //总公司
                Client cencom = clientService.findListByCityflagId(0);
                ClientBean cencomBean = new ClientBean();
                cencomBean.setClientId(cencom.getClientId());
                cencomBean.setPid(0);
                cencomBean.setClientName(cencom.getClientName());
                cencomBean.setCompany(cencom.getCompany());
                cencomBean.setAddress(cencom.getAddress());
                cencomBean.setCityFlag(cencom.getCityFlag());
                cencomBean.setContactperson(cencom.getContactperson());
                cencomBean.setEmail(cencom.getEmail());
                cencomBean.setPhone(cencom.getPhone());
                cencomBean.setRemark(cencom.getRemark());


                //子公司
                List<Client> subsidiary = clientService.findListByPid(1);
                // 总公司 下的孩子
                List<ClientBean> cencomChildren = new ArrayList<ClientBean>();
                //子公司下的孩子
                List<ClientBean> subsidiaryChildren = null;
                //车
                List<Driver> drivers = null;

                ClientBean subsidiaryBean = null;
                ClientBean subChildredBean = null;

                TreeBean driverBean = null;
                if (!S.isListNull(subsidiary) && subsidiary.size() > 0) {
                    for (Client s : subsidiary) {
                        subsidiaryBean = new ClientBean();
                        subsidiaryBean.setClientId(s.getClientId());
                        subsidiaryBean.setPid(s.getPid());
                        subsidiaryBean.setClientName(s.getClientName());
                        subsidiaryBean.setCompany(s.getCompany());
                        subsidiaryBean.setAddress(s.getAddress());
                        subsidiaryBean.setCityFlag(s.getCityFlag());
                        subsidiaryBean.setContactperson(s.getContactperson());
                        subsidiaryBean.setEmail(s.getEmail());
                        subsidiaryBean.setPhone(s.getPhone());

                        //公司下的分公司
                        List<Client> clients = clientService.findListByPid(s.getClientId());
                        subsidiaryChildren = new ArrayList<ClientBean>();
                        if (!S.isListNull(clients) && clients.size() > 0) {
                            for (Client client : clients) {
                                subChildredBean = new ClientBean();
                                subChildredBean.setClientId(client.getClientId());
                                subChildredBean.setPid(client.getPid());
                                subChildredBean.setClientName(client.getClientName());
                                subChildredBean.setCompany(client.getCompany());
                                subChildredBean.setAddress(client.getAddress());
                                subChildredBean.setCityFlag(client.getCityFlag());
                                subChildredBean.setContactperson(client.getContactperson());
                                subChildredBean.setEmail(client.getEmail());
                                subChildredBean.setPhone(client.getPhone());
                                subChildredBean.setRemark(client.getRemark());
                                subChildredBean.setIconCls("icon-group");
                                subsidiaryChildren.add(subChildredBean);
                            }
                        }

                        subsidiaryBean.setRemark(s.getRemark());
                        subsidiaryBean.setIconCls("icon-group");
                        subsidiaryBean.setChildren(subsidiaryChildren);
                        cencomChildren.add(subsidiaryBean);
                    }
                }

                cencomBean.setIconCls("icon-company");
                cencomBean.setChildren(cencomChildren);
                clientBeanList.add(cencomBean);
            } else {
                //当前公司
                Client client = clientService.findByid(clientid);
                //数列表显示
                ClientBean cencomBean = new ClientBean();
                cencomBean.setClientId(client.getClientId());
                cencomBean.setPid(client.getPid());
                cencomBean.setClientName(client.getClientName());
                cencomBean.setCompany(client.getCompany());
                cencomBean.setAddress(client.getAddress());
                cencomBean.setCityFlag(client.getCityFlag());
                cencomBean.setContactperson(client.getContactperson());
                cencomBean.setEmail(client.getEmail());
                cencomBean.setPhone(client.getPhone());
                cencomBean.setRemark(client.getRemark());

                //子公司下的孩子
                List<ClientBean> clientChildren = null;
                clientChildren = new ArrayList<ClientBean>();

                ClientBean subChildredBean = null;
                //公司下的分公司
                List<Client> clients = clientService.findListByPid(clientid);

                if (!S.isListNull(clients) && clients.size() > 0) {
                    for (Client c : clients) {
                        subChildredBean = new ClientBean();
                        subChildredBean.setClientId(c.getClientId());
                        subChildredBean.setPid(c.getPid());
                        subChildredBean.setClientName(c.getClientName());
                        subChildredBean.setCompany(c.getCompany());
                        subChildredBean.setAddress(c.getAddress());
                        subChildredBean.setCityFlag(c.getCityFlag());
                        subChildredBean.setContactperson(c.getContactperson());
                        subChildredBean.setEmail(c.getEmail());
                        subChildredBean.setPhone(c.getPhone());
                        subChildredBean.setRemark(c.getRemark());
                        subChildredBean.setIconCls("icon-group");
                        clientChildren.add(subChildredBean);
                    }
                }

                cencomBean.setIconCls("icon-company");
                cencomBean.setChildren(clientChildren);
                clientBeanList.add(cencomBean);
            }

            //            //System.out.println(clientBeanList);
            JSONArray array = JSONArray.fromObject(clientBeanList.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("加载客户异常异常:", e);
            logAbnormalService.savelogAbnormal("所有", "加载所有客户树异常异常", clientid);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    @POST
    @Path("findClienttree")
    @Produces("application/json;charset=utf-8")
    public String findClienttree(@QueryParam("id") final Integer id, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            treeBeans = new ArrayList<TreeBean>();
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            if (ac_clientid == 0) {
                //总公司
                Client cencom = clientService.findListByCityflagId(0);

                TreeBean cencomBean = new TreeBean();
                cencomBean.setId(cencom.getClientId());
                cencomBean.setPid(0);
                cencomBean.setText(cencom.getClientName());


                //子公司
                List<Client> subsidiary = clientService.findListByPid(1);
                // 总公司 下的孩子
                List<TreeBean> cencomChildren = new ArrayList<TreeBean>();
                //子公司下的孩子
                List<TreeBean> subsidiaryChildren = null;

                TreeBean subsidiaryBean = null;


                for (Client s : subsidiary) {
                    subsidiaryBean = new TreeBean();
                    subsidiaryBean.setId(s.getClientId());
                    subsidiaryBean.setPid(cencom.getPid());
                    subsidiaryBean.setText(s.getCompany());
                    subsidiaryBean.setMsid(String.valueOf(driverService.findDriverByClientId(s.getClientId()).size()));

                    subsidiaryBean.setIconCls("icon-group");
                    subsidiaryBean.setChildren(subsidiaryChildren);
                    cencomChildren.add(subsidiaryBean);
                }
                cencomBean.setIconCls("icon-company");
                cencomBean.setChildren(cencomChildren);
                treeBeans.add(cencomBean);
            } else {
                //总公司
                Client cencom = clientService.findByid(ac_clientid);

                TreeBean cencomBean = new TreeBean();
                cencomBean.setId(cencom.getClientId());
                cencomBean.setPid(cencom.getPid());
                cencomBean.setText(cencom.getClientName());


                cencomBean.setIconCls("icon-company");
                treeBeans.add(cencomBean);
            }


            JSONArray array = JSONArray.fromObject(treeBeans.toArray());
            return array.toString();
        } catch (Exception e) {
            LOGGER.error("加载所有司机树异常异常:", e);
            logAbnormalService.savelogAbnormal("所有", "加载所有司机树异常异常", clientid);
            responseSim.setCode(Constants.EXISR_DRIVER_RESP);
            responseSim.setDesc(Constants.EXISR_DRIVER_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }


    private boolean haveParentGrpid(String clientid, List<Client> clientList) {
        for (Client item : clientList) {
            if (item.getClientId().equals(clientid)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistPreClientInfo(List<Client> clientInfoList, int preid) {
        for (Client item : clientInfoList) {
            if (item.getClientId() == preid) {
                return true;
            }
        }
        return false;
    }


}
