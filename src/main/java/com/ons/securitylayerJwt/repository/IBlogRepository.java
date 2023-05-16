package com.ons.securitylayerJwt.repository;

import com.ons.securitylayerJwt.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {

}
