package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.cg.models.Admin;


@Repository

public interface AdminRepo extends MongoRepository<Admin, Integer> {
	

}
