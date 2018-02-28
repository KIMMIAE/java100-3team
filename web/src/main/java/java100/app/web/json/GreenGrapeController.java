package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java100.app.domain.member.Member;
import java100.app.domain.sponsor.GreenGrape;
import java100.app.service.GreenGrapeService;
import java100.app.service.KakaoService;

@RestController
@RequestMapping("/grape")
public class GreenGrapeController {

    @Autowired GreenGrapeService greenGrapeService;
    @Autowired KakaoService kakaoService;
 
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(GreenGrape greenGrape,HttpSession session) throws Exception {
        Member member= (Member) session.getAttribute("loginUser");
        
        greenGrape.setMemberNo(member.getNo());
        greenGrapeService.add(greenGrape);
        HashMap<String, Object> result = new HashMap<>();
        result.put("staus", "success");
        return result;
    }

    @RequestMapping("{greenGrapeNo}")
    public Object view(@PathVariable int greenGrapeNo) throws Exception {
        System.out.println(greenGrapeNo);
        HashMap<String, Object> result = new HashMap<>();
        System.out.println(greenGrapeService.get(greenGrapeNo).getGreenGrapeNo());
        result.put("greenGrape", greenGrapeService.get(greenGrapeNo));
        return result;
    }


    @RequestMapping("list")
    public Object list(  @RequestParam(value="pn", defaultValue="1") int pageNo,
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

        HashMap<String,Object> result = new HashMap<>();
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        Member member= (Member) session.getAttribute("loginUser");
        result.put("list", greenGrapeService.list(member.getNo(),pageNo, pageSize, options));
        
        if(greenGrapeService.sum(member.getNo())>=0){
            result.put("sum", greenGrapeService.sum(member.getNo()));
        } else {
            result.put("sum","0");    
        }
        
        
        return result;
    }

@RequestMapping(value="payment")
    public Object payment(GreenGrape grape, String accessToken,HttpSession session) throws Exception {
    
        @SuppressWarnings("rawtypes")
        HashMap result = kakaoService.pay(accessToken, grape,HashMap.class);
        
        session.setAttribute("tid",result.get("tid"));
        session.setAttribute("accessToken", accessToken);
    return result;
    }



@RequestMapping(value="approve")
public Object approve(String pg_Token,HttpSession session) throws Exception {
    
    @SuppressWarnings("rawtypes")
    HashMap result = kakaoService.approve(pg_Token,session,HashMap.class);
    return result;
    }

}






