package java100.app.domain.performance;

import java.sql.Date;

public class Rating {

    protected int performanceNo;
    protected int memberNo;
    protected int score;
    protected Date regDate;
    
    @Override
    public String toString() {
        return "Rating [performanceNo=" + performanceNo + ", memberNo=" + memberNo + ", score=" + score + ", regDate="
                + regDate + "]";
    }

    public int getPerformanceNo() {
        return performanceNo;
    }

    public void setPerformanceNo(int performanceNo) {
        this.performanceNo = performanceNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
}
