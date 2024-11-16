package com.auth_service.auth_service.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth_service.auth_service.models.userRegisterModel;
import com.auth_service.auth_service.repositories.userRegisterRepository;

@Service
public class userRegisterService {

    @Autowired
    private userRegisterRepository userRegisterRepository;

    public userRegisterModel createUser(userRegisterModel user) {
        return userRegisterRepository.save(user);
    }
 
    public Optional<userRegisterModel> getUserById(String id){
        return userRegisterRepository.findById(id);
    }
    
    public boolean checkUserById(String id) {
        Optional<userRegisterModel> userData = userRegisterRepository.findById(id);
        if (userData.isPresent()) {
            return true;
        }
        return false;
    }

    public boolean findUserByNumber(String number) {

        Optional<userRegisterModel> userData = userRegisterRepository.findUserByNumber(number);
        if (userData.isPresent()) {
            return true;
        }
        return false;
    }

    public Optional<userRegisterModel> updateUserById(userRegisterModel user,String id) {
        Optional<userRegisterModel> userData = userRegisterRepository.findById(id);
        if (userData.isPresent()) {
            user.setId(userData.get().getId());
            user.setCreatedAt(userData.get().getCreatedAt());
            user.setPassword(userData.get().getPassword());
            user.setUpdatedAt(LocalDateTime.now());
            user.setNewUser(userData.get().isNewUser());
            
            return Optional.of(userRegisterRepository.save(user));
        }
        return Optional.empty();
    }

    public Optional<userRegisterModel> updateAndValidateUser(userRegisterModel user,String id) {
        Optional<userRegisterModel> userData = userRegisterRepository.findById(id);
        if (userData.isPresent()) {
            user.setId(userData.get().getId());
            user.setCreatedAt(userData.get().getCreatedAt());
            user.setUpdatedAt(LocalDateTime.now());
            user.setNewUser(false);
            user.setIsPasswordSet(true);
            user.setNumber(userData.get().getNumber());
            user.setIsActive(userData.get().isIsActive());
            
            return Optional.of(userRegisterRepository.save(user));
        }
        return Optional.empty();
    }
}
