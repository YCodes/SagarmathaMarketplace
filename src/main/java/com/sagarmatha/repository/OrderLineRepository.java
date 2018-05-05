package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sagarmatha.domain.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{

}
