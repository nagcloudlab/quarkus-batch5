package org.example.web;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import com.example.web.TxrRequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TxrResourceTest {

    @Test
    public void testHelloEndpoint() {
    	
    	TxrRequest request=new TxrRequest();
    	request.setAmount(100);
    	request.setFromAccNumber("1");
    	request.setToAccNumber("2");
    	
        given()
          .body(request)
          .header("Content-Type", "application/json", "Accept","application/json")
          .when().post("/api/txr")
          .then()
             .statusCode(200);
             
    }

}