package com.speedtalk.smartkab.ws;

import com.speedtalk.smartkab.ws.dao.BaseDao;
import com.speedtalk.smartkab.ws.db.TbPrice;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;

public class PriceCalculator {
    public static final String UNKNOWN = "未知";
    private static PriceCalculator instance = new PriceCalculator();
    private BaseDao dao = new BaseDao();

    private PriceCalculator() {
    }

    public static PriceCalculator getInstance() {
        if (null == instance)
            instance = new PriceCalculator();
        return instance;
    }

    public static void main(String[] args) {
        System.out.println((4000f - 1400f) / 1000f);
        System.out.println((4000 - 1400) / 1000);
        float price = 0.0f;
        price += 4 + (4000f - 1400f) / 1000f * 1.6 + ((5784 - 4000f) / 1000f) * 2.3;
        System.out.println(price);
        // if ((4000 - 1400) % 1000 > 0)
        //     price += 1.6;
        // System.out.println(price);
        // if ((5784 - 4000) % 1000 > 0)
        //     price += 2.3;
        System.out.println(price);
        System.out.println(String.format("%.2f", price));
        price = 1.6f;
        price = Math.round(price);
        System.out.println(String.format("%.2f", price));
    }

    public String calPrice(String cityName, int meter) throws NullPointerException, IllegalArgumentException {
        if (null == cityName || cityName.trim().equals(""))
            throw new NullPointerException("cityName is null!");
        if (meter < 0)
            throw new IllegalArgumentException("meter error!");
        DetachedCriteria dc = DetachedCriteria.forClass(TbPrice.class);
        dc.add(Restrictions.eq("city", cityName));
        TbPrice tbPrice = (TbPrice) dao.findObjByDetachedCriteria(dc);
        if (null == tbPrice) {
            System.out.println(Utils.getLogFix() + "获取不到城市计价记录:" + cityName);
            return UNKNOWN;
        } else {
            boolean isNight = isNight(tbPrice);
            /**
             * 不足起步公里数
             */
            if (meter <= tbPrice.getInitialmeter()) {
                if (isNight)
                    return tbPrice.getNightinitialprice().toString();
                else
                    return tbPrice.getDayinitialprice().toString();
            }
            /**
             * 是否有加价公里数
             */
            boolean isHigh = false;
            if (tbPrice.getHighpricemeter() > 0 && meter > tbPrice.getHighpricemeter())
                isHigh = true;
            float price = 0.0f;
            if (isNight) {
                if (isHigh) {
                    /**
                     * 起步价 + (远程里程标准 - 起步里程数) * 每公里单价
                     * + (里程数 - 远程里程标准) * 远程每公里单价
                     */
                    price += tbPrice.getNightinitialprice() + (((tbPrice.getHighpricemeter() - tbPrice.getInitialmeter())) / tbPrice
                            .getNightincreasemeter()) * tbPrice.getNightincreaseprice() + ((meter - tbPrice.getHighpricemeter()) / tbPrice
                            .getNightincreasemeter()) * tbPrice.getNighthighprice();
                    System.out.println("-----night->high---------");
                } else {
                    /**
                     * 	起步价 + (里程数 - 起步里程数) * 每公里单价
                     */
                    price += tbPrice.getNightinitialprice() + ((meter - tbPrice.getInitialmeter()) / tbPrice.getNightincreasemeter()) * tbPrice
                            .getNightincreaseprice();
                    System.out.println("-----night---------");
                }
            } else {
                if (isHigh) {
                    /**
                     * 起步价 + (远程里程标准 - 起步里程数) * 每公里单价
                     * + (里程数 - 远程里程标准) * 远程每公里单价
                     */
                    price += tbPrice.getDayinitialprice() + (((tbPrice.getHighpricemeter() - tbPrice.getInitialmeter())) / tbPrice
                            .getDayincreasemeter()) * tbPrice.getDayincreaseprice() + ((meter - tbPrice.getHighpricemeter()) / tbPrice
                            .getDayincreasemeter()) * tbPrice.getDayhighprice();
                    System.out.println("-----day->high---------");
                } else {
                    /**
                     * 	起步价 + (里程数 - 起步里程数) * 每公里单价
                     */
                    price += tbPrice.getDayinitialprice() + ((meter - tbPrice.getInitialmeter()) / tbPrice.getDayincreasemeter()) * tbPrice
                            .getDayincreaseprice();
                    System.out.println("-----day---------");
                }
            }
            price = Math.round(price);
            return String.format("%.2f", price);
        }
    }

    private boolean isNight(TbPrice tbPrice) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour < tbPrice.getNightend() || hour > tbPrice.getNightinitial())
            return true;
        else
            return false;
    }
}
