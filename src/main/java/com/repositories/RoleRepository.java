package com.repositories;

import com.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by borik on 11/24/2016.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
