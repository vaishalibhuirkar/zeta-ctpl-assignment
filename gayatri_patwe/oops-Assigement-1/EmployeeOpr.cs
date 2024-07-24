using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace oops_Assigement_1
{
    internal class EmployeeOpr
    {
        private List<Employee> employees = new List<Employee>();

        public static void AddNewEmployee(EmployeeOpr employeeOpr)
        {
            Console.Write("Enter Employee ID: ");
            int id = int.Parse(Console.ReadLine());

            Console.Write("Enter Employee Name: ");
            string name = Console.ReadLine();

            Console.Write("Enter Address ID: ");
            int addressId = int.Parse(Console.ReadLine());

            Console.Write("Enter City: ");
            string city = Console.ReadLine();

            Console.Write("Enter Pincode: ");
            string pincode = Console.ReadLine();

            Console.Write("Enter Age: ");
            int age = int.Parse(Console.ReadLine());

            Console.Write("Enter Joining Date (MM-dd-yyyy): ");
            DateTime joiningDate = DateTime.ParseExact(Console.ReadLine(), "MM-dd-yyyy", CultureInfo.InvariantCulture);

            Console.Write("Enter Salary: ");
            decimal salary = decimal.Parse(Console.ReadLine());

            Address address = new Address(addressId, city, pincode);
            Employee employee = new Employee(id, name, address, age, joiningDate, salary);

            employeeOpr.AddEmployee(employee);
        }

        public void AddEmployee(Employee employee)
        {
            employees.Add(employee);
            Console.WriteLine("Employee has been added");
        }

      /*  public Employee SearcheEmployeeByName(string name)
        {
            Employee e = employees.Find()
        }*/

 public void DeleteEmployee(int id)
{
    var employee = employees.FirstOrDefault(e => e.Id == id);
    if (employee != null)
    {
        employees.Remove(employee);
        Console.WriteLine("Employee deleted successfully.");
    }
    else
    {
        Console.WriteLine("Employee not found.");
    }
}

        public void PrintAllEmployees()
        {
            foreach(var employee in employees)
            {
                Console.WriteLine(employee);
            }
        }

        public void PrintHighestSalaryEmployee()
        {
            var highestSalaryEmployee = employees.OrderByDescending(e => e.Salary).FirstOrDefault();
            if (highestSalaryEmployee != null)
            {
                Console.WriteLine("Employee with the highest salary:");
                Console.WriteLine(highestSalaryEmployee);
            }
        }

        public void PrintSecondHighestSalaryEmployee()
        {
            var secondHighestSalaryEmployee = employees.OrderByDescending(e => e.Salary).Skip(1).FirstOrDefault();
            if (secondHighestSalaryEmployee != null)
            {
                Console.WriteLine("Employee with the second highest salary:");
                Console.WriteLine(secondHighestSalaryEmployee);
            }
        }

        public void SortEmployeesByJoiningDateDesc()
        {
            var sortedEmployees = employees.OrderByDescending(e => e.JoiningDate).ToList();
            foreach (var employee in sortedEmployees)
            {
                Console.WriteLine(employee);
            }
        }

        public void GetEmployeesWithSalaryGreaterThan(decimal salary)
        {
            var filteredEmployees = employees.Where(e => e.Salary > salary).ToList();
            foreach (var employee in filteredEmployees)
            {
                Console.WriteLine(employee);
            }
        }

        public void CountEmployeesByJoiningYear(int year)
        {
            var count = employees.Count(e => e.JoiningDate.Year == year);
            Console.WriteLine($"Number of employees who joined in the year {year}: {count}");
        }

      

       /* static void SearchEmployee(EmployeeOpr employeeOpr)
        {
            Console.Write("Enter Employee Name: ");
            string name = Console.ReadLine();
            Employee employee = employeeOpr.SearchEmployeeByName(name);
            if (employee != null)
            {
                Console.WriteLine(employee);
            }
            else
            {
                Console.WriteLine("Employee not found.");
            }
        }*/

        static void DeleteEmployee(EmployeeOpr employeeOpr)
        {
            Console.Write("Enter Employee ID to delete: ");
            int id = int.Parse(Console.ReadLine());
            employeeOpr.DeleteEmployee(id);
        }

        private static void GetEmployeesWithSalaryGreaterThan(EmployeeOpr employeeOpr)
        {
            Console.Write("Enter cutoff Salary: ");
            decimal salary = decimal.Parse(Console.ReadLine());
            employeeOpr.GetEmployeesWithSalaryGreaterThan(salary);
        }

        private static void CountEmployeesByJoiningYear(EmployeeOpr employeeOpr)
        {
            Console.Write("Enter cutoff joining year: ");
            int year = int.Parse(Console.ReadLine());
            employeeOpr.CountEmployeesByJoiningYear(year);
        }


    }
}
