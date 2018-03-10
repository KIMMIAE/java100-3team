package java100.app.dao.performance;

import java.util.List;
import java.util.Map;

import java100.app.domain.performance.PerformanceReview;

public interface PerformanceReviewDao {

	List<PerformanceReview> findAll(Map<String, Object> params);
	PerformanceReview findByNo2(int no);
	int countAll();
	int updateViewCount(int no);
	int insert(PerformanceReview performanceReview);
	int update(PerformanceReview performanceReview);
	int delete(int no);
	List<PerformanceReview> findByArtNo (int no);

}















