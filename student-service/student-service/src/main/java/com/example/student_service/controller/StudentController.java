package com.example.student_service.controller;

import com.example.student_service.constant.ResponseHandler;
import com.example.student_service.dto.StudentDto;
import com.example.student_service.kafka.KafkaProducerService;
import com.example.student_service.model.Student;
import com.example.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> findStudentByStudentId(@PathVariable("id") long studentId) {
        Optional<Student> optionalStudent = studentService.getStudentById(studentId);
        if (optionalStudent.isEmpty()) {
            return ResponseHandler.generatedResponse("Student details not found.", HttpStatus.BAD_REQUEST, null);
        }
        return ResponseHandler.generatedResponse("Student details found successfully.", HttpStatus.OK, optionalStudent.get());
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> findAllStudent() {
        return ResponseHandler.generatedResponse("All Student details found successfully.", HttpStatus.OK, studentService.getAllTheStudentList());
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Object> addStudent(@RequestBody StudentDto student) {
        kafkaProducerService.sendEvent("student-topic",student);
        return ResponseHandler.generatedResponse("Student details save successfully.", HttpStatus.OK, studentService.saveStudentDetails(student));
    }


}
