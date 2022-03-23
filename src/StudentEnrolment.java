import java.util.ArrayList;

public class StudentEnrolment {
    protected Student student;
    protected Course course;
    protected String semester;


    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void add_student(Student student, Course course){
        if (course.getStudents().contains(student)){
            System.out.println("Already in course");
        }
        else {
            course.getStudents().add(student);
            System.out.println("Available");
        }
    }
    public void update_student(Student student) {
        if (course.getStudents().contains(student)) {
            student.setStudentId("S003");
            student.setStudentName("Nam");
            student.setBirthdate("02/02/2002");
        }
    }

    public void delete_student(Student student){
        if (course.getStudents().contains(student)) {
            course.getStudents().remove(student);
            System.out.println("Delete successfully");
        }
    }
    public void getOne(Student student, Course course){
        if (course.getStudents().contains(student)) {
            System.out.println(student);
        }
    }
    public void getAll(Course course){
        for (Student studentz: course.getStudents()){
            System.out.println(studentz);
        }
    }

}
