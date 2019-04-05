package com.elykoenterprises.spring.springlearner.config;

import com.elykoenterprises.spring.springlearner.models.ClassRoom;
import com.elykoenterprises.spring.springlearner.models.Instructors;
import com.elykoenterprises.spring.springlearner.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ClassroomConfig {

    private Instructors instructors;
    private Students students;
    private Students previousStudents;

    @Autowired
    public ClassroomConfig(@Qualifier("instructors") Instructors instructors, @Qualifier("students")Students students, @Qualifier("previousStudents")Students previousStudents) {
        this.instructors = instructors;
        this.students = students;
        this.previousStudents = previousStudents;
    }

    @Bean(name = "currentCohort")
    @DependsOn({"instructors", "students"})
    public ClassRoom currentCohort(){
        return new ClassRoom(instructors, students);
    }

    @Bean(name = "previousCohort")
    @DependsOn({"instructors", "previousStudents"})
    public ClassRoom previousCohort(){
        return new ClassRoom(instructors, previousStudents);
    }

    public Instructors getInstructors() {
        return instructors;
    }

    public Students getStudents() {
        return students;
    }

    public Students getPreviousStudents() {
        return previousStudents;
    }
}
