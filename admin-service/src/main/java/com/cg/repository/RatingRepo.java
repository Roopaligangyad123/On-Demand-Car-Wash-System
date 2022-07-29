package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.cg.models.UserRating;


@Repository

public interface RatingRepo extends MongoRepository<UserRating, String> {

}
