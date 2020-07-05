package tests;

import comments.CommentPojo;
import comments.CommentsAPIClient;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCommentAPI {

    private CommentsAPIClient commentsAPIClient;


    @BeforeClass
    public void setUpCommentsAPI() { this.commentsAPIClient = new CommentsAPIClient(); }

    @Test
    public void testGetAllComments() {
        ValidatableResponse response = this.commentsAPIClient.getALLComments();
        response.statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testUserCanCreateCommentUsingPojoSuccessfully() {
        CommentPojo obj = new CommentPojo(1,1,"name","email@gmail.com" ,"body");
        ValidatableResponse response = this.commentsAPIClient.createComment(obj);
        response.statusCode(HttpStatus.SC_CREATED);
    }


    @Test
    public void testUserCanCreateCommentSuccessfully() {
        int postId=1;
        int id=1;
        String name = "test name";
        String email= "test@gmail.com";
        String body = "test body";
        JSONObject json = new JSONObject();
        json.put("postId",postId);
        json.put("name", name);
        json.put("id", 8);
        json.put("body", body);
        json.put("emai",email);
        ValidatableResponse response = this.commentsAPIClient.createComment(json);
        response.statusCode(HttpStatus.SC_CREATED);

        int actualPostId = response.extract().body().path("postId");
        int actualId = response.extract().body().path("id");
        String actualName = response.extract().body().path("name");
        String actualBody = response.extract().body().path("body");
        String actualEmail = response.extract().body().path("email");

        Assert.assertEquals(actualPostId,postId);
        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualBody, body);

    }


}
