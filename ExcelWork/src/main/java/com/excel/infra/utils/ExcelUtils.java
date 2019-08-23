package com.excel.infra.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.excel.listener.ExcelListener;
import com.excel.model.MultipleSheelPropety;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;

/**
 * @author zhourui
 */
public class ExcelUtils {
    private static Sheet initSheet;

    static {
        //初始化sheet
        initSheet = new Sheet(1, 0);
        initSheet.setSheetName("sheet");
        //设置自适应宽度
        initSheet.setAutoWidth(Boolean.TRUE);
    }

    /**
     * 读取少于1000行数据
     *
     * @param filePath 文件绝对路径
     * @return
     */
    public static List<Object> readLessThan1000Row(String filePath) {
        return readLessThan1000RowBySheet(filePath, null);
    }

    /**
     * 指定sheet读取文本内容
     *
     * @param filePath
     * @param sheet
     * @return
     */
    public static List<Object> readLessThan1000Row(String filePath, Sheet sheet) {
        return readLessThan1000RowBySheet(filePath, sheet);
    }

    /**
     * 读小于1000行数据, 带样式
     * filePath 文件绝对路径
     * initSheet ：
     * sheetNo: sheet页码，默认为1
     * headLineMun: 从第几行开始读取数据，默认为0, 表示从第一行开始读取
     * clazz: 返回数据List<Object> 中Object的类名
     */
    public static List<Object> readLessThan1000RowBySheet(String filePath, Sheet sheet) {
        if (!StringUtils.hasText(filePath)) {
            return null;
        }

        sheet = sheet != null ? sheet : initSheet;

        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
            return EasyExcelFactory.read(fileStream, sheet);
        } catch (FileNotFoundException e) {
            System.err.println("找不到文件或文件路径错误, 文件：" + filePath);
        } finally {
            try {
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                System.err.println("excel文件读取失败, 失败原因：" + e);
            }
        }
        return null;
    }

    /**
     * 读大于1000行数据
     *
     * @param filePath 文件觉得路径
     * @return
     */
    public static List<Object> readMoreThan1000Row(String filePath) {
        return readMoreThan1000RowBySheet(filePath, null);
    }

    /**
     * 读大于1000行数据, 带样式
     *
     * @param filePath 文件觉得路径
     * @return
     */
    public static List<Object> readMoreThan1000RowBySheet(String filePath, Sheet sheet) {
        if (!StringUtils.hasText(filePath)) {
            return null;
        }

        sheet = sheet != null ? sheet : initSheet;

        InputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
            ExcelListener excelListener = new ExcelListener();
            EasyExcelFactory.readBySax(fileStream, sheet, excelListener);
            return excelListener.getDatas();
        } catch (FileNotFoundException e) {
            System.err.println("找不到文件或文件路径错误, 文件：" + filePath);
        } finally {
            try {
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                System.err.println("excel文件读取失败, 失败原因：" + e);
            }
        }
        return null;
    }

    /**
     * 生成excle
     *
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data     数据源
     * @param head     表头
     */
    public static void writeBySimple(String filePath, List<List<Object>> data, List<List<String>> head) {
        writeSimpleBySheet(filePath, data, head, null);
    }

    /**
     * 生成excle
     *
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data     数据源
     * @param sheet    excle页面样式
     * @param head     表头
     */
    public static void writeSimpleBySheet(String filePath, List<List<Object>> data, List<List<String>> head, Sheet sheet) {

        sheet = (sheet != null) ? sheet : initSheet;

        Sheet sheet2 = new Sheet(1,0);

        //定义Excel正文背景颜色
        TableStyle tableStyle = new TableStyle();
        tableStyle.setTableContentBackGroundColor(IndexedColors.WHITE);

        tableStyle.setTableHeadBackGroundColor(IndexedColors.WHITE);

        Font font = new Font();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("宋体");

        Font headFont = new Font();
        headFont.setFontName("宋体");
        headFont.setFontHeightInPoints((short) 12);

        tableStyle.setTableContentFont(font);
        tableStyle.setTableHeadFont(headFont);

        if (head != null) {
            sheet.setHead(head);
            sheet.setTableStyle(tableStyle);
            sheet.setSheetName("考勤明细表");
        }
        sheet2.setHead(head);
        sheet2.setTableStyle(tableStyle);
        sheet2.setSheetName("考勤汇总表");

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write1(data, sheet).write1(data,sheet2);
        } catch (FileNotFoundException e) {
            System.err.println("找不到文件或文件路径错误, 文件：" + filePath);
        } finally {
            try {
                if (writer != null) {
                    writer.finish();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("excel文件导出失败, 失败原因：" + e);
            }
        }

    }

    /**
     * 生成excle
     *
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data     数据源
     */
    public static void writeWithTemplate(String filePath, List<? extends BaseRowModel> data) {
        writeWithTemplateAndSheet(filePath, data, null);
    }

    /**
     * 生成excle
     *
     * @param filePath 绝对路径, 如：/home/chenmingjian/Downloads/aaa.xlsx
     * @param data     数据源
     * @param sheet    excle页面样式
     */
    public static void writeWithTemplateAndSheet(String filePath, List<? extends BaseRowModel> data, Sheet sheet) {
        if (CollectionUtils.isEmpty(data)) {
            return;
        }

        sheet = (sheet != null) ? sheet : initSheet;
        sheet.setClazz(data.get(0).getClass());

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write(data, sheet);
        } catch (FileNotFoundException e) {
            System.err.println("找不到文件或文件路径错误, 文件：{}" + filePath);
        } finally {
            try {
                if (writer != null) {
                    writer.finish();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("excel文件导出失败, 失败原因:" + e);
            }
        }

    }

    /**
     * 生成多Sheet的excle
     *
     * @param filePath              绝对路径
     * @param multipleSheelPropetys
     */
    public static void writeWithMultipleSheel(String filePath, List<MultipleSheelPropety> multipleSheelPropetys) {
        if (CollectionUtils.isEmpty(multipleSheelPropetys)) {
            return;
        }

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            for (MultipleSheelPropety multipleSheelPropety : multipleSheelPropetys) {
                Sheet sheet = multipleSheelPropety.getSheet() != null ? multipleSheelPropety.getSheet() : initSheet;
                if (!CollectionUtils.isEmpty(multipleSheelPropety.getData())) {
                    sheet.setClazz(multipleSheelPropety.getData().get(0).getClass());
                }
                writer.write(multipleSheelPropety.getData(), sheet);
            }

        } catch (FileNotFoundException e) {
            System.err.println("找不到文件或文件路径错误, 文件：" + filePath);
        } finally {
            try {
                if (writer != null) {
                    writer.finish();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("excel文件导出失败, 失败原因：" + e);
            }
        }

    }
}
