package com.excel.app.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.excel.app.dto.UserDTO;
import com.excel.infra.service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午11:12
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private UserService userService;

    @RequestMapping("/exportUser")
    public void exportUser(HttpServletResponse response) {
        String excelTitle = "用户表";
        List<UserDTO> data = this.getData();
        userService.exportUser(response, UserDTO.class, data, ExcelTypeEnum.XLSX, excelTitle);
    }

    private List<UserDTO> getData() {
        List<UserDTO> data=Lists.newArrayList();
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(1001L);
        userDTO.setUserName("王星");
        userDTO.setAge(20);
        UserDTO userDTO2=new UserDTO();
        userDTO2.setUserId(1002L);
        userDTO2.setUserName("周华");
        userDTO2.setAge(21);
        UserDTO userDTO3=new UserDTO();
        userDTO3.setUserId(1003L);
        userDTO3.setUserName("黎明");
        userDTO3.setAge(22);
        UserDTO userDTO4=new UserDTO();
        userDTO4.setUserId(1004L);
        userDTO4.setUserName("王春华");
        userDTO4.setAge(20);
        data.add(userDTO);
        data.add(userDTO2);
        data.add(userDTO3);
        data.add(userDTO4);
        return data;
    }
}
