package workHours.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "time_sheet_tracker")
public class TimeSheetTracker {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //auto populates timeSheetID
    private Long timeSheetID;

    @NotNull
    private double startTime;

    @NotNull
    private double endTime;  //not null because we need absolute time to start and end ...lunch is optional

    private double lunchStart;

    private double lunchEnd;

    @NotNull
    private String task;

    private double totalDayHours;

    private double totalWeeklyHours;


    public TimeSheetTracker() { }

    public TimeSheetTracker(Long timeSheetID, double startTime, double endTime, double lunchStart, double lunchEnd, String task, double totalDayHours, double totalWeeklyHours) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.lunchStart = lunchStart;
        this.lunchEnd = lunchEnd;
        this.task = task;
        this.totalDayHours = totalDayHours;
        this.totalWeeklyHours = totalWeeklyHours;
        this.timeSheetID = timeSheetID;
    }

//    public Date getLoginDate() {
//        return loginDate;
//    }
//
//    public void setLoginDate(Date loginDate) {
//        this.loginDate = loginDate;
//    }

    public double getStartTime() {
        return startTime;
    }
    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }
    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getLunchStart() {
        return lunchStart;
    }
    public void setLunchStart(double lunchStart) {
        this.lunchStart = lunchStart;
    }

    public double getLunchEnd() {
        return lunchEnd;
    }
    public void setLunchEnd(double lunchEnd) {
        this.lunchEnd = lunchEnd;
    }

    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }

    public double getTotalDayHours() {
        return totalDayHours;
    }
    public void setTotalDayHours(double totalDayHours) {
        this.totalDayHours = totalDayHours;
    }

    public double getTotalWeeklyHours() {
        return totalWeeklyHours;
    }
    public void setTotalWeeklyHours(Long totalWeeklyHours) {
        this.totalWeeklyHours = totalWeeklyHours;
    }

    public Long getTimeSheetID() {
        return timeSheetID;
    }
    public void setTimeSheetID(Long timeSheetID) {
        this.timeSheetID = timeSheetID;
    }
}
