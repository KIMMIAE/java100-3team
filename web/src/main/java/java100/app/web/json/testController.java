package java100.app.web.json;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/request")
public class testController {
    

    @RequestMapping("test")
    public Object test(String locName) throws Exception {
        System.out.println(locName);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", "bFDtO4KnfCKKptaueJAL");
        headers.set("X-Naver-Client-Secret", "0EGuD8QufL");
        HttpEntity entity = new HttpEntity(headers);
        System.out.println("실행완료");
        ResponseEntity<HashMap> response = restTemplate.exchange("https://openapi.naver.com/v1/search/local.json?query={v1}", HttpMethod.GET, entity, HashMap.class, locName);
        
        System.out.println(response.getBody());
        
        
//        HashMap<String,Object> result = new HashMap<>();
        return response.getBody();
    }
}
