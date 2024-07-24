package org.example;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Address address;
    private int age;
    private Date joiningDate;
    private double salary;

    public Employee(int id, String name, Address address, int age, Date joiningDate, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.joiningDate = joiningDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', address=" + address + ", age=" + age + ", joiningDate=" + joiningDate + ", salary=" + salary + "}";
    }
}
