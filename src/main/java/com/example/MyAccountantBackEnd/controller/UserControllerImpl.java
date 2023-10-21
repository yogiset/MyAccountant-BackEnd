package com.example.MyAccountantBackEnd.controller;

import com.example.MyAccountantBackEnd.constant.ApiConstant;
import com.example.MyAccountantBackEnd.entity.User;
import com.example.MyAccountantBackEnd.service.user.UserService;
import com.example.MyAccountantBackEnd.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return UserUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        try {
            return userService.login(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return UserUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        try {

            return userService.verifyAccount(token);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return UserUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<User> listUser() {

        return userService.listUser();

    }





    @Override
    public ResponseEntity<String> forgotPassword(Map<String, String> requestMap) {
        try {
            return userService.forgotPassword(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return UserUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> changePassword(Map<String, String> requestMap,String userEmail) {
        try {

            return userService.changePassword(requestMap,userEmail);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return UserUtils.getResponseEntity(ApiConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}