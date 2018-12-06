package com.speedtalk.smartkab.manage.ws.res;

import com.speedtalk.smartkab.manage.ws.EngineManageDao;
import com.speedtalk.smartkab.manage.ws.Utils;
import com.speedtalk.smartkab.manage.ws.db.TbEngineManage;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;

@Path("manage")
public class EngineManage {
    private static final String ERR_RESP = new String(Utils.encrypt("0:0".getBytes()));
    private static final int UNEXPIRED = 0;
    private static final int EXPIRED = 1;
    // private Logger log = Logger.getLogger(EngineManage.class.getName());
    private EngineManageDao engineDao = new EngineManageDao();
    @Context
    private HttpServletRequest req;

    @GET
    @Path("info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {
        String ip = req.getRemoteAddr();
        // log.info(ip + " get info...");
        TbEngineManage engine = engineDao.getByIp(ip);
        if (null == engine) {
            // log.info("get nothing of " + ip);
            return ERR_RESP;
        }
        try {
            String resp = ip + ":" + engine.getKabcount() + ":";
            Calendar cal = Calendar.getInstance();
            if (engine.getExpiretime() == null || engine.getExpiretime().after(cal.getTime())) {
                resp += UNEXPIRED;
            } else {
                resp += EXPIRED;
            }


            // log.info(resp + ",expired time :" + engine.getExpiretime().toString());

            return new String(Utils.encrypt(resp.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERR_RESP;
    }
}
