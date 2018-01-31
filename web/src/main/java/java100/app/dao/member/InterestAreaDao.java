package java100.app.dao.member;

import java.util.List;

import java100.app.domain.member.InterestArea;

public interface InterestAreaDao {
    List<InterestArea> findByMemberNo(int no);
    int countByMemberNo(int no);
    void insert(InterestArea interestArea);
    void deleteAllByMemberNo(int no);
}
