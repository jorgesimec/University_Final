import java.util.ArrayList;
import java.util.List;

class Class {
    private String name;
    private String classroom;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Class(String name, String classroom, Teacher selectedTeacher) {
        this.name = name;
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public Student[] getStudents() {
        return new Student[0];
    }

    public Class getTeacher() {
        return null;
    }
}