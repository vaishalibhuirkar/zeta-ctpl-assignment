
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeOpr employeeOpr = new EmployeeOpr();

        // Sample data
        employeeOpr.addEmployee(new Employee(1, "Alice", new Address(1, "New York", 10001), 30, LocalDate.of(2020, 1, 10), 70000));
        employeeOpr.addEmployee(new Employee(2, "Bob", new Address(2, "Los Angeles", 90001), 40, LocalDate.of(2018, 3, 20), 80000));
        employeeOpr.addEmployee(new Employee(3, "Charlie", new Address(3, "Chicago", 60001), 35, LocalDate.of(2019, 5, 15), 60000));
        employeeOpr.addEmployee(new Employee(4, "David", new Address(4, "Houston", 77001), 45, LocalDate.of(2021, 7, 30), 90000));
        employeeOpr.addEmployee(new Employee(5, "Eve", new Address(5, "Phoenix", 85001), 25, LocalDate.of(2022, 9, 25), 65000));

        while (true) {
            System.out.println("1. Add new Employee");
            System.out.println("2. Search employee by name");
            System.out.println("3. Delete employee");
            System.out.println("4. Print all employees");
            System.out.println("5. Print employee details who has highest salary");
            System.out.println("6. Print employee details who has second highest salary");
            System.out.println("7. Sort the employee details by their date of join");
            System.out.println("8. Print employees with salary greater than cutoff");
            System.out.println("9. Print employees with salary less than cutoff");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Address ID: ");
                        int addressId = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter City: ");
                        String city = sc.nextLine();
                        System.out.print("Enter Pincode: ");
                        int pincode = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter Joining Date (YYYY-MM-DD): ");
                        String joiningDate = sc.nextLine();
                        LocalDate date = LocalDate.parse(joiningDate, DateTimeFormatter.ISO_LOCAL_DATE);
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        Address address = new Address(addressId, city, pincode);
                        Employee employee = new Employee(id, name, address, age, date, salary);
                        employeeOpr.addEmployee(employee);
                        break;
                    case 2:
                        System.out.print("Enter Name: ");
                        String searchName = sc.nextLine();
                        Employee foundEmployee = employeeOpr.searchEmployeeByName(searchName);
                        System.out.println(foundEmployee != null ? foundEmployee : "Employee not found");
                        break;
                    case 3:
                        System.out.print("Enter ID: ");
                        int deleteId = sc.nextInt();
                        boolean isDeleted = employeeOpr.deleteEmployee(deleteId);
                        System.out.println(isDeleted ? "Employee deleted successfully" : "Employee not found");
                        break;
                    case 4:
                        List<Employee> allEmployees = employeeOpr.getAllEmployees();
                        allEmployees.forEach(System.out::println);
                        break;
                    case 5:
                        Employee highestSalaryEmployee = employeeOpr.getEmployeeWithHighestSalary();
                        System.out.println(highestSalaryEmployee != null ? highestSalaryEmployee : "No employees found");
                        break;
                    case 6:
                        Employee secondHighestSalaryEmployee = employeeOpr.getEmployeeWithSecondHighestSalary();
                        System.out.println(secondHighestSalaryEmployee != null ? secondHighestSalaryEmployee : "No employees found");
                        break;
                    case 7:
                        employeeOpr.sortEmployeesByJoiningDate();
                        System.out.println("Employees sorted by joining date");
                        break;
                    case 8:
                        System.out.print("Enter cutoff salary: ");
                        double cutoffSalaryHigh = sc.nextDouble();
                        List<Employee> employeesAboveCutoff = employeeOpr.getEmployeesAboveSalary(cutoffSalaryHigh);
                        employeesAboveCutoff.forEach(System.out::println);
                        break;
                    case 9:
                        System.out.print("Enter cutoff salary: ");
                        double cutoffSalaryLow = sc.nextDouble();
                        List<Employee> employeesBelowCutoff = employeeOpr.getEmployeesBelowSalary(cutoffSalaryLow);
                        employeesBelowCutoff.forEach(System.out::println);
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        throw new InvalidChoiceException("Invalid choice. Please try again.");
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}

class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String message) {
        super(message);
    }
}
