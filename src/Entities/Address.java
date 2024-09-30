package Entities;

public class Address {
    String address;
    long pincode;
    double lattitude;
    double longitude;

    public Address(String address, long pincode, double lattitude, double longitude) {
        this.address = address;
        this.pincode = pincode;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }
}
