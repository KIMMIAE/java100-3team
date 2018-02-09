package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.sponsor.GreenGrapeDao;
import java100.app.domain.sponsor.GreenGrape;
import java100.app.service.GreenGrapeService;

@Service
public class GreenGrapeServiceimpl implements GreenGrapeService {
    
    @Autowired GreenGrapeDao greenGrapeDao;
    
    
    @Override
    public int add(GreenGrape greenGrape) {
        return greenGrapeDao.insert(greenGrape);
    }

    @Override
    public GreenGrape get(int no) {
        return greenGrapeDao.findByGrapeNo(no);
    }

    @Override
    public int sum(int no) {
        return greenGrapeDao.findSum(no);
    }


 @Override
    public List<GreenGrape> list(int no,int pageNo, int pageSize, Map<String, Object> options) {

     HashMap<String,Object> params = new HashMap<>();
     params.put("memberGetNo", no);
     params.put("startIndex", (pageNo - 1) * pageSize);
     params.put("size", pageSize);
     
     if (options != null) {
         params.putAll(options);
     }
        return greenGrapeDao.findAll(params); 
    }

    @Override
    public int getTotalCount() {
        return greenGrapeDao.countAll();
    }

     

}
