package com.gs.controller;

import com.gs.entity.PositionDTO;
import com.yushi.pandora.web.common.JsonResult;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-6 下午4:58
 */
@RestController
@RequestMapping("/web/position")
public class PositionController {
    /**
     * 分页查询职位信息
     *
     * @param positionKind       职位分类
     * @param publishStatus      发布状态
     * @param currentPage        当前页 默认1
     * @param pageSize           页数  默认20条
     * @return   职位列表
     */
    @PostMapping("/queryPosition")
    public JsonResult<MyPage<PositionDTO>> queryPosition(@RequestParam(name = "positionKind",required = false) Integer positionKind,@RequestParam(name = "publishStatus",required = false) Integer publishStatus,
                                                         @RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return null;
    }

    /**
     * 新增或编辑职位信息
     *
     * @param positionKind           职位分类
     * @param positionName           职位名称
     * @param workExperience         工作经验
     * @param educationRequirement   学历要求
     * @param isFullTime             是否全职
     * @param positionDescribe       职位描述
     * @param positionRequirement    任职要求
     * @param contactInfo            联系方式
     * @return  Boolean
     */
    @PostMapping("/saveOrUpdatePosition")
    public JsonResult<Boolean> saveOrUpdatePosition(@RequestParam("positionKind") Integer positionKind,@RequestParam("positionName") String positionName,
                                                    @RequestParam("workExperience") Integer workExperience,@RequestParam("educationRequirement") Integer educationRequirement,
                                                    @RequestParam("isFullTime") Integer isFullTime,@RequestParam("positionDescribe") String positionDescribe,
                                                    @RequestParam("positionRequirement") String positionRequirement,@RequestParam("contactInfo") String contactInfo){
        return null;
    }

    /**
     * 下架职位
     *
     * @param positionId     职位id
     * @return  Boolean
     */
    @PostMapping("/deletePosition")
    public JsonResult<Boolean> deletePosition(@RequestParam("positionId") Long positionId){
        return null;
    }

    /**
     * 发布职位
     *
     * @param positionId     职位id
     * @return  Boolean
     */
    @PostMapping("/publishPosition")
    public JsonResult<Boolean> publishPosition(@RequestParam("positionId") Long positionId){
        return null;
    }
}
