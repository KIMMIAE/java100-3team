package java100.app.dao.performance;

import java.util.List;
import java.util.Map;

import java100.app.domain.performance.PerformanceReview;

public interface PerformanceReviewDao {

	int insert(PerformanceReview performanceReview);
	int countAll();
	List<PerformanceReview> findAll(Map<String, Object> params);
	int updateViewCount(int no);
	PerformanceReview findByNo2(int no);
	int update(PerformanceReview performanceReview);
	int delete(int no);


}















