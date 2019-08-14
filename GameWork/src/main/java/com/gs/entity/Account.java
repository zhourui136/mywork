package com.gs.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-6-17 下午3:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账号id
     */
    @TableId(value = "account_id", type = IdType.AUTO)
    private Long accountId;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 游戏渠道id
     */
    @TableField("channel_id")
    private Long channelId;

    /**
     * 资源类型名称
     */
    @TableField("source_type")
    private String sourceType;

    /**
     * 账号状态(1.库存中 2.已出库)
     */
    @TableField("account_status")
    private Integer accountStatus;

    /**
     * 商户id
     */
    @TableField("merchant_id")
    private Long merchantId;

    /**
     * 是否删除(0.否 1.是)
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "ctime", fill = FieldFill.INSERT)
    private Long ctime;

    /**
     * 更新时间
     */
    @TableField(value = "utime", fill = FieldFill.INSERT_UPDATE)
    private Long utime;
}
