package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagarmatha.domain.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
