package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
