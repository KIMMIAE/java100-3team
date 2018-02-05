package java100.app.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.performance.PerformanceReviewDao;
import java100.app.domain.performance.PerformanceReview;
import java100.app.service.PerformanceReviewService;

@Service
public class PerformanceReviewServiceImpl implements PerformanceReviewService {

    @Autowired PerformanceReviewDao performanceReviewDao;

	@Override
	public int add(PerformanceReview performanceReview) {
        int count = performanceReviewDao.insert(performanceReview);
        //this.addFiles(performanceReview.getFiles(), performanceReview.getNo());
        
        return count;
	}
    

}












