package com.spring.jersy.hibernate.resource.log;

import com.spring.jersy.hibernate.model.entity.LogOperation;
import com.spring.jersy.hibernate.model.service.LogOperationService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONArray;
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
 * Created by Administrator on 2016/9/12.
 */
@Component
@Path("/logoperation")
@Scope("prototype")
public class LogOperationResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogOperationResource.class);
    private static final String tabname = "操作日志";
    @Context
    private HttpServletResponse response;

    @Resource
    private LogOperationService logOperationService;

    private List<LogOperation> logOperationList;

    private LogOperation logOperation;

    @POST
    @Path("findLogOperationForPageList")
    @Produces("application/json;charset=utf-8")
    public String findLogOperationForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @FormParam("page") final int page, @FormParam("rows") final int rows, @QueryParam("clientid") final int clientid) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            PageList pageList = logOperationService.findList(page, rows, sort, order, key, startime, endtime, clientid);
            logOperationList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, logOperationList);

        } catch (Exception e) {
            LOGGER.error("加载用户操作日志表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }


}
