package com.gs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-6 下午7:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {
    private Long newsId;
    private Integer newsType;
    private String newsTitle;
    private String newsContent;
    private String coverImg;
    private String author;
    private Integer isPopular;
    private Long publishDate;
    private Integer baseBrowseCount;
    private Integer realBrowseCount;
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