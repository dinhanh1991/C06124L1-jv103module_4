package model;

public class Customer {
    int id;
    String name;
    String email;
    String address;

    public Customer(int id, String address, String name, String email) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.email = email;
    }
    public Customer( String address, String name, String email) {
        this.address = address;
        this.name = name;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
