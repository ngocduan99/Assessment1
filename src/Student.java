import java.util.ArrayList;

public class Student{
    private String studentId;
    private String studentName;
    private String birthDate;
    private ArrayList<Course> courseList;

    public Student(String studentId, String studentName, String birthDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.courseList = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
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
