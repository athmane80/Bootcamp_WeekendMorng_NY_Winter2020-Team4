package testtweet;


import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tweet.TweetAPIClient;

import java.util.UUID;

public class TestTweetAPIClient {
    private TweetAPIClient tweetAPIClient;

    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClient = new TweetAPIClient();
    }

    @Test(enabled = true)
    public void testUserCanTweetSuccessfully() {

        String tweet = "My first tweet " + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);
    }

    @Test(enabled = true)
    public void testUserCanNotTweetTheSameTweetTwiceInARow() {
        String tweet = "We can tweet Everyday " + UUID.randomUUID().toString();
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(200);
        String actualTweet = response.extract().body().path("text");
        Assert.assertEquals(tweet, actualTweet);
        response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(403);
        String expectedMessage = "Status is a duplicate.";
        String actualMessage = response.extract().body().path("errors[0].message");
        Assert.assertEquals(actualMessage, expectedMessage);
    }


    @Test(enabled = true)
    public void testDeleteTweet() {
        ValidatableResponse response = this.tweetAPIClient.deleteTweet(1279236339830067201L);

    }


    @Test(enabled = true)
    public void testSearchTweet() {
        ValidatableResponse response = this.tweetAPIClient.searchTweet(1279236339830067201L);
    }


    @Test(enabled = true)
    public void testShowTweet() {
        ValidatableResponse response = this.tweetAPIClient.showTweet(1279236339830067201L);
    }


    @Test(enabled = true)
    public void testUnretweetTweet() {
        ValidatableResponse response = this.tweetAPIClient.unretweetTweet(1279236339830067201L);
    }


    @Test(enabled = true)
    public void testRetweetTweet() {
        ValidatableResponse response = this.tweetAPIClient.retweetTweet(1279486698712375296L);
    }


    @Test(enabled = true)
    public void testUserTweet() {

        String Name = "Athmane Chebili" + UUID.randomUUID().toString();

        ValidatableResponse response = this.tweetAPIClient.userTweet(Name);


    }

}