package com.example.form;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController

public class ProducerController {
	 @Autowired
	    KafkaService kafkaProducer;
	 @Autowired
	 producerrepo repo;
	   
	    @PostMapping("/producer")
	    public String sendMessage(@RequestBody User user) {
	        repo.save(user);
	      kafkaProducer.send(user);
	    
	        
	        return "Message sent successfully to the Kafka ";
	       
	    }
	   @PostMapping("/producerlist")
	    public String sendMessage(@RequestBody List<User> user) {
	        kafkaProducer.sendList(user);
	        return "Message sent successfully to the Kafka ";
	    }
	    @GetMapping("/get")
	    @Cacheable(value="user")
	  public ResponseEntity<?> getStudents()
	    {
	        
	        return ResponseEntity.ok(this.repo.findAll());
	    }
	    
	}


