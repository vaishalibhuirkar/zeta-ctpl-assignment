using System;
using System.Collections.Generic;
using System.Linq;

namespace EmployeeManagement
{
    public class EmployeeOpr
    {
        private List<Employee> employees = new List<Employee>();


        //Add new Employee
        public void AddEmployee()
        {
            Console.Write("Enter Employee Id: ");
            int id = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter Employee Name: ");
            string name = Console.ReadLine();

            Console.Write("Enter Address Id: ");
            int addressId = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter City: ");
            string city = Console.ReadLine();

            Console.Write("Enter Pincode: ");
            string pincode = Console.ReadLine();

            Address address = new Address(addressId, city, pincode);

            Console.Write("Enter Age: ");
            int age = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter Joining Date (yyyy-MM-dd): ");
            DateTime joiningDate = DateTime.Parse(Console.ReadLine());

            Console.Write("Enter Salary: ");
            decimal salary = Convert.ToDecimal(Console.ReadLine());

            Employee employee = new Employee(id, name, address, age, joiningDate, salary);
            employees.Add(employee);

            Console.WriteLine("Employee added successfully.");
        }

        //Search Employee details by Name
        public void SearchEmployeeByName()
        {
            Console.Write("Enter Employee Name to search: ");
            string name = Console.ReadLine();

            var foundEmployees = employees.Where(e => e.Name.Equals(name, StringComparison.OrdinalIgnoreCase)).ToList();

            if (foundEmployees.Any())
            {
                foreach (var emp in foundEmployees)
                {
                    Console.WriteLine(emp);
                }
            }
            else
            {
                Console.WriteLine("No employee found.");
            }
        }

        //Delete Employee by Id
        public void DeleteEmployee()
        {
            Console.Write("Enter Employee Id to delete: ");
            int id = Convert.ToInt32(Console.ReadLine());

            var employeeToRemove = employees.FirstOrDefault(e => e.Id == id);

            if (employeeToRemove != null)
            {
                employees.Remove(employeeToRemove);
                Console.WriteLine("Employee deleted successfully.");
            }
            else
            {
                Console.WriteLine("No employee found with the given Id.");
            }
        }

        //print all Employee Details
        public void PrintAllEmployees()
        {
            if (employees.Any())
            {
                foreach (var emp in employees)
                {
                    Console.WriteLine(emp);
                }
            }
            else
            {
                Console.WriteLine("No employees to display.");
            }
        }

        //get details of Employee with Highest Salary
        public void PrintHighestSalaryEmployee()
        {
            var highestSalaryEmployee = employees.OrderByDescending(e => e.Salary).FirstOrDefault();

            if (highestSalaryEmployee != null)
            {
                Console.WriteLine("Employee having highest salary is :");
                Console.WriteLine(highestSalaryEmployee);
            }
            else
            {
                Console.WriteLine("No data found");
            }
        }

        //get details of Employee with second highest salary 
        public void PrintSecondHighestSalaryEmployee()
        {
            var sortedEmployees = employees.OrderByDescending(e => e.Salary).ToList();

            if (sortedEmployees.Count > 1)
            {
                var secondHighestSalaryEmployee = sortedEmployees.Skip(1).First();
                Console.WriteLine("Employee with second highest salary:");
                Console.WriteLine(secondHighestSalaryEmployee);
            }
            else
            {
                Console.WriteLine("Not enough employees to determine the second highest salary.");
            }
        }

        //Sort the data by Joining Date
        public void SortEmployeesByJoiningDate()
        {
            var sortedEmployees = employees.OrderBy(e => e.JoiningDate).ToList();

            Console.WriteLine("Employees sorted by joining date:");
            foreach (var emp in sortedEmployees)
            {
                Console.WriteLine(emp);
            }
        }

        //get count 
        public void CountEmployeesJoinedAfter(DateTime cutoffDate)
        {
            var count = employees.Count(e => e.JoiningDate > cutoffDate);
            Console.WriteLine($"Number of employees who joined after {cutoffDate.ToShortDateString()}: {count}");
        }
    }
}