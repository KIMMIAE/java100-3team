package java100.app.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.notice.NoticeInfoDao;
import java100.app.domain.notice.NoticeInfo;
import java100.app.service.NoticeInfoService;

@Service
public class NoticeInfoServiceImpl implements NoticeInfoService {
    
    @Autowired NoticeInfoDao noticeInfoDao;

    @Override
    public List<NoticeInfo> list(int pageNo, int pageSize, Map<String, Object> options) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        return noticeInfoDao.findAll(params);
    }

    @Override
    public NoticeInfo get(int no) {
        noticeInfoDao.updateViewCount(no);
        NoticeInfo noticeInfo = noticeInfoDao.findByNo2(no);
        return noticeInfo;
    }

    @Override
    public int getTotalCount() {
        return noticeInfoDao.countAll();
    }


    @Override
    public int update(NoticeInfo noticeInfo) {
        return noticeInfoDao.update(noticeInfo);
    }

    @Override
    public int delete(int no) {
        return noticeInfoDao.delete(no);
    }

    @Override
    public int add(NoticeInfo noticeInfo) {
        /*System.out.println(noticeInfo);*/
        return noticeInfoDao.insert(noticeInfo);
    }
    
    

}












