package com.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author zhourui
 */
@Data
public class Account extends BaseRowModel {
    /**
     * value: 表头名称
     * index: 列号,0表示第一列
     */
    @ExcelProperty(value = "账号", index = 0)
    private int accountNumber;

    @ExcelProperty(value = "游戏昵称", index = 1)
    private String nickName;

    @ExcelProperty(value = "手机号码", index = 2)
    private String phone;

    @ExcelProperty(value = "真实姓名", index = 3)
    private String name;

}
