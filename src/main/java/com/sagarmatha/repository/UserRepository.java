package com.sagarmatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByuserName(String userName);

}
