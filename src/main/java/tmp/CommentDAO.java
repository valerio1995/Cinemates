package tmp;


import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public interface CommentDAO {
    void saveComment(Comment comment);
    void addQuickOpinionToComment(String username, int idList, int idComment, boolean opinion);
    List<Comment> getListComments(int idList);
    AtomicBoolean getUserQuickOpinionToComment(String username, int idList, int idComment);
    void updateUserQuickOpinionToComment(String username, int idList, int idComment, boolean opinion);
    Comment getComment(int idList, int idComment);
}

