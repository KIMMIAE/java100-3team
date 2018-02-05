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
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.member.Member;
import java100.app.domain.performance.Performance;
import java100.app.domain.performance.PerformanceFile;
import java100.app.domain.performance.PerformanceReview;
import java100.app.service.PerformanceReviewService;

@Controller
@RequestMapping("/performanceReview")
@SessionAttributes("loginUser")
public class PerformanceReviewController {
    
    @Autowired ServletContext servletContext;
    @Autowired PerformanceReviewService performanceReviewService;
    
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
        
        int totalCount = performanceReviewService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("list", performanceReviewService.list(pageNo, pageSize, options));
        return "performanceReview/list";
    }

    @RequestMapping("{no}")
    public String view(@PathVariable int no, Model model) throws Exception {
        
        model.addAttribute("performanceReview", performanceReviewService.get(no));
        /*System.out.println(performanceReviewService.get(no));*/
        return "performanceReview/view";
    }

    @RequestMapping("form")
    public String form() throws Exception {
        return "performanceReview/form";
        
    }
    
    // XML 설정으로 트랜잭션을 조정한다면 @Transactional 애노테이션은 필요없다.
    //@Transactional
    @RequestMapping("add")
    public String add(
            PerformanceReview performanceReview,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
    	
    	
        performanceReview.setWriter(loginUser);
        performanceReviewService.add(performanceReview);
        
        return "redirect:list";
    }
    
    @RequestMapping("update")
    public String update(
            PerformanceReview performanceReview,Performance performance,String nickName) throws Exception {
    	
    	performanceReviewService.update(performanceReview);
        System.out.println(performanceReview/*.getPerformance().getNo()*/ + "<= update");
        return "redirect:list";
        }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        performanceReviewService.delete(no);
        return "redirect:list";
    }
    
    //long prevMillis = 0;
    //int count = 0;
    
    // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    /*
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    */
    // 파일명에서 뒤의 확장자명을 추출한다.
    /*
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        
        if (dotPosition == -1)
            return "";
        
        return filename.substring(dotPosition);
    }
    
    private String writePerformanceFile(MultipartFile part, String path) throws IOException {
        
        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        return filename;
    }
    */
}








