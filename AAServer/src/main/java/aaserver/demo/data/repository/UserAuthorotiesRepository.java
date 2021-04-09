package aaserver.demo.data.repository;



import aaserver.demo.data.entity.UserAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author masoumeh moradi on 8/4/2020
 * Email: masoom.moradi2000@gmail.com
 */

@Repository
public interface UserAuthorotiesRepository extends JpaRepository<UserAuthorities, Integer> {

    @Query("SELECT DISTINCT userAuthoroties FROM UserAuthorities userAuthoroties "
            +"INNER JOIN FETCH userAuthoroties.user  users "
            + "WHERE users.username = :username"
    )
    List<UserAuthorities> findUsers(@Param("username") String username);


}
