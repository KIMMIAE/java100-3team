package java100.app.service.impl;

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
        // TODO Auto-generated method stub
        return null;
    }  

    @Override
    public Board get(int no) {
        boardDao.updateViewCount(no); 
        
        Board board = boardDao.findByNo2(no);
        
        return board;
    }

    @Override
    public int getTotalCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int add(Board board) {
        // TODO Auto-generated method stub
        return 0;
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addFiles(List<UploadFile> files, int boardNo) {
        // TODO Auto-generated method stub
        
    }

}












