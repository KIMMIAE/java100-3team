package java100.app.service;

import java.util.HashMap;
import java.util.List;

import java100.app.domain.performance.PerformanceReview;

public interface PerformanceReviewService {

	int add(PerformanceReview performanceReview);
	int getTotalCount();
	List<PerformanceReview> list(int pageNo, int pageSize, HashMap<String, Object> options);
	PerformanceReview get(int no);
	int update(PerformanceReview performanceReview);
	int delete(int no);


}





