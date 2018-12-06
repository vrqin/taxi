package com.spring.jersy.hibernate.resource.log;

import com.spring.jersy.hibernate.model.entity.LogLogin;
import com.spring.jersy.hibernate.model.service.LogLoginService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
@Component
@Path("/loglogin")
@Scope("prototype")
public class LogLoginResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogLoginResource.class);
    private static final String tabname = "登录日志";
    @Context
    private HttpServletResponse response;

    @Autowired
    private LogLoginService logLoginService;

    private List<LogLogin> logLoginList;

    private LogLogin logLogin;

    @POST
    @Path("findLogLoginForPageList")
    @Produces("application/json;charset=utf-8")
    public String findLogLoginForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final Integer type, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = logLoginService.findList(page, rows, sort, order, key, startime, endtime, type, ac_clientid);
            logLoginList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, logLoginList);

        } catch (Exception e) {
            LOGGER.error("加载登录日志表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    public void savelogLogin(String account, Integer type, String name, String loginIP, Integer clientid) {

        try {

            logLogin = new LogLogin();
            logLogin.setAccount(account);
            logLogin.setType(type);
            logLogin.setName(name);
            logLogin.setLoginIP(loginIP);
            logLogin.setOperattime(new Date());
            logLogin.setClientid(clientid);

            logLoginService.save(logLogin);

        } catch (Exception e) {
            LOGGER.error("添加" + tabname + "表异常：", e);
        }
    }

}
