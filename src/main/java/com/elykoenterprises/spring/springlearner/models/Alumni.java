package com.elykoenterprises.spring.springlearner.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {

    @Autowired
    Instructors instructors;

    @Autowired
    @Qualifier(value = "previousStudents")
    Students students;

    @PostConstruct
    public void executeBootCamp(){
        double totalHours = 1200;
        double instructorHours = totalHours / instructors.count();

        for (Instructor i: instructors) {
            i.lecture(students, instructorHours);
        }
    }
}
