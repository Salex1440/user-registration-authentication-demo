package com.example.userregistrationauthenticationdemo.repository;

import com.example.userregistrationauthenticationdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
