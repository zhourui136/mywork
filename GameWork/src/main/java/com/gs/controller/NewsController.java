package com.gs.controller;

import com.gs.entity.NewsDTO;
import com.yushi.pandora.web.common.JsonResult;
import com.yushi.pandora.web.common.MyPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-6 下午8:02
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    /**
     * 分页查询
     *
     * @param newsType         新闻类型
     * @param isPopular        是否热门
     * @param publishStatus    状态
     * @param currentPage      当前页
     * @param pageSize         页数
     * @return 新闻列表
     */
    @PostMapping("/queryNews")
    public JsonResult<MyPage<NewsDTO>> queryNews(@RequestParam(name = "newsType",required = false) Integer newsType,@RequestParam(name = "isPopular",required = false) Integer isPopular,
                                                 @RequestParam(name = "publishStatus",required = false) Integer publishStatus,@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                                                 @RequestParam(name = "pageSize",defaultValue = "20") Integer pageSize){
        return null;
    }

    /**
     * 新增或编辑新闻
     *
     * @param newsTitle         新闻标题
     * @param content           新闻内容
     * @param newsType          新闻类型
     * @param isPopular         是否热门
     * @param coverImg          封面图
     * @param baseBrowseCount   基础浏览量
     * @param publishDate       发布日期
     * @param author            作者
     * @return  Boolean
     */
    @PostMapping("/saveOrUpdateNews")
    public JsonResult<Boolean> saveOrUpdateNews(@RequestParam("newsTitle") String newsTitle,@RequestParam("content") String content,
                                                @RequestParam("newsType") Integer newsType,@RequestParam("isPopular") Integer isPopular,
                                                @RequestParam("coverImg") String coverImg,@RequestParam(name = "baseBrowseCount",required = false) Integer baseBrowseCount,
                                                @RequestParam("publishDate") Long publishDate,@RequestParam(name = "author",required = false) String author){
        return null;

    }
    /**
     * 下架新闻
     *
     * @param newsId  新闻id
     * @return  Boolean
     */
    @PostMapping("/deleteNews")
    public JsonResult<Boolean> deleteNews(@RequestParam("newsId") Long newsId){
        return null;
    }

    /**
     * 发布新闻
     *
     * @param newsId   新闻id
     * @return  Boolean
     */
    @PostMapping("/publishNews")
    public JsonResult<Boolean> publishNews(@RequestParam("newsId") Long newsId){
        return null;
    }
}
