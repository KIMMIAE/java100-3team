package java100.app.service;

import javax.servlet.http.HttpSession;

import java100.app.domain.sponsor.GreenGrape;

public interface KakaoService {
    <T> T pay(String accessToken, GreenGrape grape, Class<T> type);
    <T> T approve(String pg_Token,HttpSession session,Class<T> type);
}
