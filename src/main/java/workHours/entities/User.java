package workHours.entities;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid")
    private Long userId;

    @Column(name = "username")
    private String userName;

    private String password;

    private int enabled;

    private String email;

    private boolean emailVerified;

    private String first;

    private String last;

    @NotNull
    @Column(nullable = false)
    private long accountId;

    @NotNull
    @Column(nullable = false)
    private Timestamp created;

    private Timestamp deactivated;

    public User(){

    }

    public User(User user) {
        this.userId = user.userId;
        this.userName = user.userName;
        this.email = user.email;
        this.password = user.password;
        this.enabled=user.enabled;
        this.emailVerified = user.emailVerified;
        this.accountId = user.accountId;
        this.created = user.created;
        this.deactivated = user.deactivated;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Long getUserid() {
        return userId;
    }

    public void setUserid(Long userid) {
        this.userId = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(Timestamp deactivated) {
        this.deactivated = deactivated;
    }
}

