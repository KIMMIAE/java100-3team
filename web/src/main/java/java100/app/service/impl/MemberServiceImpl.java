package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.member.AreaCodeDao;
import java100.app.dao.member.ArtistDao;
import java100.app.dao.member.GenreCodeDao;
import java100.app.dao.member.InterestAreaDao;
import java100.app.dao.member.InterestGenreDao;
import java100.app.dao.member.MemberDao;
import java100.app.domain.member.InterestArea;
import java100.app.domain.member.InterestGenre;
import java100.app.domain.member.Member;
import java100.app.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired MemberDao memberDao;
    @Autowired ArtistDao artistDao;
    @Autowired InterestAreaDao interestAreaDao;
    @Autowired InterestGenreDao interestGenreDao;
    @Autowired AreaCodeDao areaCodeDao;
    @Autowired GenreCodeDao genreCodeDao;
    
    @Override
    public List<Member> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return memberDao.findAll(params);
    }

    @Override
    public Member get(int no) {
        return memberDao.findByNo(no);
    }
    
    @Override
    public String getPhoto(int no) {
        return memberDao.findPhotoByMemberNo(no);
    }
    
    @Override
    public int getAreaCnt(int no) {
        return interestAreaDao.countByMemberNo(no);
    }

    @Override
    public List<InterestArea> getInterestArea(int no) {
        return interestAreaDao.findByMemberNo(no);
    }
    
    @Override
    public int getGenreCnt(int no) {
        return interestGenreDao.countByMemberNo(no);
    }

    @Override
    public List<InterestGenre> getInterestGenre(int no) {
        return interestGenreDao.findByMemberNo(no);
    }
    
    @Override
    public Member get(String email, String password) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        return memberDao.findByEmailAndPassword(params);
    }
    
    @Override
    public int getTotalCount() {
        return memberDao.countAll();
    }

    @Override
    public int add(Member member) {
        
        int count = memberDao.insert(member);
        
        if (member.getInterestAreas() != null) {
            addInterestAreas(member.getNo(), member.getInterestAreas());
        }
        
        if (member.getInterestGenres() != null) {
            addInterestGenres(member.getNo(), member.getInterestGenres());
        }
        
        if (member.getType().equals("아티스트")) {
            member.setArtistNo(member.getNo());
            artistDao.insert(member.getArtist());
        }
        
        return count;
    }
    
    @Override
    public int update(Member member) {
        int count =  memberDao.update(member);

        if (member.getInterestAreas() != null) {
            addInterestAreas(member.getNo(), member.getInterestAreas());
        }

        if (member.getInterestGenres() != null) {
            addInterestGenres(member.getNo(), member.getInterestGenres());
        }
        
        if (member.getType().equals("아티스트")) {
            member.setArtistNo(member.getNo());
            int cnt = artistDao.findMemberNo(member.getNo());
            if (cnt == 0) {
                artistDao.insert(member.getArtist());
            } else {
                artistDao.update(member.getArtist());
            }
        }
        
        return count;
    }

    @Override
    public int delete(int no) {
        return memberDao.delete(no);
    }
    
    @Override
    public void addInterestAreas(int memberNo, List<InterestArea> areas) {
        int count = interestAreaDao.countByMemberNo(memberNo);
        
        if (count > 0) {
            interestAreaDao.deleteAllByMemberNo(memberNo);
        }

        for (InterestArea area : areas) {
            if (area.getAreaName().isEmpty()) continue;
            
            int areano = areaCodeDao.findByAreaName(area.getAreaName());
            
            area.setAreaNo(areano);
            area.setMemberNo(memberNo);
            interestAreaDao.insert(area);
        }
    }
    
    @Override
    public void addInterestGenres(int memberNo, List<InterestGenre> genres) {
        int count = interestGenreDao.countByMemberNo(memberNo);
        
        if (count > 0) {
            interestGenreDao.deleteAllByMemberNo(memberNo);
        }

        for (InterestGenre genre : genres) {
            if (genre.getGenreName().isEmpty()) continue;
            
            int genreno = genreCodeDao.findByGenreName(genre.getGenreName());
            
            genre.setGenreNo(genreno);
            genre.setMemberNo(memberNo);
            interestGenreDao.insert(genre);
        }
    }


}
