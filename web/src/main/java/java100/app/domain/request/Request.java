package java100.app.domain.request;

import java.sql.Date;

import java100.app.domain.member.Artist;
import java100.app.domain.member.Member;

public class Request {
    protected int no;
    protected String title;
    protected String detailDesc;
    protected String genre;
    protected String entryDate;
    protected String location;
    protected String specialDesc;
    protected int viewCount;
    protected Date regDate;
    protected String mapx;
    protected String mapy;
    protected String artno;
    
    
    protected Member writer;
    protected Artist artist;
    
    @Override
    public String toString() {
        return "Request [no=" + no + ", title=" + title + ", detailDesc=" + detailDesc + ", genre=" + genre
                + ", entryDate=" + entryDate + ", location=" + location + ", specialDesc=" + specialDesc
                + ", viewCount=" + viewCount + ", regDate=" + regDate + ", mapx=" + mapx + ", mapy=" + mapy
                + ", writer=" + writer + "]";
    }
    
    public String getArtno() {
        return artno;
    }
    public void setArtno(String artno) {
        this.artno = artno;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDetailDesc() {
        return detailDesc;
    }
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getSpecialDesc() {
        return specialDesc;
    }
    public void setSpecialDesc(String specialDesc) {
        this.specialDesc = specialDesc;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public String getMapx() {
        return mapx;
    }
    public void setMapx(String mapx) {
        this.mapx = mapx;
    }
    public String getMapy() {
        return mapy;
    }
    public void setMapy(String mapy) {
        this.mapy = mapy;
    }
    public Member getWriter() {
        return writer;
    }
    public void setWriter(Member writer) {
        this.writer = writer;
    }
    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}










