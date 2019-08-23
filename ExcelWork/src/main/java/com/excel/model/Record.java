package com.excel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-15 下午3:09
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private String checkType;
    private String onDutyIsNormal;
    private String offDutyIsNormal;
}

