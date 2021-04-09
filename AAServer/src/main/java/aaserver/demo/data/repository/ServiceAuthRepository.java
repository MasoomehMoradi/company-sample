package aaserver.demo.data.repository;



import aaserver.demo.data.entity.ServiceAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Masoumeh Moradi
 * @Email : masoom.moradi2000@gmail.com
 * @Date : 8/15/2020
 */

@Repository
public interface ServiceAuthRepository  extends JpaRepository<ServiceAuthorities, Integer> {
}
