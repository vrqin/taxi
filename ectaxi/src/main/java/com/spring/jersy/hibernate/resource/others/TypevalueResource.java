package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.TypeValue;
import com.spring.jersy.hibernate.model.service.TypevalueService;
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
@Path("/typevalue")
@Scope("prototype")
public class TypevalueResource extends BaseResource {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(TypevalueResource.class);
    private static final String tabname = "Typevalue";
    @Context
    private HttpServletResponse response;


    @Resource
    private TypevalueService typevalueService;


    private List<TypeValue> typevalueList;
    private List<TreeBean> treeBeanList;

    private TypeValue typevalue;

    @POST
    @Path("findTypevalueForPageList")
    @Produces("application/json;charset=utf-8")
    public String findTypevalueForPageList(@QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("key") final String key, @QueryParam("type") final int type, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            PageList pageList = typevalueService.findList(page, rows, sort, order, key, begintime, endtime, type);
            typevalueList = pageList.getList();
            total = pageList.getTotalRecord();
            return ReturePageList(total, typevalueList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "列表异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @POST
    @Path("findTypevalueByid")
    @Produces("application/json;charset=utf-8")
    public String findTypevalueByid(@QueryParam("id") final Integer id) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            Integer re_id = !S.isNull(id) ? id : 0;
            typevalue = typevalueService.findByid(re_id);
            JSONObject array = JSONObject.fromObject(typevalue);
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
    @Path("saveorupdateTypevalue")
    @Produces("application/json;charset=utf-8")
    public String saveorupdateTypevalue(@QueryParam("id") final Integer id, TypeValue retypevalue) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            typevalue = typevalueService.findByid(re_id);
            if (!S.isNull(typevalue)) {
                typevalueService.saveOrUpd(retypevalue);
            } else {
                typevalueService.save(retypevalue);
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
    @Path("delTypevalueByid")
    @Produces("application/json;charset=utf-8")
    public String delTypevalueByid(@QueryParam("id") final Integer id) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);

        try {
            Integer re_id = !S.isNull(id) ? id : 0;
            typevalue = typevalueService.findByid(re_id);
            if (!S.isNull(typevalue)) {
                typevalueService.delete(id);
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
    @Path("findTypevalueBykey")
    @Produces("application/json;charset=utf-8")
    public String findTypevalueBykey(@QueryParam("code") final String code) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            String re_code = !S.isNull(code) ? code : "";
            typevalueList = typevalueService.findListByKey(re_code);
            treeBeanList = new ArrayList<TreeBean>();
            TreeBean tb;
            for (TypeValue c : typevalueList) {
                tb = new TreeBean();
                tb.setId(c.getCode());
                tb.setText(c.getValue());
                treeBeanList.add(tb);
            }
            JSONArray array = JSONArray.fromObject(treeBeanList.toArray());
            return array.toString();

        } catch (Exception e) {
            LOGGER.error(tabname + "根据code查找类型：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONObject array = JSONObject.fromObject(responseSim);
            return array.toString();
        }
    }


}
