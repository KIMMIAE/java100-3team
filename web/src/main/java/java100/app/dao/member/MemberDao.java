package java100.app.dao.member;

import java.util.List;
import java.util.Map;

import java100.app.domain.member.Member;

public interface MemberDao {
    List<Member> findAll(Map<String,Object> params);
    Member findByNo(int no);
    String findPhotoByMemberNo(int no);
    Member findByEmailAndPassword(Map<String,Object> params);
    Member findByEmail(String email);
    int countEmail(String email);
    int countNickName(String nickName);
    int countAll();
    int countComparePassword();
    int insert(Member member);
    int update(Member member);
    int updatePassword(Member member);
    int delete(int no);
}















