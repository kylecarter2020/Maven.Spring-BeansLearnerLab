package com.elykoenterprises.spring.springlearner.config;

import com.elykoenterprises.spring.springlearner.models.Instructor;
import com.elykoenterprises.spring.springlearner.models.Students;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentConfigTest {

    //when
    @Autowired
    @Qualifier(value = "students")
    Students studentsBean;

    //when
    @Autowired
    @Qualifier(value = "previousStudents")
    Students previousStudentsBean;

    @Test
    public void currentStudents() {
        //Given
        String expected = "D E F";

        //when
        String actual = studentsBean.toString();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void previousStudents() {
        //Given
        String expected = "A B C";

        //when
        String actual = previousStudentsBean.toString();

        //then
        assertEquals(expected, actual);
    }
}