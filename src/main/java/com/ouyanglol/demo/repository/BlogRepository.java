package com.ouyanglol.demo.repository;

import com.ouyanglol.demo.model.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 */
public interface BlogRepository extends MongoRepository<Blog, ObjectId> {

}