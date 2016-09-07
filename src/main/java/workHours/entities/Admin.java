package workHours.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "admin")
public class Admin {
    @Id
    private String adminID;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @NotNull
    private HashSet<RoleType> roles = new HashSet<RoleType>();

    public Admin() {
    }

    public Admin(String email, String firstName, String lastName, String adminID, String password) {
        this.adminID = adminID;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        roles.add(RoleType.ADMIN);
    }

    public String getAdminID() {
        return adminID;
    }
    public void setAdminID(String adminID) {
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
}
