import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        while (true) {
            System.out.println("---- Welcome to the Student Management System ----");
            System.out.println(" Please enter your choice: ");
            System.out.println("1 Add a student ");
            System.out.println("2 Print all courses in semester");
            System.out.println("3 Enrol ");
            System.out.println("4 Print all students in one course in semester ");
            System.out.println("5 Print all courses that student enrol in semester");
            System.out.println("6 Print all courses in semester");
            System.out.println("7 sign out ");

            StudentEnrolment se = new StudentEnrolment();
            Scanner sc = new Scanner(System.in);
            String lines = sc.nextLine();
            switch (lines) {
                case "1":
                    System.out.println("Add a student");
                    addStudent(se,sc);
                    break;
                case "2":
                    System.out.println("Print out all courses in sem");
                    break;
                case "3":
                    System.out.println("Enrol");
                    break;
                case "4":
                    System.out.println("Print out all student");
                    break;
                case "5":
                    System.out.println("Print out all courses this student enrol");
                    break;
                case "6":
                    System.out.println(" Thank you for using. ");
                    break;
//                    System.exit(0);
            }
        }
    }

    public static void addStudent(StudentEnrolment se, Scanner sc) {
        System.out.println("Please enter student ID:");
        String sID = sc.nextLine();
        System.out.println("Please enter student name:");
        String sName = sc.nextLine();
        System.out.println("Please enter student birthday:");
        String sDoB = sc.nextLine();
        se.input_student(sID,sName,sDoB);
    }
}
