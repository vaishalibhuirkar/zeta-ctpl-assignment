using System;
using System.Text;

namespace EmployeeManagement
{
    public class Program
    {
        public static EmployeeOpr employeeOpr = new EmployeeOpr();
        public static void Main()
        {
            while (true)
            {
                Console.WriteLine("\nEmployee Operations:");
                Console.WriteLine("1. Add new Employee");
                Console.WriteLine("2. Search employee by name");
                Console.WriteLine("3. Delete employee");
                Console.WriteLine("4. Print all employees");
                Console.WriteLine("5. Print employee details who has highest salary");
                Console.WriteLine("6. Print employee details who has second highest salary");
                Console.WriteLine("7. Sort the employee details by their date of joining");
                Console.WriteLine("8. Count all the employees who joined after a given date");
                Console.WriteLine("9. Exit");
                Console.Write("Enter your choice: ");

                int choice = Convert.ToInt32(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        employeeOpr.AddEmployee();
                        break;
                    case 2:
                        employeeOpr.SearchEmployeeByName();
                        break;
                    case 3:
                        employeeOpr.DeleteEmployee();
                        break;
                    case 4:
                        employeeOpr.PrintAllEmployees();
                        break;
                    case 5:
                        employeeOpr.PrintHighestSalaryEmployee();
                        break;
                    case 6:
                        employeeOpr.PrintSecondHighestSalaryEmployee();
                        break;
                    case 7:
                        employeeOpr.SortEmployeesByJoiningDate();
                        break;
                    case 8:
                        Console.Write("Enter cutoff joining date (yyyy-MM-dd): ");
                        DateTime cutoffDate = DateTime.Parse(Console.ReadLine());
                        employeeOpr.CountEmployeesJoinedAfter(cutoffDate);
                        break;

                    case 9:
                        return;
                    default:
                        Console.WriteLine("Invalid choice");
                        break;
                }
            }

        }
    }
}