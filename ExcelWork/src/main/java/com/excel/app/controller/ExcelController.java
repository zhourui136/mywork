package com.excel.app.controller;

import com.alibaba.excel.support.ExcelTypeEnum;
import com.excel.model.Account;
import com.excel.service.ExcelService;
import com.excel.infra.utils.ExcelUtils;
import com.excel.infra.utils.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zhourui
 */
@RestController
@RequestMapping("/account")
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping("/exportAccount")
    public String exportAccount() {
        String path = "/home/zhourui/down/data.xlsx";
        List<Account> accountList = new ArrayList<Account>();
        for (int i = 1; i < 100000; i++) {
            Account account = new Account();
            account.setAccountNumber(1000 + i);
            account.setNickName("test" + i);
            account.setName("wang" + i);
            account.setPhone("1314531248" + i);
            accountList.add(account);
        }
        excelService.exportExcel(path, accountList);
        return "SUCCESS";
    }

    @RequestMapping("/importAccount")
    public List<Object> importAccount() {
        Properties properties = new Properties();
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(in);
            String path = properties.getProperty("importFile");
            List<Object> objects = ExcelUtils.readMoreThan1000Row(path);
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/exportWithResponse")
    public void exportWithResponse(HttpServletRequest request,HttpServletResponse response){
        String excelTitle = new String("账号列表".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        List<Account> accounts = new ArrayList<Account>();
        for (int i = 1; i < 100; i++) {
            Account account = new Account();
            account.setAccountNumber(1000 + i);
            account.setNickName("test" + i);
            account.setName("wang" + i);
            account.setPhone("1314531248" + i);
            accounts.add(account);
        }
        new ExportExcel().exportWithResponse(request,response, Account.class, accounts, ExcelTypeEnum.XLS, excelTitle);
    }
}
