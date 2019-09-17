package by.qulixsystem.practice.database.models;


public class Project extends Model{

    String title;
    String abbreviate;
    String information;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAbbreviate() {
        return abbreviate;
    }
    public void setAbbreviate(String abbreviate) {
        this.abbreviate = abbreviate;
    }
    public String getInformation() {
        return information;
    }
    public void setInformation(String information) {
        this.information = information;
    }

    public Project() {
        super();
    }

    public Project(Long id) {
        super(id);
    }
}
