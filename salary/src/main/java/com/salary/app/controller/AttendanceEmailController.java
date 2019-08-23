package com.salary.app.controller;

import com.salary.app.dto.AttendanceEmailDTO;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 下午3:33
 */
@RestController
@RequestMapping("/attendanceEmail")
public class AttendanceEmailController {
    @PostMapping("/queryAttendanceEmail")
    public MyPage<AttendanceEmailDTO> queryAttendanceEmail(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(name = "pageSuze",defaultValue = "20") Integer pageSize){
        return new MyPage<>();
    }
    @PostMapping("/sendAttendanceEmail")
    public Boolean sendAttendanceEmail(List<Long> deptIds,@RequestParam(name = "jobNumber",required = false) String jobNumber,@RequestParam("startTime") Long startTime,@RequestParam("endTime")Long endTime){
        return true;
    }
}
