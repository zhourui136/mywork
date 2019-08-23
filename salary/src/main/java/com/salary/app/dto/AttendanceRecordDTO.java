package com.salary.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 下午2:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceRecordDTO {
    private Long workDate;
    private String attendanceClass;
    private String onDutyTime;
    private String onDutyResult;
    private Integer onDutyIsNormal;
    private String offDutyTime;
    private String offDutyResult;
    private Integer offDutyIsNormal;
    private String remark;
    private List<Integer> violationIds;
}
