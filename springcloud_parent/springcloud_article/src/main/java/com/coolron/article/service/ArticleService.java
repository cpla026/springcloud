package com.coolron.article.service;

import com.coolron.article.dao.ArticleMapper;
import com.coolron.article.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: xf
 * @Date: 2018/12/18 18:05
 * @Description:
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> list() {
        return articleMapper.list();
    }

    public Article getInfo(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
