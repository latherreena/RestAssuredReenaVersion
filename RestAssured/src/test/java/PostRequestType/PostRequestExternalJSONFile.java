package PostRequestType;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PostRequestExternalJSONFile {

    @Test(priority = 1)

    public void PostExternalJSONFile() throws FileNotFoundException {

        // these 4 steps are important when we are reading from external file:

        File f = new File(".//body.json");// call the file
        FileReader fr = new FileReader(f); // Resding the data
        JSONTokener jt = new JSONTokener(fr);// split the data
        JSONObject jo = new JSONObject(jt); // extract the data

        // set the data:
        jo.put("name", "shiva");
        jo.put("location", "Kailash");
        jo.put("phone", "111111");

        //create Array for single data array with multiple values like course has many values in it
        String rt[] = {"happy", "peace"};
        jo.put("courses", rt);

        //Now start testing:
        given()
                .contentType("application/json")
                .body(jo.toString())// org jason file and external file needs to convert into string always since originally they are int type
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
    void externalfileDelete()
    {
        given()
                .when()
                .delete("http://localhost:3000/students/7")
                .then()
                .statusCode(200)
                .log().all();
    }
}

