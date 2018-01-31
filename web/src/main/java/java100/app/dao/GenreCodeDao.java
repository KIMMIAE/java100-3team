package java100.app.dao;

import java100.app.domain.GenreCode;

public interface GenreCodeDao {

    int findByGenreName(String genreName);
    void insert(GenreCode genreCdoe);
    void delete(String code);
}
