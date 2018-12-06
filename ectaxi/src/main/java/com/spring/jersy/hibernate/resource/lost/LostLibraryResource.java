package com.spring.jersy.hibernate.resource.lost;

import com.spring.jersy.hibernate.model.entity.LostLibrary;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
import com.spring.jersy.hibernate.model.service.LogOperationService;
import com.spring.jersy.hibernate.model.service.LostLibraryService;
import com.spring.jersy.hibernate.publics.util.*;
import com.spring.jersy.hibernate.resource.BaseResource;
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

/**
 * Created by Administrator on 2016/9/9.
 */
@Component
@Path("/lostlibrary")
@Scope("prototype")
public class LostLibraryResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LostLibraryResource.class);
    private static final String tabname = "失物入库";
    private static final String tabcontent = "失物入库数据";
    @Context
    private HttpServletResponse response;

    @Resource
    private LostLibraryService lostLibraryService;
    @Resource
    private LogOperationService logOperationService;

    @Resource
    private LogAbnormalService logAbnormalService;


    private List<LostLibrary> lostLibraryList;

    private LostLibrary lostLibrary;

    @POST
    @Path("findLostLibraryForPageList")
    @Produces("application/json;charset=utf-8")
    public String findLostLibraryForPageList(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("getonstartime") final String getonstartime, @QueryParam("getonendtime") final String getonendtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("token") final String token, @QueryParam("key") final String key, @QueryParam("clientid") final Integer clientid, @QueryParam("state") final Byte state, @QueryParam("classify") final Byte classify, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_QUERY, OPERATION_QUERY_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;
            PageList pageList = lostLibraryService.findList(page, rows, sort, order, key, startime, endtime, getonstartime, getonendtime, classify, state, re_clientid);
            lostLibraryList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, lostLibraryList);

        } catch (Exception e) {
            LOGGER.error("加载失物入库数据异常：", e);
            logAbnormalService.savelogAbnormal(token, "加载" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


    @GET
    @Path("delLostLibraryByid")
    @Produces("application/json;charset=utf-8")
    public String delLostLibraryByid(@QueryParam("id") final Integer id, @QueryParam("token") final String token, @QueryParam("clientid") final Integer clientid) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        logOperationService.savelogOperation(token, OPERATION_DEL, OPERATION_DEL_NAME + ":" + tabcontent, clientid);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            lostLibrary = lostLibraryService.findByid(re_id);
            if (!S.isNull(lostLibrary)) {
                lostLibraryService.delete(id);
            } else {
                responseSim.setCode(Constants.FAILURE_RESP);
                responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            }
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("删除" + tabname + "信息异常：", e);
            logAbnormalService.savelogAbnormal(token, "删除" + tabname + "数据异常", clientid);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @POST
    @Path("saveorupdateLostLibrary")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateLostLibrary(@QueryParam("id") final Integer id, @QueryParam("name") final String name, @QueryParam("phone") final String phone, @QueryParam("classify") final Byte classify, @QueryParam("geton") final String geton, @QueryParam("getoff") final String getoff, @QueryParam("kabnum") final String kabnum, @QueryParam("clientid") final Integer clientid, @QueryParam("state") final Byte state, @QueryParam("token") final String token, @QueryParam("createtime") final String createtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;
            lostLibrary = lostLibraryService.findByid(re_id);

            if (!S.isNull(lostLibrary)) {

                lostLibrary.setName(name);
                lostLibrary.setPhone(phone);
                lostLibrary.setClassify(classify);
                if (!S.isNull(createtime)) {
                    lostLibrary.setCreatetime(DateUtil.stringToDate(createtime, "yyyy-MM-dd HH:mm:ss"));
                }
                if (!S.isNull(geton)) {
                    lostLibrary.setGeton(DateUtil.stringToDate(geton, "yyyy-MM-dd HH:mm:ss"));
                }
                if (!S.isNull(getoff)) {
                    lostLibrary.setGetoff(DateUtil.stringToDate(getoff, "yyyy-MM-dd HH:mm:ss"));
                }
                lostLibrary.setKabnum(kabnum);
                lostLibrary.setState(state);
                lostLibrary.setClientid(re_clientid);
                lostLibraryService.saveOrUpd(lostLibrary);
                logOperationService.savelogOperation(token, OPERATION_EDIT, OPERATION_EDIT_NAME + ":" + tabcontent, clientid);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();

            } else {
                lostLibrary = new LostLibrary();
                lostLibrary.setName(name);
                lostLibrary.setPhone(phone);
                lostLibrary.setClassify(classify);
                lostLibrary.setCreatetime(new Date());
                if (!S.isNull(geton)) {
                    lostLibrary.setGeton(DateUtil.stringToDate(geton, "yyyy-MM-dd HH:mm:ss"));
                }
                if (!S.isNull(getoff)) {
                    lostLibrary.setGetoff(DateUtil.stringToDate(getoff, "yyyy-MM-dd HH:mm:ss"));
                }
                lostLibrary.setKabnum(kabnum);
                lostLibrary.setState(state);
                lostLibrary.setClientid(re_clientid);
                lostLibraryService.save(lostLibrary);
                logOperationService.savelogOperation(token, OPERATION_ADD, OPERATION_ADD_NAME + ":" + tabcontent, clientid);
                JSONObject array = JSONObject.fromObject(responseSim);
                return array.toString();
            }
        } catch (Exception e) {

            LOGGER.error("添加或修改" + tabname + "异常：", e);
            logAbnormalService.savelogAbnormal(token, "添加或修改" + tabname + "数据异常", clientid);

            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

    @GET
    @Path("findNameByid")
    @Produces("application/json;charset=utf-8")
    public String findNameByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            lostLibrary = lostLibraryService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(lostLibrary);
            return array.toString();

        } catch (Exception e) {
            LOGGER.error("根据id查询：" + tabname + "信息异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }

    }

}
