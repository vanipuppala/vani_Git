import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EndToEndFlow {
    public static String authToken;


    @Test
    public void getProducts() {
        Response response = given()
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/products");
        JsonPath jsonPath = response.jsonPath();
        List<Map> products = jsonPath.getList("data");
        System.out.println(products);

    }

    @BeforeClass

    public void  authToken(){
        Response res=given()
                .formParam("grant_type","password")
                .formParam("username","vani.puppala@gmail.com")
                .formParam("password","Kritish5396")
                .post("https://spree-vapasi-prod.herokuapp.com/spree_oauth/token");
        System.out.println(res.prettyPrint());
        authToken="Bearer " + res.path("access_token");
        System.out.println(authToken);
    }

    @Test
    public void addItem1()
    {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", authToken);
        String createBody = "{\n" +
                "  \"variant_id\": \"17\",\n" +
                "  \"quantity\": 2\n" +
                "}";
        Response res = given()
                .headers(headers)
                .body(createBody)
                .when()
                .post("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/cart/add_item");
        Assert.assertEquals(res.statusCode(), 200);
    }

    @Test

    public void viewCart()
    {
        Response response = given()
                .get("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/cart");
    }

    @Test
    public void deleteProduct()
    {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content_Type", "application/json");
        headers.put("Authorization", authToken);


        Response res = given()
                .headers(headers)
                .when()
                .post("https://spree-vapasi-prod.herokuapp.com/api/v2/storefront/cart/remove_line_item/441");
        Assert.assertEquals(res.statusCode(), 200);
    }
}
