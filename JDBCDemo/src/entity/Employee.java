package entity;

public class Employee {

    private String email;
    private  String empname;
    private String phone;

    public Employee() {
    }

    public Employee(String email, String empname, String phone) {
        this.email = email;
        this.empname = empname;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", empname='" + empname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
