package tests.api;

import baseEntities.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRailApiTest1 extends BaseApiTest {
    int projectID;

    @Test
    public void getAllProjects(){
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject1(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_01")
                .announcement("This is the description for the project")
                .isShowAnnouncement(true)
                .typeOfProject(ProjectType.SINGLE.getProjectType())
                .build();

        given()
                .body(String.format("{\n" +
                        "  \"name\": \"%s\",\n" +
                        "  \"announcement\": \"%s\",\n" +
                        "  \"show_announcement\": %b,\n" +
                        "  \"suite_mode\" : %d\n" +
                        "}",
                        project.getName(),
                        project.getAnnouncement(),
                        project.isCompleted(),
                        project.getTypeOfProject()))
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject2(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_02")
                .typeOfProject(ProjectType.SINGLE.getProjectType())
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", project.getName());
        jsonAsMap.put("suite_mode", project.getTypeOfProject());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_03")
                .typeOfProject(ProjectType.SINGLE_WITH_BASELINE.getProjectType())
                .build();

        given()
                .body(project, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject4(){
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_04")
                .typeOfProject(ProjectType.SINGLE_WITH_BASELINE.getProjectType())
                .build();

        int projectID = given()
                .body(project, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println(projectID);
    }
    @Test(dependsOnMethods = "addProject4")
    public void updateProject(){
        String  endpoint = "/index.php?/api/v2/update_project/{project_id}";

        ProjectBuilder projectUpd = ProjectBuilder.builder()
                .name("WP_Project_04_UPD")
                .announcement("Test!!!")
                .isCompleted(true)
                .build();

        Response response = given()
                .pathParam("project_id", projectID)
                .body(projectUpd, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("name"),
                projectUpd.getName());

    }

    @Test(dependsOnMethods = "addProject4")
    public void deleteProject(){
        String endpoint = "index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
