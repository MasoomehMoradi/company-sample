package staff.com.integrationtest.controllertest;


import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import staff.com.StaffManagementApplication;
import staff.com.facade.dto.EmployeeDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK , classes = StaffManagementApplication.class )
//@AutoConfigureMockMvc
//@TestPropertySource( locations = "classpath:application-integrationtest.properties")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StaffManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

//    @Autowired
//    private MockMvc mvc;
  
   // @MockBean
  //  private EmployeeService service;

    //@Autowired
   // private EmployeeFacade employeeFacade;

    /*@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public EmployeeFacade employeeFacade() {
            return new EmployeeFacadeImpl() {
                // implement methods
            };
        }
    }
*/

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();



    @Test
    public void testRetrieveEmployee() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/employee/getEmployee/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{id:1,name:bob,family:tomson}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }



    @Test
    public void addEmployee() {

        EmployeeDTO employeeDTO = new EmployeeDTO(1, "bob", "tomson", "email@co.com" ,"computer");

        HttpEntity<EmployeeDTO> entity = new HttpEntity<EmployeeDTO>(employeeDTO, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/employee/saveEmployee"),
                HttpMethod.POST, entity, String.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        //String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        //assertTrue(actual.contains("/api/v1/employee/saveEmployee/"));

    }


    @Test
    public void getEmployeeByIdreetingShouldReturnMessageFromService() throws Exception {

       /* mvc.perform(get("/api/v1/employee/getEmployee/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("bob")));
*/
    }

    @Test
    public void createTestEmployee() throws Exception{

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("bob");
        employeeDTO.setFamily("tomson");
        employeeDTO.setEmail("email@co.com");
        employeeDTO.setDepartment("computer");

       /* mvc.perform(post("/api/v1/employee/saveEmployee",employeeDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content()
                  .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("bob")));
*/
    }


    @Before
    public void setUp() {
        /*Employee alex = new Employee("alex");

        Mockito.when(employeeRepository.findByName(alex.getName()))
                .thenReturn(alex);*/
    }
}
