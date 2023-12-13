package PostRequestType;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postrequestUsingPojoClass {


    @Test(priority = 1)

    public void PostrequestPojoclass()
    {

        // these 4 steps are important when we are reading from external file:

        Pojo pj = new Pojo();


        // set the data:
        pj.setName("shiva");
        pj.setLocation("Kailash");
        pj.setPhone("111111");

        //create Array for single data array with multiple values like course has many values in it
        String rt[] = {"happy", "peace"};
        pj.setCourses(rt);

        //Now start testing:
        given()
                .contentType("application/json")
                .body(pj)// org jason file and external file needs to convert into string always since originally they are int type
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("shiva"))
                .body("location", equalTo("Kailash"))
                .body("phone", equalTo("111111"))
                .body("courses[0]",equalTo("happy"))
                .header("content-type", "application/json")
                .log().all();

    }

   // @Test(priority = 2)
    void pojorequestDelete()
    {
        given()
                .when()
                .delete("http://localhost:3000/students/7")
                .then()
                .statusCode(200)
                .log().all();
    }

}
