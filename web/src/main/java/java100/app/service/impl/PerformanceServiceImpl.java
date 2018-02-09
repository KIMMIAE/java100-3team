package java100.app.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.performance.JjimDao;
import java100.app.dao.performance.PerformanceDao;
import java100.app.dao.performance.PerformanceFileDao;
import java100.app.dao.performance.RatingDao;
import java100.app.dao.performance.RippleDao;
import java100.app.domain.performance.Jjim;
import java100.app.domain.performance.Performance;
import java100.app.domain.performance.PerformanceFile;
import java100.app.domain.performance.Rating;
import java100.app.domain.performance.Ripple;
import java100.app.service.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired PerformanceDao performanceDao;
    @Autowired PerformanceFileDao performanceFileDao;
    @Autowired JjimDao jjimDao;
    @Autowired RatingDao ratingDao;
    @Autowired RippleDao rippleDao;
    
    @Override
    public List<Performance> list(int pageNo, int pageSize, Map<String, Object> options) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        return performanceDao.findAll(params);
    }

    @Override
    public Performance get(int no) {
        performanceDao.updateViewCount(no);
        Performance performance = performanceDao.findByNo2(no);
        
        return performance;
    }

    @Override
    public List<PerformanceFile> getMedias(int no) {
        return performanceFileDao.findByPerformanceNo(no);
    }
    
    @Override
    public int getTotalCount() {
        return performanceDao.countAll();
    }

    @Override
    //@Transactional // XML 설정으로 대체한다.
    public int add(Performance performance) {
        int count = performanceDao.insert(performance);
        
        if (performance.getMedias() != null) {
            this.addFiles(performance.getMedias(), performance.getNo());
        }
        
        return count;
    }

    @Override
    public int update(Performance performance) {
        int count = performanceDao.update(performance);
        
        if (performance.getMedias() != null) {
            performanceFileDao.deleteAllByPerformanceNo(performance.getNo());
            addFiles(performance.getMedias(), performance.getNo());
        }
        
        return count;
    }
    
    @Override
    //@Transactional // XML 설정으로 대체
    public void addFiles(List<PerformanceFile> medias, int performanceNo) {
        for (PerformanceFile media : medias) {
            media.setPerformanceNo(performanceNo);
            performanceFileDao.insert(media);
            
            System.out.println("ServiceImpl.addFiles =>  " + media.toString());
        }
    }

    @Override
    public int delete(int no) {
        //return performanceDao.delete(no);
        return 0;
    }
    
    @Override
    public void jjimHagi(Jjim jjim) {
        if (jjim.getJjimFlag().equals("1")) {
            jjimDao.insert(jjim);
        } else {
            jjimDao.delete(jjim);
        }
    }

    @Override
    public int getJjim(Jjim jjim) {
        return jjimDao.getJjim(jjim);
    }
    
    @Override
    public void addRating(Rating rating) {
        ratingDao.insert(rating);
    }
    
    @Override
    public void addRipple(Ripple ripple) {
        rippleDao.insert(ripple);
    }
    
    @Override
    public String getRipple(Ripple ripple) {
        return rippleDao.getRipple(ripple);
    }

}
