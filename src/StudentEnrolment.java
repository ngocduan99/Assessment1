import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SplittableRandom;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;


    public StudentEnrolment() {
    }

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

//add_student function
    public boolean add_student (Student student,Course course) {
        HashMap<Course, Student> enrolment = new HashMap<>();
        if (course.getStudentsList().contains(student)){
            System.out.println("Not available");
            return false;

    }
        else {
            course.getStudentsList().add(student);
            enrolment.put(course,student);
            System.out.println(enrolment);
            return true;

        }
    }




    public void update_student(Student student) {
        if (course.getStudentsList().contains(student)) {
            student.setStudentId("S003");
            student.setStudentName("Nam");
            student.setBirthdate("02/02/2002");
        }
    }

    public void delete_student(Student student){
        if (course.getStudentsList().contains(student)) {
            course.getStudentsList().remove(student);
            System.out.println("Delete successfully");
        }
    }
    public void getOne(Student student, Course course){
        if (course.getStudentsList().contains(student)) {
            System.out.println(student);
        }
    }
    public void getAll(Course course){
        for (Student studentz: course.getStudentsList()){
            System.out.println(studentz);
        }
    }

}
