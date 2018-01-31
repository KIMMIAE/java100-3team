package java100.app.dao;

import java.util.List;

import java100.app.domain.InterestGenre;

public interface InterestGenreDao {
    List<InterestGenre> findByMemberNo(int no);
    int countByMemberNo(int no);
    void insert(InterestGenre interestGenre);
    void deleteAllByMemberNo(int no);
}
