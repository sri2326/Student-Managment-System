package Student_Mangment_System;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        try {
            sms.loadFromFile("students.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing student data found. Starting fresh.");
        }

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = -1;
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear invalid input
                continue;
            }
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Roll-No: ");
                    int roll_no = -1;
                    try {
                        roll_no = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid roll number. Please enter a valid integer.");
                        sc.next();  // Consume invalid input
                        break;
                    }
                    sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    if (grade.isEmpty()) {
                        System.out.println("Grade cannot be empty.");
                        break;
                    }

                    sms.addStudent(new Student(name, roll_no, grade));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter the Roll-No of Student to remove: ");
                    try {
                        roll_no = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid roll number. Please enter a valid integer.");
                        sc.next();  // Consume invalid input
                        break;
                    }
                    if (sms.removeStudent(roll_no)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    sc.nextLine();  // Consume newline
                    break;

                case 3:
                    System.out.print("Enter the Roll-No of Student to search: ");
                    try {
                        roll_no = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid roll number. Please enter a valid integer.");
                        sc.next();  // Consume invalid input
                        break;
                    }
                    Student student = sms.searchStudent(roll_no);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    sc.nextLine();  // Consume newline
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    try {
                        sms.saveToFile("students.dat");
                        System.out.println("Student data saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Error saving student data.");
                    }
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
