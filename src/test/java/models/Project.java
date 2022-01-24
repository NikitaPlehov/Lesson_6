package models;

import enums.ProjectType;
import org.openqa.selenium.By;


public class Project {

    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private ProjectType typeOfProject;
    private boolean isCompleted;

    public static class BuilderProject {
        private Project newProject;

        public static class Builder {
            private Project newProject;

            public Builder() {
                newProject = new Project();
            }

            public Builder withName(String name) {
                newProject.name = name;
                return this;
            }

            public Builder withAnnouncement(String announcement) {
                newProject.announcement = announcement;
                return this;
            }

            public Builder withIsShowAnnouncement(boolean isShowAnnouncement) {
                newProject.isShowAnnouncement = isShowAnnouncement;
                return this;
            }

            public Builder withTypeOfProject(ProjectType typeOfProject) {
                newProject.typeOfProject = typeOfProject;
                return this;
            }

            public Builder withIsCompleted(boolean isCompleted) {
                newProject.isCompleted = isCompleted;
                return this;
            }

            public Project build() {
                return newProject;
            }
        }
    }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAnnouncement() {
                return announcement;
            }

            public void setAnnouncement(String announcement) {
                this.announcement = announcement;
            }

            public boolean isShowAnnouncement() {
                return isShowAnnouncement;
            }

            public void setShowAnnouncement(boolean showAnnouncement) {
                isShowAnnouncement = showAnnouncement;
            }

            public ProjectType getTypeOfProject() {
                return typeOfProject;
            }

            public void setTypeOfProject(ProjectType typeOfProject) {
                this.typeOfProject = typeOfProject;
            }

            public boolean isCompleted() {
                return isCompleted;
            }

            public void setCompleted(boolean completed) {
                isCompleted = completed;
            }
}
