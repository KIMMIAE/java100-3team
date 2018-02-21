package java100.app.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.member.Member;
import java100.app.domain.sponsor.GreenGrape;
import java100.app.service.GreenGrapeService;

@Controller
@RequestMapping("/grape")
@SessionAttributes("loginUser")
public class GreenGrapeController {
    
    @Autowired GreenGrapeService greenGrapeService;
    
  
     
    @RequestMapping("form")
    public String form(HttpSession session,Model model) throws Exception {
        Member member= (Member) session.getAttribute("loginUser");
        model.addAttribute("greenGrape", member.getNo());
        return "grape/form";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(GreenGrape greenGrape) throws Exception {
        System.out.println(greenGrape.getMemberNo());
        greenGrapeService.add(greenGrape);
        return "redirect:list";
    }
    
    
    @RequestMapping("{greenGrapeNo}")
    public String view(@PathVariable int greenGrapeNo, Model model) throws Exception {
        System.out.println(greenGrapeNo);
        
        System.out.println(greenGrapeService.get(greenGrapeNo).getGreenGrapeNo());
        model.addAttribute("greenGrape", greenGrapeService.get(greenGrapeNo));
        return "grape/view";
    }
    
    @RequestMapping("list")
    public String list(  @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align,
            HttpSession session,Model model) throws Exception {


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

        int totalCount = greenGrapeService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        Member member= (Member) session.getAttribute("loginUser");
        model.addAttribute("list", greenGrapeService.list(member.getNo(),pageNo, pageSize, options));
        if(greenGrapeService.sum(member.getNo())>=0){
            model.addAttribute("sum", greenGrapeService.sum(member.getNo()));
        } else {
            model.addAttribute("sum", "0");    
        }
        return "grape/list";
    }

    
}








