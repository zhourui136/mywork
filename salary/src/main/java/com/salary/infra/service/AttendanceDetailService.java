package com.salary.infra.service;

import com.salary.app.dto.AttendanceDetailDTO;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 下午3:51
 */
public interface AttendanceDetailService {
    List<AttendanceDetailDTO> listAttendanceDetail();
}
