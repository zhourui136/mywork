package com.gs.utils;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.commons.collections.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午10:42
 */
public class ExcelUtils {
    /**
     * 导出excel文件
     *
     * @param response      response
     * @param clazz         映射实体类
     * @param data          数据
     * @param excelTypeEnum excel文件类型
     * @param excelTitle    excel文件标题
     */
    public static void exportWithResponse(HttpServletResponse response, Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> data, ExcelTypeEnum excelTypeEnum, String excelTitle) {
        try {
            String fileName = excelTitle + excelTypeEnum.getValue();
            String headStr = "attachment;filename=" + fileName;
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", headStr);
            OutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, excelTypeEnum);
            setSheet(clazz, data, writer);
            writer.finish();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setSheet(Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> data, ExcelWriter writer) {
        Sheet sheet = new Sheet(1, 2, clazz);
        if (CollectionUtils.isEmpty(data)) {
            writer.write(null, sheet);
        }
        writer.write(data, sheet);
    }
}
