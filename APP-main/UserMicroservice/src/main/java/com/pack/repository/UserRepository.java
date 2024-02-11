package com.pack.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.model.User;
 
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}