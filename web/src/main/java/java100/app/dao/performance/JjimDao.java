package java100.app.dao.performance;

import java100.app.domain.performance.Jjim;

public interface JjimDao {

    int findByMemberNo(Jjim jjim);
    int getJjim(Jjim jjim);
    void insert(Jjim jjim);
    void update(Jjim jjim);
    void delete(Jjim jjim);
}
