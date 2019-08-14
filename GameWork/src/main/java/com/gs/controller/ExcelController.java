package com.gs.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.collect.Lists;
import com.gs.entity.User;
import com.gs.utils.ExcelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午10:26
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @RequestMapping("/exportUser")
    public void exportUser(HttpServletResponse response){
        String excelTitle="用户表";
        List<User> userList= Lists.newArrayList();
        ExcelUtils.exportWithResponse(response,User.class,userList, ExcelTypeEnum.XLSX,excelTitle);
    }
}
