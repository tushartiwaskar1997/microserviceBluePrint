package com.example.course_service.service;

import com.example.course_service.service.feignClientInterface.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentClient studentClient;


    public ResponseEntity<Object> getTheStudentDetailsById(Long id){
        return studentClient.findStudentByStudentId(id);
    }
}
