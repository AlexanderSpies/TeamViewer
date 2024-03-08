package com.teamviewercodingchallenge.domain.repository;

import com.teamviewercodingchallenge.domain.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}