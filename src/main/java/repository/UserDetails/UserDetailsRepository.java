package repository.UserDetails;

import model.UserDetails;

import java.util.List;

public interface UserDetailsRepository {
    public UserDetails save(UserDetails userDetails);

    public List<UserDetails> findAll();

    public UserDetails findById(int id);

    public void delete(int id);
}
