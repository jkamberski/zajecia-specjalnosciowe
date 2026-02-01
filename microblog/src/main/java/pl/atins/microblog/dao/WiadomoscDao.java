package pl.atins.microblog.dao;

import java.util.List;
import pl.atins.microblog.model.Wpis;

public interface WiadomoscDao {

    List<Wpis> getUserTimeline(long userId);

    
    List<Wpis> getFullTimeline(long userId);


    List<Wpis> getPublicTimeline();


    void addMessage(Wpis post);
}
