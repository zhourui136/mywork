package com.excel.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-12 上午11:09
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserE {
    @TableId("user_id")
    private Long userId;
    @TableField("user_name")
    private String userName;
    @TableField("age")
    private Integer age;
    @TableField("is_deleted")
    private Integer isDeleted;
    @TableField("ctime")
    private Long ctime;
    @TableField("utime")
    private Long utime;
}

