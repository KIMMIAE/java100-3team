package java100.app.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.member.Member;
import java100.app.domain.sponsor.Sponsor;
import java100.app.service.SponsorService;

@RestController
@RequestMapping("/sponsor")
@SessionAttributes("loginUser")
public class SponsorController {
    
    @Autowired SponsorService sponsorService;
    
    @RequestMapping("list")
    public Object list(HttpSession session,Model model) throws Exception {
        Member member = (Member)session.getAttribute("loginUser");
        HashMap <String, Object> result = new HashMap<>();
        result.put("list", sponsorService.list(member.getNo()));
        return result;
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(Sponsor sponsor,HttpSession session) throws Exception {
        Member member = (Member)session.getAttribute("loginUser");
        sponsor.setMemberNo(member .getNo());
        HashMap<String,Object> result = new HashMap<>();
        int count = sponsorService.add(sponsor);
        if(count >= 0){
            result.put("Status", "success");
        } else {
            result.put("Status", "fail");
        }
        return result;
    }
    
    @RequestMapping("{sponsorNo}")
    public Object view(@PathVariable int sponsorNo) throws Exception {
        HashMap<String,Object> result = new HashMap<>();
        result.put("sponsor", sponsorService.get(sponsorNo));
        return result;
    }
    
    @RequestMapping("get")
    public Object get(HttpSession session) throws Exception {
        Member member = (Member)session.getAttribute("loginUser");
        HashMap<String,Object> result = new HashMap<>();
        System.out.println(member.getArtist());
        result.put("get", sponsorService.findSpons(member.getArtist().getNo()));
        return result;
    }

}








