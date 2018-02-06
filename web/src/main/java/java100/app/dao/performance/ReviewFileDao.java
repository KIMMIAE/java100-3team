package java100.app.dao.performance;

import java.util.List;

import java100.app.domain.performance.ReviewFile;

public interface ReviewFileDao {

	List<ReviewFile> findByPerformanceReviewNo(int reviewFileNo);
	void insert(ReviewFile media);



}















