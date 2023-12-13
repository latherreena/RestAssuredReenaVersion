package PostRequestType;


import org.json.JSONObject;
import org.testng.annotations.Test;
import org.hamcrest.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.io.*;
import java.net.*;


public class POstRequestUsingOrgJSONlib {


        @Test(priority = 1)
        public void postRequestJsonLib()
        {
            JSONObject jo = new JSONObject();// default datatype is int hence need to convert into string
            jo.put("name", "Noemi");
            jo.put("location", "Australia");
            jo.put("phone", "12345");

            String rt[] = {"kanban", "scrum"};
            jo.put("courses", rt);

            given()
                    .contentType("application/json")
                    .body(jo.toString())// converting into to string because JSON object has int type automatically

                  .when()
                    .post("http://localhost:3000/students")
                    .then()
                    .statusCode(201)
                    .body("name", equalTo("Noemi"))
                    .body("location", equalTo("Australia"))
                    .body("phone", equalTo("12345"))
                    .body("courses[0]",equalTo("kanban"))
                    .header("content-type", "application/json")
                    .log().all();

        }

        //@Test(priority = 2)
        void deletePostrequest()
        {
           given()
                   .when()
                   .delete("http://localhost:3000/students/6")
                   .then()
                   .statusCode(200)
                   .log().all();
        }
}
