package ch.zhaw.pm4;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
class ProposalResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/proposal")
          .then()
             .statusCode(200)
             .body(is("Salut à la zhaw de la part de Quarkus dans le TGV!"));
    }


    @Test
    void testListAllSize() {
        given()
          .when().get("/proposal/all")
          .then()
             .statusCode(200)
             .body("$", hasSize(2));
    }

    @Test
    void testFirstEntityTitle() {
        given()
          .when().get("/proposal/all")
          .then()
             .statusCode(200)
             .body("[0].title", is("Herbal Garden Cat Protector"));
    }
      
    

}