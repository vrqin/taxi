package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.*;
import com.spring.jersy.hibernate.model.service.*;
import com.spring.jersy.hibernate.publics.bean.DateCallBussReport;
import com.spring.jersy.hibernate.publics.bean.DriverCallBussReport;
import com.spring.jersy.hibernate.publics.bean.PasserCallBussReport;
import com.spring.jersy.hibernate.publics.bean.SeatCallBussReport;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.ExcelUtil;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.publics.util.Utils;
import com.spring.jersy.hibernate.resource.BaseResource;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2016/10/13.
 */

@Component
@Path("/files")
@Scope("prototype")
public class FileResource extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(FileResource.class);
    private static final String tabname = "FileResource";
    private static final String tabcontent = "导出";
    private static final String FILE_PATH = "c:\\excel-file.xls";
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
    private final SimpleDateFormat idSdf = new SimpleDateFormat("mmssSSS");
    @Context
    private HttpServletResponse response;


    @Resource
    private FileService fileService;

    @Resource
    private DriverService driverService;

    @Resource
    private ClientService clientService;

    @Resource
    private PassengerService passengerService;

    @Resource
    private PayRecordsService payRecordsService;

    @Resource
    private CallBussService callBussService;

    @Resource
    private CarinfoService carinfoService;

    @Resource
    private LogAbnormalService logAbnormalService;
    @Resource
    private LogOperationService logOperationService;

    private PayRecords payRecords;

    @GET
    @Path("/exportCarInfo")
    @Produces("application/vnd.ms-excel")
    public Response exportCarInfo(@QueryParam("key") final String key, @QueryParam("token") final String token, @QueryParam("clientid") final int clientid) {
        //88888888
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "车辆数据", clientid);
        String[] cellNames = {"车牌号码*", "所属公司*", "行驶证*", "里程*", "车型*", "排量*", "年审*"};
        Integer[] cellLen = {10, 10, 10, 10, 10, 10, 10};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<Carinfo> carinfoListc = null;
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            carinfoListc = carinfoService.findListbyKey(key, ac_clientid);
        } catch (Exception e) {
            LOGGER.error("导出车辆数据异常", e);
            logAbnormalService.savelogAbnormal(token, "导出车辆数据异常", clientid);
            e.printStackTrace();
        }
        int index = 0;
        if (!S.isNull(carinfoListc) && carinfoListc.size() > 0) {
            for (Carinfo c : carinfoListc) {
                index = 0;
                cellValue = new String[7];
                cellValue[index++] = c.getKabnum();
                cellValue[index++] = (clientService.findByid(c.getClientid())).getCompany();
                cellValue[index++] = c.getVehicleid();
                cellValue[index++] = String.valueOf(c.getMileage());
                cellValue[index++] = c.getModels();
                cellValue[index++] = String.valueOf(c.getDisplacement());
                if (!S.isNull(c.getYearcareful())) {
                    cellValue[index++] = DateUtil.dateFormatStr("yyyy-MM-dd HH:mm:ss", c.getYearcareful());

                }
                cellValueList.add(cellValue);
            }
        }

        return exportExcelFile("车辆信息", null, cellNames, cellLen, cellValueList);
    }

    //导出电召单
    @GET
    @Path("/exportOrderdetails")
    @Produces("application/vnd.ms-excel")
    public Response exportOrderdetails(@QueryParam("key") final String key, @QueryParam("token") final String token, @QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("sort") final String sort, @QueryParam("order") final String order, @QueryParam("status") final Integer status, @QueryParam("type") final Integer type, @QueryParam("ordertype") final Integer ordertype, @QueryParam("msid") final String msid, @QueryParam("clientid") final int clientid) {
        //88888888
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "车辆数据", clientid);
        String[] cellNames = {"订单号*", "电召时间*", "乘客电话*", "起点*", "终点*", "订单类型*", "状态*", "司机名称*", "司机号码*", "车牌号*", "支付方式*", "交易金额*", "评价*", "调度人员*"};
        Integer[] cellLen = {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<Callbuss> callbusses = null;
        Integer re_type = !S.isNull(type) ? type : -1;
        Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
        String ac_msid = !S.isNull(msid) ? msid : null;
        try {
            callbusses = callBussService.findCallBuss(sort, order, key, startime, endtime, re_type, ordertype, ac_clientid, status);

        } catch (Exception e) {
            LOGGER.error("导出电召单数据异常", e);
            logAbnormalService.savelogAbnormal(token, "导出电召单数据异常", clientid);
            e.printStackTrace();
        }
        int index = 0;
        if (!S.isNull(callbusses) && callbusses.size() > 0) {
            if (!S.isNull(callbusses) && callbusses.size() > 0) {
                for (Callbuss c : callbusses) {
                    index = 0;
                    cellValue = new String[14];
                    cellValue[index++] = c.getBillid();
                    cellValue[index++] = DateUtil.dateFormatStr("yyyy-MM-dd HH:mm:ss", c.getCalltime());
                    cellValue[index++] = c.getClientmobile();
                    cellValue[index++] = c.getSrcaddr();
                    cellValue[index++] = c.getAddress();
                    cellValue[index++] = String.valueOf(Utils.type(c.getOrderType(), new String[]{"app", "微信", "电话", "电话语音"}));
                    cellValue[index++] = String.valueOf(Utils.type(c.getStatus(), new String[]{"新业务", "已下呼", "已租车", "已取消", "已完成", "附近没车"}));
                    cellValue[index++] = c.getDriver() == null ? "" : c.getDriver().getName();
                    cellValue[index++] = c.getDriverphone();
                    cellValue[index++] = c.getCarbox();
                    cellValue[index++] = String.valueOf(Utils.type(c.getPaytype(), new String[]{"现金支付", "支付宝支付", "微信支付"}));
                    cellValue[index++] = String.valueOf(c.getMoney() == null ? "" : c.getMoney());
                    cellValue[index++] = String.valueOf(c.getEvaluate() == null ? "" : c.getEvaluate());
                    cellValue[index++] = String.valueOf(c.getOpruser() == null ? "" : c.getOpruser());
                    cellValueList.add(cellValue);

                }
            }
        }

        return exportExcelFile("车辆信息", null, cellNames, cellLen, cellValueList);
    }


    //导出离线
    @GET
    @Path("/exportDriverOnOfflineCar")
    @Produces("application/vnd.ms-excel")
    public Response exportDriverOnOfflineCar(@QueryParam("kabnum") final String kabnum, @QueryParam("isonline") final Integer isonline, @QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token) {
        //88888888
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "车辆数据", clientid);
        String[] cellNames = {"车牌号码*", "驾驶员*", "所属单位*", "次数*", "驾驶时长*"};
        Integer[] cellLen = {20, 20, 20, 20, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<Driver> driverList = null;
        Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
        try {
            driverList = driverService.findListByOnOffline(kabnum, isonline, ac_clientid);
        } catch (Exception e) {
            LOGGER.error("导出离线车辆数据异常", e);
            logAbnormalService.savelogAbnormal(token, "导出离线车辆数据异常", clientid);
            e.printStackTrace();
        }
        int index = 0;
        if (!S.isNull(driverList) && driverList.size() > 0) {
            if (!S.isNull(driverList) && driverList.size() > 0) {
                for (Driver c : driverList) {
                    index = 0;
                    cellValue = new String[14];
                    cellValue[index++] = c.getKabnum();
                    cellValue[index++] = c.getName();
                    cellValue[index++] = c.getCompany();
                    cellValue[index++] = "";
                    cellValue[index++] = "";
                    cellValueList.add(cellValue);

                }
            }
        }

        return exportExcelFile("离线车辆信息", null, cellNames, cellLen, cellValueList);
    }

    @GET
    @Path("/exportDateInfo")
    @Produces("application/vnd.ms-excel")
    public Response exportDateInfo(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("token") final String token, @QueryParam("clientid") final int clientid, @QueryParam("key") final String key) {
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "电召日期数据", clientid);
        String[] cellNames = {"日期", "总电召单数", "电召未完成", "取消次数", "电召成功数"};
        Integer[] cellLen = {10, 12, 5, 12, 10, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<DateCallBussReport> driverCallBussReportList = null;
        try {
            String ac_startTime = !S.isNull(startime) ? startime : null;
            String ac_endTime = !S.isNull(endtime) ? endtime : null;
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            driverCallBussReportList = callBussService.findDateCallBuss(ac_startTime, ac_endTime, ac_clientid);
        } catch (Exception e) {
            LOGGER.error("导出电召日期统计信息异常", e);
            logAbnormalService.savelogAbnormal(token, "导出电召日期统计信息异常", clientid);

        }
        int index = 0;
        for (DateCallBussReport s : driverCallBussReportList) {
            index = 0;
            cellValue = new String[5];
            cellValue[index++] = s.getDatatime();
            cellValue[index++] = String.valueOf(s.getTotal());
            cellValue[index++] = String.valueOf(s.getUnfinish());
            cellValue[index++] = String.valueOf(s.getCancellation());
            cellValue[index++] = String.valueOf(s.getFinish());
            cellValueList.add(cellValue);
        }
        return exportExcelFile("电召日期统计信息", null, cellNames, cellLen, cellValueList);
    }

    @GET
    @Path("/exportDriver")
    @Produces("application/vnd.ms-excel")
    public Response exportDriver(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token, @QueryParam("key") final String key) {
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "司机数据", clientid);
        String[] cellNames = {"帐号", "总电召单数", "电召未完成", "取消次数", "电召成功数"};
        Integer[] cellLen = {10, 12, 5, 12, 10, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<DriverCallBussReport> driverCallBussReportList = null;
        try {
            String ac_startTime = !S.isNull(startime) ? startime : null;
            String ac_endTime = !S.isNull(endtime) ? endtime : null;
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            driverCallBussReportList = callBussService.findDriverCallBuss(ac_startTime, ac_endTime, ac_clientid);
        } catch (Exception e) {
            LOGGER.error("导出司机统计信息异常", e);
            logAbnormalService.savelogAbnormal(token, "导出司机统计信息异常", clientid);

        }
        int index = 0;
        for (DriverCallBussReport s : driverCallBussReportList) {
            index = 0;
            cellValue = new String[5];
            cellValue[index++] = s.getDrivername();
            cellValue[index++] = String.valueOf(s.getTotal());
            cellValue[index++] = String.valueOf(s.getUnfinish());
            cellValue[index++] = String.valueOf(s.getCancellation());
            cellValue[index++] = String.valueOf(s.getFinish());
            cellValueList.add(cellValue);
        }
        return exportExcelFile("司机统计信息", null, cellNames, cellLen, cellValueList);
    }

    @GET
    @Path("/exportPasserInfo")
    @Produces("application/vnd.ms-excel")
    public Response exportPasserInfo(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("token") final String token, @QueryParam("key") final String key, @QueryParam("clientid") final Integer clientid) {
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "乘客数据", clientid);
        String[] cellNames = {"帐号", "总电召单数", "电召未完成", "取消次数", "电召成功数"};
        Integer[] cellLen = {10, 12, 5, 12, 10, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<PasserCallBussReport> passerCallBussReportList = null;
        try {
            String ac_startTime = !S.isNull(startime) ? startime : null;
            String ac_endTime = !S.isNull(endtime) ? endtime : null;
            Integer ac_clientid = !S.isNull(clientid) ? clientid : 0;
            passerCallBussReportList = callBussService.findPasserCallBuss(ac_startTime, ac_endTime, ac_clientid);
        } catch (Exception e) {
            LOGGER.error("导出乘客统计信息异常", e);
            logAbnormalService.savelogAbnormal(token, "导出乘客统计信息异常", clientid);

        }
        int index = 0;
        for (PasserCallBussReport s : passerCallBussReportList) {
            index = 0;
            cellValue = new String[5];
            cellValue[index++] = s.getOpruser();
            cellValue[index++] = String.valueOf(s.getTotal());
            cellValue[index++] = String.valueOf(s.getUnfinish());
            cellValue[index++] = String.valueOf(s.getCancellation());
            cellValue[index++] = String.valueOf(s.getFinish());
            cellValueList.add(cellValue);
        }
        return exportExcelFile("乘客统计信息", null, cellNames, cellLen, cellValueList);
    }

    @GET
    @Path("/exportSeatInfo")
    @Produces("application/vnd.ms-excel")
    public Response exportSeatInfo(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("clientid") final Integer clientid, @QueryParam("token") final String token, @QueryParam("key") final String key) {
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "坐席数据", clientid);
        String[] cellNames = {"帐号", "坐席人员名称", "总电召单数", "电召未完成", "取消次数", "电召成功数"};
        Integer[] cellLen = {10, 12, 5, 12, 10, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<SeatCallBussReport> seatCallBussReportList = null;
        try {
            String ac_startTime = !S.isNull(startime) ? startime : null;
            String ac_endTime = !S.isNull(endtime) ? endtime : null;
            Integer re_clientid = !S.isNull(clientid) ? clientid : 0;
            seatCallBussReportList = callBussService.findSeatCallBuss(ac_startTime, ac_endTime, re_clientid);
        } catch (Exception e) {
            LOGGER.error("导出坐席统计信息异常", e);
            logAbnormalService.savelogAbnormal(token, "导出坐席统计信息异常", clientid);

        }
        int index = 0;
        for (SeatCallBussReport s : seatCallBussReportList) {
            index = 0;
            cellValue = new String[6];
            cellValue[index++] = s.getOpruser();
            cellValue[index++] = s.getName();
            cellValue[index++] = String.valueOf(s.getTotal());
            cellValue[index++] = String.valueOf(s.getUnfinish());
            cellValue[index++] = String.valueOf(s.getCancellation());
            cellValue[index++] = String.valueOf(s.getFinish());
            cellValueList.add(cellValue);
        }
        return exportExcelFile("坐席统计信息", null, cellNames, cellLen, cellValueList);
    }

    @GET
    @Path("/exportPassengerInfo")
    @Produces("application/vnd.ms-excel")
    public Response exportPassengerInfo(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("token") final String token, @QueryParam("key") final String key, @QueryParam("clientid") final Integer clientid) {
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "乘客数据", clientid);
        String[] cellNames = {"乘客名称", "电话号码", "注册时间",};
        Integer[] cellLen = {10, 12, 5, 12, 10, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<Passenger> passengerList = null;
        try {
            String ac_startTime = !S.isNull(startime) ? startime : null;
            String ac_endTime = !S.isNull(endtime) ? endtime : null;
            passengerList = passengerService.findAllList(ac_startTime, ac_endTime);
        } catch (Exception e) {
            LOGGER.error("导出乘客信息异常", e);
            logAbnormalService.savelogAbnormal(token, "导出乘客信息异常", clientid);

        }
        int index = 0;
        for (Passenger passenger : passengerList) {
            index = 0;
            cellValue = new String[3];
            cellValue[index++] = passenger.getName();
            cellValue[index++] = passenger.getMobile();
            cellValue[index++] = String.valueOf(passenger.getCreatedate());
            cellValueList.add(cellValue);
        }
        return exportExcelFile("乘客信息", null, cellNames, cellLen, cellValueList);
    }

    @GET
    @Path("/exportDriverInfo")
    @Produces("application/vnd.ms-excel")
    public Response exportDriverInfo(@QueryParam("startime") final String startime, @QueryParam("endtime") final String endtime, @QueryParam("isstop") final Integer isstop, @QueryParam("key") final String key, @QueryParam("token") final String token, @QueryParam("clientid") final int clientid, @QueryParam("isonline") final Integer isonline) {
        logOperationService.savelogOperation(token, OPERATION_OUT, OPERATION_OUT_NAME + ":" + tabcontent + "司机数据", clientid);
        String[] cellNames = {"司机名称*", "登录帐号*", "性别*", "联系电话*", "车牌号*", "所在公司*",};
        Integer[] cellLen = {10, 12, 5, 12, 10, 20};
        List<String[]> cellValueList = new ArrayList<String[]>();
        String[] cellValue = null;
        Integer temp = null;
        List<Driver> driverList = null;
        try {
            int ac_clientid = !S.isNull(clientid) ? clientid : 0;
            driverList = driverService.findAllList(key, isstop, isonline, startime, endtime, ac_clientid);
        } catch (Exception e) {
            LOGGER.error("导出司机数据异常", e);
            logAbnormalService.savelogAbnormal(token, "导出司机数据异常", clientid);
            e.printStackTrace();
        }
        int index = 0;
        if (!S.isNull(driverList) && driverList.size() > 0) {
            for (Driver driver : driverList) {
                index = 0;
                cellValue = new String[6];
                cellValue[index++] = driver.getName();
                cellValue[index++] = driver.getAccount();
                cellValue[index++] = S.getKeyByValue(driver.getSex(), S.SEX_MAP);
                cellValue[index++] = driver.getPhone();
                cellValue[index++] = driver.getKabnum();
                cellValue[index++] = (clientService.findByid(driver.getClientid())).getCompany();
                cellValueList.add(cellValue);
            }
        }

        return exportExcelFile("司机信息", null, cellNames, cellLen, cellValueList);
    }


    @POST
    @Path("/importDriver")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response importDriver(@FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = null;
        //System.out.println(uploadedInputStream);
        //System.out.println(fileDetail);


        try {
            name = URLDecoder.decode(fileDetail.getFileName(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //System.out.println("---------------------");
        try {
            Workbook workbook = new HSSFWorkbook(uploadedInputStream);
            //System.out.println(workbook);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //System.out.println("---------------------");

        //        LOGGER.info("[" + getUserName() + "]正在导入司机信息!");
        //        try {
        //            File[] files = null;
        //            if (!S.isNull(files)&&files.length>0){
        //                String filename = name;
        //                String ext = filename.substring(filename.indexOf(".") + 1);
        //                FileInputStream is = new FileInputStream(files[0]);
        //                Workbook workbook = null;
        //                if (ext.equals("xls")) {
        //                    workbook = new HSSFWorkbook(is);
        //                } else {
        //                    LOGGER.info("导入司机信息的文件格式不对");
        ////                    showMassage("您导入的文件格式不对,请先下载模版,填写后再导入！");
        //                    return null;
        //                }
        //                List<Driver> exportDriverList= readDriver(workbook);//待导入司机信息
        //                StringBuffer repeatAccount = new StringBuffer();
        //                StringBuffer repeatMessage = new StringBuffer("请修改重复的数据后再导入：\n");
        //                int repeatLen = repeatMessage.toString().length();
        //                int importCount = 0;
        //                try {
        //                    for (Driver driver :exportDriverList){
        //                        System.out.println(driver.toString());
        //                        if (S.isNull(driverService.findByName(driver.getAccount()))){
        //                            driverService.save(driver);
        //                            importCount++;
        //                        }else{
        //                            repeatAccount.append(driver.getAccount()).append(",");
        //                        }
        //
        //
        //                    }
        //                    System.out.println(repeatAccount.toString());
        //                    if (repeatAccount.toString().length() > 0){
        //                        System.out.println(repeatAccount.toString());
        //                        repeatMessage.append("司机登录帐号：").append(repeatAccount.toString())
        //                                .append("\n");
        //
        ////                        showMassage(repeatMessage.toString());
        //                    }else {
        ////                        showMassage("成功导入" + importCount + "名司机信息！");
        //                    }
        //
        //                } catch (Exception e) {
        ////                    showMassage("导入司机信息失败,请仔细检查导入文件的数据！");
        //                    LOGGER.error("处理重复数据异常：",e);
        //                    return null;
        //                }
        //
        //            } else {
        //                LOGGER.info("导入司机信息失败!");
        ////                showMassage("导入司机信息失败,请仔细检查导入文件的数据！");
        //                return null;
        //            }
        //        }catch (Exception e){
        //            LOGGER.error("导入司机信息失败：",e);
        //            return null;
        //        }
        return null;
    }

    public List<Driver> readDriver(Workbook workbook) {
        List<Driver> list = new ArrayList<Driver>();
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat excelSdf = new SimpleDateFormat("yyyy/MM/dd");
        Row row = null;
        Cell cell = null;
        Driver driver = null;
        Date birthDate = null, entryDate = null, workDate = null;
        String temp = null;
        int index = 0;
        for (int i = 1; i < rows; i++) {
            index = 0;
            driver = new Driver();
            row = sheet.getRow(i);
            //            index++;
            driver.setName(ExcelUtil.dealWithCell(row.getCell(index++)));
            driver.setAccount(ExcelUtil.dealWithCell(row.getCell(index++)));
            driver.setSex(S.SEX_MAP.get(ExcelUtil.dealWithCell(row.getCell(index++))));
            driver.setPhone(ExcelUtil.dealWithCell(row.getCell(index++)));
            driver.setKabnum(ExcelUtil.dealWithCell(row.getCell(index++)));
            driver.setCompany(ExcelUtil.dealWithCell(row.getCell(index++)));

            driver.setCreatetime(new Date());
            driver.setIsonline(0);
            driver.setMsid(driver.getPhone());
            driver.setPwd("123456");
            driver.setIsstop(0);
            list.add(driver);
        }
        return list;
    }

    public void inputstreamtofile(InputStream ins, File file) throws IOException {
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();

    }


    /**
     * 导入模版
     * @return
     */
    /**
     * 导入模版
     *
     * @return
     */
    @GET
    @Path("/carinfoTemplate")
    @Produces("application/vnd.ms-excel")
    public Response carinfoTemplate() {
        String[] cellNames = {"车牌号码*", "所属公司*", "行驶证*", "里程*", "车型*", "排量*", "年审*"};
        Integer[] cellLen = {10, 10, 10, 10, 10, 10, 10};
        String[] exapmleValues = {"粤A123456", "speedtalk", "ABC123456", "55.5", "小型车", "88.8", "2016-11-11 11:11:11"};

        ArrayList<String> list = new ArrayList<String>();
        list.add("注意：");
        list.add("1、带星号为必填");
        list.add("2、车牌号和行驶证号码不能重复！");
        list.add("3、年审时间不能为空！");
        //        list.add("3、司机名称请用“姓+师傅”，例如：陈师傅  ");


        return staticTemplate("车辆信息模板.xls", "车辆信息", cellNames, cellLen, "说明", exapmleValues, list);
    }

    @GET
    @Path("/driverTemplate")
    @Produces("application/vnd.ms-excel")
    public Response driverTemplate() {
        String[] cellNames = {"司机名称*", "登录帐号*", "性别*", "联系电话*", "车牌号*", "所在公司*",};
        Integer[] cellLen = {10, 12, 5, 12, 10, 20};
        String[] exapmleValues = {"李师傅", "13700000000", "男", "13700000000", "粤A1234", "广东喜洋洋出租车公司"};

        ArrayList<String> list = new ArrayList<String>();
        list.add("注意：");
        list.add("1、带星号为必填");
        list.add("2、司机登录电话号码不能重复！");
        list.add("3、司机名称请用“姓+师傅”，例如：陈师傅  ");


        return staticTemplate("司机信息模板.xls", "司机信息", cellNames, cellLen, "说明", exapmleValues, list);
    }


    /**
     * 生成静态模板
     *
     * @param templateName 生成的模板文件名称
     * @param sheetName    模板工作簿名称,为空时，使用templateName
     * @param cellNames    数据列名称   与cellLen个数一致
     * @param cellLen      数据列长度   与cellNames个数一致
     * @param tipSheetName 示例sheet名称
     * @param exampleValue 示例数值
     * @param tipsStr      添加到示例sheet的说明
     * @return
     */
    public Response staticTemplate(String templateName, String sheetName, String[] cellNames, Integer[] cellLen, String tipSheetName, String[] exampleValue, List<String> tipsStr) {

        try {
            //            LOGGER.info("【" + + "】正在导出【" + templateName +"】!");

            //处理文件名
            this.fileName = sdf.format(new Date()) + "-" + templateName + ".xls";


            //创建一个excel工作簿
            HSSFWorkbook wb = new HSSFWorkbook();

            //创建一个工作表(只有表头)
            HSSFSheet sheet = wb.createSheet((null == sheetName || sheetName.trim()
                    .equals("")) ? templateName : sheetName);
            ExcelUtil.setRowLength(sheet, cellLen);
            ExcelUtil.findCell(wb, sheet, cellNames);

            if (tipSheetName != null && !tipSheetName.trim().equals("")) {
                //创建一个示例(有表头和一行数据)
                HSSFSheet tipSeet = wb.createSheet(tipSheetName);
                //设置第一行的值
                ExcelUtil.setFirstRowValues(tipSeet, exampleValue);

                try {
                    //写说明
                    ExcelUtil.setSheetTips(tipSeet, tipsStr, 1, 3);
                } catch (Exception e) {
                }

                ExcelUtil.setRowLength(tipSeet, cellLen);
                ExcelUtil.findCell(wb, tipSeet, cellNames);
            }

            //输出
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            wb.write(output);
            excelFile = new ByteArrayInputStream(output.toByteArray());
            output.flush();
            output.close();
            String fileName2 = URLEncoder.encode(templateName, "UTF-8");
            Response.ResponseBuilder response = Response.ok((Object) excelFile);
            response.header("Content-Disposition", "attachment; filename=" + fileName2);
            return response.build();

        } catch (Exception e) {
            LOGGER.error("导出【" + templateName + "】异常:", e);
            return null;
        }
    }


    /**
     * 导出Excel文件
     *
     * @param fileName
     * @param sheetName
     * @param cellNames
     * @param cellLen
     * @param cellValueList
     * @return
     */
    public Response exportExcelFile(String fileName, String sheetName, String[] cellNames, Integer[] cellLen, List<String[]> cellValueList) {
        try {
            //            LOGGER.info("【" + getUserName() + "】正在导出文件【" + fileName +"】!");

            //处理文件名
            this.fileName = sdf.format(new Date()) + "-" + fileName + ".xls";


            //创建一个excel工作簿
            HSSFWorkbook wb = new HSSFWorkbook();

            //创建一个工作表(只有表头)
            HSSFSheet sheet = wb.createSheet((null == sheetName || sheetName.trim().equals("")) ? fileName : sheetName);
            ExcelUtil.setRowLength(sheet, cellLen);
            ExcelUtil.findCell(wb, sheet, cellNames);
            int cells = cellValueList.size();
            for (int i = 0; i < cells; i++)
                ExcelUtil.setRowValue(sheet, i + 1, cellValueList.get(i));
            //输出
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            wb.write(output);
            excelFile = new ByteArrayInputStream(output.toByteArray());
            output.flush();
            output.close();

            Response.ResponseBuilder response = Response.ok((Object) excelFile);
            String fileName2 = URLEncoder.encode(this.fileName, "UTF-8");
            response.header("Content-Disposition", "attachment; filename=" + fileName2);
            return response.build();
        } catch (Exception e) {
            LOGGER.error("导出文件【" + fileName + "】异常:", e);
            return null;
        }

    }


}
