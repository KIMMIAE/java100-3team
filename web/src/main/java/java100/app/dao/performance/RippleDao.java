package java100.app.dao.performance;

import java100.app.domain.performance.Ripple;

public interface RippleDao {

    String getRipple(Ripple ripple);
    void insert(Ripple ripple);
    void update(Ripple ripple);
    void delete(Ripple ripple);
}
