package com.spring.jersy.hibernate.resource.driver;

import com.spring.jersy.hibernate.model.entity.DriverVioDeltails;
import com.spring.jersy.hibernate.model.service.DriverVioDeltailsService;
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
 * Created by Administrator on 2016/9/11.
 */
@Component
@Path("/driverviodeltails")
@Scope("prototype")
public class DriverVioDeltailsResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DriverVioDeltailsResource.class);

    @Context
    private HttpServletResponse response;
    @Resource
    private DriverVioDeltailsService driverVioDeltailsService;

    private List<DriverVioDeltails> driverVioDeltailsList;

    @POST
    @Path("findDriverVioDeltailsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDriverVioDeltailsForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final Integer type, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            PageList pageList = driverVioDeltailsService.findList(page, rows, sort, order, key, startime, endtime, type);
            driverVioDeltailsList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, driverVioDeltailsList);

        } catch (Exception e) {
            LOGGER.error("加载驾驶员违规明细数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }


    }
}
