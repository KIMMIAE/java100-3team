package java100.app.dao.performance;

import java.util.List;

import java100.app.domain.performance.PerformanceFile;

public interface PerformanceFileDao {

    List<PerformanceFile> findByPerformanceNo(int no);
    void insert(PerformanceFile file);
    void deleteAllByPerformanceNo(int no);
}
