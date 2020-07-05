package tweet;

import base.TwitterAPIClient;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class TweetAPIClient extends TwitterAPIClient {




    private final String CREATE_TWEET_ENDPOINT="/statuses/update.json";
    private final String DELETE_TWEET_ENDPOINT="/statuses/destroy.json";
    private final String GET_USER_TWEET_ENDPOINT="/statuses/user_timeline.json";
    private final String SEARCH_TWEET_ENDPOINT="/search/tweets.json";
    private final String SHOW_TWEET_ENDPOINT="/statuses/show.json";
    private final String UNRETWEET_TWEET_ENDPOINT="/statuses/unretweet.json";
    private final String RETWEET_TWEET_ENDPOINT="/statuses/retweet.json";
    private final String USER_TIME_LINE="/statuses/user_timeline.json";




    public ValidatableResponse getUserTimelineTweets(){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUri+this.GET_USER_TWEET_ENDPOINT)
                .then();
    }

    public ValidatableResponse createTweet(String tweet){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status",tweet)
                .when().post(this.baseUri+this.CREATE_TWEET_ENDPOINT)
                .then(); }

    public ValidatableResponse deleteTweet(Long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUri+this.DELETE_TWEET_ENDPOINT)
                .then(); }

    public ValidatableResponse searchTweet(long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUri+this.SEARCH_TWEET_ENDPOINT)
                .then(); }

    public ValidatableResponse showTweet(long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUri+this.SHOW_TWEET_ENDPOINT)
                .then(); }

    public ValidatableResponse unretweetTweet(long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUri+this.UNRETWEET_TWEET_ENDPOINT)
                .then(); }

    public ValidatableResponse retweetTweet(long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().post(this.baseUri+this.RETWEET_TWEET_ENDPOINT)
                .then(); }

    public ValidatableResponse userTweet(String Name){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status",Name)
                .when().post(this.baseUri+this.USER_TIME_LINE)
                .then(); }

}
