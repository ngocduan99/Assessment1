import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        while (true) {
            System.out.println("---- Welcome to the Student Management System ----");
            System.out.println(" Please enter your choice: ");
            System.out.println("1 Add a student ");
            System.out.println("2 Enrol");
            System.out.println("3 Print all course in a semester ");
            System.out.println("4 Print all students in one course in semester ");
            System.out.println("5 Print all courses that student enrol in semester");
            System.out.println("6 sign out ");

            StudentEnrolment se = new StudentEnrolment();
            Scanner sc = new Scanner(System.in);
            Course course1 = new Course("M002", "Further Programming", 12);
            Course course2 = new Course("M003", "User Interface Design", 24);
            Student s1 = new Student("S002", "Duan", "12/1/2021");
            Student s2 = new Student("s12345", "Nguyen Van A", "12/12/1212");
            se.add_studentList(s1);
            se.add_studentList(s2);
            se.add_courselist(course1);
            se.add_courselist(course2);


            String lines = sc.nextLine();
            switch (lines) {
                case "1":
                    System.out.println(" Add a student ");
                    addStudent(se,sc);
                    break;
                case "2":
                    System.out.println(" Enrol ");
                    enrol(se,sc);
                    break;
                case "3":
                    System.out.println(" Print all course in semester ");
                    allCourse(se,sc);
                    break;
                case "4":
                    System.out.println(" Print out all student ");
                    allStudentInCourse(se,sc);
                    break;
                case "5":
                    System.out.println(" Print out all courses this student enrol ");
                    allCourseInStudent(se,sc);
                    break;
                case "6":
                    System.out.println(" Thank you for using. ");
                    System.exit(0);
            }
        }
    }

    // add a student
    public static void addStudent(StudentEnrolment se, Scanner sc) {
        System.out.println("Please enter student ID:");
        String sID = sc.nextLine();
        System.out.println("Please enter student name:");
        String sName = sc.nextLine();
        System.out.println("Please enter student birthday:");
        String sDoB = sc.nextLine();

        System.out.println(se.input_student(sID,sName,sDoB));
    }


    //enrolment system
    public static void enrol(StudentEnrolment se, Scanner sc) {
        System.out.println("Please enter the student ID:");
        String sID = sc.nextLine();
        System.out.println("Please enter the course ID");
        String cID = sc.nextLine();
        System.out.println("Please enter the semester:");
        String semester = sc.nextLine();
        System.out.println(se.enrolments(sID,cID,semester));
    }

    //Print all course
    public static void allCourse(StudentEnrolment se, Scanner sc){
        System.out.println("Please enter the semester: ");
        String semester = sc.nextLine();
        System.out.println(se.courseInSem(semester));
    }

    //Print all student in one course in one semester
    public static void allStudentInCourse(StudentEnrolment se, Scanner sc){
        System.out.println("Please enter the course ID: ");
        String cID = sc.nextLine();
        System.out.println("Please enter the semester: ");
        String semester = sc.nextLine();
        System.out.println(se.get_all_student(cID,semester));
    }

    public static void allCourseInStudent(StudentEnrolment se, Scanner sc){
        System.out.println("Please enter the student ID: ");
        String sID = sc.nextLine();
        System.out.println("Please enter the semester: ");
        String semester = sc.nextLine();
        System.out.println(se.get_all_course(sID,semester));
    }
}