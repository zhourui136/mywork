package com.gs.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
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
@TableName("game")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 游戏id
     */
    @TableId(value = "game_id")
    private Long gameId;

    @TableField("game_number")
    private String gameNumber;
    /**
     * 游戏名称
     */
    @TableField("game_name")
    private String gameName;
    /**
     * 商户id
     */
    @TableField("merchant_id")
    private Long merchantId;
    /**
     * count
     */
    @TableField("count")
    private int count;
    /**
     * 是否启用 0.禁用 1.启用
     */
    @TableField("is_enabled")
    private Integer isEnabled;
    /**
     * 是否删除 0.否 1.是 (逻辑删除)
     */
    @TableField("is_deleted")
    @TableLogic
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
