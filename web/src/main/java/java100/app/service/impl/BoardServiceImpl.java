package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.BoardDao;
import java100.app.dao.FileDao;
import java100.app.domain.Board;
import java100.app.domain.UploadFile;
import java100.app.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired BoardDao boardDao;
    @Autowired FileDao fileDao;
    
    @Override
    public List<Board> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return boardDao.findAll(params);
    }

    @Override
    public Board get(int no) {
    }

    @Override
    public int getTotalCount() {
    }

    @Override
    public int add(Board board) {
    }

    @Override
    public int update(Board board) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateViewCount(int no) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(int no) {
        
        return boardDao.delete(no);
    }

    @Override
    public void addFiles(List<UploadFile> files, int boardNo) {
        for (UploadFile file : files) {
            file.setBoardNo(boardNo);
            fileDao.insert(file);
        }
    }

 
    
    
}












