package com.example.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.form.User;
import com.example.form.KafkaUserRepository;
 
@Service
public class KafkaUserService {
    @Autowired
    private KafkaUserRepository edao;
   
    public void saveUser(User user) {
        edao.save(user);
    }
   
    public Iterable<User> findAllUsers() {
    return edao.findAll();
    }   
}