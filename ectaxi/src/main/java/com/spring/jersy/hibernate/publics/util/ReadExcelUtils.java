package com.spring.jersy.hibernate.publics.util;

import com.spring.jersy.hibernate.model.entity.Carinfo;
import com.spring.jersy.hibernate.model.entity.Driver;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 读取Excel
 *
 * @author zengwendong
 */
public class ReadExcelUtils {
    private Logger LOGGER = LoggerFactory.getLogger(ReadExcelUtils.class);
    private Workbook wb;
    private Sheet sheet;
    private Row row;

    public ReadExcelUtils(String filepath) {
        if (filepath == null) {
            return;
        }
        String ext = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filepath);
            if (".xls".equals(ext)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException", e);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
    }

    public static void main(String[] args) {
        try {
            String filepath = "d:\\driver001.xls";
            ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

            // 对读取Excel表格内容测试
            Map<Integer, Map<Integer, Object>> map = excelReader.readExcelContent();
            //System.out.println("获得Excel表格的内容:");

            readDriver(map);
            //            for (int i = 1; i <= map.size(); i++) {
            //                //System.out.println("第"+i+"行："+map.get(i));
            ////                //System.out.println(map.get(i).size());
            //                for (int j=0;j<map.get(i).size();j++){
            //                    System.out.print("第"+j+"列："+map.get(i).get(j).toString()+", ");
            //                }
            //                //System.out.println();
            //            }
            //            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Driver> readDriver(Map<Integer, Map<Integer, Object>> map) {
        List<Driver> list = new ArrayList<Driver>();
        Driver driver = null;

        for (int i = 1; i <= map.size(); i++) {
            int index = 0;
            //            //System.out.println("第"+i+"行："+map.get(i));
            driver = new Driver();
            driver.setName(map.get(i).get(index++).toString());
            driver.setAccount(map.get(i).get(index++).toString());
            driver.setSex(S.SEX_MAP.get(map.get(i).get(index++).toString()));
            driver.setPhone(map.get(i).get(index++).toString());
            driver.setKabnum(map.get(i).get(index++).toString());
            driver.setCompany(map.get(i).get(index++).toString());
            driver.setCreatetime(new Date());
            driver.setIsonline(0);
            driver.setMsid(driver.getPhone());
            driver.setPwd("123456");
            driver.setIsstop(0);
            list.add(driver);
        }

        return list;
    }

    public static List<Carinfo> readCarinfo(Map<Integer, Map<Integer, Object>> map) {
        List<Carinfo> list = new ArrayList<Carinfo>();
        Carinfo carinfo;

        for (int i = 1; i <= map.size(); i++) {
            int index = 0;
            //            //System.out.println("第"+i+"行："+map.get(i));
            carinfo = new Carinfo();
            carinfo.setKabnum(map.get(i).get(index++).toString());
            carinfo.setCompany(map.get(i).get(index++).toString());
            carinfo.setVehicleid(map.get(i).get(index++).toString());
            carinfo.setMileage(Double.parseDouble(map.get(i).get(index++).toString()));
            carinfo.setModels(map.get(i).get(index++).toString());
            carinfo.setDisplacement(Double.parseDouble(map.get(i).get(index++).toString()));
            try {
                carinfo.setYearcareful(com.spring.jersy.hibernate.publics.util.DateUtil.stringToDate(map.get(i)
                        .get(index++)
                        .toString(), "yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(carinfo);
        }
        //        //System.out.println(list);
        return list;
    }

    /**
     * 读取Excel表格表头的内容
     *
     * @param //InputStream
     * @return String 表头内容的数组
     * @author zengwendong
     */
    public String[] readExcelTitle() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        //System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            // title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = row.getCell(i).getCellFormula();
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     *
     * @param //InputStream1
     * @return Map 包含单元格数据内容的Map对象
     * @author zengwendong
     */
    public Map<Integer, Map<Integer, Object>> readExcelContent() throws Exception {
        if (wb == null) {
            throw new Exception("Workbook对象为空！");
        }
        Map<Integer, Map<Integer, Object>> content = new HashMap<Integer, Map<Integer, Object>>();

        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer, Object> cellValue = new HashMap<Integer, Object>();
            while (j < colNum) {
                Object obj = getCellFormatValue(row.getCell(j));
                cellValue.put(j, obj);
                j++;
            }
            content.put(i, cellValue);
        }
        return content;
    }

    /**
     * 根据Cell类型设置数据
     *
     * @param cell
     * @return
     * @author zengwendong
     */
    private Object getCellFormatValue(Cell cell) {
        Object cellvalue ;
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        cellvalue = cell.getDateCellValue() + "";
                    } else {
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        cellvalue = cell.getStringCellValue();
                    }
                    break;// 如果当前Cell的Type为NUMERIC
                }
                case Cell.CELL_TYPE_FORMULA: {
                    cellvalue = cell.getCellFormula();
                    break;
                }
                case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:// 默认的Cell值
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

}