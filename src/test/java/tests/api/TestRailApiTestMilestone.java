package tests.api;

import baseEntities.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.*;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTestMilestone extends BaseApiTest {
    int projectID;
    int milestoneID;


    @Test
    public void addProject(){

        AddProject addProject = AddProject.builder()
                .name("Audi")
                .announcement("RSQ8")
                .show_announcement(true)
                .suite_mode(ProjectType.SINGLE_SUITE_MODE)
                .build();

        projectID = given()
                .body(addProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println(projectID);
    }

    @Test(dependsOnMethods = "addProject")
    public void getMilestones(){

        Milestone getMilestones = Milestone.builder()
                .name("Audi8")
                .build();

        given()
                .pathParam("project_id", projectID)
                .body(getMilestones, ObjectMapperType.GSON)
                .when()
                .get(Endpoints.GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "getMilestones")
    public void addMilestone(){

        Milestone addMilestone = Milestone.builder()
                .name("Audi3")
                .description("420 power")
                .build();

        milestoneID = given()
                .pathParam("project_id", projectID)
                .body(addMilestone, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .body("name", is(addMilestone.getName()))
                .body("description", equalTo(addMilestone.getDescription()))
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println(milestoneID);

    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone(){

        Milestone updateMilestone = Milestone.builder()
                .name("AudiQ5")
                .build();

        Response response = given()
                .pathParam("milestone_id", milestoneID)
                .body(updateMilestone, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .body("name", is(updateMilestone.getName()))
                .extract().response();

        System.out.println(milestoneID);

    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone(){

        given()
                .pathParam("milestone_id", milestoneID)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
