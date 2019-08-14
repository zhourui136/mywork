package com.excel.infra.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhourui
 */
@Slf4j
public class PoiUtils {
    public static List<String[]> readExcel(String sourceFilePath) throws Exception {
        Workbook workbook = null;

        try {
            workbook = getReadWorkBookType(sourceFilePath);
            List<String[]> contents = new ArrayList<String[]>();

            //获取第一个sheet
            Sheet sheet = workbook.getSheetAt(0);
            //第0行是表名，忽略，从第二行开始读取
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }
                //获得当前行的开始列
                int firstCellNum = row.getFirstCellNum();
                //获得当前行的列数
                int lastCellNum = row.getPhysicalNumberOfCells();
                String[] cells = new String[row.getPhysicalNumberOfCells()];
                //循环当前行
                for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    cells[cellNum] = getCellStringVal(cell);
                }
                contents.add(cells);
            }
            return contents;
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }

    private static String getCellStringVal(Cell cell) {
        String cellValue = "";
        if(cell == null){
           return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
           cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
           case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
               break;
           case Cell.CELL_TYPE_BLANK: //空值
               cellValue = "";
                break;
           case Cell.CELL_TYPE_ERROR: //故障
              cellValue = "非法字符";
                break;
           default:
               cellValue = "未知类型";
               break;
             }
       return cellValue;
    }

    private static Workbook getReadWorkBookType(String filePath) throws Exception {
        //xls-2003, xlsx-2007
        FileInputStream is = null;
        is = new FileInputStream(filePath);
        if (filePath.toLowerCase().endsWith("xlsx")) {
            return new XSSFWorkbook(is);
        } else if (filePath.toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook(is);
        }
        return null;
    }
}
