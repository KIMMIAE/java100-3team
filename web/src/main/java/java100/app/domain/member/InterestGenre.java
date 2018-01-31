package java100.app.domain.member;

public class InterestGenre {
    
    protected int genreNo;
    protected String genreName;
    protected String genreAll;
    protected int memberNo;
    
    public InterestGenre() {}
    
    public InterestGenre(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "InterestGenre [genreNo=" + genreNo + ", genreName=" + genreName + ", genreAll=" + genreAll
                + ", memberNo=" + memberNo + "]";
    }

    public int getGenreNo() {
        return genreNo;
    }

    public void setGenreNo(int genreNo) {
        this.genreNo = genreNo;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreAll() {
        return genreAll;
    }

    public void setGenreAll(String genreAll) {
        this.genreAll = genreAll;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    
    
}










