package com.example.MyAccountantBackEnd.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserUtils {
    private UserUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }

}
