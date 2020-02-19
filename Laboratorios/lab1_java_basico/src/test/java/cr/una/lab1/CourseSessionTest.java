package cr.una.lab1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Test Class for CourseSession
 */
public class CourseSessionTest {
    CourseSession courseSession = null;

    @Before
    public void init(){
        // The appropriate number is calculated by multiplying 16 weeks by 7 days per week,
        // then subtracting 7 days (since the last day of the session is on the Monday of the 16th week)
        
        int year = 2020;
        int month = 1;
        int day = 10;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        courseSession = new CourseSession("PROGRA I", "EIF206", calendar.getTime());
    }

    @Test
    public void create() {
        assertEquals("PROGRA I", courseSession.getDepartment());
        assertEquals("EIF206", courseSession.getCode());
        assertEquals(0, courseSession.getNumberOfStudents());
    }

    @Test
    public void enrollStudents() {
        int year = 2020;
        int month = 4;
        int day = 25;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Date expectedDate = calendar.getTime();


        Student student1 = new Student("Maikol", "Guzman");
        courseSession.enrollStudent(student1);

        assertEquals(1, courseSession.getNumberOfStudents());
        ArrayList<Student> allStudents = courseSession.getStudents();
        assertEquals(1, allStudents.size());
        assertEquals(student1, allStudents.get(0));
        assertEquals(expectedDate.toString(), courseSession.getEndDate().toString());

        Student student2 = new Student("Sebastian", "Guzman");
        courseSession.enrollStudent(student2);

        assertEquals(2, courseSession.getNumberOfStudents());
        assertEquals(2, allStudents.size());
        assertEquals(student2, allStudents.get(1));
    }
}
