package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.models.Signup;

@Repository
public interface UserRepo extends MongoRepository<Signup, Integer> 
{

	Optional<Signup> findById(Long id);

	

}
