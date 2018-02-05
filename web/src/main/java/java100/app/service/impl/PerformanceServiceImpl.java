package java100.app.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.performance.PerformanceDao;
import java100.app.dao.performance.PerformanceFileDao;
import java100.app.domain.performance.Performance;
import java100.app.domain.performance.PerformanceFile;
import java100.app.service.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired PerformanceDao performanceDao;
    @Autowired PerformanceFileDao performanceFileDao;
    
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
        this.addFiles(performance.getMedias(), performance.getNo());
        
        return count;
    }

    @Override
    public int update(Performance performance) {
        int count = performanceDao.update(performance);
        
        System.out.println(count + " <= PerformanceServiceImpl");
        System.out.println(performance.toString() + " <= PerformanceServiceImpl");
        //System.out.println(performance.getMedias().get(0).getFilename() + " <= PerformanceServiceImpl");
        if (performance.getMedias() != null) {
            System.out.println(count + " <= PerformanceServiceImpl");
            performanceFileDao.deleteAllByPerformanceNo(performance.getNo());
            addFiles(performance.getMedias(), performance.getNo());
        }
        
        return count;
    }

    @Override
    public int delete(int no) {
        //return performanceDao.delete(no);
        return 0;
    }
    
    @Override
    //@Transactional // XML 설정으로 대체
    public void addFiles(List<PerformanceFile> medias, int performanceNo) {
        for (PerformanceFile media : medias) {
            System.out.println(media.toString());
            media.setPerformanceNo(performanceNo);
            performanceFileDao.insert(media);
        }
    }

}












