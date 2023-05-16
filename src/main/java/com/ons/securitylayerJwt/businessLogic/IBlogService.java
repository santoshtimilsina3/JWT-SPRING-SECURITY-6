package com.ons.securitylayerJwt.businessLogic;


import com.ons.securitylayerJwt.dto.BlogDto;
import com.ons.securitylayerJwt.models.Blog;

public interface IBlogService {
    Blog save(BlogDto blog);
    Blog getById(Long id);
}
