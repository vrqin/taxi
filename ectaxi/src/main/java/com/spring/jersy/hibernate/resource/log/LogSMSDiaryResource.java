package com.spring.jersy.hibernate.resource.log;

import com.spring.jersy.hibernate.model.entity.LogSMSDiary;
import com.spring.jersy.hibernate.model.service.LogSMSDiaryService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.resource.BaseResource;
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
@Path("/logsmsdiary")
@Scope("prototype")
public class LogSMSDiaryResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogSMSDiaryResource.class);
    private static final String tabname = "短信日志";
    @Context
    private HttpServletResponse response;

    @Resource
    private LogSMSDiaryService logSMSDiaryService;

    private List<LogSMSDiary> logSMSDiaryList;

    private LogSMSDiary logSMSDiary;

    @POST
    @Path("findLogSMSDiaryForPageList")
    @Produces("application/json;charset=utf-8")
    public String findLogSMSDiaryForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("status") final Byte status, @QueryParam("clientid") final Integer clientid, @FormParam("page") final int page, @FormParam("rows") final int rows) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            PageList pageList = logSMSDiaryService.findPageList(page, rows, sort, order, key, startime, endtime, status, clientid);
            logSMSDiaryList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, logSMSDiaryList);


        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("加载" + tabname + "表异常：", e);
            return null;
        }

    }


    public void savelogSMSDiary(String phone, String sendtime, Byte status, String content, Integer clientid) {

        try {

            logSMSDiary = new LogSMSDiary();
            logSMSDiary.setPhone(phone);
            logSMSDiary.setSendtime(DateUtil.stringToDate(sendtime, "yyyy-MM-dd HH:mm:ss"));
            logSMSDiary.setContent(content);
            logSMSDiary.setClientid(clientid);

            logSMSDiaryService.save(logSMSDiary);
        } catch (Exception e) {
            LOGGER.error("添加" + tabname + "表异常：", e);
        }
    }
}
