package com.example.MyAccountantBackEnd.service.user;

import com.example.MyAccountantBackEnd.entity.User;
import com.example.MyAccountantBackEnd.request.ChangePasswordRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<String> signUp(Map<String, String> requestMap);

    ResponseEntity<String> login(Map<String, String> requestMap);


    ResponseEntity<String> verifyAccount(String token);

    List<User> listUser();



    ResponseEntity<String> forgotPassword(Map<String, String> requestMap);


    ResponseEntity<String> changePassword(Map<String, String> requestMap);
}
