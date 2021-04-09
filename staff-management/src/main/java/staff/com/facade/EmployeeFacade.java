package staff.com.facade;

import staff.com.facade.dto.EmployeeDTO;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

public interface EmployeeFacade {

    EmployeeDTO getEmployee(int id);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
}
