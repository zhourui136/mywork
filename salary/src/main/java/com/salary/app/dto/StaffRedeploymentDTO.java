package com.salary.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffRedeploymentDTO{
    private String staffName;
    private String jobNumber;
    private Integer extraRedeploymentDays;
    private Integer historyRedeploymentRemainDays;
    private Integer monthOvertimeDays;
    private Integer monthRedeploymentDays;
    private Integer redeploymentRemainDays;
}
