package com.salary.app.controller;

import com.salary.app.dto.AttendanceResultDTO;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:17
 */
@RestController
@RequestMapping("/attendanceResult")
public class AttendanceResultController {
    @PostMapping("/queryAttendanceResult")
    public MyPage<AttendanceResultDTO> queryAttendanceResult(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return new MyPage<>();
    }
    @PostMapping("/saveOrUpdateAttendanceResult")
    public Boolean saveOrUpdateAttendanceResult(@RequestParam(name = "resultId",required = false) Long resultId){
        return true;
    }
    @PostMapping("/toggleRelation")
    public Boolean toggleRelation(@RequestParam("relationId") Long relationId,@RequestParam("resultId") Long resultId){
        return true;
    }
}
