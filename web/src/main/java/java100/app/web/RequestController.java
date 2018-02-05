package java100.app.web;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.member.Member;
import java100.app.domain.request.Request;
import java100.app.service.RequestService;

@Controller
@RequestMapping("/request")
@SessionAttributes("loginUser")
public class RequestController {
    
    @Autowired ServletContext servletContext;
    @Autowired RequestService requestService;
    
    @RequestMapping("list")
    public String list(
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            Model model) throws Exception {

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
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", requestService.list(pageNo, pageSize, options));
        return "request/list";
    }

    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("request", requestService.get(no));
        return "request/view";
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "request/form";
        
    }
    
    // XML 설정으로 트랜잭션을 조정한다면 @Transactional 애노테이션은 필요없다.
    //@Transactional
    @RequestMapping("add")
    public String add(
            Request request,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
        
        // 게시글 작성자는 로그인 사용자이다. 
        request.setWriter(loginUser);
        
        // 게시글 등록
        requestService.add(request);
        
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(
            Request request) throws Exception {
        
        requestService.update(request);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        requestService.delete(no);
        return "redirect:list";
    }
}
