package PLuralsight;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PeekandPrint {

    static final String baseUrl = "https://api.github.com";
    @Test(priority = 1)
    void Peek()
    {
        RestAssured.given()
                .when().get(baseUrl).peek();

    }
    @Test(priority = 2)
    void prettypeek()
    {
        RestAssured.get(baseUrl).prettyPeek();

    }
}
