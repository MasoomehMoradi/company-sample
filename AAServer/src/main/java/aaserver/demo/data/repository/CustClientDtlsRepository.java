package aaserver.demo.data.repository;


import aaserver.demo.data.entity.CustomClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author : Masoumeh Moradi
 * @Email : masoom.moradi2000@gmail.com
 * @Date : 8/15/2020
 */
@Repository
public interface CustClientDtlsRepository extends JpaRepository<CustomClientDetails, String> {


    @Query("SELECT DISTINCT clientDtl FROM CustomClientDetails clientDtl "
            +"INNER JOIN FETCH clientDtl.clientAuthorities AS authorities "
            + "WHERE clientDtl.clientId = :clientId"
    )
    CustomClientDetails findByClientidcu(@Param("clientId") String clientId);




}
