package com.example.userregistrationauthenticationdemo.repository;

import com.example.userregistrationauthenticationdemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
