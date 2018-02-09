package java100.app.domain.performance;

public class ReviewFile {
    int no;
    String filename;
    int reviewNo;
    
    public ReviewFile() {}
    
    public ReviewFile(String filename) {
    	this(0, filename);
    }
    
    public ReviewFile(int no, String filename) {
    	this.no = no;
    	this.filename = filename;
    }
    
	@Override
	public String toString() {
		return "ReviewFile [no=" + no + ", filename=" + filename + ", reviewNo=" + reviewNo + "]";
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
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
    
    
    
    
    
}
