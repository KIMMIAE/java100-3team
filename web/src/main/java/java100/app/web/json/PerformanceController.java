package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.member.Member;
import java100.app.domain.performance.Jjim;
import java100.app.domain.performance.Performance;
import java100.app.domain.performance.PerformanceFile;
import java100.app.domain.performance.Rating;
import java100.app.domain.performance.Ripple;
import java100.app.service.PerformanceService;

@RestController
@RequestMapping("/performance")
@SessionAttributes("loginUser")
public class PerformanceController {
    
    @Autowired ServletContext servletContext;
    @Autowired PerformanceService performanceService;
    
    @RequestMapping("list")
    public Object list(
            HttpSession session,
            @RequestParam(value="pn", defaultValue="1") int pageNo,
            @RequestParam(value="ps", defaultValue="5") int pageSize,
            @RequestParam(value="words", required=false) String[] words,
            @RequestParam(value="oc", required=false) String orderColumn,
            @RequestParam(value="al", required=false) String align) throws Exception {

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
        
        int totalCount = performanceService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String,Object> result = new HashMap<>();
        Member member = new Member();
        member = (Member) session.getAttribute("loginUser");
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", performanceService.list(pageNo, pageSize, options));
        result.put("loginUser", member);
        
        return result;
    }

    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("data",  performanceService.get(no));
        System.out.println("Controller.view =>  " + performanceService.get(no).toString());
        return result;
    }
    
    // XML 설정으로 트랜잭션을 조정한다면 @Transactional 애노테이션은 필요없다.
    //@Transactional
    @RequestMapping(value="add", method = RequestMethod.POST)
    public Object add(
            Performance performance,
            MultipartFile[] files,
            HttpSession session) throws Exception {
        
        //System.out.println("Controller.add =>  " + performance.toString());
        
        String saveDir = servletContext.getRealPath("/download");
        ArrayList<PerformanceFile> performanceFiles = new ArrayList<>();
        
        for (MultipartFile file : files) {
            if (file.isEmpty()) continue;
            
            String filename = this.writePerformanceFile(file, saveDir);
            performanceFiles.add(new PerformanceFile(filename));
        }
        
        performance.setMedias(performanceFiles);
        Member member = (Member)session.getAttribute("loginUser");
        performance.setWriter(member);
        System.out.println("Controller.add =>  " + performance.toString());
        
        performanceService.add(performance);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("update")
    public Object update(
            Performance performance,
            MultipartFile[] files) throws Exception {
        
        System.out.println("Controller.update =>  " + performance.toString());
        
        ArrayList<PerformanceFile> performanceFiles = new ArrayList<>();
        if (!files[0].isEmpty()) {
            String uploadDir = servletContext.getRealPath("/download");
            
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                
                String filename = this.writePerformanceFile(file, uploadDir);
                performanceFiles.add(new PerformanceFile(filename));
            }
            performance.setMedias(performanceFiles);
        }
        
        performanceService.update(performance);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }

    /*@RequestMapping("delete")
    public String delete(int no) throws Exception {

        performanceService.delete(no);
        return "redirect:list";
    }*/

    @RequestMapping("jjim")
    public Object jjim(Jjim jjim) throws Exception {
        
        System.out.println("Controller.jjim =>  " + jjim.toString());

        performanceService.jjimHagi(jjim);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("viewjjim")
    public Object viewJjim(Jjim jjim) throws Exception {
        HashMap<String, Object> result = new HashMap<>();

        result.put("jjim",  performanceService.getJjim(jjim));
        return result;
    }

    @RequestMapping("addrating")
    public Object addRating(Rating rating) throws Exception {
        
        System.out.println("Controller.addRating =>  " + rating.toString());

        performanceService.addRating(rating);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }

    @RequestMapping("addripple")
    public Object addRipple(Ripple ripple) throws Exception {
        
        System.out.println("Controller.jjim =>  " + ripple.toString());

        performanceService.addRipple(ripple);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("viewripple")
    public Object viewRipple(Ripple ripple) throws Exception {
        
        System.out.println("Controller.viewRipple =>  " + ripple.toString());
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("ripple",  performanceService.getRipple(ripple));
        System.out.println("Controller.viewRipple =>  " + performanceService.getRipple(ripple));
        return result;
    }
    
    long prevMillis = 0;
    int count = 0;
    
    // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    synchronized private String getNewFilename(String filename) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(filename); 
    }
    
    // 파일명에서 뒤의 확장자명을 추출한다.
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
}








