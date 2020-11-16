package net.bossones;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class App 
{
    public static void main( String[] args )
    {
        String name = "Volodya", position = "Software testing", number = "653854";
        postRequestTest(name, position, number);
        getAllRequestTest();
        getRequestTest();
        deleteRequestTest();
    }

    public static void getAllRequestTest() {
        get(Base.BASE + EndPoints.GETALL).
        then().
            statusCode(200);
    }

    public static void postRequestTest(String name, String position, String number) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", name);
        requestBody.put("position", position);
        requestBody.put("number", number);
        given().
                contentType(ContentType.JSON).
                body(requestBody.toString()).
                when().
                post(Base.BASE + EndPoints.CREATE).
                then().
                statusCode(201).body("name", equalTo(name)).and().
                body("position", equalTo(position)).and().
                body("number", equalTo(number));
    }

    public static void getRequestTest() {
        String id = get(Base.BASE + EndPoints.GETALL).getBody().jsonPath().getString("[0].id");
        get(Base.BASE + EndPoints.GET + id).
        then().
            statusCode(200);
    }

    public static void deleteRequestTest() {
        String id = get(Base.BASE + EndPoints.GETALL).getBody().jsonPath().getString("[0].id");
        delete(Base.BASE + EndPoints.DELETE + id).then().statusCode(200).body("id", equalTo(Integer.parseInt(id)));
    }
}
