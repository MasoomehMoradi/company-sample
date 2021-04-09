package staff.com.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import staff.com.controller.EmployeeController;
import staff.com.facade.EmployeeFacade;
import staff.com.facade.dto.EmployeeDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author masoumeh moradi on 4/8/2021
 * Email: masoom.moradi2000@gmail.com
 */


@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
public class EmployeeUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
     private EmployeeFacade employeeFacade;

    String exampleJson = "{\"name\":\"bob\",\"family\":\"tomson\",\"email\":\"mail@com\",\"department\":\"Computer\",\"id\":1 }";

    EmployeeDTO employeeDTO = new EmployeeDTO(1, "bob", "tomson", "email@co.com" ,"computer");

    @Test
    public void getEmpById() throws Exception {
       /* this.mockMvc.perform(get("/api/v1/employee/getEmployee/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("bob")));
*/
        Mockito.when( employeeFacade.getEmployee(Mockito.anyInt())).thenReturn(employeeDTO);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/employee/getEmployee/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{id:1,name:bob,family:tomson}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);


    }


    @Test
    public void createTestEmployee() throws Exception{

        //  to respond back with employeeDTO
        Mockito.when(
                employeeFacade.saveEmployee(Mockito.any(EmployeeDTO.class))).thenReturn(employeeDTO);

        // Send employee as body
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/employee/saveEmployee")
                .accept(MediaType.APPLICATION_JSON).content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

      /*  assertEquals("http://localhost/api/v1/employee/getEmployee/1",
                response.getHeader(HttpHeaders.LOCATION));*/

    }



}
