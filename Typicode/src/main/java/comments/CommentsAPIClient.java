package comments;

import base.TypicodeAPIClient;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CommentsAPIClient extends TypicodeAPIClient {



    private String COMMENTS_ENDPOINT="/comments";



    public ValidatableResponse getALLComments() {return when().get(this.baseUri + COMMENTS_ENDPOINT).then(); }

    public ValidatableResponse createComment(Object json) {
        return given().header("Content-Type", "application/json")
                .body(json)
                .when()
                .post(this.baseUri + COMMENTS_ENDPOINT)
                .then();
    }








}
