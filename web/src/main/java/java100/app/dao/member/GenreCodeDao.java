package java100.app.dao.member;

import java100.app.domain.member.GenreCode;

public interface GenreCodeDao {

    int findByGenreName(String genreName);
    void insert(GenreCode genreCdoe);
    void delete(String code);
}
