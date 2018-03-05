package java100.app.web.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java100.app.domain.member.InterestArea;
import java100.app.domain.member.InterestGenre;
import java100.app.domain.member.Member;
import java100.app.service.MemberService;
import java100.app.web.util.Base64Decoder;
import java100.app.web.util.ThumbnailMaker;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    @Autowired ServletContext servletContext;
    @Autowired ServletRequest pageContext;
    @Autowired MemberService memberService;
    
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
        
        int totalCount = memberService.getTotalCount();
        int lastPageNo = totalCount / pageSize;
        if ((totalCount % pageSize) > 0) {
            lastPageNo++;
        }
        
        HashMap<String,Object> result = new HashMap<>();
        
        result.put("pageNo", pageNo);
        result.put("lastPageNo", lastPageNo);
        
        result.put("list", memberService.list(pageNo, pageSize, options));
        return result;
    }
    
    @RequestMapping("{no}")
    public Object view(@PathVariable int no) throws Exception {
        
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("member", memberService.get(no));

        if (memberService.getAreaCnt(no) > 0) {
            result.put("arealist", memberService.getInterestArea(no));
        }

        if (memberService.getGenreCnt(no) > 0) {
            result.put("genrelist", memberService.getInterestGenre(no));
        }
        
        return result;
    }
    
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(Member member,
            @RequestParam(value="base64Image",required=false) String base64Image,
                       @RequestParam(value="areas", required=false) List<String> areas,
                       @RequestParam(value="genres", required=false) List<String> genres) throws Exception {
        
        if (!base64Image.isEmpty()) {
            
            String uploadDir = servletContext.getRealPath("/download");
            String filename = getNewFilename(".jpeg");
            Base64Decoder.decoder(base64Image, uploadDir + "//" + filename);
            
            member.setPhoto(filename);
            
            ThumbnailMaker.thumbnailMaker(100, 100, uploadDir, filename, "t1");
            ThumbnailMaker.thumbnailMaker(200, 200, uploadDir, filename, "t2");
            ThumbnailMaker.thumbnailMaker(300, 300, uploadDir, filename, "t3");
        }
        
        if (areas != null && areas.size() > 0) {
            ArrayList<InterestArea> interestAreas = new ArrayList<>();
            
            for (String area : areas) {
                interestAreas.add(new InterestArea(area));
            }
            
            member.setInterestAreas(interestAreas);
        }
        
        
        if (genres != null && genres.size() > 0) {
            ArrayList<InterestGenre> interestAreas = new ArrayList<>();
            for (String genre : genres) {
                interestAreas.add(new InterestGenre(genre));
            }
            member.setInterestGenres(interestAreas);
        }
        
        
        memberService.add(member);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    @RequestMapping("form")
    public String form() throws Exception {
        return "member/form";
        
    }
    
    @RequestMapping("checkEmail")
    public int checkEmail(String email) {
        
        int count = memberService.getEmailCount(email);
        
        return count;
    }
    
    @RequestMapping("checkNickName")
    public int checkNickName(String nickName) {
        
        int count = memberService.getNickNameCount(nickName);
        
        return count;
    }
    
    
    @RequestMapping("update")
    public Object update(Member member, 
            @RequestParam(value="base64Image",required=false) String base64Image,
                          @RequestParam(value="areas",required=false) String[] areas,
                          @RequestParam(value="genres",required=false) String[] genres) throws Exception {
        
        if (!base64Image.isEmpty()) {
            
            String uploadDir = servletContext.getRealPath("/download");
            String filename = getNewFilename(".jpeg");
            Base64Decoder.decoder(base64Image, uploadDir + "//" + filename);
            
            member.setPhoto(filename);
            
            ThumbnailMaker.thumbnailMaker(100, 100, uploadDir, filename, "t1");
            ThumbnailMaker.thumbnailMaker(200, 200, uploadDir, filename, "t2");
            ThumbnailMaker.thumbnailMaker(300, 300, uploadDir, filename, "t3");
        }
        
        /*if (!file.isEmpty()) {
            String uploadDir = servletContext.getRealPath("/download");
            String filename = writeUploadFile(file, uploadDir);
            member.setPhoto(filename);
        } else {
            member.setPhoto(memberService.getPhoto(member.getNo()));
        }*/

        if (areas != null && areas[0].length() > 0) {
            ArrayList<InterestArea> interestAreas = new ArrayList<>();
            for (String area : areas) {
                if (area.isEmpty()) continue;
                interestAreas.add(new InterestArea(area));
            }
            member.setInterestAreas(interestAreas);
        }

        if (genres != null && genres[0].length() > 0) {
            ArrayList<InterestGenre> interestGenres = new ArrayList<>();
            for (String genre : genres) {
                if (genre.isEmpty()) continue;
                interestGenres.add(new InterestGenre(genre));
            }
            member.setInterestGenres(interestGenres);
        }
        
        memberService.update(member);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }

    @RequestMapping("delete")
    public Object delete(int no) throws Exception {

        memberService.delete(no);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }
    
    
    long prevMillis = 0;
    int count = 0;
    
    // 다른 클라이언트가 보낸 파일명과 중복되지 않도록 
    // 서버에 파일을 저장할 때는 새 파일명을 만든다.
    synchronized private String getNewFilename(String png) {
        long currMillis = System.currentTimeMillis();
        if (prevMillis != currMillis) {
            count = 0;
            prevMillis = currMillis;
        }
        
        return  currMillis + "_" + count++ + extractFileExtName(png); 
    }
    
    // 파일명에서 뒤의 확장자명을 추출한다.
    private String extractFileExtName(String filename) {
        int dotPosition = filename.lastIndexOf(".");
        
        if (dotPosition == -1)
            return "";
        
        return filename.substring(dotPosition);
    }
    
    private String writeUploadFile(MultipartFile part, String path) throws IOException {
        
        String filename = getNewFilename(part.getOriginalFilename());
        part.transferTo(new File(path + "/" + filename));
        return filename;
    }

}