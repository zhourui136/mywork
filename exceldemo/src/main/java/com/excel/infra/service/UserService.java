package com.excel.infra.service;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.support.ExcelTypeEnum;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午11:11
 */
public interface UserService {
    /**
     * 导出用户excel
     *
     * @param response           response
     * @param clazz              映射实体类
     * @param data               数据
     * @param excelTypeEnum      excel文件类型
     * @param excelTitle         excel文件名称
     */
    void exportUser(HttpServletResponse response, Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> data, ExcelTypeEnum excelTypeEnum, String excelTitle);
}
