package com.ouyanglol.demo.repository;

import com.ouyanglol.demo.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author ouyangduning
 */
public interface ArticleRepository extends ElasticsearchRepository<Article,String> {
}
