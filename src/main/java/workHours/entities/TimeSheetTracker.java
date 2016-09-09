package workHours.entities;

import javax.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "time_sheet_tracker")
public class TimeSheetTracker {

    @Id
    private long timeSheetID;

    @Id
    private java.sql.Date loginDate; //TODO do I really need this?

    @Id
    private String startTime;

    @Id
    private String endTime;

    @Id
    private String lunchStart;

    @Id
    private String lunchEnd;

    private String task;

    private String totalDayHours;

    private String totalWeeklyHours;


    public TimeSheetTracker() { }

    public TimeSheetTracker(long timeSheetID) {
        this.timeSheetID = timeSheetID;
    }

    public TimeSheetTracker(String startTime, String endTime, String lunchStart, String lunchEnd, String task, String totalDayHours, String totalWeeklyHours) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.lunchStart = lunchStart;
        this.lunchEnd = lunchEnd;
        this.task = task;
        this.totalDayHours = totalDayHours;
        this.totalWeeklyHours = totalWeeklyHours;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLunchStart() {
        return lunchStart;
    }

    public void setLunchStart(String lunchStart) {
        this.lunchStart = lunchStart;
    }

    public String getLunchEnd() {
        return lunchEnd;
    }

    public void setLunchEnd(String lunchEnd) {
        this.lunchEnd = lunchEnd;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTotalDayHours() {
        return totalDayHours;
    }

    public void setTotalDayHours(String totalDayHours) {
        this.totalDayHours = totalDayHours;
    }

    public String getTotalWeeklyHours() {
        return totalWeeklyHours;
    }

    public void setTotalWeeklyHours(String totalWeeklyHours) {
        this.totalWeeklyHours = totalWeeklyHours;
    }

    public long getTimeSheetID() {
        return timeSheetID;
    }

    public void setTimeSheetID(long timeSheetID) {
        this.timeSheetID = timeSheetID;
    }
}
