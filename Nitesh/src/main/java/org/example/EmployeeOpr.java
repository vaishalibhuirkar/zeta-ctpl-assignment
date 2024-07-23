package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeOpr {
    private List<Employee> employees;

    public EmployeeOpr() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    public boolean deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
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

    public List<Employee> sortEmployeesByJoiningDateDesc() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getJoiningDate).reversed())
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWithSalaryGreaterThan(double salary) {
        return employees.stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }

    public long countEmployeesJoinedInYear(int year) {
        Calendar cal = Calendar.getInstance();
        return employees.stream()
                .filter(employee -> {
                    cal.setTime(employee.getJoiningDate());
                    return cal.get(Calendar.YEAR) == year;
                })
                .count();
    }
}

