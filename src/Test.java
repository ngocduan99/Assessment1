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




        // add_student into list
        se.add_studentList(s1);
        se.add_studentList(s2);

        //add_course into list
        se.add_courselist(course1);
        se.add_courselist(course2);


        //add_course into semester lists
//        se.getCourseListInSem("A/2021",course1);
//        se.getCourseListInSem("A/2021",course2);

        //Test result

        System.out.println(se.getCourseListInSem());

        System.out.println(se.getStudentsLists());

        System.out.println(se.getCoursesLists());

        //Enrol more courses
//        System.out.println(se.enrolments("S003","M002","A/2021"));
//        System.out.println(se.enrolments("S003","M004","A/2021"));
//        System.out.println(se.enrolments("S003","M003","A/2021"));
//        System.out.println(se.enrolments("S004","M002","A/2021"));

        //Enrol 2 different student
        System.out.println(se.enrolments("S004", "M003", "A/2021"));


        System.out.println(se.enrolments("S003", "M003", "A/2021"));

        System.out.println(se.enrolments("S003", "M004", "A/2021"));
        System.out.println(se.enrolments("S003","M003","A/2021"));
        System.out.println(se.enrolments("S003","M003","A/2021"));

        System.out.println(se.enrolments("S003","M004","A/2021"));
        System.out.println(se.enrolments("S004","M004","A/2021"));


        //Drop course

        System.out.println(se.drop_course("S003","M003","A/2021"));
        System.out.println(se.drop_course("S003","M002","A/2021"));

        //Get all course of one student in semester

        System.out.println(se.get_all_course("S003", "A/2021"));
        System.out.println(se.get_all_course("S003", "B/2021"));

        //Get all student of one course in semester

        System.out.println(se.get_all_student("M003", "A/2021"));

        //Get all course

        System.out.println(se.courseInSem("B/2021"));

        //Update info student
        System.out.println(se.update_student("S002","Nam","021221"));
    }
}
