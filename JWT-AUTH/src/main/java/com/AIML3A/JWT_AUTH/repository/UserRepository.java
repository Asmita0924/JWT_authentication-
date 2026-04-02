package com.AIML3A.JWT_AUTH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AIML3A.JWT_AUTH.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}