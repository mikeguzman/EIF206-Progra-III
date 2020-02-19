package cr.una.lab1;

/**
 * Student Class
 */
public class Student {
    private String firstName;
    private String lastName;

    /**
     * Default Constructor
     */
    public Student() {
    }

    /**
     * Main Constructor
     * @param firstName First Name of the Student
     * @param lastName Last Name of the Student
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
