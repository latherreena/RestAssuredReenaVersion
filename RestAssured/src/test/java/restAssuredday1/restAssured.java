package restAssuredday1;
import org.testng.annotations.Test;
import io.restassured.*;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class restAssured {

    int id;
    @Test(priority = 1) // we can set priority here
    public void getUserList() // user defined method
    {
        /*Runtime.Version rv = Runtime.version();
        System.out.println(rv);*/
        given()// if we sending any body data then it come here
                .when().get("https://reqres.in/api/users?page=2")//  condition here
                .then().statusCode(200).body("page", equalTo(2)) // validation
                .log().all();

    }

    @Test(priority = 2)
    public void createUser()
    {
        HashMap hm = new HashMap();
        hm.put("name", "reena");
        hm.put("job", "Mother");

        id = given()
                .contentType("application/json")
                .body(hm)
           .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
    }

    @Test(priority = 3, dependsOnMethods = "createUser")
    public void updateUser()
    {
        HashMap hm = new HashMap();
        hm.put("name", "Raj");
        hm.put("job", "Father");

        given()
                .contentType("application/json")
                .body(hm)
             .when()
                .put("https://reqres.in/api/users/"+id)
              .then()
                .statusCode(200)
                .log().all();
    }
   @Test(priority = 4)
    public void deleteUser()
    {
        given()
                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();

    }



}
