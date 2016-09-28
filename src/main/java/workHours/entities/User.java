package workHours.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userId;

    @Column(name = "username")
    private String userName;

    private String password;

    private int enabled;

    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private double salary;

    private HashSet<RoleType> roles = new HashSet<RoleType>();

    public User() {

    }

    public User(User user) {
        this.userId = user.userId;
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
    }

    public User(String userName, String password, int enabled, String email) {  //, String firstName, String lastName, String phone, String address, double salary
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.email = email;
        //TODO this errors out when I add this here...where is the correct place?
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.address = address;
//        this.salary = salary;
//        roles.add(RoleType.EMPLOYEE);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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

    public HashSet<RoleType> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<RoleType> roles) {
        this.roles = roles;
    }
}
