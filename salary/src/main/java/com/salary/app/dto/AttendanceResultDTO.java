package com.salary.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceResultDTO {
    private Long relationId;
    private String dingResult;
    private String attendanceResultId;
    private Long resultId;
}
