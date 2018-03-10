package java100.app.dao.sponsor;

import java.util.List;
import java.util.Map;

import java100.app.domain.sponsor.Sponsor;

public interface SponsorDao {
    int insert(Sponsor sponsor);
    Sponsor findBySponNo(int no);
    List<Sponsor> findAll(Map<String,Object> params);
    List<Sponsor> findByArtistNo(Map<String,Object> params);
    int countAll(int no);
}
