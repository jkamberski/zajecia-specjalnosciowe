package pl.atins.microblog.dao;

import java.util.List;
import pl.atins.microblog.model.Post;

public interface WiadomoscDao {

    List<Post> getUserTimeline(long userId);

    
    List<Post> getFullTimeline(long userId);


    List<Post> getPublicTimeline();


    void addMessage(Post post);
}