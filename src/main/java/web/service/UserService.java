package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import java.util.List;

@Transactional(readOnly = true)
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
}