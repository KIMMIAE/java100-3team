package java100.app.dao.notice;

import java.util.List;
import java.util.Map;

import java100.app.domain.notice.NoticeInfo;

public interface NoticeInfoDao {
    List<NoticeInfo> findAll(Map<String,Object> params);
    NoticeInfo findByNo(int no);
    int countAll();
    int updateViewCount(int no);
    int insert(NoticeInfo noticeInfo);
    int update(NoticeInfo noticeInfo);
    int delete(int no);
    NoticeInfo findByNo2(int no);
}
