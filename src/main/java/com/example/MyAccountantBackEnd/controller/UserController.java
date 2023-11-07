package com.example.MyAccountantBackEnd.controller;

import com.example.MyAccountantBackEnd.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping(path = "/register")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String,String> requestMap);

    @PostMapping(path = "/login")
    public ResponseEntity<String>login(@RequestBody(required = true)Map<String,String> requestMap);

    @GetMapping(path = "/register/accountVerification/{token}")
    ResponseEntity<String> verifyAccount(@PathVariable String token);

    @GetMapping(path = "/me")
    public List<User> listUser();

    @PostMapping(path = "/forgotPassword")
    ResponseEntity<String>forgotPassword(@RequestBody Map<String,String> requestMap);

    @PostMapping("/changePassword")
    ResponseEntity<String> changePassword(@RequestBody Map<String, String> requestMap,String userEmail);


}
