package com.elykoenterprises.spring.springlearner.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AlumniTest {

    @Autowired
    @Qualifier(value = "previousStudents")
    Students students;

    @Autowired
    Instructors instructors;

    @Test
    public void executeBootCamp() {
        //Given
        double expected = 1200;

        //Then
        for (Student s : students) {
            assertEquals(expected, s.getTotalStudyTime(), 0);
        }
    }

    @Test
    public void executeBootCamp2() {
        //Given
        double expected = 200;

        //Then
        for (Instructor i : instructors) {
            assertEquals(expected, i.getNumberOfHours(), 0);
        }
    }
}