package java100.app.domain.performance;

public class PerformanceFile {
    int no;
    String filename;
    int performanceNo;
    
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
        return "PerformanceFile [no=" + no + ", filename=" + filename + ", performanceNo=" + performanceNo + "]";
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
    
    

}
