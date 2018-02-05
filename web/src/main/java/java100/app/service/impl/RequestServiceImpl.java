package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.request.RequestDao;
import java100.app.domain.request.Request;
import java100.app.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired RequestDao requestDao;
    
    @Override
    public List<Request> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return requestDao.findAll(params);
    }

    @Override
    public Request get(int no) {
        requestDao.updateViewCount(no);
        
        // 게시물의 첨부 파일 정보를 가져올 때 
        // 방법1: 
        // => 따로 따로 가져오기 
        Request request = requestDao.findByNo(no);
        //request.setFiles(fileDao.findByBoardNo(no));
        
        // 방법2:
        // => request 객체에 묶어서 가져오기
        // Request request = requestDao.findByNo2(no);
        
        return request;
    }
    
    @Override
    public int getTotalCount() {
        return requestDao.countAll();
    }

    @Override
    //@Transactional // XML 설정으로 대체한다.
    
    public int add(Request request) {
        
        // insert를 하기 전에는 request의 no 프로퍼티 값은 0이다.
        // insert를 한 후에는 no 프로퍼티에 DB에서 생성한 값이 저장된다.
        int count = requestDao.insert(request);

        
        return count;
    }

    @Override
    public int update(Request request) {
        
        int count = requestDao.update(request);
        /*System.out.println(count);*/
        return count;
    }

    @Override
    public int delete(int no) {
        
        // 자식 테이블의 데이터를 먼저 지워야만 게시물 데이터를 지울 수 있다.
        // => 만약 bno 외부키에 대해 on delete cascade가 지정되어 있다면,
        //    부모 테이블 ex_request 의 데이터를 지우는 즉시 
        //    자식 테이블 ex_file의 데이터도 자동으로 지워진다.
        // 
        //fileDao.deleteAllByBoardNo(no);
        
        return requestDao.delete(no);
    }
    

}












