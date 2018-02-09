package java100.app.dao.performance;

import java100.app.domain.performance.Rating;

public interface RatingDao {

    String getRating(int no);
    void insert(Rating rating);
    void update(Rating rating);
    void delete(Rating rating);
}
