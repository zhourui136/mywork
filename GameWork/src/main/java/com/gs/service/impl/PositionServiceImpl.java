package com.gs.service.impl;

import com.gs.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-7 上午11:03
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Override
    public Boolean saveOrUpdatePosition(Integer positionKind, String positionName, Integer workExperience, Integer educationRequirement, Integer isFullTime, String positionDescribe, String positionRequirement, String contactInfo) {
        return null;
    }
}
