using oops_Assigement_1;
using System.Globalization;

namespace Assigment
{

    public class InvalidChoiceException : Exception
    {
        public InvalidChoiceException(string message) : base(message) { }
    }


   

    class program
    {
        static void Main(String args)
        {
            EmployeeOpr employeeOpr = new EmployeeOpr();
            while (true)
            {
                Console.WriteLine("\nMenu:");
                Console.WriteLine("1. Add new Employee");
                Console.WriteLine("2. Search employee by name");
                Console.WriteLine("3. Delete employee");
                Console.WriteLine("4. Print all employees");
                Console.WriteLine("5. Print employee details who has highest salary");
                Console.WriteLine("6. Print employee details who has second highest salary");
                Console.WriteLine("7. Sort the employee details by their date of joining in desc order");
                Console.WriteLine("8. Get all employees having salary greater than x");
                Console.WriteLine("9. Count all the employees who joined in year x");
                Console.WriteLine("0. Exit");
                Console.Write("Enter your choice: ");

                try
                {
                    int choice = int.Parse(Console.ReadLine());
                    if (choice < 0 || choice > 9)
                    {
                        throw new InvalidChoiceException("Invalid choice! Please enter a valid option.");
                    }

                    switch (choice)
                    {
                        case 1:
                            AddNewEmployee(employeeOpr);
                            break;
                        case 2:
                            SearchEmployee(employeeOpr);
                            break;
                        case 3:
                            DeleteEmployee(employeeOpr);
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
                            employeeOpr.SortEmployeesByJoiningDateDesc();
                            break;
                       // case 8:
                         //   GetEmployeesWithSalaryGreaterThan(employeeOpr);
                           // break;
                        //case 9:
                          //  CountEmployeesByJoiningYear(employeeOpr);
                            //break;
                        case 0:
                            Environment.Exit(0);
                            break;
                    }
                }
                catch (InvalidChoiceException ex)
                {
                    Console.WriteLine(ex.Message);
                }
                catch (Exception ex)
                {
                    Console.WriteLine("An error occurred: " + ex.Message);
                }
            }

            

        }
    }
}
    

