package java100.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java100.app.domain.member.Member;
import java100.app.domain.sponsor.Sponsor;
import java100.app.service.SponsorService;

@Controller
@RequestMapping("/sponsor")
@SessionAttributes("loginUser")
public class SponsorController {
    
    @Autowired SponsorService sponsorService;
    
    @RequestMapping("list")
    public String list(@ModelAttribute(value="loginUser") Member loginUser,Model model) throws Exception {
        model.addAttribute("list", sponsorService.list(loginUser.getNo()));
        return "sponsor/list";
    }
    
    @RequestMapping("form")
    public String form(@ModelAttribute(value="loginUser") Member loginUser,Model model) throws Exception {
        model.addAttribute("sponsor", loginUser.getNo());
        return "sponsor/form";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Sponsor sponsor) throws Exception {
        System.out.println(sponsor.getMemberNo());
        sponsorService.add(sponsor);
        return "redirect:list";
    }
    
    @RequestMapping("{sponsorNo}")
    public String view(@PathVariable int sponsorNo, Model model) throws Exception {
        System.out.println(sponsorNo);
        System.out.println(sponsorService.get(sponsorNo).getSponsorNo());
        model.addAttribute("sponsor", sponsorService.get(sponsorNo));
        return "sponsor/view";
    }
    
    
}








