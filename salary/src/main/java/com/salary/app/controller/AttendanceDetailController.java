package com.salary.app.controller;

import com.salary.app.dto.AttendanceDetailDTO;
import com.salary.infra.service.AttendanceDetailService;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 下午2:51
 */
@RestController
@RequestMapping("/attendanceDetail")
public class AttendanceDetailController {

    @Autowired
    private AttendanceDetailService attendanceDetailService;

    @PostMapping("/queryAttendanceDetail")
    public MyPage<AttendanceDetailDTO> queryAttendanceDetail(@RequestParam(name = "startTime",required = false) Long startTime,@RequestParam(name = "endTime",required = false) Long endTime,
                                                             @RequestParam(name = "jobNumber",required = false)String jobNumber,@RequestParam(name = "classType",required = false) String classType,
                                                             @RequestParam(name = "isNormal",required = false) Integer isNormal,@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                                             @RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return new MyPage<>();
    }
    @PostMapping("/updateAttendanceDetail")
    public Boolean updateAttendanceDetail(Long attendanceId,Long workDate){
        return true;
    }
    @PostMapping("/listAttendanceDetail")
    public List<AttendanceDetailDTO> listAttendanceDetail(){
        return attendanceDetailService.listAttendanceDetail();
    }
}
