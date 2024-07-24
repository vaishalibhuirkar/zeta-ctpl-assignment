package org.example;

import java.util.*;
import java.text.*;

public class Main {
    private static EmployeeOpr employeeOpr = new EmployeeOpr();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    public static void main(String[] args) {
        while (true) {
            try {
                printMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addNewEmployee();
                        break;
                    case 2:
                        searchEmployeeByName();
                        break;
                    case 3:
                        deleteEmployee();
                        break;
                    case 4:
                        printAllEmployees();
                        break;
                    case 5:
                        printEmployeeWithHighestSalary();
                        break;
                    case 6:
                        printEmployeeWithSecondHighestSalary();
                        break;
                    case 7:
                        sortEmployeesByJoiningDateDesc();
                        break;
                    case 8:
                        getEmployeesWithSalaryGreaterThan();
                        break;
                    case 9:
                        countEmployeesJoinedInYear();
                        break;
                    default:
                        throw new InvalidChoiceException("Invalid choice. Please select a valid option.");
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add new Employee");
        System.out.println("2. Search employee by name");
        System.out.println("3. Delete employee");
        System.out.println("4. Print all employees");
        System.out.println("5. Print employee details who has highest salary");
        System.out.println("6. Print employee details who has second highest salary");
        System.out.println("7. Sort the employee details by their date of joining in descending order");
        System.out.println("8. Get all employees having salary greater than x");
        System.out.println("9. Count all the employees who joined in year x");
        System.out.print("Enter your choice: ");
    }

    private static void addNewEmployee() throws ParseException {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Address ID: ");
        int addressId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter Pincode: ");
        String pincode = scanner.nextLine();

        Address address = new Address(addressId, city, pincode);

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Joining Date (MM-dd-yyyy): ");
        Date joiningDate = sdf.parse(scanner.nextLine());

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Employee employee = new Employee(id, name, address, age, joiningDate, salary);
        employeeOpr.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void searchEmployeeByName() {
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        Employee employee = employeeOpr.searchEmployeeByName(name);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (employeeOpr.deleteEmployee(id)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void printAllEmployees() {
        List<Employee> employees = employeeOpr.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void printEmployeeWithHighestSalary() {
        Employee employee = employeeOpr.getEmployeeWithHighestSalary();
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("No employees found.");
        }
    }

    private static void printEmployeeWithSecondHighestSalary() {
        Employee employee = employeeOpr.getEmployeeWithSecondHighestSalary();
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("No employees found.");
        }
    }

    private static void sortEmployeesByJoiningDateDesc() {
        List<Employee> employees = employeeOpr.sortEmployeesByJoiningDateDesc();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void getEmployeesWithSalaryGreaterThan() {
        System.out.print("Enter cutoff Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        List<Employee> employees = employeeOpr.getEmployeesWithSalaryGreaterThan(salary);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void countEmployeesJoinedInYear() throws ParseException {
        System.out.print("Enter cutoff Joining Date (MM-dd-yyyy): ");
        Date cutoffDate = sdf.parse(scanner.nextLine());
        Calendar cal = Calendar.getInstance();
        cal.setTime(cutoffDate);
        int year = cal.get(Calendar.YEAR);
        long count = employeeOpr.countEmployeesJoinedInYear(year);
        System.out.println("Number of employees who joined in year " + year + ": " + count);
    }
}
