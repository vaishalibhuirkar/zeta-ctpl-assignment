package org.pavan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
// write import the employee class



public class Main {
    public static void main(String[] args) {
        EmployeeOpr employeeOpr = new EmployeeOpr();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Employee employee1 = new Employee(1, "Pavan", new Address(1, "Pune", 123456), 22, formatter.parse("2020-01-15"), 50000);
            Employee employee2 = new Employee(2, "Vishal", new Address(2, "Mumbai", 654321), 26, formatter.parse("2019-03-22"), 55000);
            Employee employee3 = new Employee(3, "Nitesh", new Address(3, "Pune", 99999), 28, formatter.parse("2018-06-30"), 60000);

            employeeOpr.addEmployee(employee1);
            employeeOpr.addEmployee(employee2);
            employeeOpr.addEmployee(employee3);

        } catch (ParseException e) {
            throw new RuntimeException("Error in parsing date while adding the default employees");
        }

        while (true) {
            System.out.println();
            System.out.println("************ Menu ***********");
            System.out.println("1. Add new Employee");
            System.out.println("2. Search employee by name");
            System.out.println("3. Delete employee by name");
            System.out.println("4. Delete employee by ID");
            System.out.println("5. Print all employees");
            System.out.println("6. Print employee with highest salary");
            System.out.println("7. Print employee with second highest salary");
            System.out.println("8. Sort employees by joining date");
            System.out.println("9. Get employees with salary greater than x");
            System.out.println("10. Count employees who joined in year x");
            System.out.println("11. Exit");
            System.out.print("Choose Operation -> ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.print("Enter employee id = ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter employee name = ");

                        String name = scanner.nextLine();

                        System.out.print("Enter address id = ");
                        int addressId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter city = ");
                        String city = scanner.nextLine();

                        System.out.print("Enter pincode = ");
                        int pincode = Integer.parseInt(scanner.nextLine());
                        Address address = new Address(addressId, city, pincode);

                        System.out.print("Enter age = ");
                        int age = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter joining date (yyyy-MM-dd) = ");
                        Date joiningDate = formatter.parse(scanner.nextLine());

                        System.out.print("Enter salary = ");
                        double salary = Double.parseDouble(scanner.nextLine());

                        Employee employee = new Employee(id, name, address, age, joiningDate, salary);
                        employeeOpr.addEmployee(employee);
                        System.out.println("Employee added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter employee name to search = ");
                        String searchName = scanner.nextLine();
                        Employee foundEmployee = employeeOpr.searchEmployeeByName(searchName);
                        if (foundEmployee != null) {
                            System.out.println(foundEmployee);
                        } else {
                            System.out.println("Employee not found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter employee name to delete = ");
                        String deleteName = scanner.nextLine();
                        boolean isDeletedByName = employeeOpr.deleteEmployeeByName(deleteName);
                        if (isDeletedByName) {
                            System.out.println("Employee deleted successfully!");
                        } else {
                            System.out.println("Employee not found!!!!!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter employee id to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        boolean isDeletedById = employeeOpr.deleteEmployeeById(deleteId);
                        if(isDeletedById) {
                            System.out.println("Employee deleted successfully!");
                        }else{
                            System.out.println("Employee not found!!!!!");
                        }
                        break;

                    case 5:
                        System.out.println("All employees = ");
                        employeeOpr.getAllEmployees().forEach(System.out::println);
                        break;

                    case 6:
                        Employee highestSalaryEmployee = employeeOpr.getEmployeeWithHighestSalary();
                        if (highestSalaryEmployee != null) {
                            System.out.println("Employee with highest salary is " + highestSalaryEmployee.getName()
                                            +  " with salary " + highestSalaryEmployee.getSalary()
                            );
                        } else {
                            System.out.println("No Employee Present");
                        }
                        break;

                    case 7:
                        Employee secondHighestSalaryEmployee = employeeOpr.getEmployeeWithSecondHighestSalary();
                        if(secondHighestSalaryEmployee != null) {
                            System.out.println("Employee with second highest salary is " + secondHighestSalaryEmployee.getName() +
                                                " with salary " + secondHighestSalaryEmployee.getSalary()
                            );
                        }else{
                            System.out.println("No Employee Present");
                        }
                        break;

                    case 8:
                        System.out.println("Employees sorted by joining dates are");
                        employeeOpr.sortEmployeesByJoiningDate().forEach(System.out::println);
                        break;

                    case 9:
                        System.out.print("Enter salary = ");
                        double salaryThreshold = Double.parseDouble(scanner.nextLine());
                        System.out.println("Employees with salary greater than " + salaryThreshold + " are ");
                        employeeOpr.getEmployeesWithSalaryGreaterThan(salaryThreshold).forEach(System.out::println);
                        break;

                    case 10:
                        System.out.print("Enter year = ");
                        int year = Integer.parseInt(scanner.nextLine());
                        long count = employeeOpr.countEmployeesJoinedInYear(year);
                        System.out.println("Number of employees who joined in year " + year + " are " + count);
                        break;

                    case 11:
                        System.out.println("Exit");
                        System.exit(0);
                        break;

                    default:
                        throw new CustomException("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}