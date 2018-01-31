package java100.app.dao.member;

import java.util.List;

import java100.app.domain.member.InterestGenre;

public interface InterestGenreDao {
    List<InterestGenre> findByMemberNo(int no);
    int countByMemberNo(int no);
    void insert(InterestGenre interestGenre);
    void deleteAllByMemberNo(int no);
}
