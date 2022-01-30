package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class TestRailApiTestCases extends BaseApiTest {

    int projectID;
    int sectionId;
    int caseId;

    @Test
    public void addProject(){

        AddProject addProject = AddProject.builder()
                .name("BMW")
                .announcement("2001(7)")
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
    public void addSection() {

        AddSection addSection = AddSection.builder()
                .name("BMW5")
                .description("123")
                .build();

        sectionId = given()
                .pathParam("project_id", projectID)
                .body(addSection, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_SECTION)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().jsonPath().get("id");

        System.out.println(sectionId);

    }

    @Test(dependsOnMethods = "addSection")
    public void addCase(){

        Cases addCase = Cases.builder()
                .title("easy")
                .section_id(sectionId)
                .build();

        caseId = given()
                .pathParam("section_id", sectionId)
                .body(addCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .body("title", is(addCase.getTitle()))
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println(caseId);

    }

    @Test(dependsOnMethods = "addCase")
    public void getCase(){

        Cases getCase = Cases.builder()
                .build();

        given()
                .pathParam("case_id", caseId)
                .body(getCase, ObjectMapperType.GSON)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);


    }

    @Test(dependsOnMethods = "addCase")
    public void updateCase(){
        Gson gson = new Gson();


        Cases updateCase = Cases.builder()
                .title("easyTitle")
                .section_id(sectionId)
                .build();

        Response response = given()
                .pathParam("case_id", caseId)
                .body(updateCase, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.UPDATE_CASE)
                .then()
                .log().body()
                .extract().response();

        Cases[] actualCases = gson.fromJson(response.getBody().asString(), Cases[].class);

        Assert.assertEquals(actualCases[0], updateCase);

    }

    @Test(dependsOnMethods = "updateCase")
    public void deleteCase(){

        given()
                .pathParam("case_id", caseId)
                .when()
                .post(Endpoints.DELETE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
