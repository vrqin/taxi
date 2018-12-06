package com.speedtalk.smartkab.score.ws.res;

import com.speedtalk.protocol.utils.DateUtils;
import com.speedtalk.smartkab.score.ws.dao.BaseDao;
import com.speedtalk.smartkab.score.ws.dao.DriverScoreDao;
import com.speedtalk.smartkab.score.ws.dao.PassengerScoreDao;
import com.speedtalk.smartkab.score.ws.db.TabDriverScore;
import com.speedtalk.smartkab.score.ws.db.TabPassengerScore;
import com.speedtalk.smartkab.score.ws.domain.ScoreHis;
import com.speedtalk.smartkab.ws.Constants;
import com.speedtalk.smartkab.ws.domain.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("score")
public class ScoreResource {
    private static final Logger LOG = Logger.getLogger(ScoreResource.class.getName());
    private DriverScoreDao driverScoreDao = new DriverScoreDao();
    private PassengerScoreDao passengerScoreDao = new PassengerScoreDao();
    private BaseDao baseDao = new BaseDao();

    @GET
    @Path("driver")
    @Produces("application/json;charset=utf-8")
    public Response getDrivers(@QueryParam("account") final String account) {
        Response resp = new Response(Constants.SUCCESS_RESP, "0");
        try {
            TabDriverScore score = driverScoreDao.getByAccount(account);
            resp.setDesc(String.valueOf(score.getScore()));
            resp.setCode(Constants.SUCCESS_RESP);
            LOG.info(account + " get driver's score " + score.getScore());
        } catch (Exception e) {
            LOG.info(account + " get driver's score failure!");
        }
        return resp;
    }

    @GET
    @Path("passer")
    @Produces("application/json;charset=utf-8")
    public Response getPassers(@QueryParam("account") final String account) {
        Response resp = new Response(Constants.SUCCESS_RESP, "0");
        try {
            TabPassengerScore score = passengerScoreDao.getByAccount(account);
            resp.setDesc(String.valueOf(score.getScore()));
            resp.setCode(Constants.SUCCESS_RESP);
            LOG.info(account + " get passenger's score " + score.getScore());
        } catch (Exception e) {
            LOG.info(account + " get passenger's score failure!");
        }
        return resp;
    }

    @GET
    @Path("driverhis")
    @Produces("application/json;charset=utf-8")
    public List<ScoreHis> getDrivershis(@QueryParam("account") final String account, @QueryParam("time") final String time, @QueryParam("count") final int count) {
        List<ScoreHis> list = new ArrayList<ScoreHis>();
        ScoreHis his;
        try {
            String accountStr = BaseDao.replaceSQLKeyword(account);
            String timeStr = BaseDao.replaceSQLKeyword(time);
            int c = count > 30 ? 30 : count;
            StringBuilder sql = new StringBuilder("select ordernum,score,time,remark " + "from tab_score_records where account ='");
            sql.append(accountStr).append("' and type = 0 ");
            if (timeStr != null && !timeStr.trim().equals(""))
                sql.append(" and time < '").append(timeStr).append("'");
            sql.append(" order by time desc limit ").append(c);
            List<Object[]> tempList = baseDao.get(sql.toString());
            String temp;
            for (Object[] o : tempList) {
                try {
                    temp = null == o[3] ? "" : o[3].toString();
                    his = new ScoreHis(o[0].toString(), (int) o[1], DateUtils.getCommonTimeFormat().format(o[2]), temp);
                    list.add(his);
                } catch (Exception e) {
                }
            }
            LOG.info(account + " get score driver records! " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @GET
    @Path("passerhis")
    @Produces("application/json;charset=utf-8")
    public List<ScoreHis> getPasserhis(@QueryParam("account") final String account, @QueryParam("time") final String time, @QueryParam("count") final int count) {
        List<ScoreHis> list = new ArrayList<>();
        ScoreHis his;
        try {
            String accountStr = BaseDao.replaceSQLKeyword(account);
            String timeStr = BaseDao.replaceSQLKeyword(time);
            int c = count > 30 ? 30 : count;
            StringBuilder sql = new StringBuilder("select ordernum,score,time,remark from tab_score_records where account ='");
            sql.append(accountStr).append("' and type = 1 ");
            if (timeStr != null && !timeStr.trim().equals(""))
                sql.append(" and time < '").append(timeStr).append("'");
            sql.append(" order by time desc limit ").append(c);
            List<Object[]> tempList = baseDao.get(sql.toString());
            String temp;
            for (Object[] o : tempList) {
                try {
                    temp = null == o[3] ? "" : o[3].toString();
                    his = new ScoreHis(o[0].toString(), (int) o[1], DateUtils.getCommonTimeFormat().format(o[2]), temp);
                    list.add(his);
                } catch (Exception e) {
                }
            }
            LOG.info(account + " get score passer records! " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
