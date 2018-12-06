package com.spring.jersy.hibernate.resource.log;

import com.spring.jersy.hibernate.model.entity.LogAbnormal;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
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
@Path("/logabnormal")
@Scope("prototype")
public class LogAbnormalResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogAbnormalResource.class);
    private static final String tabname = "异常日志";
    @Context
    private HttpServletResponse response;

    @Resource
    private LogAbnormalService logAbnormalService;

    private List<LogAbnormal> logAbnormalList;

    private LogAbnormal logAbnormal;

    @POST
    @Path("findLogAbnormalForPageList")
    @Produces("application/json;charset=utf-8")
    public String findLogAbnormalForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            PageList pageList = logAbnormalService.findList(page, rows, sort, order, key, startime, endtime, clientid);
            logAbnormalList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, logAbnormalList);

        } catch (Exception e) {
            LOGGER.error("加载异常日志：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }


}
