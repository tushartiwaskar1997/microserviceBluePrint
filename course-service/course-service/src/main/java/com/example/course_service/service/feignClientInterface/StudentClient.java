package com.example.course_service.service.feignClientInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

///  @FeignClient(url="http://localhost:8082",name="student-service")
///  for load balancing
@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("/student/getById/{id}")   ///  this url need to be same as in student controller
    ResponseEntity<Object> findStudentByStudentId(@PathVariable("id") Long studentId);
}
