package java100.app.domain.performance;

import java.util.Date;
import java.util.List;

import java100.app.domain.member.Artist;
import java100.app.domain.member.Member;

public class Performance {
    
    protected int no;
    protected String name;
    protected String genre;
    protected Date entryDate;
    protected String location;
    protected String mapLatitude;
    protected String mapLongitude;
    protected String detailDesc;
    protected String specialDesc;
    protected int viewCount;
    protected Member writer;
    protected Artist artist;
    protected List<PerformanceFile> medias;
    protected String deleteTag;
    protected Date regDate;
    
    @Override
    public String toString() {
        return "Performance [no=" + no + ", name=" + name + ", genre=" + genre + ", entryDate=" + entryDate
                + ", location=" + location + ", mapLatitude=" + mapLatitude + ", mapLongitude=" + mapLongitude
                + ", detailDesc=" + detailDesc + ", specialDesc=" + specialDesc + ", viewCount=" + viewCount
                + ", writer=" + writer + ", artist=" + artist + ", medias=" + medias + ", deleteTag=" + deleteTag
                + ", regDate=" + regDate + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMapLatitude() {
        return mapLatitude;
    }

    public void setMapLatitude(String mapLatitude) {
        this.mapLatitude = mapLatitude;
    }

    public String getMapLongitude() {
        return mapLongitude;
    }

    public void setMapLongitude(String mapLongitude) {
        this.mapLongitude = mapLongitude;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getSpecialDesc() {
        return specialDesc;
    }

    public void setSpecialDesc(String specialDesc) {
        this.specialDesc = specialDesc;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Member getWriter() {
        return writer;
    }

    public void setWriter(Member writer) {
        this.writer = writer;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<PerformanceFile> getMedias() {
        return medias;
    }

    public void setMedias(List<PerformanceFile> medias) {
        this.medias = medias;
    }

    public String getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(String deleteTag) {
        this.deleteTag = deleteTag;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
    

}
