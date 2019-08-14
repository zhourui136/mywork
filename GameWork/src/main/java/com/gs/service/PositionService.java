package com.gs.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-7 上午10:57
 */
public interface PositionService {
    /**
     * 新增或编辑新闻
     *
     * @param positionKind             职位分类
     * @param positionName             职位名称
     * @param workExperience           工作经验
     * @param educationRequirement     学历要求
     * @param isFullTime               是否全职
     * @param positionDescribe         职位描述
     * @param positionRequirement      任职要求
     * @param contactInfo              联系方式
     * @return  Boolean
     */
    Boolean saveOrUpdatePosition(Integer positionKind,String positionName, Integer workExperience,Integer educationRequirement,
                                 Integer isFullTime, String positionDescribe, String positionRequirement,String contactInfo);
}
