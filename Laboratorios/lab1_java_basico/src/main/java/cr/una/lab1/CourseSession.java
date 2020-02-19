package cr.una.lab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Main Class
 */
public class CourseSession {
    private String department;
    private String code;
    private int numberOfStudents;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Date startDate;
    private Date endDate;


    /**
     * Default Constructor
     */
    public CourseSession() {
    }

    /**
     * Main Constructor
     * @param department
     * @param code
     * @param startDate
     */
    public CourseSession(String department, String code, Date startDate) {
        this.department = department;
        this.code = code;
        this.startDate = startDate;
    }

    /**
     * This Method is for enroll a new Student
     * @param student
     */
    public void enrollStudent(Student student){
        students.add(student);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This Method calculate the end date of the course
     * The appropriate number is calculated by multiplying 16 weeks by 7 days per week,
     * then subtracting 7 days (since the last day of the session is on the Monday of the 16th week)
     *
     * @return endDate
     */
    public Date getEndDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 7;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        endDate = calendar.getTime();
        return endDate;
    }

    public String toString() {
        return "CourseSession{" +
                "department='" + department + '\'' +
                ", code='" + code + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}
