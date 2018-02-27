package java100.app.service.impl;
 
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java100.app.domain.sponsor.GreenGrape;
import java100.app.service.KakaoService;


@Service
public class KaKaoServiceImpl implements KakaoService {

    @Override
    public <T> T pay(String accessToken,GreenGrape grape,Class<T> type) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.ALL}));
        headers.set("Authorization", "Bearer " + accessToken);
        
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("cid", "TC0ONETIME");
        param.add("partner_order_id", "partner_order_id");
        param.add("partner_user_id", "partner_user_id");
        param.add("item_name", "청포도");
        param.add("quantity", Integer.toString(grape.getChrCount()));
        param.add("total_amount", Integer.toString(grape.getChrAmount()));
        param.add("tax_free_amount", Integer.toString((int)(grape.getChrAmount() * 0.1)));
        param.add("approval_url", "http://t3.java100.com:9999/grape/success.html");
        param.add("cancel_url", "http://t3.java100.com:9999/grape/form.html");
        param.add("fail_url", "http://t3.java100.com:9999/grape/form.html");
        
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(param, headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
        return restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready",entity, type);
        } catch (Exception e) {
            throw new RuntimeException("카카오 API 실행 오류!",e);
        }
    }

    @Override
    public <T> T approve(String pg_Token, HttpSession session,Class<T> type) {
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.ALL}));
        headers.set("Authorization", "Bearer " + session.getAttribute("accessToken"));
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("cid", "TC0ONETIME");
        param.add("tid", (String)session.getAttribute("tid"));
        param.add("partner_order_id", "partner_order_id");
        param.add("partner_user_id", "partner_user_id");
        param.add("pg_token", pg_Token);
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(param, headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
        return restTemplate.postForObject("https://kapi.kakao.com/v1/payment/approve",entity, type);
        } catch (Exception e) {
            throw new RuntimeException("카카오 API 실행 오류!",e);
        }
    }
    
}








