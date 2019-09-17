package by.qulixsystem.practice.database.models;

import java.util.Calendar;
import java.util.Date;

public class Task extends Model{

    String title;
    int time;
    String start;
    String  finish;
    String status;
    Project project;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getFinish() {
        return finish;
    }
    public void setFinish(String finish) {
        this.finish = finish;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    public Task() {
        super();
    }
    public Task(Long id) {
        super(id);
    }

}
