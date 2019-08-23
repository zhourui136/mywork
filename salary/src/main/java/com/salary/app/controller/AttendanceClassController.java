package com.salary.app.controller;

import com.salary.app.dto.AttendanceClassDTO;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:33
 */
@RestController
@RequestMapping("/attendanceClass")
public class AttendanceClassController {
    @PostMapping("/queryAttendanceClass")
    public MyPage<AttendanceClassDTO> queryAttendanceClass(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return new MyPage<>();
    }
    @PostMapping("/toggleRelation")
    public Boolean toggleRelation(@RequestParam("classId") Long classId,@RequestParam("attendanceClass") Integer attendanceClass){
        return true;
    }
}
