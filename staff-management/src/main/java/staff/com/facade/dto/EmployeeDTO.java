package staff.com.facade.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

@Getter
@Setter
@ToString
public class EmployeeDTO {

    private int id;

    @NotNull
    private String name;
    @NotNull
    private String family;
    private String email;
    private String department;

    public EmployeeDTO(){}
    public EmployeeDTO(int id, String name, String family, String email, String department) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.email = email;
        this.department = department;
    }
}
