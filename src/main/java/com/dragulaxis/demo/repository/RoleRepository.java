package com.dragulaxis.demo.repository;

import com.dragulaxis.demo.entity.Role;
import com.dragulaxis.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
