package com.salary.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zhourui
 * @since 2019-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("attendance_detail")
public class AttendanceDetailE implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考勤id
     */
    @TableId("attendance_id")
    private Long attendanceId;

    /**
     * 工作日期
     */
    @TableField("work_date")
    private Long workDate;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 排班id
     */
    @TableField("class_id")
    private Long classId;

    /**
     * 上班时间
     */
    @TableField("on_duty_time")
    private Long onDutyTime;

    /**
     * 上班考勤结果id
     */
    @TableField("on_duty_result")
    private Long onDutyResult;

    /**
     * 下班时间
     */
    @TableField("off_duty_time")
    private Long offDutyTime;

    /**
     * 下班考勤结果id
     */
    @TableField("off_duty_result")
    private Long offDutyResult;

    /**
     * 当天违规
     */
    @TableField("day_violation")
    private Integer dayViolation;

    /**
     * 备注信息
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 是否删除 0.否 1.是
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField("ctime")
    private Long ctime;

    /**
     * 更新时间
     */
    @TableField("utime")
    private Long utime;
}
