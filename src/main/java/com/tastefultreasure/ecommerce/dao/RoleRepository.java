package com.tastefultreasure.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastefultreasure.ecommerce.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
