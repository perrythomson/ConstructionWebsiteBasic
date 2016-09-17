package workHours.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by perrythomson on 9/16/16.
 */@Entity
@Table(name = "admin")
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobSeekerID;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String name;

    @NotNull
    private String form;



    public Long getJobSeekerID() {
        return jobSeekerID;
    }

    public void setJobSeekerID(Long jobSeekerID) {
        this.jobSeekerID = jobSeekerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
