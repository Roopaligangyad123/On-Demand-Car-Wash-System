package com.cg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.cg.models.Washpack;


@Repository
public interface WashRepo extends MongoRepository<Washpack,Integer> {

}
