package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagarmatha.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
