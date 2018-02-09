package java100.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.sponsor.SponsorDao;
import java100.app.domain.sponsor.Sponsor;
import java100.app.service.SponsorService;

@Service
public class SponsorServiceImpl implements SponsorService{

    @Autowired SponsorDao sponsorDao;
    
    @Override
    public List<Sponsor> list(int no) {
        return sponsorDao.findAll(no);
    }

    @Override
    public Sponsor get(int no) {
        return sponsorDao.findBySponNo(no);
    }

    @Override
    public int add(Sponsor sponsor) {
        return sponsorDao.insert(sponsor);
    }
}
