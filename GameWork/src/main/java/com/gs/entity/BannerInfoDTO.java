package com.gs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-6 下午2:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerInfoDTO {
    private Integer sortOrder;
    private Integer bannerType;
    private String  coverImage;
    private String  url;
    private Integer publishStatus;
    private String  operateUser;
    private String  createUser;
    private String  publishUser;
    private String  deleteUser;
    private Long    createTime;
    private Long    operateTime;
    private Long    publishTime;
    private Long    deleteTime;
}
