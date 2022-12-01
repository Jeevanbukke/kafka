package com.example.form;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.form.User;
import com.example.form.KafkaUserService;
 
@SpringBootApplication
@RestController
public class ConsumerApplication {
	 @Autowired
	    KafkaUserService kafkaUserService;
	   
	    public static void main(String[] args) {
	        SpringApplication.run(ConsumerApplication.class, args);
	    }
	   
	    @KafkaListener(topics = "gfg", groupId = "gfg-group")
	    public void listen(User user) {
	        System.out.println("Received User information : " + user.toString());
	        try {
	            kafkaUserService.saveUser(user);
	        } catch (Exception e) {
	            e.printStackTrace();   
	        }
	    }
	   
	    @GetMapping("/get")
	    public Iterable<User> findAllUser() {
	        return kafkaUserService.findAllUsers();
	    }
	
	
	}


