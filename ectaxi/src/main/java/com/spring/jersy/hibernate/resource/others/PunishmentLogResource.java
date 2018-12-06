package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.PunishmentLog;
import com.spring.jersy.hibernate.model.service.PunishmentLogService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.resource.BaseResource;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.util.List;


@Component
@Path("/punishmentlog")
@Scope("prototype")
public class PunishmentLogResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PunishmentLogResource.class);
    private static final String tabname = "punishment_log";
    @Context
    private HttpServletResponse response;


    @Resource
    private PunishmentLogService punishmentLogService;


    private List<PunishmentLog> punishmentLogList;


    @GET
    @Path("findPunishmentLogList")
    @Produces("application/json;charset=utf-8")
    public String findPunishmentLogList(@QueryParam("kabnum") final String kabnum) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            punishmentLogList = punishmentLogService.findList(kabnum);
            total = punishmentLogList.size();
            return ReturePageList(total, punishmentLogList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

}
