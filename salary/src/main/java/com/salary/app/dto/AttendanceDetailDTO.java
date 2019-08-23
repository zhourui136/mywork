package com.salary.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDetailDTO {
    private Long attendanceId;
    private String staffName;
    private String jobNumber;
    private String deptName;
    private List<AttendanceRecordDTO> attendanceRecordDtoList;
}
