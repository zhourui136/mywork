package com.gs.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-7 上午10:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("position")
public class PositionE implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职位id
     */
    @TableId("position_id")
    private Long positionId;
    /**
     * 职位分类
     */
    @TableField("position_kind")
    private Integer positionKind;
    /**
     * 职位名称
     */
    @TableField("position_name")
    private String  positionName;
    /**
     * 工作经验
     */
    @TableField("work_experience")
    private Integer workExperience;
    /**
     * 学历要求
     */
    @TableField("education_requirement")
    private Integer educationRequirement;
    /**
     * 发布状态
     */
    @TableField("publish_status")
    private Integer publishStatus;
    /**
     * 是否全职 0.否 1.是
     */
    @TableField("is_full_time")
    private Integer isFullTime;
    /**
     * 职位描述
     */
    @TableField("position_describe")
    private String  positionDescribe;
    /**
     * 任职要求
     */
    @TableField("position_requirement")
    private String  positionRequirement;
    /**
     * 联系方式
     */
    @TableField("contact_info")
    private String  contactInfo;
    /**
     * 创建者uid
     */
    @TableField("creator_uid")
    private Long creatorUid;
    /**
     * 操作人uid
     */
    @TableField("operator_uid")
    private Long operatorUid;
    /**
     * 发布人uid
     */
    @TableField("publisher_uid")
    private Long publisherUid;
    /**
     * 删除人uid
     */
    @TableField("delete_uid")
    private Long deleteUid;
    /**
     *创建时间
     */
    @TableField(value = "ctime",fill = FieldFill.INSERT)
    private Long ctime;
    /**
     * 更新时间
     */
    @TableField(value = "utime",fill = FieldFill.INSERT_UPDATE)
    private Long utime;
    /**
     * 发布时间
     */
    @TableField("publish_time")
    private Long publishTime;
    /**
     * 删除时间
     */
    @TableField("delete_time")
    private Long deleteTime;
    /**
     * 是否删除 0.否 1.是
     */
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;
}
