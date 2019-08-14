package com.excel.model;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import lombok.Data;

import java.util.List;

/**
 * @author zhourui
 */
@Data
public class MultipleSheelPropety {

    private List<? extends BaseRowModel> data;

    private Sheet sheet;
}
