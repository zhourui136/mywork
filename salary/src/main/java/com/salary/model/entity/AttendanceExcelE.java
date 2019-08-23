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
@TableName("attendance_excel")
public class AttendanceExcelE implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 考勤excel表id
     */
    @TableId("excel_id")
    private Long excelId;

    /**
     * 导出时间
     */
    @TableField("export_time")
    private Long exportTime;

    /**
     * 是否导出 0.导出失败 1.导出成功
     */
    @TableField("is_exported")
    private Integer isExported;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private Long startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Long endTime;

    /**
     * 部门id

     */
    @TableField("dept_id")
    private Long deptId;

    /**
     * 文件下载路径
     */
    @TableField("download_path")
    private String downloadPath;

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
    private Integer ctime;

    /**
     * 更新时间

     */
    @TableField("utime")
    private Long utime;
}
