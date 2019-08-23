package com.excel.model;

import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-14 下午7:24
 */
@Data
@Accessors(chain = true)
public class User extends BaseRowModel {
    private Integer number;
    private String name;
    private String deptName;
    private String group;
    private String inDate;
    private String outDate;
    List<Record> recordList;
}
