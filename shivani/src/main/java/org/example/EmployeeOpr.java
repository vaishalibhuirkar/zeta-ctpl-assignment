
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeOpr {
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.name.equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        return employees.removeIf(employee -> employee.id == id);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeWithHighestSalary() {
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
    }

    public Employee getEmployeeWithSecondHighestSalary() {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    public void sortEmployeesByJoiningDate() {
        employees.sort(Comparator.comparing(e -> e.joiningDate));
    }

    public List<Employee> getEmployeesAboveSalary(double cutoffSalary) {
        return employees.stream().filter(e -> e.salary > cutoffSalary).collect(Collectors.toList());
    }

    public List<Employee> getEmployeesBelowSalary(double cutoffSalary) {
        return employees.stream().filter(e -> e.salary < cutoffSalary).collect(Collectors.toList());
    }
}
