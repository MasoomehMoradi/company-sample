package staff.com.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import staff.com.facade.dto.EmployeeDTO;
import staff.com.service.EmployeeService;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {

    @Autowired
    EmployeeService employeeService;

    @Override
    public EmployeeDTO getEmployee(int id) {
        return employeeService.getEmpById(id);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }
}
