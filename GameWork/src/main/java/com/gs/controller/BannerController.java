package com.gs.controller;

import com.gs.entity.BannerInfoDTO;
import com.yushi.pandora.web.common.JsonResult;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-6 下午2:48
 */
@RestController
@RequestMapping("/web/banner")
public class BannerController {
    /**
     * 分页查询banner
     * @param publishStatus    发布状态
     * @param currentPage      当前页
     * @param pageSize         页数
     * @return banner数据列表
     */
    @PostMapping("/queryBanner")
    public MyPage<BannerInfoDTO> queryBanner(Integer publishStatus,
                                             @RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,@RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return null;
    }

    /**
     * 新增或编辑banner信息
     * @param bannerId         bannerId
     * @param bannerType      类型
     * @param coverImage      封面图路径
     * @param url             链接/视频地址
     * @return      Boolean
     */
    @PostMapping("/saveOrUpdateBanner")
    public JsonResult<Boolean> saveOrUpdateBanner(@RequestParam(name = "bannerId",required = false) Long bannerId,@RequestParam("bannerType") Integer bannerType,@RequestParam("coverImage") String coverImage,@RequestParam(name = "url",required = false) String url){
        return null;
    }
    /**
     * 删除banner
     * @param bannerId  bannerId
     * @return     Boolean
     */
    @PostMapping("/deleteBanner")
    public JsonResult<Boolean> deleteBanner(@RequestParam("bannerId") Long bannerId){
        return null;
    }

    /**
     * 发布banner
     * @param bannerId  bannerId
     * @return  Boolean
     */
    @PostMapping("/publishBanner")
    public JsonResult<Boolean> publishBanner(@RequestParam("bannerId") Long bannerId){
        return null;
    }
}
