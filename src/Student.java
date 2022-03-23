import java.util.ArrayList;
import java.util.Date;

public class Student{
    private String studentId;
    private String studentName;
    private String birthdate;
    private ArrayList<Course> courses;

    public Student(String studentId, String studentName, String birthdate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthdate = birthdate;
        this.courses = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
