package com.auth_service.auth_service.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.auth_service.auth_service.models.userRegisterModel;

@Repository
public interface  userRegisterRepository extends MongoRepository<userRegisterModel, String> {

    Optional<userRegisterModel> findUserByNumber(String number);
    

    
}
