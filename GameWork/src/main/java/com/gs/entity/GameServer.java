package com.gs.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhourui
 */
@Data
@Getter
@Setter
public class GameServer implements Serializable {
    @TableField("game_id")
    private Long gameId;
    @TableField("game_name")
    private String gameName;
    @TableField("is_deleted")
    private boolean deleted;
    @TableField("ctime")
    private String ctime;
}