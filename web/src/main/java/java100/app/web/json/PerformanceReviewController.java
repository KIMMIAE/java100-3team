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
import java100.app.domain.performance.PerformanceReview;
import java100.app.domain.performance.ReviewFile;
import java100.app.service.PerformanceReviewService;
import java100.app.service.PerformanceService;
import java100.app.web.util.ThumbnailMaker;

@RestController
@RequestMapping("/performanceReview")
@SessionAttributes("loginUser")
public class PerformanceReviewController {
    
    @Autowired ServletContext servletContext;
    @Autowired PerformanceReviewService performanceReviewService;
    @Autowired PerformanceService performanceService;
    
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
        
        int totalCount = performanceReviewService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", performanceReviewService.list(pageNo, pageSize, options));
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        return result;
    }
    
    @RequestMapping("search")
    public Object search(
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
        
        int totalCount = performanceReviewService.getSearchCount(options);
        int lastPageNo = totalCount / pageSize;
        if(lastPageNo == 0) {
            lastPageNo=1;
        }
        
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        
        
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        result.put("list", performanceService.list(pageNo, pageSize, options));
        
        
        // view 컴포넌트가 사용할 값을 Model에 담는다.
        return result;
    }
        
    // XML 설정으로 트랜잭션을 조정한다면 @Transactional 애노테이션은 필요없다.
    //@Transactional
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(
            PerformanceReview performanceReview,
            MultipartFile[] files,
            HttpSession session) throws Exception {
        
    	System.out.println("=====================>");
    	System.out.println(files);
    	System.out.println(performanceReview);
    	
       String uploadDir = servletContext.getRealPath("/download");
       
       ArrayList<ReviewFile> reviewFileList = new ArrayList<>();

      for (MultipartFile parts : files) {
         if (parts.isEmpty())
            continue;

         String filename = this.writeUploadFile(parts, uploadDir);
         reviewFileList.add(new ReviewFile(filename));
         ThumbnailMaker.thumbnailMaker(740, 300, uploadDir, filename, "reviewT1");

      }
      
       performanceReview.setReviewFiles(reviewFileList);

       Member member = (Member)session.getAttribute("loginUser");
   	performanceReview.setWriter(new Member());
   	performanceReview.getWriter().setNo(member.getNo());
       
       performanceReview.toString();
       performanceReviewService.add(performanceReview);
        
        HashMap<String,Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
       
       HashMap<String, Object> result = new HashMap<>();
       result.put("performanceReview", performanceReviewService.get(no));
       return result;
    }
    
    @RequestMapping("form")
    public Object form(HttpSession session) throws Exception {
       Member member = (Member)session.getAttribute("loginUser");
       HashMap<String, Object> result = new HashMap<>();
       result.put("loginUser", member);
       return result;
    }
    
    
    @RequestMapping("artNo")
    public Object findByArtNo(int artNo) throws Exception {
       
       HashMap<String, Object> result = new HashMap<>();
       result.put("list", performanceReviewService.findByArtNo(artNo));
       return result;
    }
    

   @RequestMapping("update")
    public Object update(
            PerformanceReview performanceReview, /*Performance performance,String nickName,*/ MultipartFile[] files, HttpSession session) throws Exception {
       
      

           ArrayList<ReviewFile> reviewUploadFile = new ArrayList<>();
           if (!files[0].isEmpty()) {
               String uploadDir = servletContext.getRealPath("/download");
           
               for (MultipartFile part : files) {
                   if (part.isEmpty()) continue;
               
               String filename = this.writeUploadFile(part, uploadDir);
               ThumbnailMaker.thumbnailMaker(300, 300, uploadDir, filename, "reviewT1");
               reviewUploadFile.add(new ReviewFile(filename));
           }
           performanceReview.setReviewFiles(reviewUploadFile);
       }
      
           System.out.println(performanceReview + "<= 리뷰//");
           /*System.out.println(performance + "<= 공연//");
			System.out.println(nickName + "<= 닉네임//");*/
           Member member = (Member)session.getAttribute("loginUser");
           performanceReview.setWriter(member);
           performanceReviewService.update(performanceReview);
           
           HashMap<String, Object> result = new HashMap<>();
           result.put("status", "succes");
           
           return result;
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
       return  currMillis + "_" + count++ + extractFileExtName(originalFilename); 
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
    

    
    
    
    //
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







