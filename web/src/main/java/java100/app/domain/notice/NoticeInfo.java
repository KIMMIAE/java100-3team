package java100.app.domain.notice;

import java.sql.Date;

import java100.app.domain.member.Member;


public class NoticeInfo {
    
    protected int no;
    protected String noticeTitle;
    protected String noticeDescription;
    protected int viewCount;
    protected Date noticeDate;
    protected Member member;
    
    
    public NoticeInfo() {}
    
    

    @Override
    public String toString() {
        return "NoticeInfo [no=" + no + ", noticeTitle=" + noticeTitle + ", noticeDescription=" + noticeDescription
                + ", viewCount=" + viewCount + ", noticeDate=" + noticeDate + ", member=" + member + "]";
    }

    public Member getMember() {
        return member;
    }



    public void setMember(Member member) {
        this.member = member;
    }



    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeDescription() {
        return noticeDescription;
    }

    public void setNoticeDescription(String noticeDescription) {
        this.noticeDescription = noticeDescription;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }
    
    
}
