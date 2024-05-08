package com.learn.java.student_management_application;

import DAO.StudentDAO;
import entities.Student;
import helper.ConnectionProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Student_management_application {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome to Student Management Application !! \nPlease choose your options: ");
        System.out.println("Enter 1 -> for Display all Student");
        System.out.println("Enter 2 -> for Find a Student");
        System.out.println("Enter 3 -> for Insert a Student");
        System.out.println("Enter 4 -> for Update a Student");
        System.out.println("Enter 5 -> for Delete a Student");
        System.out.println("Enter 6-> for Exit");

        int op = Integer.parseInt(br.readLine());

        while (true) {
            if (op == 6) 
            {
                break;
            }
            else if (op == 1) //display all the students
            {
                List<Student> students = StudentDAO.displayAllStudents();

                for (Student s : students) {
                    System.out.println("Id: " + s.getS_id());
                    System.out.println("Name: " + s.getS_name());
                    System.out.println("Department: " + s.getS_dept());
                    System.out.println("Passing year: " + s.getS_passingYear());
                    System.out.println("DOB: " + s.getS_dob());
                    System.out.println("Address: " + s.getS_address());

                    System.out.println("***********************************");

                }

            } else if (op == 2) //Find a student
            {
                System.out.println("Please enter the student id: ");
                int id = Integer.parseInt(br.readLine());

                Student stu = StudentDAO.findStudent(id);

                if (stu == null) {
                    System.out.println("Sorry! No Student found with the given Id");
                } else {
                    System.out.println("**************************************");
                    System.out.println("Id: " + stu.getS_id());
                    System.out.println("Name: " + stu.getS_name());
                    System.out.println("Department: " + stu.getS_dept());
                    System.out.println("Passing year: " + stu.getS_passingYear());
                    System.out.println("DOB: " + stu.getS_dob());
                    System.out.println("Address: " + stu.getS_address());
                    System.out.println("**************************************");
                }
            } else if (op == 3) //Insert a student
            {
                System.out.println("Please Enter Student's name: ");
                String name = br.readLine();
                System.out.println("Please Enter Student's department: ");
                String department = br.readLine();
                System.out.println("Please Enter Student's passing year: ");
                String passingYear = br.readLine();
                System.out.println("Please Enter Student's date of birth(YYYY-MM-DD): ");
                String dob = br.readLine();
                System.out.println("Please Enter Student's address: ");
                String address = br.readLine();

                Student stu = new Student(name, department, passingYear, address, dob);

                if (StudentDAO.addStudent(stu)) {
                    System.out.println("Hurray! Student data inserted successfully.");
                } else {
                    System.out.println("Sorry! Something went wrong. Please try again later");
                }

            } else if (op == 4) //Update a student
            {
                System.out.println("Caution! Please ensure that you know the correct id. ");
                System.out.println("Please enter the student id: ");
                int id = Integer.parseInt(br.readLine());
                Student stu = StudentDAO.findStudent(id);
                if (stu == null) {
                    System.out.println("Sorry! No Student found with the given Id");
                } else {
                    System.out.println("Enter 1 -> for update Name");
                    System.out.println("Enter 2 -> for update Department");
                    System.out.println("Enter 3 -> for update Passing Year");
                    System.out.println("Enter 4 -> for update Address");
                    System.out.println("Enter 5 -> for update Date of Birth");

                    int upop = Integer.parseInt(br.readLine());

                    if (upop == 1) //Update name
                    {
                        System.out.println("Please enter your updated name: ");
                        String name = br.readLine();

                        if (StudentDAO.updateStudent(upop, id, name)) {
                            System.out.println("Hurray! Student name updated successfully.");
                        } else {
                            System.out.println("Sorry! Something went wrong. Please try again later");
                        }
                    } else if (upop == 2) //Update dept..
                    {
                        System.out.println("Please enter your updated department: ");
                        String dept = br.readLine();

                        if (StudentDAO.updateStudent(upop, id, dept)) {
                            System.out.println("Hurray! Student dept updated successfully.");
                        } else {
                            System.out.println("Sorry! Something went wrong. Please try again later");
                        }
                    } else if (upop == 3) //Update Passing Year
                    {
                        System.out.println("Please enter your updated passing year:");
                        String passingYear = br.readLine();

                        if (StudentDAO.updateStudent(upop, id, passingYear)) {
                            System.out.println("Hurray! Student passingYear updated successfully.");
                        } else {
                            System.out.println("Sorry! Something went wrong. Please try again later");
                        }
                    } else if (upop == 5) //Update DOB
                    {
                        System.out.println("Please enter your updated date of birth(YYYY-MM-DD):");
                        String DOB = br.readLine();

                        if (StudentDAO.updateStudent(upop, id, DOB)) {
                            System.out.println("Hurray! Student DOB updated successfully.");
                        } else {
                            System.out.println("Sorry! Something went wrong. Please try again later");
                        }
                    } else if (upop == 4) 
                    {
                        System.out.println("Please enter your updated address: ");
                        String address = br.readLine();

                        if (StudentDAO.updateStudent(upop, id, address)) 
                        {
                            System.out.println("Hurray! Student address updated successfully.");
                        } else {
                            System.out.println("Sorry! Something went wrong. Please try again later");
                        }
                    } else 
                    {
                        System.out.println("Wrong option! Please choose again");
                    }
                }

            } else if (op == 5) //Delete a student
            {
                System.out.println("Caution! Please ensure that you know the correct id. ");
                System.out.println("Please enter the student id: ");
                int id = Integer.parseInt(br.readLine());

                if (StudentDAO.removeStudent(id)) {
                    System.out.println("Hurray! Student data deleted successfully.");
                } else {
                    System.out.println("Sorry! Something went wrong. Please try again later");
                }

            } else {
                System.out.println("Wrong option! Please choose again");
            }

            System.out.println("Please choose your options: ");
            System.out.println("Enter 1 -> for Display all Students");
            System.out.println("Enter 2 -> for Find a Student");
            System.out.println("Enter 3 -> for Insert a Student");
            System.out.println("Enter 4 -> for Update a Student");
            System.out.println("Enter 5 -> for Delete a Student");
            System.out.println("Enter 6-> for Exit");

            op = Integer.parseInt(br.readLine());

        }

        System.out.println("Thanks for using our App!! Hope you enjoyed");
    }
}
