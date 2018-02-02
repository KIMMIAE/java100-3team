package java100.app.dao.performance;

import java.util.List;
import java.util.Map;

import java100.app.domain.performance.Performance;

public interface PerformanceDao {
    List<Performance> findAll(Map<String,Object> params);
    Performance findByNo(int no);
    Performance findByNo2(int no);
    int countAll();
    int updateViewCount(int no);
    int insert(Performance performance);
    int update(Performance performance);
    int delete(int no);
}















