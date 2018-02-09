package java100.app.dao.sponsor;

import java.util.List;
import java.util.Map;

import java100.app.domain.sponsor.GreenGrape;

public interface GreenGrapeDao {
    int insert(GreenGrape greenGrape);
    GreenGrape findByGrapeNo(int no);
    List<GreenGrape> findAll(Map<String,Object> params);
    int findSum(int no);
    int countAll();
}
