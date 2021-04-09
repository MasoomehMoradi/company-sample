package aaserver.demo.data.repository;


import com.tosantechno.authorizationserver.data.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author masoumeh moradi on 8/4/2020
 * Email: masoom.moradi2000@gmail.com
 */

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Integer> {

    @Query("SELECT DISTINCT user FROM CustomUser user "
            +"INNER JOIN FETCH user.userAuthorities AS authorities "
            + "WHERE user.username = :username"
    )
    CustomUser findByUsername(@Param("username") String username);


}
