package tmp;

public class Comment {
    private String writerUsername;
    private String text;
    private int numberLikes;
    private int numberNoLikes;
    private int idList;
    private int idComment;

    public String getWriterUsername() {
        return writerUsername;
    }

    public void setWriterUsername(String writerUsername) {
        this.writerUsername = writerUsername;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumberLikes() {
        return numberLikes;
    }

    public void setNumberLikes(int numberLikes) {
        this.numberLikes = numberLikes;
    }

    public int getNumberNoLikes() {
        return numberNoLikes;
    }

    public void setNumberNoLikes(int numberNoLikes) {
        this.numberNoLikes = numberNoLikes;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }
}