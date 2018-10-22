package com.packy.SpringBoot2.elasticsearch.repository;

import com.packy.SpringBoot2.elasticsearch.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

}
