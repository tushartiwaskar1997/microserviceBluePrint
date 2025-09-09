package com.example.student_service.constant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generatedResponse(String message, HttpStatus http, Object response) {
        Map<String, Object> map = new HashMap<>();
        map.put(AppConstant.MESSAGE, message);
        map.put(AppConstant.STATUS, http.value());
        map.put(AppConstant.DATA, response);
        return ResponseEntity.ok(map);
    }

}
