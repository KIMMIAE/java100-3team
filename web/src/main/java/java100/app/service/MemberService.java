package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.member.InterestArea;
import java100.app.domain.member.InterestGenre;
import java100.app.domain.member.Member;

// => "역할"을 강조할 때는 "객체(object)"라는 말보다는 
//    "컴포넌트(component)"라는 말을 사용한다.
// => "객체"는 말 그대로 한 개의 클래스를 가리키는 것이라면,
//    "컴포넌트"는 그 역할을 수행하는 여러 객체의 묶음을 총칭한다.
//
// Service 컴포넌트(인터페이스, 구현체)는 "업무 로직"과 "트랜잭션 처리"를  
// 담당하기 때문에 인터페이스에 선언하는 메서드 이름도 
// 가능한 업무 용어를 사용한다.
//
public interface MemberService {
    List<Member> list(int pageNo, int pageSize, Map<String,Object> options);
    Member get(int no);
    String getPhoto(int no);
    int getAreaCnt(int no);
    List<InterestArea> getInterestArea(int no);
    int getGenreCnt(int no);
    List<InterestGenre> getInterestGenre(int no);
    Member get(String email, String password);
    int getTotalCount();
    int add(Member member);
    int update(Member member);
    int delete(int no);
    public void addInterestAreas(int memberNo, List<InterestArea> areas);
    public void addInterestGenres(int memberNo, List<InterestGenre> genres);
}





