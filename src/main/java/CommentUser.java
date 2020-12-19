
public class CommentUser {

    private final String email;
    private int commentCount = 0;

    public CommentUser(String email) {
        this.email = email;
    }

    public void increaseCommentCount() {
        commentCount++;
    }

    public String getEmail() {
        return email;
    }

    public int getCommentCount() {
        return commentCount;
    }
}
