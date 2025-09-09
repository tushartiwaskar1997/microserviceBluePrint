package com.example.notification_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumerService {

    @KafkaListener(topics = "student-topic", groupId = "notification-group")
    public void consumeFromStudent(String message) {
        System.out.println("Received from student service: " + message);
        // handle notification logic (email, SMS, etc.)
    }

    @KafkaListener(topics = "course-topic", groupId = "notification-group")
    public void consumeFromCourse(String message) {
        System.out.println("Received from course service: " + message);
        // handle notification logic
    }


}
