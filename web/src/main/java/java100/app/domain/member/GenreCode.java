package java100.app.domain.member;

public class GenreCode {

    protected int no;
    protected String genreCode;
    protected String genreName;
    
    @Override
    public String toString() {
        return "GenreCode [no=" + no + ", genreCode=" + genreCode + ", genreName=" + genreName + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(String genreCode) {
        this.genreCode = genreCode;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    

}










