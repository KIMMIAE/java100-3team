package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.sponsor.SponsorDao;
import java100.app.domain.sponsor.Sponsor;
import java100.app.service.SponsorService;

@Service
public class SponsorServiceImpl implements SponsorService{

    @Autowired SponsorDao sponsorDao;
    
    @Override
    public List<Sponsor> list(int pageNo, int pageSize, Map<String, Object> options, int memberNo) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        params.put("memberNo",memberNo);
        return sponsorDao.findAll(params);
    }

    @Override
    public Sponsor get(int no) {
        return sponsorDao.findBySponNo(no);
    }

    @Override
    public int add(Sponsor sponsor) {
        return sponsorDao.insert(sponsor);
    }
    
    @Override
    public List<Sponsor> findSpons(int pageNo, int pageSize, Map<String, Object> options, int no) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        params.put("no",no);
        
        return sponsorDao.findByArtistNo(params);
    }

    @Override
    public int getTotalCount(int no) {
        return sponsorDao.countAll(no);
    }
    
    
}
