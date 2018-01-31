package java100.app.dao;

import java100.app.domain.Artist;

public interface ArtistDao {
    int findMemberNo(int no);
    int insert(Artist artist);
    int update(Artist artist);
    int delete(int no);

}
