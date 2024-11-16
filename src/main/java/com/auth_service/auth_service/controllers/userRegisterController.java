package com.auth_service.auth_service.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.auth_service.models.ApiResponse;
import com.auth_service.auth_service.models.userRegisterModel;
import com.auth_service.auth_service.services.userRegisterService;

@RestController
@RequestMapping("/user")

public class userRegisterController {

    @Autowired
    private userRegisterService userRegisterService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<userRegisterModel>> registerUser(@RequestBody userRegisterModel user) {

        boolean isUserAvailable = userRegisterService.findUserByNumber(user.getNumber());

        try {
            if (isUserAvailable) {
                ApiResponse<userRegisterModel> response = new ApiResponse<>(409, "User with this number already exists",
                        null);
                return ResponseEntity.status(409).body(response);
            } else {
                userRegisterModel newUser = new userRegisterModel(true, false, null, null,
                        LocalDateTime.now(), null, user.getNumber(), null,null,true);
                userRegisterService.createUser(newUser);
                ApiResponse<userRegisterModel> response = new ApiResponse<>(200, "User registered successfully",
                        newUser);
                return ResponseEntity.status(201).body(response);
            }

        } catch (Exception e) {
            ApiResponse<userRegisterModel> response = new ApiResponse<>(500, "Internal Server Error", null);
            return ResponseEntity.status(500).body(response);
        }

    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<userRegisterModel>> updateUserByUserID(@RequestBody userRegisterModel user,
            @PathVariable String userId) {

        boolean isUserAvailable = userRegisterService.checkUserById(userId);
        try {
            if (isUserAvailable) {

                Optional<userRegisterModel> userDataOptional = userRegisterService.getUserById(userId);

                if (userDataOptional.isPresent()) {
                    userRegisterService.updateUserById(user, userId);
                    ApiResponse<userRegisterModel> response = new ApiResponse<>(200, "User Updated successfully.",
                            user);
                    return ResponseEntity.status(200).body(response);

                } else {

                    ApiResponse<userRegisterModel> response = new ApiResponse<>(409, "User not Avaiable",
                            null);
                    return ResponseEntity.status(400).body(response);
                }

            } else {
                ApiResponse<userRegisterModel> response = new ApiResponse<>(400, "Bad Request",
                        null);
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            ApiResponse<userRegisterModel> response = new ApiResponse<>(500, "Internal Server Error", null);
            return ResponseEntity.status(500).body(response);
        }

    }

    @GetMapping("/{userId}/user-details")
    public ResponseEntity<ApiResponse<userRegisterModel>> getMethodName(@PathVariable String userId) {
        Optional<userRegisterModel> userDataOptional = userRegisterService.getUserById(userId);
        try {
            if (userDataOptional.isPresent()) {

                ApiResponse<userRegisterModel> res = new ApiResponse<>(200, "success", userDataOptional.get());
                return ResponseEntity.status(200).body(res);
            } else {
                ApiResponse<userRegisterModel> response = new ApiResponse<>(409, "User not Avaiable",
                        null);
                return ResponseEntity.status(400).body(response);
            }
        } catch (Exception e) {
            ApiResponse<userRegisterModel> response = new ApiResponse<>(500, "Internal Server Error", null);
            return ResponseEntity.status(500).body(response);
        }

    }

    @PutMapping("/validate/{userId}")
    public ResponseEntity<ApiResponse<userRegisterModel>> validateUser(@RequestBody userRegisterModel user,@PathVariable String userId) {
        try {
            Optional<userRegisterModel> userDataOptional = userRegisterService.getUserById(userId);
            if(userDataOptional.isPresent()) {
                
                userRegisterService.updateAndValidateUser(user, userId);
                ApiResponse<userRegisterModel> response = new ApiResponse<>(200, "User Updated successfully.",
                        user);
                return ResponseEntity.status(200).body(response);
            }else{
                ApiResponse<userRegisterModel> response = new ApiResponse<>(409, "User not Avaiable",
                        null);
                return ResponseEntity.status(400).body(response);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            ApiResponse<userRegisterModel> response = new ApiResponse<>(500, "Internal Server Error", null);
            return ResponseEntity.status(500).body(response);
        }
       
    }
    

}
