package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import java100.app.domain.member.Member;
import java100.app.domain.request.Request;
import java100.app.service.RequestService;

@RestController
@RequestMapping("/request")
@SessionAttributes("loginUser")
public class RequestController {
    
    @Autowired ServletContext servletContext;
    @Autowired RequestService requestService;
    
    @RequestMapping("list")
    public Object list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            HttpSession session) throws Exception {

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
        
        int totalCount = requestService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        HashMap<String,Object> result = new HashMap<>();

        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        Member member = (Member) session.getAttribute("loginUser");
        result.put("list", requestService.list(member.getNo(), pageNo, pageSize, options));
      
        return result;
    }

    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        result.put("data", requestService.get(no));
        return result;
    }
    
    // XML 설정으로 트랜잭션을 조정한다면 @Transactional 애노테이션은 필요없다.
    //@Transactional
    @RequestMapping("add")
    public Object add(Request request,
            HttpSession session) throws Exception {
        Member member = (Member)session.getAttribute("loginUser");
        request.setWriter(new Member());
        request.getWriter().setNo(member.getNo());;

        
        System.out.println(request.getEntryDate());
        
        requestService.add(request);
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("update")
    public Object update(Request request,
            HttpSession session) throws Exception {
        Member member = (Member)session.getAttribute("loginUser");
        request.setWriter(new Member());
        request.getWriter().setNo(member.getNo());;
        
        requestService.update(request);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no,
            Request request,
            HttpSession session) throws Exception {
        Member member = (Member)session.getAttribute("loginUser");
        request.setWriter(new Member());
        request.getWriter().setNo(member.getNo());;
        
        requestService.delete(no);
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("form")
    public Object form(String locName) throws Exception {
        System.out.println(locName);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", "bFDtO4KnfCKKptaueJAL");
        headers.set("X-Naver-Client-Secret", "0EGuD8QufL");
        HttpEntity entity = new HttpEntity(headers);
        System.out.println("실행완료");
        ResponseEntity<HashMap> response = restTemplate.exchange("https://openapi.naver.com/v1/search/local.json?query={v1}", HttpMethod.GET, entity, HashMap.class, locName);
        
        System.out.println(response.getBody());
        
        
//        HashMap<String,Object> result = new HashMap<>();
        return response.getBody();
    }
}
