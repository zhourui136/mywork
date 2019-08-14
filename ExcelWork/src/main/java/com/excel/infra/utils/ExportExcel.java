package com.excel.infra.utils;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-22 上午10:55
 */
public class ExportExcel {
    /**
     * 导出excel
     *
     * @param response   前端响应
     * @param clazz      字节码
     * @param data       数据
     * @param type       类型
     * @param excelTitle excel文件名
     */
    public void exportWithResponse(HttpServletRequest request, HttpServletResponse response, Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> data, ExcelTypeEnum type, String excelTitle) {
        final String userAgent = request.getHeader("USER-AGENT");
        try {
            String fileName = excelTitle + type.getValue();
            //IE浏览器
            if (StringUtils.contains(userAgent, "MSIE")) {
                fileName = URLEncoder.encode(fileName, "UTF8");
                //google,火狐浏览器
            } else if (StringUtils.contains(userAgent, "Mozilla")) {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
                //其他浏览器
            } else {
                fileName = URLEncoder.encode(fileName, "UTF8");
            }
            String headStr = "attachment;filename=" + fileName;
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", headStr);
            OutputStream out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, type);
            setSheet(clazz, data, writer);
            writer.finish();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setSheet(Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> data, ExcelWriter writer) {
        int sheetNum = 1;
        Sheet sheet = new Sheet(sheetNum, 0, clazz);
        if (CollectionUtils.isEmpty(data)) {
            writer.write(null, sheet);
        }
        writer.write(data, sheet);
    }
}
