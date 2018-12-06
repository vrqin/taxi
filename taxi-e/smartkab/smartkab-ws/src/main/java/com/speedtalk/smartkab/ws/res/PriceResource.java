package com.speedtalk.smartkab.ws.res;

import com.speedtalk.smartkab.ws.*;
import com.speedtalk.smartkab.ws.dao.BaseDao;
import com.speedtalk.smartkab.ws.dao.DriverDao;
import com.speedtalk.smartkab.ws.dao.UserDao;
import com.speedtalk.smartkab.ws.db.TabDriver;
import com.speedtalk.smartkab.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.ws.domain.Paramter;
import com.speedtalk.smartkab.ws.domain.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("price")
public class PriceResource {
    private BaseDao baseDao;
    private UserDao userDao;
    private DriverDao driverDao;

    public PriceResource() {
        baseDao = new BaseDao();
        userDao = new UserDao();
        driverDao = new DriverDao();
    }

    @GET
    @Produces("application/json;charset=utf-8")
    public Response getPrice(@QueryParam("account") final String account, @QueryParam("srccity") final String srccity, @QueryParam("dstcity") final String dstcity, @QueryParam("src") final String src, @QueryParam("dst") final String dst, @QueryParam("srclg") final String srclg, @QueryParam("srclt") final String srclt, @QueryParam("dstlg") final String dstlg, @QueryParam("dstlt") final String dstlt, @QueryParam("coordtype") final String coordtype) {
        System.out.println(Utils.getLogFix() + account + "获取价格!srccity:" + srccity + ",dstcity:" + dstcity + ",src:" + src + ",dst:" + dst + ",srclg:" + srclg + ",srclt:" + srclt + ",dstlg:" + dstlg + ",dstlt:" + dstlt + ",coordtype:" + coordtype);
        Response resp = new Response((byte) 0, "");
        TabPhoneuser user = userDao.getByAccount(account);
        if (null == user) {
            resp.setCode(Constants.ACCOUNT_ERR_RESP);
            resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + "a incorrect user try to get price!" + account);
            return resp;
        }
        String apiResp = RouteMatrixRequester.getInstance().getDirectionDistance(srccity, dstcity, src, dst);
        try {
            Price price = null;
            try {
                price = RouteMatrixRequester.getInstance().getDircetionPrice(apiResp);
            } catch (Exception e) {
            }
            if (price != null && price.getStatus().equals("0") && price.getType().equals("2")) {
                // Calendar cal = Calendar.getInstance();
                // int hour = cal.get(Calendar.HOUR_OF_DAY);
                /**
                 * 未区别白天夜晚,返回白天价格
                 */
                resp.setDesc(price.getDayPrice());
                System.out.println(Utils.getLogFix() + account + " 获取价格数据:" + price.toString() + " 返回价格:" + resp.getDesc());
                return resp;
            } else {
                apiResp = RouteMatrixRequester.getInstance()
                        .getDirectionDistance(srccity, dstcity, srclt, srclg, dstlt, dstlg, coordtype);
                try {
                    /**
                     * 同一个起点终点,有的按地点名称获取不到价格,再按坐标可能获取到价格。
                     * 这里尝试按坐标能不能获取到价格。
                     */
                    price = RouteMatrixRequester.getInstance().getDircetionPrice(apiResp);
                } catch (Exception e) {
                }
                if (price != null && price.getStatus().equals("0") && price.getType().equals("2")) {
                    /**
                     * 未区别白天夜晚,返回白天价格
                     */
                    resp.setDesc(price.getDayPrice());
                    System.out.println(Utils.getLogFix() + account + " 获取价格数据:" + price.toString() + " 返回价格:" + resp.getDesc());
                } else {
                    int distance = RouteMatrixRequester.getInstance().parseDirectionDistance(apiResp);
                    String priceStr = PriceCalculator.getInstance().calPrice(srccity, distance);
                    if (priceStr.equals(PriceCalculator.UNKNOWN))
                        resp.setCode(Constants.FAILURE_RESP);
                    resp.setDesc(priceStr);
                    System.out.println(Utils.getLogFix() + account + " 从百度接口获取不到价格,由系统计算价格!srccity:" + srccity + ",dstcity:" + dstcity + ",src:" + src + ",dst:" + dst + ",srclg:" + srclg + ",srclt:" + srclt + ",dstlg:" + dstlg + ",dstlt:" + dstlt + ",coordtype:" + coordtype + ",api resp:" + apiResp
                            .substring(0, 50) + "...距离(米):" + distance + ",计算出价格:" + priceStr);
                }
                return resp;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setCode(Constants.FAILURE_RESP);
            resp.setDesc(PriceCalculator.UNKNOWN);
        }
        return resp;
    }

    @GET
    @Path("param")
    @Produces("application/json;charset=utf-8")
    public Paramter getPriceParam(@QueryParam("account") final String account) {
        Paramter resp = new Paramter((byte) 0, "");
        TabDriver user = driverDao.getDriverByAccount(account);
        if (null == user) {
            resp.setCode(Constants.ACCOUNT_ERR_RESP);
            resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
            System.out.println(Utils.getLogFix() + "a incorrect user try to get price param!" + account);
            return resp;
        }
        String tempAccount = account.replaceAll("(?i)delete|(?i)select|(?i)update", "");
        //		String sql = "SELECT p.* FROM tb_price p,tab_phoneuser u,"
        //				+ "tab_client_setting s where u.opruser='" + tempAccount + "' "
        //				+ "and u.enterpriseid = s.clientid and s.priceid = p.id";
        String sql = "SELECT p.* FROM tb_price p,tab_driver d," + "tab_client_setting s where d.account='" + tempAccount + "' " + "and d.clientid = s.clientid and s.priceid = p.id";
        List<Object[]> list = baseDao.findBySql(sql);
        if (null == list || list.isEmpty()) {
            resp.setCode(Constants.NO_SET_PARAMTER);
            resp.setDesc(Constants.NO_SET_PARAMTER_DESC);
            System.out.println(Utils.getLogFix() + "没有设置价格参数！" + account);
            return resp;
        }
        resp.setNight(list.get(0)[3].toString());
        resp.setNightend(list.get(0)[4].toString());
        resp.setInimeter(list.get(0)[5].toString());
        resp.setDayiniprice(list.get(0)[6].toString());
        resp.setNightiniprice(list.get(0)[7].toString());
        resp.setDayincmeter(list.get(0)[8].toString());
        resp.setDayincprice(list.get(0)[9].toString());
        resp.setNightincmeter(list.get(0)[10].toString());
        resp.setNightincprice(list.get(0)[11].toString());
        resp.setHighpricemeter(list.get(0)[12].toString());
        resp.setDayhighprice(list.get(0)[13].toString());
        resp.setNighthighprice(list.get(0)[14].toString());
        System.out.println(Utils.getLogFix() + account + ",get price param:" + resp.toString());
        return resp;
    }
}
