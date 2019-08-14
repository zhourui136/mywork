package com.excel.service;

import java.io.File;
import java.util.List;

/**
 * @author zhourui
 */
public interface ExcelService {
    /**
     * 导出excel文件
     *
     * @param path
     * @param list
     */
    public void exportExcel(String path, List list);

    /**
     * 读取excel文件,导入
     *
     * @param path
     */
    public List<Object> importExcel(String path);
}
