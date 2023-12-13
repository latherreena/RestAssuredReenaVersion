package PostRequestType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import java.util.HashMap;

public class postRequestHashmap
{

    @Test(priority = 1)
    void postHashmap()
    {
        HashMap hm = new HashMap();
        hm.put("name", "ram");
        hm.put("location", "New Zealand");
        hm.put("phone", "321312312");

        String st[] = {"java", "rest"};// string
        hm.put("courses", st);

        given()
                .contentType("application/json")
                .body(hm)

                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("ram"))
                .body("location", equalTo("New Zealand"))
                .body("phone", equalTo("321312312"))
                .body("courses[0]", equalTo("java"))
                .body("courses[1]", equalTo("rest"))
                .header("contentType", "application/json")
                .log().all();

    }

    //@Test(priority = 2)

    void hashmapDelete()
    {
        given()
                .when()
                .delete("http://localhost:3000/students/6")
                .then()
                .statusCode(200)
                .log().all();

    }

}
