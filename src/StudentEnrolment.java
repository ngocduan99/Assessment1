import javax.print.DocFlavor;
import java.util.*;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;
    private ArrayList<Course> coursesLists;
    private HashMap<String, HashMap> enrolmentList;
    private ArrayList<String> semesterList;
    private ArrayList<Student> studentsLists;
    private HashMap<String, ArrayList> courseListInSem;


    public StudentEnrolment() {
        this.coursesLists = new ArrayList<>();
        this.semesterList = new ArrayList<>();
        this.courseListInSem = new HashMap<>();
        this.studentsLists = new ArrayList<>();
        this.enrolmentList = new HashMap<>();
    }


    public StudentEnrolment(Student student, Course course, String semester) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.enrolmentList = new HashMap<>();
        this.semesterList = new ArrayList<String>();
        this.courseListInSem = new HashMap<>();
        this.coursesLists = new ArrayList<Course>();
    }

    //Getter and Setter
    public HashMap<String, ArrayList> getCourseListInSem() {
        return courseListInSem;
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


    //add course to course list
    public boolean add_courselist(Course course) {
        for (Course cou : coursesLists) {
            if (cou.getCourseID().equals(course.getCourseID())) {
                System.out.println("The course ID is already exists");
                return false;
            }
        }
        System.out.println(course);
        coursesLists.add(course);
        return true;
    }

    //add student to student list
    public boolean add_studentList(Student student) {
        for (Student stu : studentsLists) {
            if (stu.getStudentId().equals(student.getStudentId())) {
                System.out.println("The student ID is already exists");
                return false;
            }
        }
        System.out.println(student);
        studentsLists.add(student);
        return true;
    }

    //Update a student
    public String update_student(String Id, String name, String birth) {
        for (Student stu: studentsLists) {
            if (stu.getStudentId().equals(Id)) {
                stu.setStudentName(name);
                stu.setBirthdate(birth);
                System.out.println(stu);
                return "Change successfully";
            }
            else {
                return "Can not find this student ID";
            }
        }
        return "Can find this student";
    }


    //add course in the semester
    public boolean addCourseinSem(String semester, Course course) {
        ArrayList<Course> list = new ArrayList<>();
        if (list.contains(course) && courseListInSem.containsKey(semester)) {
            System.out.println("The course is already in the semester");
            return false;
        }
        else {
            list.add(course);
            courseListInSem.put(semester, list);
            System.out.println(courseListInSem);
            System.out.println("Add new course in new semester");
            return true;
        }
    }

    //Enrolment + update system
    public String enrolments(String studentId, String courseId, String semester) {
        String alarmMess = "";
        String studentInfor = "";
        String courseInfor = "";

        // Check if this student is already in the student lists
        for (Student i : studentsLists) {
            if (i.getStudentId().equals(studentId)) {
                studentInfor = i.toString();
            }
        }
        if (studentInfor.equals("")) {
            alarmMess = "student ID not exist";
        }

        // Check if this course is already in the course lists
        for (Course i : coursesLists) {
            if (i.getCourseID().equals(courseId)) {
                courseInfor = i.toString();
            }
        }
        if (courseInfor.equals("")) {
            alarmMess += "course ID not exist";
            return alarmMess;
        }

        //Main function
        if (enrolmentList.containsKey(semester)) {
            HashMap<String, String> enrolData = enrolmentList.get(semester); //Hashmap(studentInfo (Key), courseInfo (Value))
            String enrolInfo = enrolData.get(studentInfor);
            //if data have both student info and course info
            if (enrolData.containsKey(studentInfor) && enrolInfo.contains(courseInfor)) {
                return "Already enrol before";
            }
            //If data have student info but they need update more course
            else if (enrolData.containsKey(studentInfor)) {
                String enrolInfo2 = enrolInfo + "\'" + courseInfor; //Plus another course if student enrol more

                enrolData.put(studentInfor, enrolInfo2);
                enrolmentList.put(semester, enrolData);
                System.out.println(enrolmentList);
                return "Enrol more successfully";
            }
            //If data have student info but no any course info
            else {
                enrolData.put(studentInfor, courseInfor);
                enrolmentList.put(semester, enrolData);
                System.out.println(enrolmentList);
                return "Enrol new course success";
            }
        }
        // If data dont have any student, course
        else {
            HashMap<String, String> newEnrolData = new HashMap<String, String>();
            newEnrolData.put(studentInfor, courseInfor);
            enrolmentList.put(semester, newEnrolData);
            System.out.println(enrolmentList);
            return "Enrol new semeter successfully";
        }
    }


    // Delete/drop any course by student
    public String drop_course(String studentId, String courseId, String semester) {
        String alarmMess = "";
        String studentInfor = "";
        String courseInfor = "";

        // Check if this student is already in the student lists
        for (Student i : studentsLists) {
            if (i.getStudentId().equals(studentId)) {
                studentInfor = i.toString();
            }
        }
        if (studentInfor.equals("")) {
            alarmMess = "student ID not exist";
        }
        //Check if this course is already in the course lists
        for (Course i : coursesLists) {
            if (i.getCourseID().equals(courseId)) {
                courseInfor = i.toString();
            }
        }
        if (courseInfor.equals("")) {
            alarmMess += "course ID not exist";
            return alarmMess;
        }

        //Main function
        if (enrolmentList.containsKey(semester)) {
            HashMap<String, String> enrolData = enrolmentList.get(semester);
            if (enrolData.get(studentInfor).contains(courseInfor)) {
                String newData = enrolData.get(studentInfor).replace(courseInfor, "");
                enrolData.put(studentInfor, newData);
                System.out.println(enrolmentList);
                return "Delete successfully";
            } else {
                alarmMess = "Input wrong course";
                return alarmMess;
            }
        } else {
            alarmMess = "Can not find this semester";
            return alarmMess;
        }
    }

    // Print all courses for 1 student in semester
    public String get_all_course(String studentId, String semester) {
        String alarmMess = "";
        String studentInfor = "";

        // Check if this student is already in the student lists
        for (Student i : studentsLists) {
            if (i.getStudentId().equals(studentId)) {
                studentInfor = i.toString();
            }
        }
        if (studentInfor.equals("")) {
            alarmMess = "student ID not exist";
            return alarmMess;
        }

        //Main function
        if (enrolmentList.containsKey(semester)) {
            HashMap<String, String> enrolData = enrolmentList.get(semester);
            if (enrolData.containsKey(studentInfor)) {
                for (String i : enrolData.keySet()) {
                    System.out.println("Course: " + "\'" + enrolData.get(i) + "in semester:" + "" + semester);
                    return "Done";
                }
            } else {
                alarmMess = "Can not find the studentId";
                return alarmMess;
            }
        } else {
            alarmMess = "Can not find the semester";
            return alarmMess;
        }
        return "End";
    }

    //get all student in one course
    public String get_all_student(String courseId, String semester) {
        String alarmMess = "";
        String courseInfor = "";

        // Check if this course is already in the course lists
        for (Course i : coursesLists) {
            if (i.getCourseID().equals(courseId)) {
                courseInfor = i.toString();
            }
        }
        if (courseInfor.equals("")) {
            alarmMess = "course ID not exist";
            return alarmMess;
        }

        //Main function
        if (enrolmentList.containsKey(semester)) {
            HashMap<String, String> enrolData = enrolmentList.get(semester);
            for (String i : enrolData.keySet()) {
                if (enrolData.get(i).contains(courseId)) {
                    System.out.println("Student:" + i);
                } else {
                    alarmMess = "Can not find the match course ID";
                    return alarmMess;
                }
            }
        } else {
            alarmMess = "Can not find the semester";
            return alarmMess;
        }
        return "End";
    }

    //Print all course in semester
    public String courseInSem (String semester) {
        String alarmMess = "";
        String courseInfor = "";
        if(enrolmentList.containsKey(semester)){
            HashMap<String,String> enrolData = enrolmentList.get(semester);
            for(String i: enrolData.values()){
                courseInfor = i;
            }
        }
        else {
            alarmMess = "Can not find this semester";
            return alarmMess;
        }
        return courseInfor;
    }
}

