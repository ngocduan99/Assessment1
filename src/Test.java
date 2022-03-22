public class Test {
    public static void main (String args[]){
        Student student1 = new Student("S001","Khang","01/01/2000");
        Student student2 = new Student("S002","Dat","26/07/2002");
        Course course1 = new Course("M992","DDD",12);
        Course course2 = new Course("M993","MMM",12);
        StudentEnrolment s2 = new StudentEnrolment(student1,course1,"SSS");
        s2.add_student(student1,course1);
        s2.add_student(student2,course1);
        s2.update_student(student2);
        s2.delete_student(student1);
        s2.getOne(student2,course1);
        s2.getOne(student1,course1);
        s2.getAll();
    }
}
