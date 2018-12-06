package com.speedtalk.smartkab.ws.res;

import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.smartkab.ws.Constants;
import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.dao.BaseDao;
import com.speedtalk.smartkab.ws.dao.DriverDao;
import com.speedtalk.smartkab.ws.dao.UserDao;
import com.speedtalk.smartkab.ws.db.TabDriver;
import com.speedtalk.smartkab.ws.db.TabPhonecallbuss;
import com.speedtalk.smartkab.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.ws.db.TabPosOfOrderTrack;
import com.speedtalk.smartkab.ws.domain.PosOfOrderTrack;
import com.speedtalk.smartkab.ws.domain.Position;
import com.speedtalk.smartkab.ws.domain.Response;
import com.speedtalk.smartkab.ws.kabs.Distance;
import com.speedtalk.smartkab.ws.kabs.DistanceComparator;
import com.speedtalk.smartkab.ws.kabs.KabInfo;
import com.speedtalk.smartkab.ws.kabs.KabTeam;

import javax.ws.rs.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

@Path("position")
public class PositionResource {
    private static final int MAX_KAB_COUNT = 15;
    private static final int MAX_EXTENT = 2000;
    private DriverDao driverDao;
    private UserDao userDao;
    private BaseDao baseDao;
    private DistanceComparator comparator = new DistanceComparator();

    public PositionResource() {
        driverDao = new DriverDao();
        userDao = new UserDao();
        baseDao = new BaseDao();
    }

    @GET
    @Path("list")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * get some near kab of account
     * @param account
     * @param lg
     * @param lt
     * @return position of some kab
     */ public ArrayList<Position> getKabList(@QueryParam("account") final String account, @QueryParam("lg") final double lg, @QueryParam("lt") final double lt) {
        ArrayList<Position> list = new ArrayList<Position>();
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            System.out.println(Utils.getLogFix() + "a incorrect user try to get kab list! " + account);
            return list;
        }
        ArrayList<Distance> disList = new ArrayList<Distance>();
        for (KabInfo info : KabTeam.getInstance().getOnlineKabs()) {
            double distance = Utils.calDistance(lt, lg, info.getLt(), info.getLg());
            if (distance <= MAX_EXTENT)
                disList.add(new Distance(info, distance));
        }
        Collections.sort(disList, comparator);
        try {
            Position position = null;
            for (Distance dis : disList) {
                position = new Position();
                position.setMsId(dis.getKab().getMsId());
                position.setKabName(dis.getKab().getName());
                position.setLg(dis.getKab().getLg());
                position.setLt(dis.getKab().getLt());
                position.setDirection(dis.getKab().getDirection());
                position.setpTime(Utils.getCommonsdf().format(dis.getKab().getTime()));
                position.setIsApp(dis.getKab().getIsApp());
                list.add(position);
                System.out.println(Utils.getLogFix() + dis.getKab()
                        .getName() + " -- " + dis.getDistance() + " -- " + dis.getKab().getIsApp());
                if (list.size() >= MAX_KAB_COUNT)
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Utils.getLogFix() + account + "," + lg + "," + lt + " get near kab list! " + list.size());
        return list;
    }

    @GET
    @Path("one")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    /**
     * get position of a kab
     * @param account
     * @param msId
     * @return position of specified
     */ public Position getKab(@QueryParam("account") final String account, @QueryParam("msId") final String msId) {
        Position position = new Position();
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            System.out.println(Utils.getLogFix() + "a incorrect user try to get kab! " + account);
            return position;
        }
        TabDriver driver = driverDao.getDriver(msId);
        KabInfo info = KabTeam.getInstance().getKabByMsId(msId);
        if (driver != null && info != null) {
            position.setMsId(driver.getMsid());
            position.setKabName(driver.getKabnum());
            //			position.setLg(info.getLg());
            //			position.setLt(info.getLt());
            //			position.setpTime(Utils.getCommonsdf().format(info.getTime()));
            position.setLg(driver.getLastlg());
            position.setLt(driver.getLastlt());
            position.setDirection(info.getDirection());
            position.setpTime(Utils.getCommonsdf().format(driver.getGpstime()));
            position.setIsApp(info.getIsApp());
        }
        //		System.out.println(Utils.getLogFix() + account + " get " + msId + "'s position!");
        return position;
    }

    @POST
    @Path("track")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public Response posOfOrderTrack(final PosOfOrderTrack posOfOrderTrack) {
        Response resp = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        if (null == posOfOrderTrack) {
            System.out.println(Utils.getLogFix() + "PosOfOrderTrack info error!");
            resp.setCode(Constants.PARAM_ERR_RESP);
            resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
            return resp;
        }
        TabPhonecallbuss tbOrder = (TabPhonecallbuss) baseDao.get(TabPhonecallbuss.class, posOfOrderTrack.getOrderNum());
        if (null == tbOrder) {
            System.out.println(Utils.getLogFix() + "PosOfOrderTrack orderid error!" + posOfOrderTrack.getOrderNum());
            return resp;
        }
        if (!tbOrder.getOpruser().equals(posOfOrderTrack.getAccount())) {
            System.out.println(Utils.getLogFix() + "PosOfOrderTrack account error!" + posOfOrderTrack.getAccount() + "," + tbOrder
                    .getOpruser());
            return resp;
        }
        try {
            TabPosOfOrderTrack posOfOrderTrack2 = new TabPosOfOrderTrack(posOfOrderTrack.getOrderNum(), posOfOrderTrack.getAccount(), (byte) 0, posOfOrderTrack
                    .getLg(), posOfOrderTrack.getLt(), new Timestamp(DateUtils.getCommonTimeFormat()
                    .parse(posOfOrderTrack.getTime())
                    .getTime()), new Timestamp(System.currentTimeMillis()));
            Serializable id = baseDao.save(posOfOrderTrack2);
            System.out.println(Utils.getLogFix() + "PosOfOrderTrack upload:" + posOfOrderTrack.getOrderNum() + "," + id);
        } catch (ParseException e) {
            System.out.println(Utils.getLogFix() + "PosOfOrderTrack time format error!" + posOfOrderTrack.getTime());
            resp.setCode(Constants.PARAM_ERR_RESP);
            resp.setDesc(Constants.PARAM_ERR_DESC_RESP);
            return resp;
        }

        return resp;
    }
}
