package workHours.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "time_sheet_tracker")
public class TimeSheetTracker {

    private int hours;
    private int days;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //this auto populates ID
    private long id;

    @NotNull  //forces it to be populated
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;


    public TimeSheetTracker() { }

    public TimeSheetTracker(long id) {
        this.id = id;
    }

    public TimeSheetTracker(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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

    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }
}
