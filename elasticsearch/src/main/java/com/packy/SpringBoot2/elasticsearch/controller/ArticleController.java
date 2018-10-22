package com.packy.SpringBoot2.elasticsearch.controller;


import com.packy.SpringBoot2.elasticsearch.domain.Article;
import com.packy.SpringBoot2.elasticsearch.domain.JsonData;
import com.packy.SpringBoot2.elasticsearch.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("save")
    public Object save(long id, String title) {
        Article article = new Article();
        article.setId(id);
        article.setPv(123);
        article.setContent("springboot整合elasticsearch");
        article.setTitle(title);
        article.setSummary("搜索框架整合");
        articleRepository.save(article);
        return JsonData.buildSuccess();
    }


    @GetMapping("search")
    public Object search(String title) {
        //QueryBuilder queryBuilder = QueryBuilders.matchAllQuery(); //搜索全部文档
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
        Iterable<Article> list = articleRepository.search(queryBuilder);
        return JsonData.buildSuccess(list);
    }

}
