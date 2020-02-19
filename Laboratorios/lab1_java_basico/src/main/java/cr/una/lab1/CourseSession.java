package cr.una.lab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession {
    private String department;
    private String code;
    private int numberOfStudents;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Date startDate;
    private Date endDate;


    public CourseSession() {
    }

    public CourseSession(String department, String code, Date startDate) {
        this.department = department;
        this.code = code;
        this.startDate = startDate;
    }

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

    public Date getEndDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        int numberOfDays = 16 * 7 - 7;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        endDate = calendar.getTime();
        return endDate;
    }

    @Override
    public String toString() {
        return "CourseSession{" +
                "department='" + department + '\'' +
                ", code='" + code + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}
