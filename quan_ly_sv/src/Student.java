import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Student {
    private String name;
    private String grade;
    private String _class;
    private String company;
    private String job;
    private String teacher;

    public Student(String name, String grade, String _class, String company, String job, String teacher) {
        this.name = name;
        this.grade = grade;
        this._class = _class;
        this.company = company;
        this.job = job;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

}
