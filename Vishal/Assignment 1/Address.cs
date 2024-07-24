
namespace EmployeeManagement
{
    public class Address
    {
        public int Id { get; set; }
        public string City { get; set; }
        public string Pincode { get; set; }
        public Address(int id,string city,string pincode)
        {
            Id = id;
            City = city;
            Pincode = pincode;
        }
        public override string ToString()
        {
            return $"{City},{Pincode}";
        }
    }
}
