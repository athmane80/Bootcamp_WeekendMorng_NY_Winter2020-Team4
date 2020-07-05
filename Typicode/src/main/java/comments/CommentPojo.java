package comments;



public class CommentPojo {
    private int id;
    private String body;
    private int postId;
    private String name;
    private String email;





    public CommentPojo(int postId, int id,String name ,String email, String body) {

        this.id = id;
        this.body = body;
        this.postId=postId;
        this.name=name;
        this.email=email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPostId(){ return postId;}
    public void setPostId(int postId){this.postId=postId;}

    public String getName(){ return name;}
    public void setName(String name){this.name=name;}

    public String getEmail(){ return email;}
    public void setEmail(String name){this.email=name;}








}
