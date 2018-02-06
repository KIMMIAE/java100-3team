package java100.app.domain.performance;

public class ReviewFile {
    int reviewFileNo;
    String reviewFilename;
    int reviewNo;
    
    public ReviewFile() {}
    
    public ReviewFile(String reviewFilename) {
    	this(0, reviewFilename);
    }
    
    public ReviewFile(int reviewFileNo, String reviewFilename) {
    	this.reviewFileNo = reviewFileNo;
    	this.reviewFilename = reviewFilename;
    }

	public int getReviewFileNo() {
		return reviewFileNo;
	}

	public void setReviewFileNo(int reviewFileNo) {
		this.reviewFileNo = reviewFileNo;
	}

	public String getReviewFilename() {
		return reviewFilename;
	}

	public void setReviewFilename(String reviewFilename) {
		this.reviewFilename = reviewFilename;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
    
    

    
    
    
    
}
