package com.work.service.impl;

import com.google.common.collect.Lists;
import com.work.entity.User;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ScrolledPage;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * @author zhourui
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public String saveOrUpdateUser(Long id, String name, String motto, Integer age) {
        User user = new User(id, name, motto, age);
        String key = null != id ? String.valueOf(id) : null;
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(key).withObject(user).build();
        return esTemplate.index(indexQuery);

    }

    @Override
    public List<User> scrollQueryUser(String name) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("name", name))
                .build();

        ScrolledPage<User> page = (ScrolledPage<User>)esTemplate.startScroll(100, searchQuery, User.class);

        List<User> users = Lists.newArrayList();
        while (page.hasContent()) {
            users.addAll(page.getContent());
            page = (ScrolledPage<User>)esTemplate.continueScroll(page.getScrollId(), 1000, User.class);
        }

        esTemplate.clearScroll(page.getScrollId());

        return users;
    }
}
