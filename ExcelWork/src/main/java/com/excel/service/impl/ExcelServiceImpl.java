package com.excel.service.impl;

import com.excel.service.ExcelService;
import com.excel.infra.utils.ExcelUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhourui
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public void exportExcel(String path, List list) {
        ExcelUtils.writeWithTemplate(path, list);
    }

    @Override
    public List<Object> importExcel(String path) {
        return ExcelUtils.readMoreThan1000Row(path);
    }
}
