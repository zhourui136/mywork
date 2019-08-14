package com.gs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-6 下午4:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDTO {
    private Long positionId;
    private Integer positionKind;
    private String positionName;
    private Integer workExperience;
    private Integer educationRequirement;
    private Integer publishStatus;
    private Integer isFullTime;
    private String positionDescribe;
    private String positionRequirement;
    private String contactInfo;
    private String operateUser;
    private String createUser;
    private String publishUser;
    private String deleteUser;
    private Long createTime;
    private Long operateTime;
    private Long publishTime;
    private Long deleteTime;
}
