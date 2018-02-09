package java100.app.domain.sponsor;

import java.sql.Date;

public class Sponsor {
    
    protected int sponsorNo;
    protected int memberNo;
    protected int performNo;
    protected int ggcnt;
    protected String sponsDesc;
    protected Date sponsDate;
    
    public int getSponsorNo() {
        return sponsorNo;
    }
    public void setSponsorNo(int sponsorNo) {
        this.sponsorNo = sponsorNo;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public int getPerformNo() {
        return performNo;
    }
    public void setPerformNo(int performNo) {
        this.performNo = performNo;
    }
    public int getGgcnt() {
        return ggcnt;
    }
    public void setGgcnt(int ggcnt) {
        this.ggcnt = ggcnt;
    }
    public String getSponsDesc() {
        return sponsDesc;
    }
    public void setSponsDesc(String sponsDesc) {
        this.sponsDesc = sponsDesc;
    }
    public Date getSponsDate() {
        return sponsDate;
    }
    public void setSponsDate(Date sponsDate) {
        this.sponsDate = sponsDate;
    }
    
    
    
    
}










