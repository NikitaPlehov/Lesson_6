package baseEntities;

import com.tms.core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    @BeforeTest
    public void setupApiTest(){
        // Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUrl();

        // Setup request Object
        RestAssured.requestSpecification = given()
            .header(HTTP.CONTENT_TYPE, ContentType.JSON)
            .auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword());
    }
}
