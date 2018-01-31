package java100.app.dao.member;

import java100.app.domain.member.AreaCode;

public interface AreaCodeDao {

    int findByAreaName(String areaName);
    void insert(AreaCode areaCdoe);
    void delete(String code);
}
