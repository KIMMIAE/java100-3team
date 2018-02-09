package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.performance.Jjim;
import java100.app.domain.performance.Performance;
import java100.app.domain.performance.PerformanceFile;
import java100.app.domain.performance.Rating;
import java100.app.domain.performance.Ripple;

public interface PerformanceService {
    List<Performance> list(int pageNo, int pageSize, Map<String,Object> options);
    Performance get(int no);
    int getTotalCount();
    List<PerformanceFile> getMedias(int no);
    int add(Performance performance);
    int update(Performance performance);
    int delete(int no);
    void addFiles(List<PerformanceFile> files, int performanceNo);
    void jjimHagi(Jjim jjim);
    int getJjim(Jjim jjim);
    void addRating(Rating rating);
    void addRipple(Ripple ripple);
    String getRipple(Ripple ripple);
}





