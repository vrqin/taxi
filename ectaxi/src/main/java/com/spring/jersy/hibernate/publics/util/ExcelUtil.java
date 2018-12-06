package com.spring.jersy.hibernate.publics.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by sky on 15-9-28
 */
public class ExcelUtil {
    /**
     * 导入功能使用,处理单元格,把单元格中的内容转换成字符串
     *
     * @param cell 单元格的内容
     * @return 相应的字符串
     */
    public static String dealWithCell(Cell cell) {
        String value = null;
        if (S.isNull(cell))
            return "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_FORMULA:
                value = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    value = cell.getDateCellValue() + "";
                } else {
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    value = cell.getStringCellValue();
                }
                break;
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
        }
        return value;
    }

    /**
     * 导入功能使用,处理单元格,把单元格中的内容转换成字符串
     *
     * @param cell 单元格的内容
     * @param sdf  单元格中日期转换格式
     * @return 相应的字符串
     */
    public static String dealWithCell(Cell cell, SimpleDateFormat sdf) {
        String value = null;
        if (S.isNull(cell))
            return "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_FORMULA:
                value = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    value = (null == cell.getDateCellValue() || cell.getDateCellValue()
                            .toString()
                            .trim()
                            .equals("")) ? "" : sdf.format(cell.getDateCellValue());
                } else {
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    value = cell.getStringCellValue();
                }
                break;
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
        }
        return value;
    }


    /**
     * excel格式处理标题
     *
     * @param wb      excel文件
     * @param sheet   工作表
     * @param headers 标题
     */
    public static void findCell(HSSFWorkbook wb, HSSFSheet sheet, String[] headers) {
        HSSFRow headRow = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle(); // 创建单元格样式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置样式为居中显示

        HSSFFont headfont = wb.createFont();
        headfont.setFontName("黑体");
        headfont.setFontHeightInPoints((short) 10);        // 字体大小
        headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
        style.setFont(headfont);

        HSSFCell cell = null;
        for (int i = 0; i < headers.length; i++) {
            cell = headRow.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(headers[i]);

        }
    }

    /**
     * @param sheet      在这个sheet里面创建单元格
     * @param cellLength 单元格长度的数组,这个数组的长度就是每行需要创建的单元格个数,里面的每个值就是每个单元格的长度
     */
    public static void setRowLength(HSSFSheet sheet, Integer[] cellLength) {
        if (!S.isNull(cellLength)) {
            for (int i = 0; i < cellLength.length; i++) {
                sheet.setColumnWidth(i, cellLength[i] * 2 * 256);
            }
        }
    }

    /**
     * @param sheet  在这个sheet里面创建单元格
     * @param values 单元格需要设置的值,它的长度需要和sheet里创建的单元格列数相等
     */
    public static void setFirstRowValues(HSSFSheet sheet, String[] values) {
        //        HSSFRow row = sheet.createRow(1);
        //        for (int i = 0; i < values.length; i++) {
        //            row.createCell(i).setCellValue(values[i]);
        //        }
        setRowValue(sheet, 1, values);
    }

    /**
     * @param sheet
     * @param row
     * @param values
     */
    public static void setRowValue(HSSFSheet sheet, int row, String[] values) {
        try {
            int valueLen = values.length;
            HSSFRow hssfRow = sheet.createRow(row);
            for (int i = 0; i < valueLen; i++)
                hssfRow.createCell(i).setCellValue(values[i]);
        } catch (Exception e) {
        }
    }

    /**
     * @param sheet    为这个sheet里添加说明
     * @param tips     说明内容的集合,需要换行则加入新的一个元素即可
     * @param rowledge 表示每个说明应该隔几行(一般type==2)
     * @param startRow 表示从第几行开始(一般follow==2)
     */
    public static void setSheetTips(HSSFSheet sheet, List<String> tips, Integer rowledge, Integer startRow) {
        for (int i = 0; i < tips.size(); i++) {
            HSSFRow row = sheet.createRow(i * rowledge + startRow);
            row.createCell(0).setCellValue(tips.get(i));
        }
    }

    public static Date dealDate(String value) {
        if (!value.equals("")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
                return sdf.parse(value);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }
}
