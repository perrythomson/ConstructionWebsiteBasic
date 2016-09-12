package workHours.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;


@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminID;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String address;

    @NotNull
    private double salary;

    private String password;

    private HashSet<RoleType> roles = new HashSet<RoleType>();

    public Admin() {
    }

    public Admin (Long adminID, String password, String firstName, String lastName, String email, String phone, String address, double salary) {
        this.adminID = adminID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.salary = salary;
        roles.add(RoleType.EMPLOYEE);
    }

    public Long getAdminID() {
        return adminID;
    }
    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<RoleType> getRoles() {
        return roles;
    }
    public void setRoles(HashSet<RoleType> roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
