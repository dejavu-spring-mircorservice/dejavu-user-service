package com.dejavu.user.repository;

import java.util.Optional;

import com.dejavu.user.model.User;

public interface UserRepository extends BaseRepository<User, Integer>{
	Optional<User> findByEmail(String email); 
}
