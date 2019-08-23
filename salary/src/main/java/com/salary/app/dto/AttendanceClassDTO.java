package com.salary.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceClassDTO {
    private String dingClass;
    private Integer attendanceClass;
    private Long classId;
}
