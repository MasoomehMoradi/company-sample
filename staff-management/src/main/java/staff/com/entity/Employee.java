package staff.com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author masoumeh moradi on 4/7/2021
 * Email: masoom.moradi2000@gmail.com
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "tblEmployee")
public class Employee {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String family;

    @Column
    private String email;

    @Column
    private String department;

    private Employee(Builder builder) {
        id = builder.id;
        name = builder.name;
        family = builder.family;
        email = builder.email;
        department = builder.department;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int id;
        private String name;
        private String family;
        private String email;
        private String department;

        private Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder family(String family) {
            this.family = family;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
