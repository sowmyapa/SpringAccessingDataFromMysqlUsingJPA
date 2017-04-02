package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Sowmya on 3/16/17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
    List<User> findByName(String name);
    User findByIdAndName(int id, String name);
}
