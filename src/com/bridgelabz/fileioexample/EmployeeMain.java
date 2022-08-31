package com.bridgelabz.fileioexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMain {
    static Scanner sc = new Scanner(System.in);

    static List<Employee> employeeList = new ArrayList<>();
    public static void addEmployeeData() {

        Employee employee = new Employee();

        int randomId = (int) (Math.random() * 899 + 100);
        employee.setId(randomId);
        System.out.println("Employee ID: "+ randomId);
        System.out.println("Enter the employee name: ");
        employee.setName(sc.next());
        System.out.println("Enter the employee salary: ");
        employee.setSalary(sc.nextDouble());

        employeeList.add(employee);
    }

    public static void readAndWriteOntoFile() {

        EmployeeFileIO employeeFileIO = new EmployeeFileIO();

        if(employeeFileIO.writeEmployeeData(employeeList)){
            employeeFileIO.readEmployeeData();
        }else{
            System.out.println("Error occurred in saving data onto file.");
        }


    }

    public static void main(String[] args) {

        while(true){

            System.out.println("Would you like to add employee data ?");
            System.out.println("1. Add Employee Data");
            System.out.println("2. Exit");
            int choice = sc.nextInt();

            if(choice == 1){
                addEmployeeData();
            }else{
                readAndWriteOntoFile();
                break;
            }



        }

    }




}
