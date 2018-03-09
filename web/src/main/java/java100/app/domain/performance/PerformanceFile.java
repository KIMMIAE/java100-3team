package java100.app.domain.performance;

import java.util.Date;

public class PerformanceFile {
    protected int no;
    protected String filename;
    protected int performanceNo;
    protected Date regDate;
    
    public PerformanceFile() {}
    
    public PerformanceFile(String filename) {
        this(0, filename);
    }

    public PerformanceFile(int no, String filename) {
        this.no = no;
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "PerformanceFile [no=" + no + ", filename=" + filename + ", performanceNo=" + performanceNo
                + ", regDate=" + regDate + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getPerformanceNo() {
        return performanceNo;
    }

    public void setPerformanceNo(int performanceNo) {
        this.performanceNo = performanceNo;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
    

}
