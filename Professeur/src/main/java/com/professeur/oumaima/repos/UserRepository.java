package com.professeur.oumaima.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.professeur.oumaima.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);


}
