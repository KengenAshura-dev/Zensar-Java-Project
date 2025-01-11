import java.util.ArrayList;
import java.util.Scanner;

class Student 
{
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) 
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

public class StudentManagementSystem 
{
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
            
        }
    }

    private static void addStudent() 
    {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() 
    {
        if (students.isEmpty()) 
        {
            System.out.println("No students available!");
        } 
        else 
        {
            System.out.println("\n--- Student List ---");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void updateStudent() 
    {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);

        if (student != null) 
        {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new age: ");
            int age = scanner.nextInt();

            student.setName(name);
            student.setAge(age);
            System.out.println("Student updated successfully!");
        } 
        else 
        {
            System.out.println("Student not found!");
        }
    }

    private static void deleteStudent() 
    {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } 
        else {
            System.out.println("Student not found!");
        }
    }

    private static Student findStudentById(int id) 
    {
        for (Student student : students) {
            if (student.getId() == id) 
            {
                return student;
            }
        }
        return null;
    }
}
