package com.ouyanglol.demo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author ouyangduning
 * @date 2019/11/30 下午5:58
 */
@Data
public class Blog {
    @Id
    private ObjectId id;
    private String title;
    private Date date;
    private Content content;
}
