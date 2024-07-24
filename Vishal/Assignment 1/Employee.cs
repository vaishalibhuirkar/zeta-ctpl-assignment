using System;
namespace EmployeeManagement
{
    public class Employee
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public Address Address { get; set; }

        public int Age { get; set; }
        public DateTime JoiningDate { get; set; }
        public decimal Salary { get; set; }

        public Employee(int id,string name,Address address,int age,DateTime joiningDate,decimal salary)
        {
            Id = id;
            Name = name;
            Address = address;
            Age = age;
            JoiningDate = joiningDate;
            Salary = salary;
        }

        public override string ToString()
        {
            return $"Id: {Id}, Name: {Name}, Address: {Address}, Age: {Age}, Joining Date: {JoiningDate.ToShortDateString()}, Salary: {Salary:C}";
        }

    }
}
