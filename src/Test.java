import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Course course1 = new Course("M002", "Further Programming", 12);
        Course course2 = new Course("M003", "User Interface Design", 24);
        Student s1 = new Student("S002", "Duan", "12/1/2021");
        Student s2 = new Student("s12345", "Nguyen Van A", "12/12/1212");
        StudentEnrolment se = new StudentEnrolment();


        //input student
        se.input_student("S003","Nam","02/02/2000");
        se.input_student("S004","Son","03/03/2001");

        //input course
        se.input_course("M004","Further","12");

        // add_student into list
        se.add_studentList(s1);
        se.add_studentList(s2);

        //add_course into list
        se.add_courselist(course1);
        se.add_courselist(course2);

        //add semester
        se.add_semester("A/2021");

        //add_course into semester
        se.getCourseListInSem("A/2021",course1);
        se.getCourseListInSem("A/2021",course2);

        //Test result

//        System.out.println(se.getCourseListInSem());
//
//        System.out.println(se.getStudentsLists());
//
//        System.out.println(se.getCoursesLists());

//        System.out.println(se.enrolments("S003","M002","A/2021"));
//        System.out.println(se.enrolments("S003","M003","A/2021"));
        System.out.println(se.enrolments("S004","M005","A/2021"));
        System.out.println(se.enrolments("S004","M003","A/2021"));


    }
}


//    public static void enrol_student() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter student ID:");
//        String sID = sc.nextLine();
//        System.out.println("Please enter student name:");
//        String sName = sc.nextLine();
//        System.out.println("Please enter student birthday:");
//        String sDoB = sc.nextLine();
//        Student student = new Student(sID, sName, sDoB);
//        System.out.println(student);
//
//        Course course1 = new Course("M992", "DDD", 12);
//        Course course2 = new Course("M993", "MMM", 12);
//        StudentEnrolment s = new StudentEnrolment();
//    }
//}
