package com.elykoenterprises.spring.springlearner.config;

import com.elykoenterprises.spring.springlearner.models.ClassRoom;
import com.elykoenterprises.spring.springlearner.models.Instructors;
import com.elykoenterprises.spring.springlearner.models.Students;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassroomConfigTest {

    @Autowired
    @Qualifier(value = "currentCohort")
    ClassRoom classRoom;

    @Autowired
    @Qualifier(value = "previousCohort")
    ClassRoom pastClassroom;

    @Test
    public void currentCohort() {
        //Given
        String expectedInstructors = "T U V X Y Z";
        String expectedStudents = "D E F";

        //When
        String actualInstructors = classRoom.getInstructors().toString();
        String actualStudents = classRoom.getStudents().toString();

        assertTrue(expectedInstructors.equals(actualInstructors) && expectedStudents.equals(actualStudents));
    }

    @Test
    public void previousCohort() {
        //Given
        String expectedInstructors = "T U V X Y Z";
        String expectedStudents = "A B C";

        //When
        String actualInstructors = pastClassroom.getInstructors().toString();
        String actualStudents = pastClassroom.getStudents().toString();

        assertTrue(expectedInstructors.equals(actualInstructors) && expectedStudents.equals(actualStudents));
    }
}