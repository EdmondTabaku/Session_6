package repository.User;

import model.User;

import java.util.List;

public interface UserRepository {
    public User save(User user);

    public List<User> findAll();

    public User findById(int id);

    public void delete(int id);
}
