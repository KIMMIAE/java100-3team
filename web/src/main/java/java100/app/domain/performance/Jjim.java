package java100.app.domain.performance;

import java.sql.Date;

public class Jjim {
    
    protected int performanceNo;
    protected int memberNo;
    protected String jjimFlag;
    protected Date regDate;
    
    @Override
    public String toString() {
        return "Jjim [performanceNo=" + performanceNo + ", memberNo=" + memberNo + ", jjimFlag=" + jjimFlag
                + ", regDate=" + regDate + "]";
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

    public String getJjimFlag() {
        return jjimFlag;
    }

    public void setJjimFlag(String jjimFlag) {
        this.jjimFlag = jjimFlag;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    
}
