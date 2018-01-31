package java100.app.dao.member;

import java.util.List;
import java.util.Map;

import java100.app.domain.member.Member;

public interface MemberDao {
    List<Member> findAll(Map<String,Object> params);
    Member findByNo(int no);
    String findPhotoByMemberNo(int no);
    Member findByEmailAndPassword(Map<String,Object> params);
    int countAll();
    int insert(Member member);
    int update(Member member);
    int delete(int no);
}















