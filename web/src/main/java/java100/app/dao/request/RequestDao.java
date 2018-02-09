package java100.app.dao.request;

import java.util.List;
import java.util.Map;

import java100.app.domain.request.Request;

public interface RequestDao {
    List<Request> findAll(Map<String,Object> params);
    Request findByNo(int no);
    Request findByNo2(int no);
    int countAll();
    int updateViewCount(int no);
    int insert(Request request);
    int update(Request request);
    int delete(int no);
}















