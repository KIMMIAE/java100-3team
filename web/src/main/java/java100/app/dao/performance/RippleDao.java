package java100.app.dao.performance;

import java.util.List;

import java100.app.domain.performance.Ripple;

public interface RippleDao {

    List<Ripple> getRipple(Ripple ripple);
    void insert(Ripple ripple);
    void update(Ripple ripple);
    void delete(Ripple ripple);
}
