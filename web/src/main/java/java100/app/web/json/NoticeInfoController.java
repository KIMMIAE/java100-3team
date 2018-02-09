package java100.app.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.member.Member;
import java100.app.domain.notice.NoticeInfo;
import java100.app.service.NoticeInfoService;

@RestController
@RequestMapping("/notice")
@SessionAttributes("loginUser")
public class NoticeInfoController {
    
    @Autowired NoticeInfoService noticeInfoService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align) throws Exception {
        // UI 제어와 관련된 코드는 이렇게 페이지 컨트롤러에 두어야 한다.
        //
        if (pageNo < 1) {
            pageNo = 1;
        }
        
        if (pageSize < 5 || pageSize > 15) {
            pageSize = 5;
        }
        
        HashMap<String,Object> options = new HashMap<>();
        if (words != null && words[0].length() > 0) {
            options.put("words", words);
        }
        options.put("orderColumn", orderColumn);
        options.put("align", align);
        
        int totalCount = noticeInfoService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String,Object> result = new HashMap<>();

        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", noticeInfoService.list(pageNo, pageSize, options));
      
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("data", noticeInfoService.get(no));
        return result;
    }
    
    @RequestMapping("add")
    public Object add(NoticeInfo noticeInfo,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
       noticeInfo.setMember(loginUser);
        /* System.out.println(noticeInfo);*/
        noticeInfoService.add(noticeInfo);
        
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("update")
    public Object update(NoticeInfo noticeInfo) throws Exception {
        noticeInfoService.update(noticeInfo);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("delete")
    public Object delete(int no) throws Exception {

        noticeInfoService.delete(no);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    
   
    
}








