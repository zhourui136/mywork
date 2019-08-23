package com.salary.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 下午3:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceEmailDTO {
    private Long exportTime;
    private Integer exportResult;
    private Long startTime;
    private Long endTime;
    private List<String> names;
}
