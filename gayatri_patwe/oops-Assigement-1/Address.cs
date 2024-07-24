using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace oops_Assigement_1
{
    internal class Address
    {
        public int Id { get; set; }
        public string City { get; set; }
        public string Pincode { get; set; }

        public Address (int id,string city,string pincode)
        {
            Id = id;
            City = city;
            Pincode = pincode;
        }

        public override string ToString()
        {
            return $"ID: {Id}, City: {City}, Pincode: {Pincode}";
        }

    }


}
