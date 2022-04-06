import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        StudentEnrolment se = new StudentEnrolment();
//        Example of a course
//        Course course1 = new Course("M002", "Further Programming", 12);


//        Example of a student
//        Student s2 = new Student("s12345", "Nguyen Van A", "12/12/1212");



        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---- Welcome to the Student Management System ----");
            System.out.println(" Please enter your choice: ");
            System.out.println("1 Add a student ");
            System.out.println("2 Add a course");
            System.out.println("3 Enroll");
            System.out.println("4 Print all course in a semester ");
            System.out.println("5 Print all students in one course in semester ");
            System.out.println("6 Print all courses that student enrol in semester");
            System.out.println("7 Drop a course");
            System.out.println("8 Update a student's info");
            System.out.println("9 sign out ");
            System.out.println("Please enter the number:");
            String line = sc.nextLine();

            //Add a student to student lists
            if (line.equals("1")) {
                System.out.println("Enter the student ID: ");
                String sID = sc.nextLine();
                System.out.println("Enter the student name: ");
                String sName = sc.nextLine();
                System.out.println("Enter the birthday");
                String sDoB = sc.nextLine();
                Student stu = new Student(sID, sName, sDoB);
                System.out.println(se.add_studentList(stu));
                System.out.println("Exit Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            //Add a course to course lists
            if (line.equals("2")) {
                System.out.println("Enter the course ID: ");
                String cID = sc.nextLine();
                System.out.println("Enter the course name: ");
                String cName = sc.nextLine();
                System.out.println("Enter the credit");
                Integer credit = sc.nextInt();
                Course cou = new Course(cID, cName, credit);
                System.out.println(se.add_courselist(cou));
                System.out.println("Exit Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            //Enrol a student in some course in semester
            else if (line.equals("3")) {
                System.out.println("Please enter the student ID:");
                String sID = sc.nextLine();
                System.out.println("Please enter the course ID");
                String cID = sc.nextLine();
                System.out.println("Please enter the semester:");
                String semester = sc.nextLine();
                System.out.println(se.enrolments(sID, cID, semester));
                System.out.println("Exit: Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            // Print all courses in a semester (after enrol)
            else if (line.equals("4")) {
                System.out.println("Please enter the semester: ");
                String semester = sc.nextLine();
                System.out.println(se.courseInSem(semester));
                System.out.println("Exit: Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            //Print all student enrol that course in semester
            else if (line.equals("5")) {
                System.out.println("Please enter the course ID: ");
                String cID = sc.nextLine();
                System.out.println("Please enter the semester: ");
                String semester = sc.nextLine();
                System.out.println(se.get_all_student(cID, semester));
                System.out.println("Exit: Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            //Print all course that student enroll in a semester
            else if (line.equals("6")) {
                System.out.println("Please enter the student ID: ");
                String sID = sc.nextLine();
                System.out.println("Please enter the semester: ");
                String semester = sc.nextLine();
                System.out.println(se.get_all_course(sID, semester));
                System.out.println("Exit: Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            //Drop a course
            else if (line.equals("7")) {
                System.out.println("Please enter the student ID: ");
                String sID = sc.nextLine();
                System.out.println("Please enter the course ID: ");
                String cID = sc.nextLine();
                System.out.println("Please enter the semester: ");
                String semester = sc.nextLine();
                System.out.println(se.drop_course(sID,cID,semester));
                System.out.println("Exit: Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            //Update student information
            else if (line.equals("8")) {
                System.out.println("Please enter the student ID: ");
                String sID = sc.nextLine();
                System.out.println("Please enter the student name: ");
                String name = sc.nextLine();
                System.out.println("Please enter student birthday: ");
                String birthday = sc.nextLine();
                System.out.println(se.update_student(sID,name,birthday));
                System.out.println("Exit: Y/N?");
                String line2 = sc.nextLine();
                if(line2.equals("N")){
                    continue;
                }
                else if(line2.equals("Y")){
                    break;
                }
            }

            //Exit the app
            else if (line.equals("9")) {
                System.out.println(" Exiting the program.... ");
                System.out.println("Thank for using the app");
                break;
            }

            //If input any key except the number
            else {
                break;
            }
        }
    }
}