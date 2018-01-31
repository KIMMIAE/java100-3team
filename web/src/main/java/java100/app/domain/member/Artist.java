package java100.app.domain.member;

import java.sql.Date;

public class Artist {
    
    protected int no;
    protected String artistName;
    protected String artistMember;
    protected String profile;
    protected Date joinDate;
    
    @Override
    public String toString() {
        return "Artist [no=" + no + ", artistName=" + artistName + ", artistMember=" + artistMember + ", profile="
                + profile + ", joinDate=" + joinDate + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistMember() {
        return artistMember;
    }

    public void setArtistMember(String artistMember) {
        this.artistMember = artistMember;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

}
