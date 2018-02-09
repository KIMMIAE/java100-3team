package java100.app.domain.performance;

import java.sql.Date;

public class Ripple {

    protected int no;
    protected int performanceNo;
    protected int memberNo;
    protected String ripple;
    protected Date regDate;
    
    @Override
    public String toString() {
        return "Ripple [no=" + no + ", performanceNo=" + performanceNo + ", memberNo=" + memberNo + ", ripple=" + ripple
                + ", regDate=" + regDate + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public String getRipple() {
        return ripple;
    }

    public void setRipple(String ripple) {
        this.ripple = ripple;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
}
