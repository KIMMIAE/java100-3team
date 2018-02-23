package java100.app.domain.performance;

import java.sql.Date;
import java.util.List;

import java100.app.domain.member.Member;

public class PerformanceReview {
	
	protected int reviewNo;
	protected Performance performance;
	protected Member writer;
	protected String reviewDescription;
	protected int viewCount;
	protected Date regDate;
	protected List<ReviewFile> reviewFiles;
	
	
	
	@Override
	public String toString() {
		return "PerformanceReview [reviewNo=" + reviewNo + ", performance=" + performance + ", writer=" + writer
				+ ", reviewDescription=" + reviewDescription + ", viewCount=" + viewCount + ", regDate=" + regDate
				+ ", reviewFiles=" + reviewFiles + "]";
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public Performance getPerformance() {
		return performance;
	}
	public void setPerformance(Performance performance) {
		this.performance = performance;
	}
	public Member getWriter() {
		return writer;
	}
	public void setWriter(Member writer) {
		this.writer = writer;
	}
	public String getReviewDescription() {
		return reviewDescription;
	}
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public List<ReviewFile> getReviewFiles() {
		return reviewFiles;
	}
	public void setReviewFiles(List<ReviewFile> reviewFiles) {
		this.reviewFiles = reviewFiles;
	}
	
	
	
	
	


}
