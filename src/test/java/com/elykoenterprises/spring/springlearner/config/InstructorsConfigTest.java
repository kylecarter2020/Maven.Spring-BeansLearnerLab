package com.elykoenterprises.spring.springlearner.config;

import com.elykoenterprises.spring.springlearner.models.Instructors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class InstructorsConfigTest {

    @Autowired
    Instructors instructors;

    @Autowired
    @Qualifier(value = "tcUsaInstructors")
    Instructors usInstructors;

    @Autowired
    @Qualifier(value = "tcUkInstructors")
    Instructors ukInstructors;

    @Test
    public void tcUsaInstructors() {
        //Given
        String expected = "T U V";

        //when
        String actual = usInstructors.toString();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void tcUkInstructors() {
        //Given
        String expected = "X Y Z";

        //when
        String actual = ukInstructors.toString();

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void allInstructors() {
        //Given
        String expected = "T U V X Y Z";

        //when
        String actual = instructors.toString();

        //then
        assertEquals(expected, actual);
    }
}