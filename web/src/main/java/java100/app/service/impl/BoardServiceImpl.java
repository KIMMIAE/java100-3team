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

    @Override
    public int getTotalCount() {
        return 0;
    }

    @Override
    public Object list(int pageNo, int pageSize, HashMap<String, Object> options) {
        return null;
    }

    @Override
    public Board get(int no) {
        return null;
    }
 
}












