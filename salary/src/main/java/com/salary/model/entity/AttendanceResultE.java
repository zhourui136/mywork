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
 * 考勤结果表
 * </p>
 *
 * @author zhourui
 * @since 2019-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("attendance_result")
public class AttendanceResultE implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 考勤结果id
     */
    @TableId("result_id")
    private Long resultId;

    /**
     * 考勤结果
     */
    @TableField("attendance_result")
    private String attendanceResult;

    /**
     * 是否正常 0.否 1.是
     */
    @TableField("is_normal")
    private Integer isNormal;

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
