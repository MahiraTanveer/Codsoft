import java.io.*;
import java.util.*;

public class StudentManagement {

    public static class Student implements Serializable {
        private String name;
        private int rollNumber;
        private String grade;

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    students.add(new Student(name, rollNumber, grade));
                    System.out.println("Student added.");
                    break;
                case 2:
                    System.out.print("Enter roll number to remove student: ");
                    int rollToRemove = sc.nextInt();
                    sc.nextLine();
                    students.removeIf(student -> student.rollNumber == rollToRemove);
                    System.out.println("Student removed.");
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = sc.nextInt();
                    sc.nextLine();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.rollNumber == rollToSearch) {
                            System.out.println(student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
