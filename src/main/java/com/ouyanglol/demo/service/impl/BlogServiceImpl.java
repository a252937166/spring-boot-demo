package com.ouyanglol.demo.service.impl;

import com.ouyanglol.demo.model.Blog;
import com.ouyanglol.demo.repository.BlogRepository;
import com.ouyanglol.demo.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ouyangduning
 * @date 2019/11/30 下午6:03
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
