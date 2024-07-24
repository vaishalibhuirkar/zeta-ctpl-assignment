public class Address {
    int id;
    String city;
    int pincode;

    public Address(int id, String city, int pincode) {
        this.id = id;
        this.city = city;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{id=" + id + ", city='" + city + "', pincode=" + pincode + "}";
    }
}
