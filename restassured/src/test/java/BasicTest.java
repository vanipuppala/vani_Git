import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BasicTest {

    public static String authToken;

    @Test
    public void testStatusCode() {
        given()
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products")
                .then()
                .statusCode(200);

    }

    @Test
    public void testLogging() {
        given()
                .log().all()
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
    }

    @Test
    public void printResponse() {
        Response res = given().when()
                .log().all()
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
        // System.out.println(res.asString());

        System.out.println(res.prettyPrint());

    }

    @Test
    public void testCurrency() {


        given()
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products")
                .then()
                .body("data[0].attributes.currency", equalTo("USD"));

    }

    @Test
    public void testCurrency_1() {
        Response response = given()
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
        JsonPath jsonPath = response.jsonPath();
        List<Map> products = jsonPath.getList("data");
        for (Map product_attributes : products) {
            Map attributes = (Map) product_attributes.get("attributes");
            Assert.assertEquals(attributes.get("currency"), "USD");
        }

    }

    @Test
    public void testFilter() {
        Response res = given()
                .log().all()
                .queryParam("filter[name]", "ba")
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
        System.out.println(res.prettyPrint());
    }


    @Test
    public void testFilterId() {
        Response res = given()
                .log().all()
                .queryParam("filter[ids]", "2")
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
        System.out.println(res.prettyPrint());
    }

    @Test
    public void testFilterPrice() {
        Response res = given()
                .log().all()
                .queryParam("filter[price]", "10 - 19.99")
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
        System.out.println(res.prettyPrint());
    }

    @BeforeClass
    public void authToken() {
        Response res = given()
                .formParam("grant_type", "password")
                .formParam("username", "vani.puppala@gmail.com")
                .formParam("password", "Kritish5396")
                .post("https://spree-vapasi-prod.herokuapp.com/spree_oauth/token");
        authToken = "Bearer " + res.path("access_token");
        System.out.println(authToken);
    }

    @Test
    public void testPostCall() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content_Type", "application/json");
        headers.put("Authorization", authToken);

        String createBody = "{\n" +
                "  \"variant_id\": \"17\",\n" +
                "  \"quantity\": 5\n" +
                "}";
        Response res = given()
                .headers(headers)
                .body(createBody)
                .when()
                .post("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/cart/add_item");
        Assert.assertEquals(res.statusCode(), 200);

    }


}
