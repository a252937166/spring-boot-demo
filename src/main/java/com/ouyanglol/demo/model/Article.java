package com.ouyanglol.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author ouyangduning3
 * @date 2019/9/21 18:09
 */
@Data
@Document(indexName="test_index",type="article")
public class Article {
    @Id
    private String id;
    private String title;
    private String desc;
}
