package java100.app.dao.performance;

import java.util.Map;

import java100.app.domain.performance.Rating;

public interface RatingDao {

    String getRating(int no);
    int checkRating(Map<String,Object> params);
    float getAverage(int performanceNo);
    void insert(Rating rating);
    void update(Rating rating);
    void delete(Rating rating);
}
