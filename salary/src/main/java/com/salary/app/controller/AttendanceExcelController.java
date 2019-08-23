package com.salary.app.controller;

import com.salary.app.dto.AttendanceExcelDTO;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 下午3:18
 */
@RestController
@RequestMapping("/attendanceExcel")
public class AttendanceExcelController {
    @PostMapping("/queryAttendanceExcel")
    public MyPage<AttendanceExcelDTO> queryAttendanceExcel(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return new MyPage<>();
    }
    @PostMapping("/exportAttendanceExcel")
    public Boolean exportAttendanceExcel(@RequestParam("startTime") Long startTime, @RequestParam("endTime") Long endTime,List<Long> deptIds){
        return true;
    }
    @PostMapping("/downAttendanceExcel")
    public void downAttendanceExcel(@RequestParam("downloadPath") String downLoadPath){

    }
}
