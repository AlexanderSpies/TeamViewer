package com.teamviewercodingchallenge.domain.repository;

import com.teamviewercodingchallenge.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
