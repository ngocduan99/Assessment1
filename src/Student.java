import java.util.ArrayList;
import java.util.Date;

public class Student{
    private String studentId;
    private String studentName;
    private String birthDate;
    private ArrayList<Course> coursesLists;

    public Student(String studentId, String studentName, String birthDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.coursesLists = new ArrayList<Course>();

    }

    public ArrayList<Course> getCourses() {
        return coursesLists;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setBirthdate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
