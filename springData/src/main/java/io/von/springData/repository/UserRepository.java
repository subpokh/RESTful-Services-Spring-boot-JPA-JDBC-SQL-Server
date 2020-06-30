package io.von.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.von.springData.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
