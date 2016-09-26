package workHours.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "contactUs")
public class InterestedParty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactUsID;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String name;

    @NotNull
    private String form;

    @NotNull
    private String location;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getContactUsID() {
        return contactUsID;
    }

    public void setContactUsID(Long contactUsID) {
        this.contactUsID = contactUsID;
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
