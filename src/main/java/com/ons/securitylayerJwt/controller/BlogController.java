package com.ons.securitylayerJwt.controller;

import com.ons.securitylayerJwt.businessLogic.IBlogService;
import com.ons.securitylayerJwt.dto.BlogDto;
import com.ons.securitylayerJwt.exception.BlogNotFound;
import com.ons.securitylayerJwt.models.Blog;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    private final IBlogService iBlogService;

    //http://localhost:8087/api/blog
    @PostMapping
    public ResponseEntity<Blog> save(@Valid @RequestBody BlogDto blogDto) throws BlogNotFound {
        Blog blog = iBlogService.save(blogDto);
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPERADMIN')")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Blog blog = iBlogService.getById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
