package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Postrack;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.model.service.PostrackService;
import com.spring.jersy.hibernate.publics.bean.PostrackBean;
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
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
@Component
@Path("/postrack")
@Scope("prototype")
public class PostrackResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(PostrackResource.class);
    private static final String tabname = "轨迹";

    @Context
    private HttpServletResponse response;

    @Resource
    private PostrackService postrackService;
    @Resource
    private DriverService driverService;

    private List<Postrack> postrackList;
    private List<PostrackBean> postrackBeanList;

    private Postrack postrack;
    private PostrackBean postrackBean;

    @POST
    @Path("findPostrackBeanForPageList")
    @Produces("application/json;charset=utf-8")
    public String findPostrackBeanForPageList(@QueryParam("kabnum") final String kabnum, @QueryParam("name") final String name, @QueryParam("phone") final String phone, @QueryParam("clientid") final int clientid, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime, @FormParam("page") final int page, @FormParam("rows") final int rows) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            postrackBeanList = postrackService.findDriverTrackByTime(begintime, endtime, kabnum, name, phone, clientid);
            total = postrackBeanList.size();
            return ReturePageList(total, postrackBeanList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

    @GET
    @Path("findPostrackListByKabnum")
    @Produces("application/json;charset=utf-8")
    public String findPostrackListByKabnum(@QueryParam("kabnum") final String kabnum, @QueryParam("name") final String name, @QueryParam("phone") final String phone, @QueryParam("begintime") final String begintime, @QueryParam("endtime") final String endtime) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        ResponseSim responseSim = new ResponseSim(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {

            postrackBeanList = postrackService.findPosTrack(begintime, endtime, kabnum, name, phone);
            //            if (!S.isNull(postrackBeanList)){
            //                for (PostrackBean p:postrackBeanList){
            //                    GpsEntity gpsEntity = ChangeGps.wgs84Tobd09(p.getLt(),p.getLg());
            //                    p.setLt(gpsEntity.getLatitude());
            //                    p.setLg(gpsEntity.getLongitude());
            //                }
            //            }
            total = postrackBeanList.size();
            return ReturePageList(total, postrackBeanList);

        } catch (Exception e) {
            LOGGER.error("加载" + tabname + "数据异常：", e);
            responseSim.setCode(Constants.FAILURE_RESP);
            responseSim.setDesc(Constants.FAILURE_DESC_RESP);
            JSONArray array = JSONArray.fromObject(responseSim);
            return array.toString();
        }
    }

}
