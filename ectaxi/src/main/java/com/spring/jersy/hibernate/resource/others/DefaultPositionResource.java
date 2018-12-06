package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.DefaultPosition;
import com.spring.jersy.hibernate.model.service.DefaultPositionService;
import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.ResponseSim;
import com.spring.jersy.hibernate.publics.util.S;
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
@Path("/defaultPosition")
@Scope("prototype")
public class DefaultPositionResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(DefaultPositionResource.class);
    private static final String tabname = "DefaultPosition";
    @Context
    private HttpServletResponse response;


    @Resource
    private DefaultPositionService defaultPositionService;


    private List<DefaultPosition> defaultPositionList;

    private DefaultPosition defaultPosition;

    @POST
    @Path("findDefaultPositionForPageList")
    @Produces("application/json;charset=utf-8")
    public String findDefaultPositionForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            defaultPositionList = defaultPositionService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(defaultPositionList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findDefaultPositionByid")
    @Produces("application/json;charset=utf-8")
    public String findDefaultPositionByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            defaultPosition = defaultPositionService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(defaultPosition);
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
    @Path("saveorupdateDefaultPosition")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateDefaultPosition(DefaultPosition redefaultPosition) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            defaultPosition = defaultPositionService.findByUseid(redefaultPosition.getUserId(), redefaultPosition.getSsid());

            if (!S.isNull(defaultPosition)) {
                defaultPosition.setDeflg(redefaultPosition.getDeflg());
                defaultPosition.setDeflt(redefaultPosition.getDeflt());
                defaultPosition.setLayer(redefaultPosition.getLayer());
                defaultPosition.setGpstime(new Date());
                defaultPositionService.saveOrUpd(defaultPosition);
            } else {
                defaultPositionService.save(redefaultPosition);
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
    @Path("delDefaultPositionByid")
    @Produces("application/json;charset=utf-8")
    public String delDefaultPositionByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            defaultPosition = defaultPositionService.findByid(re_id);
            if (!S.isNull(defaultPosition)) {
                defaultPositionService.delete(id);
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
