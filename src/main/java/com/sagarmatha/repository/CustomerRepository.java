package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
