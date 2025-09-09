package com.example.course_service.controller;

import com.example.course_service.constants.ResponseHandler;
import com.example.course_service.model.Course;
import com.example.course_service.service.CourseService;
import com.example.course_service.service.feignClientInterface.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentClient studentClient;

    @GetMapping("/student/{id}")
    public ResponseEntity<Object> getTheStudentDetails(@PathVariable("id") Long id) {
        return studentClient.findStudentByStudentId(id);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> findStudentByStudentId(@PathVariable("id") long courseId) {
        Optional<Course> optionalCourse = courseService.getTheCourseById(courseId);
        if (optionalCourse.isEmpty()) {
            return ResponseHandler.generatedResponse("Course details not found.", HttpStatus.BAD_REQUEST, null);
        }
        return ResponseHandler.generatedResponse("Course details found successfully.", HttpStatus.OK, optionalCourse.get());
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> findAllCourses() {
        return ResponseHandler.generatedResponse("All course details found successfully.", HttpStatus.OK, courseService.getAllCourse());
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Object> addCourse(@RequestBody Course course) {
        return ResponseHandler.generatedResponse("Course details save successfully.", HttpStatus.OK, courseService.saveTheCourse(course));
    }


}
