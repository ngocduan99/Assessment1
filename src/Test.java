import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Course course1 = new Course("M002","Further Programming",12);
        Student student = new Student("S002","Duan","01212");
        Student s2 = new Student("s12345","Nguyen Van A","12/12/1212");
        StudentEnrolment se = new StudentEnrolment();

        se.print_student(student,course1);
        se.print_student(s2,course1);
        System.out.println(course1.getStudentsList());
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
