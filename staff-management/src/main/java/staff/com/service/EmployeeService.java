package staff.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import staff.com.entity.Employee;
import staff.com.facade.dto.EmployeeDTO;
import staff.com.repository.EmployeeRepository;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDTO getEmpById(int id){
        try{
            Employee employee = employeeRepository.findById(id).get();
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setDepartment(employee.getDepartment());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setFamily(employee.getFamily());
            employeeDTO.setName(employee.getName());
            employeeDTO.setId(employee.getId());
            return employeeDTO;
        }catch (Exception ex){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
                    //("not found" , "401" , HttpStatus.NOT_FOUND,null , null);
        }

    }


    public EmployeeDTO saveEmployee (EmployeeDTO employeeDTO){
        try{
            Employee employee = Employee.newBuilder()
                    .department(employeeDTO.getDepartment())
                    .email(employeeDTO.getEmail())
                    .family(employeeDTO.getFamily())
                    .name(employeeDTO.getName())
                    .build();
            employeeRepository.save(employee);
            return employeeDTO;
        }catch (Exception ex){
            throw new HttpClientErrorException(HttpStatus.EXPECTATION_FAILED);
        }

    }
}
