package com.example.student_service.service;

import com.example.student_service.StudentServiceApplication;
import com.example.student_service.dto.StudentDto;
import com.example.student_service.kafka.KafkaProducerService;
import com.example.student_service.model.Student;
import com.example.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;



    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllTheStudentList() {
        return studentRepository.findAll();
    }

    public Student saveStudentDetails(StudentDto student) {
        Student student1 =  new Student();
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        return studentRepository.save(student1);
    }

}
