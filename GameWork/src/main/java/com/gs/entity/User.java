package com.gs.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午10:28
 */
@Data
public class User extends BaseRowModel {
    @ExcelProperty(index = 0,value = "id")
    private Long userId;
    @ExcelProperty(index = 1,value = "姓名")
    private String userName;
    @ExcelProperty(index = 2,value = "年龄")
    private Integer age;
}
