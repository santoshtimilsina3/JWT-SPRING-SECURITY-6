package com.ons.securitylayerJwt.businessLogic;

import com.ons.securitylayerJwt.dto.BlogDto;
import com.ons.securitylayerJwt.exception.BlogNotFound;
import com.ons.securitylayerJwt.models.Blog;
import com.ons.securitylayerJwt.repository.IBlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService implements IBlogService {

    private final IBlogRepository iBlogRepository;

    @Override
    public Blog save(BlogDto blog) {

        Blog newBlog = new Blog();
        newBlog.setTitle(blog.getTitle());
        newBlog.setContent(blog.getContent());
        iBlogRepository.save(newBlog);
        return newBlog;
    }

    @Override
    public Blog getById(Long id) {
        return iBlogRepository.findById(id).orElseThrow(() ->
                new BlogNotFound("Blog of id = " + id + " Not found "));
    }
}
