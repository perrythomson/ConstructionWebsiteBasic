//package workHours.entities;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Entity
//@Table(name = "user")
//public class Employee {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long employeeID;
//
//    @NotNull  //forces it to be populated
//    private String email;
//
//    @NotNull
//    private String firstName;
//
//    @NotNull
//    private String lastName;
//
//    @NotNull
//    private String phone;
//
//    @NotNull
//    private String address;
//
//    @NotNull
//    private double salary;
//
//    private String password;
//
//    private String userName;
//
//    private HashSet<RoleType> roles = new HashSet<RoleType>();
//
//    public Employee() {
//    }
//
//    public Employee (Long employeeID, String userName, String password, String firstName, String lastName, String email, String phone, String address, double salary) {
//        this.employeeID = employeeID;
//        this.password = password;
//        this.userName = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.phone = phone;
//        this.address = address;
//        this.email = email;
//        this.salary = salary;  //TODO BigDecimal exclusive for banking its an object  i.e. salary.add
//        roles.add(RoleType.EMPLOYEE);
//    }
//
//    public Set<RoleType> getRoles() {
//        return roles;
//    }
//    public void setRoles(HashSet<RoleType> roles) {
//        this.roles = roles;
//    }
//
//    public Long getEmployeeID() {
//        return employeeID;
//    }
//    public void setEmployeeID(Long employeeID) {
//        this.employeeID = employeeID;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//}
