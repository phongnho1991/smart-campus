package net.zdsoft.smartcampus.user.dao;

import net.zdsoft.smartcampus.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author shenke
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "from User where username=?1 and deleted=0")
    Optional<User> getUserByUsername(String username);
}
