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
    public int getTotalCount() {
        return performanceDao.countAll();
    }

    @Override
    //@Transactional // XML 설정으로 대체한다.
    public int add(Performance performance) {
        int count = performanceDao.insert(performance);
        this.addFiles(performance.getFiles(), performance.getNo());
        
        return count;
    }

    @Override
    public int update(Performance performance) {
        
        int count = performanceDao.update(performance);
        performanceFileDao.deleteAllByPerformanceNo(performance.getNo());
        addFiles(performance.getFiles(), performance.getNo());
        
        return count;
    }

    @Override
    public int delete(int no) {
        return performanceDao.delete(no);
    }
    
    @Override
    //@Transactional // XML 설정으로 대체
    public void addFiles(List<PerformanceFile> files, int performanceNo) {
        for (PerformanceFile file : files) {
            file.setPerformanceNo(performanceNo);
            performanceFileDao.insert(file);
        }
    }

}












