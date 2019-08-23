package com.salary.app.controller;

import com.salary.app.dto.StaffRedeploymentDTO;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:43
 */
@RestController
@RequestMapping("/staffRedeployment")
public class StaffRedeploymentController {
    @PostMapping("/queryStaffRedeployment")
    public MyPage<StaffRedeploymentDTO> queryStaffRedeployment(@RequestParam(name = "jobNumber",required = false) String jobNumber,@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return new MyPage<>();
    }
    @PostMapping("/updateStaffRedeployment")
    public Boolean updateStaffRedeployment(@RequestParam("staffId") Long staffId,@RequestParam("extraRedeploymentDays") Integer extraRedeploymentDays){
        return true;
    }
}
