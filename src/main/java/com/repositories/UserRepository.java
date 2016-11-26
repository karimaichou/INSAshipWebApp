package com.repositories;

import com.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by borik on 11/24/2016.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
