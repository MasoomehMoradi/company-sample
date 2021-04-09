package staff.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import staff.com.entity.Employee;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

    Employee findByName(String name);
}
