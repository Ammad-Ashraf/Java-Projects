import java.util.ArrayList;
import java.util.List;

public class Enrollment
{
    private List<Course> courses;
    private List<List<Student>> enrolledStudents;

    public Enrollment() 
    {
        this.courses = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Course course, Student student) 
    {
        int index = courses.indexOf(course);
        if (index == -1)
        { 
            courses.add(course);
            List<Student> students = new ArrayList<>();
            students.add(student);
            enrolledStudents.add(students);
        } else 
        {
            
            List<Student> students = enrolledStudents.get(index);
            if (!students.contains(student))
            { 
                students.add(student);
            }
        }
    }

    
    public void dropStudent(Course course, Student student)
    {
        int index = courses.indexOf(course);
        if (index != -1)
        {
            List<Student> students = enrolledStudents.get(index);
            students.remove(student);
        }
    }

    
    public void displayEnrolledStudents(Course course)
    {
        int index = courses.indexOf(course);
        if (index != -1)
        {
            List<Student> students = enrolledStudents.get(index);
            if (!students.isEmpty()) 
            {
                System.out.println("Enrolled students in " + course.getCourseName() + ":");
                for (Student student : students) 
                {
                    System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
                }
            } else 
            {
                System.out.println("No students enrolled in " + course.getCourseName());
            }
        } else 
        {
            System.out.println("Course not found: " + course.getCourseName());
        }
    }
}
