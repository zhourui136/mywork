package com.salary.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-23 上午11:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffAnnualLeaveDTO {
    private String staffName;
    private String jobNumber;
    private Long   entryTime;
    private Long  annualLeaveEffectTime;
    private Double workAge;
    private Double companyAge;
    private Integer currentPeriodAnnualLeave;
    private Integer currentPeriodUsedAnnualLeave;
    private Integer remainAnnualLeave;
}
