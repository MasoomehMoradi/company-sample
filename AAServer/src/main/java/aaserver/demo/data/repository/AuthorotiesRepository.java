package aaserver.demo.data.repository;


import aaserver.demo.data.entity.Authoroties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author masoumeh moradi on 8/4/2020
 * Email: masoom.moradi2000@gmail.com
 */

@Repository
public interface AuthorotiesRepository  extends JpaRepository<Authoroties, Integer> {
}
