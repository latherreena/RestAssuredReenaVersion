package PLuralsight;

import org.testng.annotations.Test;

import java.util.PriorityQueue;

import static io.restassured.RestAssured.given;

public class FirstTest {

    @Test(priority = 1)
    public void getRequest()
    {
        given()
                .when().get("https://api.github.com")
                .then()
                .statusCode(200)
                .log().all();

    }


}
