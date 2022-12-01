package com.example.form;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface producerrepo extends MongoRepository<User,Integer> {



}
