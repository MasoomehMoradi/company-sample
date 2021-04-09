package staff.com.integrationtest.persitenceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import staff.com.entity.Employee;
import staff.com.repository.EmployeeRepository;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author masoumeh moradi on 4/8/2021
 * Email: masoom.moradi2000@gmail.com
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = Employee.newBuilder()
                //.id(1)
                .name("alex")
                .family("tomson")
                .email("@mail.com")
                .department("computer")
                .build();
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(alex.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());
    }
}
