package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.WorkRecords;
import com.spring.jersy.hibernate.model.service.WorkRecordsService;
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
import java.util.List;


@Component
@Path("/workrecords")
@Scope("prototype")
public class WorkrecordsResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(WorkrecordsResource.class);
    private static final String tabname = "Workrecords";
    @Context
    private HttpServletResponse response;


    @Resource
    private WorkRecordsService workRecordsService;


    private List<WorkRecords> workrecordsList;

    private WorkRecords workrecords;

    @POST
    @Path("findWorkrecordsForPageList")
    @Produces("application/json;charset=utf-8")
    public String findWorkrecordsForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        try {
            workrecordsList = workRecordsService.findList(sort, order, key, begintime, endtime);
            JSONArray array = JSONArray.fromObject(workrecordsList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            return null;
        }
    }

    @POST
    @Path("findWorkrecordsByid")
    @Produces("application/json;charset=utf-8")
    public String findWorkrecordsByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            workrecords = workRecordsService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(workrecords);
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
    @Path("saveorupdateWorkrecords")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateWorkrecords(@QueryParam("id") final Integer id, WorkRecords reworkrecords) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            workrecords = workRecordsService.findByid(re_id);
            if (!S.isNull(workrecords)) {
                workRecordsService.saveOrUpd(reworkrecords);
            } else {
                workRecordsService.save(reworkrecords);
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
    @Path("delWorkrecordsByid")
    @Produces("application/json;charset=utf-8")
    public String delWorkrecordsByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            workrecords = workRecordsService.findByid(re_id);
            if (!S.isNull(workrecords)) {
                workRecordsService.delete(id);
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
