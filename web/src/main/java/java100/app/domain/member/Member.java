package java100.app.domain.member;

import java.sql.Date;
import java.util.List;

public class Member {
    
    protected int no;
    protected String photo;
    protected String email;
    protected String password;
    protected String nickName;
    protected String type;
    protected String messageFlag;
    protected String messageId;
    protected String cancelFlag;
    protected Date regDate;
    protected Artist artist;
    protected List<InterestArea> interestAreas;
    protected List<InterestGenre> interestGenres;
    
    public Member() {}
    
    public Member(int no, String nickName, String email) {
        this.no = no;
        this.nickName = nickName;
        this.email = email;
        this.artist.setNo(no);
    }

    public void setArtistNo(int no) {
        this.artist.setNo(no);
    }

    @Override
    public String toString() {
        return "Member [no=" + no + ", photo=" + photo + ", email=" + email + ", password=" + password + ", nickName="
                + nickName + ", type=" + type + ", messageFlag=" + messageFlag + ", messageId=" + messageId
                + ", cancelFlag=" + cancelFlag + ", regDate=" + regDate + ", artist=" + artist + ", interestAreas="
                + interestAreas + ", interestGenres=" + interestGenres + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessageFlag() {
        return messageFlag;
    }

    public void setMessageFlag(String messageFlag) {
        this.messageFlag = messageFlag;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<InterestArea> getInterestAreas() {
        return interestAreas;
    }

    public void setInterestAreas(List<InterestArea> interestAreas) {
        this.interestAreas = interestAreas;
    }

    public List<InterestGenre> getInterestGenres() {
        return interestGenres;
    }

    public void setInterestGenres(List<InterestGenre> interestGenres) {
        this.interestGenres = interestGenres;
    }
    
    
    
}









