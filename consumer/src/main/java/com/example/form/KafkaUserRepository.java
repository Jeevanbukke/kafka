package com.example.form;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import com.example.form.User;
 
@Repository
public interface KafkaUserRepository extends ElasticsearchRepository<User,String> {
   
}