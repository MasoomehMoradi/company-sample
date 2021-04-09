package staff.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import staff.com.facade.EmployeeFacade;
import staff.com.facade.dto.EmployeeDTO;

import javax.validation.Valid;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {


    @Autowired
    EmployeeFacade employeeFacade;

    @GetMapping(value = "/getEmployee/{id}" )
    public ResponseEntity<EmployeeDTO>  getEmployee(@PathVariable  int id){

        return new ResponseEntity<>(
                employeeFacade.getEmployee(id), HttpStatus.OK
        );
    }

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<EmployeeDTO> saveEmployee (@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(
                employeeFacade.saveEmployee(employeeDTO), HttpStatus.CREATED
        );
    }


    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
