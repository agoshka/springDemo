package org.agoshka.demo.data.repo;

import org.agoshka.demo.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author go
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query("select u from User u where u.name=:name")
    User findByUserName(@Param("name") String name);

}
