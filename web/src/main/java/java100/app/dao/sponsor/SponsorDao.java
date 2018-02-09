package java100.app.dao.sponsor;

import java.util.List;

import java100.app.domain.sponsor.Sponsor;

public interface SponsorDao {
    int insert(Sponsor sponsor);
    Sponsor findBySponNo(int no);
    List<Sponsor> findAll(int no);
/*    int deleteAllByMemberNo(int no);
*/}
