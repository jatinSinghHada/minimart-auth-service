package com.minimart.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minimart.auth_service.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

    boolean existsByEmail(String email);
    
}
