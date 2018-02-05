package java100.app.domain.request;

import java.sql.Date;

import java100.app.domain.member.Member;

public class Request {
    protected int no;
    protected String title;
    protected String detailDesc;
    protected String genre;
    protected Date entryDate;
    protected String location;
    protected String specialDesc;
    protected int viewCount;
    protected Date regDate;

    protected Member writer;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        /*System.out.println(title + " ==> getTitle");*/
        return title;
    }

    public void setTitle(String title) {
        /*System.out.println(title + " ==> setTitle");*/
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

    public Date getEntryDate() {
        System.out.println(entryDate + "=> getEntryDate");
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
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
        /*System.out.println(viewCount + " ==> getViewCount");*/
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        /*System.out.println(viewCount + " ==> setViewCount");*/
        this.viewCount = viewCount;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Member getWriter() {
        return writer;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }

}










