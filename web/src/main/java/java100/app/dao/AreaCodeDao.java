package java100.app.dao;

import java100.app.domain.AreaCode;

public interface AreaCodeDao {

    int findByAreaName(String areaName);
    void insert(AreaCode areaCdoe);
    void delete(String code);
}
