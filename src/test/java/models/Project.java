package models;

public class Project {
    private String name;
    private String announcement;


    public Project() {
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public Project setAnnouncement(String announcement) {
        this.announcement = announcement;
        return this;
    }
}
