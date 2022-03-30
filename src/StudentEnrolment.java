import javax.print.DocFlavor;
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
    private ArrayList<Student> studentsLists;
    private HashMap<String,ArrayList> courseListInSem;
    private HashMap<Course,ArrayList> studentListInCourse;

    public StudentEnrolment() {
        this.coursesLists = new ArrayList<>();
        this.semesterList = new ArrayList<>();
        this.courseListInSem = new HashMap<>();
        this.studentsLists = new ArrayList<>();
        this.studentListInCourse = new HashMap<>();
        this.enrolmentList = new HashMap<>();
    }



    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.enrolmentList = new HashMap<>();
        this.semesterList = new ArrayList<String>();
        this.courseListInSem = new HashMap<>();
        this.studentListInCourse = new HashMap<>();
        this.coursesLists = new ArrayList<Course>();
    }

    public ArrayList<Student> getStudentsLists() {
        return studentsLists;
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

    //add_course function
    public boolean add_course (Course course,Student student) {
        if(student.getCourseList().contains(course)){
            return false;
        }
        else{
            student.getCourseList().add(course);
            return true;
        }
    }

    //add course to course list
    public boolean add_courselist (Course course){
        for(Course couTemp : coursesLists)
            if(couTemp.equals(course)){
                return false;
            }
            coursesLists.add(course);
            return true;
    }

    //add student to student list
    public boolean add_studentList (Student student) {
        for (Student stuTemp : studentsLists)
            if (stuTemp.equals(student)) {
                return false;
            }
            studentsLists.add(student);
            return true;
    }

    //input info of student
    public boolean input_student (String id, String name, String birthdate){
        for (Student stuTemp : studentsLists)
            if(stuTemp.getStudentId().equals(id)){
                return false;
            }
            Student stu = new Student(id, name, birthdate);
            studentsLists.add(stu);
            return true;
    }

    //input info of course
    public boolean input_course (String id, String name, String credits){
        for (Course couTemp: coursesLists)
            if(couTemp.getCourseID().equals(id)){
                return false;
            }
            Course cou = new Course(id,name,Integer.parseInt(credits));
            coursesLists.add(cou);
            return true;
    }

    // add semester to semester list
    public boolean add_semester (String semester){
        if(semesterList.contains(semester)){
            return false;
        }
            semesterList.add(semester);
            ArrayList<Course> courseLists = new ArrayList<>();
            courseListInSem.put(semester,courseLists);
            return true;
    }


    //Add courses list in one semester
    public HashMap<String, ArrayList> getCourseListInSem(String semester, Course course) {
        if(courseListInSem.containsKey(semester)){
            if(coursesLists.contains(course)){
                ArrayList<Course> couTemp = courseListInSem.get(semester);
                for (Course couTemp2 : couTemp)
                if(couTemp2.equals(course)){
                    return courseListInSem;
                }
                    couTemp.add(course);
                    courseListInSem.put(semester, couTemp);
                    return courseListInSem;
            }
            return courseListInSem;
        }
        return courseListInSem;
    }

    //enrolment system
    public String enrolments (String studentId,String courseId,String semester) {
        String alarmMess = "";
        String studentInfor = "";
        String courseInfor = "";
        String totalData = "";

        for (Student i : studentsLists) {
            if (i.getStudentId().equals(studentId)) {
                studentInfor = i.toString();
            }
        }
        if (studentInfor.equals("")) {
            alarmMess = "student ID not exist";
        }
        for (Course i : coursesLists) {
            if (i.getCourseID().equals(courseId)) {
                courseInfor = i.toString();
            }
        }
        if (courseInfor.equals("")) {
            alarmMess += "course ID not exist";
            return alarmMess;
        }
        totalData = studentInfor + " and " + courseInfor;
        return totalData;

    }






//        String newStudent = student.getStudentId() + student.getStudentName() + student.getBirthDate();
//        String newCourse = course.getCourseID() + course.getCourseName();
//        if(enrolmentList.containsKey(semester)){
//            HashMap<String,String> enrolData = enrolmentList.get(semester); //Hashmap(newCourse (Key), newStudent (Value))
//            String enrolInfo = enrolData.get(newCourse);
//            if(enrolData.containsKey(newCourse) && enrolInfo.contains(newStudent)){
//                return "Haha";
//            }
//            else if (enrolData.containsKey(newCourse)){
//                String enrolValue = enrolInfo + newCourse;
//                enrolData.put(newCourse,enrolValue);
//                enrolmentList.put(semester,enrolData);
//                return "Hihi";
//            }
//        }
//        else {
//            HashMap<String,String> newEnrolData = new HashMap<>();
//            newEnrolData.put(newCourse,newStudent);
//            enrolmentList.put(semester,newEnrolData);
//            return "Hihi";
//        }
//        return "Hehe";



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
