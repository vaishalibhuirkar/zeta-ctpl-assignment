package org.pavan;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeOpr {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public Employee searchEmployeeByName(String name) {
        for(Employee emp : employees) {
            if(emp.getName().equalsIgnoreCase(name)){
                return emp;
            }
        }
        return null;
    }

    public boolean deleteEmployeeByName(String name) {
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee emp = iterator.next();
            if(emp.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployeeById(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee emp = iterator.next();
            if(emp.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee getEmployeeWithHighestSalary() {
        if(employees.isEmpty()) {
            return null;
        }
        Employee employee = employees.get(0);
//      String name = highestSalaryEmployee.getName();
        for(Employee emp : employees) {
            if(emp.getSalary() > employee.getSalary()) {
                employee = emp;
            }
        }
        return employee;
    }

    public Employee getEmployeeWithSecondHighestSalary() {
        Employee employee = getEmployeeWithHighestSalary();
        Employee ans = null;
        for(Employee emp : employees) {
            if(emp != employee) {
                if(ans==null) ans = emp;
                if(emp.getSalary() > ans.getSalary()) {
                    ans = emp;
                }
            }
        }
        return ans;
    }

    public List<Employee> sortEmployeesByJoiningDate() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getJoiningDate))
                .collect(Collectors.toList());
    }


    public List<Employee> getEmployeesWithSalaryGreaterThan(double salary) {
        List<Employee> ans = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getSalary() > salary) {
                ans.add(emp);
            }
        }
        return ans;
    }

    public long countEmployeesJoinedInYear(int year) {
        Calendar cal = Calendar.getInstance();
        long count = 0;
        for (Employee emp : employees) {
            cal.setTime(emp.getJoiningDate());
            if (cal.get(Calendar.YEAR) == year) {
                count++;
            }
        }
        return count;
    }
}
