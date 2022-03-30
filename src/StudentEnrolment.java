import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SplittableRandom;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;
    private ArrayList<Course> coursesLists;
    private HashMap<String,HashMap> enrolmentList; //String here is semester, Hashmap here is another hashmap(String newCourse, String newStudent)
    private ArrayList<String> semesterList;
    private HashMap<String,ArrayList> courseListInSem;

    public StudentEnrolment() {
        this.coursesLists = new ArrayList<>();
        this.semesterList = new ArrayList<>();
        this.courseListInSem = new HashMap<>();
    }



    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.enrolmentList = new HashMap<String, HashMap>();
        this.semesterList = new ArrayList<String>();
        this.courseListInSem = new HashMap<>();
        this.coursesLists = new ArrayList<Course>();
    }

    public HashMap<String, HashMap> getEnrolmentList() {
        return enrolmentList;
    }

    public ArrayList<String> getSemesterList() {
        return semesterList;
    }

    public Student getStudent() {
        return student;
    }
    public ArrayList<Course> getCoursesLists() {
        return coursesLists;
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

    public void setSemesterList(ArrayList<String> semesterList) {
        this.semesterList = semesterList;
    }

    //add_student function
    public boolean add_student (Student student,Course course) {
        if (course.getStudentList().contains(student)){
            return false;
    }
        else {
            course.getStudentList().add(student);
            return true;
        }
    }

    //add_course functions
    public boolean add_course (Course course,Student student) {
        if(student.getCourseList().contains(course)){
            return false;
        }
        else{
            student.getCourseList().add(course);
            return true;
        }
    }

    public boolean add_courselist (Course course){
//        if(coursesLists.contains(course)){
//            return false;
//        }
//        else {
//            coursesLists.add(course);
//            return true;
//        }
        for(Course couTemp : coursesLists)
            if(couTemp.equals(course)){
                System.out.println("Huhu");
                return false;
            }
            coursesLists.add(course);
            System.out.println("hahu");
            return true;
    }

    public boolean add_semester (String semester){
        if(semesterList.contains(semester)){
            return false;
        }

            semesterList.add(semester);
            ArrayList<Course> courseLists = new ArrayList<>();
            System.out.println("hauahau");
            courseListInSem.put(semester,courseLists);
            return true;

    }

    public HashMap<String, ArrayList> getCourseListInSem(String semester, Course course) {
        if(courseListInSem.containsKey(semester)){
            if(coursesLists.contains(course)){
                ArrayList<Course> couTemp = courseListInSem.get(semester);
                for (Course couTemp2 : couTemp)
                if(couTemp2.equals(course)){
                    System.out.println("Huhu");
                    return courseListInSem;
                }
                    couTemp.add(course);
                    courseListInSem.put(semester, couTemp);
                    System.out.println("LOlo");
                    return courseListInSem;

            }
            System.out.println("Hhiih");
            return courseListInSem;
        }
        System.out.println("Hoooho");

        return courseListInSem;
    }

    //enrolment system
    public HashMap<String,HashMap> enrolments (Student student,Course course,String semester){
        String newStudent = student.getStudentId() + student.getStudentName();
        String newCourse = course.getCourseID() + course.getCourseName();
        if(enrolmentList.containsKey(semester)){
            HashMap<String,String> enrolData = enrolmentList.get(semester); //Hashmap(newCourse (Key), newStudent (Value))
            String enrolInfo = enrolData.get(newCourse);
            if(enrolData.containsKey(newCourse) && enrolInfo.contains(newStudent)){
                System.out.println("Already enrol");

            }
        }
        else {
            HashMap<String,String> newEnrolData = new HashMap<>();
            newEnrolData.put(newCourse,newStudent);
            enrolmentList.put(semester,newEnrolData);
        }
        return enrolmentList;
    }


    public void update_student(Student student) {
        if (course.getStudentList().contains(student)) {
            student.setStudentId("S003");
            student.setStudentName("Nam");
            student.setBirthdate("02/02/2002");
        }
    }

    public void delete_student(Student student){
        if (course.getStudentList().contains(student)) {
            course.getStudentList().remove(student);
            System.out.println("Delete successfully");
        }
    }
    public void getOne(Student student, Course course){
        if (course.getStudentList().contains(student)) {
            System.out.println(student);
        }
    }
    public void getAll(Course course){
        for (Student studentz: course.getStudentList()){
            System.out.println(studentz);
        }
    }

}
