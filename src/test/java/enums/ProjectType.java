package enums;

import models.Project;

public enum ProjectType {
    SINGLE(1),
    SINGLE_WITH_BASELINE(2),
    MULTIPLE(3);

    int projectType;

    ProjectType(int projectType){
        this.projectType = projectType;
    }

}
