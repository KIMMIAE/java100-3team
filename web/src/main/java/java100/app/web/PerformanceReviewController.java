package java100.app.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import java100.app.domain.performance.PerformanceReview;
import java100.app.domain.performance.ReviewFile;
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
            MultipartFile[] files,
            @ModelAttribute(value="loginUser") Member loginUser) throws Exception {
    	System.out.println(performanceReview);
    	System.out.println(count + " <= PerformanceServiceImpl");
    	System.out.println(performanceReview.toString() + " <= PerformanceServiceImpl");
    	
    	String uploadDir = servletContext.getRealPath("/download");

    	ArrayList<ReviewFile> reviewFileList = new ArrayList<>();

		for (MultipartFile parts : files) {
			if (parts.isEmpty())
				continue;

			String filename = this.writeUploadFile(parts, uploadDir);
			reviewFileList.add(new ReviewFile(filename));

		}
        performanceReview.setWriter(loginUser);
        performanceReview.setReviewFiles(reviewFileList);
        performanceReviewService.add(performanceReview);
        
        return "redirect:list";
    }
    


	@RequestMapping("update")
    public String update(
            PerformanceReview performanceReview,Performance performance,String nickName, MultipartFile[] files) throws Exception {
	     
	     String uploadDir = servletContext.getRealPath("/download");

	        // 업로드 파일 정보를 저장할 List 객체 준비
	        ArrayList<ReviewFile> reviewUploadFile = new ArrayList<>();
	        
	        // 클라이언트가 보낸 파일을 저장하고, 
	        // 그 파일명(저장할 때 사용한 파일명)을 목록에 추가한다.
	        for (MultipartFile part : files) {
	            if (part.isEmpty())
	                continue;
	            
	            String filename = this.writeUploadFile(part, uploadDir);
	            
	            reviewUploadFile.add(new ReviewFile(filename));
	        }
	        
	        // Board 객체에 저장한 파일명을 등록한다. 
	        performanceReview.setReviewFiles(reviewUploadFile);

	        performanceReviewService.update(performanceReview);
	        return "redirect:list";
	    }

    @RequestMapping("delete")
    public String delete(int no) throws Exception {
    	
        performanceReviewService.delete(no);
        
        
        return "redirect:list";
    }
    
    
    long prevMillis = 0;
    int count = 0;
    
    synchronized private String getNewFilename(String originalFilename) {
    	long currMillis = System.currentTimeMillis();
    	if (prevMillis != currMillis) {
    		count = 0;
    		prevMillis = currMillis;
    	}
    	return System.currentTimeMillis() + "_" + count++ + extractFileExtName(originalFilename);
    }
    
    
    
    private String extractFileExtName(String originalFilename) {
    	int dotposition = originalFilename.lastIndexOf(".");
    	if (dotposition == -1)
    		return "";
    	
    	return originalFilename.substring(dotposition);
    }
    
    private String writeUploadFile(MultipartFile parts, String route) throws IOException {
    	String filename = getNewFilename(parts.getOriginalFilename());
    	parts.transferTo(new File(route + "/" + filename));
    	
    	return filename;
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








