package java100.app.dao.member;

import java100.app.domain.member.Artist;

public interface ArtistDao {
    int findMemberNo(int no);
    int insert(Artist artist);
    int update(Artist artist);
    int delete(int no);

}
