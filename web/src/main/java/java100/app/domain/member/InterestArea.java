package java100.app.domain.member;

public class InterestArea {
    
    protected int areaNo;
    protected String areaName;
    protected String areaAll;
    protected int memberNo;
    
    public InterestArea() {}
    
    public InterestArea(String areaName) {
        this.areaName = areaName;
    }
    
    
    @Override
    public String toString() {
        return "InterestArea [areaNo=" + areaNo + ", areaName=" + areaName + ", areaAll=" + areaAll + ", memberNo="
                + memberNo + "]";
    }

    public int getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(int areaNo) {
        this.areaNo = areaNo;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaAll() {
        return areaAll;
    }

    public void setAreaAll(String areaAll) {
        this.areaAll = areaAll;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    
    
    
}










