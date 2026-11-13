import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.List;

public class LoginTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult)
    {

    }

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
//
//        driver.get("chrome://settings/appearance");
//
//        WebElement shadowHost = driver.findElement(By.xpath("//settings-ui")).getShadowRoot().findElement(By.cssSelector("cr-toolbar#toolbar"));
//
//        RequestSpecification reqspec = new RequestSpecBuilder()
//                .setBaseUri("")
//                .setBasePath("")
//                .setAccept(ContentType.JSON)
//                .addHeader("Authorization","Bearer token")
//                .build();
//
//
//        int id = RestAssured.given().spec(reqspec)
//                .body("")
//                .when()
//                .post("")
//                .then().statusCode(200).extract()
//                .path("id");
//
//        Response response = RestAssured.given().spec(reqspec)
//                .body("")
//                .when()
//                .post("")
//                .then().statusCode(200).extract()
//                .response();

        String jsonString = """
            {
              "id": 101,
              "name": "John",
              "address": { "city": "Mumbai" },
              "roles": ["admin", "qa"],
              "orders": [ { "id": 1, "amount": 50 }, { "id": 2, "amount": 150 } ]
            }
            """;

        JsonPath jsonPath = new JsonPath(jsonString);
        int id1 = jsonPath.get("id");
        String name = jsonPath.getString("name");
        String address = jsonPath.getString("address.city");
        String role1 = jsonPath.getString("roles[1]");
        List<String> role = jsonPath.getList("roles");
        for (String s : role)
        {
            System.out.println(s);
        }

    }

}
