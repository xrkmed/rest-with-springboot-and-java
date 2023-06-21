package com.xrkmed.restwithspringbootandjava.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xrkmed.restwithspringbootandjava.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
	@Query("SELECT u FROM Users u WHERE u.userName =:userName")
	Users findByUsername(@Param("userName") String userName);
	
}
