public class Test {
    public static void main (String args[]){
        Student student1 = new Student("S001","Khang","01/01/2000");
        Course course1 = new Course("M992","DDD",12);
        StudentEnrolment s2 = new StudentEnrolment(student1,course1,"SSS");
        s2.update_student(student1);
        s2.add_student(student1,course1);
        s2.delete_student(student1);
        System.out.println(student1.toString());
    }
}
