package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.notice.NoticeInfo;

public interface NoticeInfoService {
    List<NoticeInfo> list(int pageNo, int pageSize, Map<String,Object> options);
    NoticeInfo get(int no);
    int getTotalCount();
    int add(NoticeInfo noticeInfo);
    int update(NoticeInfo noticeInfo);
    int delete(int no);
}





