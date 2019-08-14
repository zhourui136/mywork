package com.excel.infra.service.impl;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.excel.infra.service.UserService;
import com.excel.infra.utils.ExcelUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午11:11
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void exportUser(HttpServletResponse response, Class<? extends BaseRowModel> clazz, List<? extends BaseRowModel> data, ExcelTypeEnum excelTypeEnum, String excelTitle) {
        ExcelUtils.exportWithResponse(response, clazz, data, excelTypeEnum, excelTitle);
    }
}
