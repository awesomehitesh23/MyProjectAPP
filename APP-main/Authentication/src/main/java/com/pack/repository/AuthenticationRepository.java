package com.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.model.UserLogin;

@Repository
public interface AuthenticationRepository extends JpaRepository<UserLogin, Integer>{

	Optional<UserLogin> findByUserIdAndPassword(int userId,String password);

	void findByUserIdAndPassword(Integer any, String any2);
}
