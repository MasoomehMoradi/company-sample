package aaserver.demo.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author masoumeh moradi on 8/4/2020
 * Email: masoom.moradi2000@gmail.com
 */


@Getter
@Setter
@ToString
@Entity
@Table(name = "kcdcauthortes")  //kcdcauthorities
public class Authoroties implements GrantedAuthority {

    @Column(name = "auid")
    @Id
    private int id;

    @Column(name = "auname")
    private String name;

    @Column(name = "audesc")
    private String description;

    // @OneToMany(mappedBy="authoroties")
    // private Set<UserAuthorities> userAuthoroties;
    @OneToMany(mappedBy = "authoroties")
    private List<UserAuthorities> userAuthoroties = new ArrayList<>();


    @OneToMany(mappedBy = "authoroties")
    private List<ClientAuthorities> clientAuthorities = new ArrayList<>();

    @Override
    public String getAuthority() {
        return this.name;
    }


    public static final class AuthorotiesBuilder {
        private Authoroties authoroties;

        private AuthorotiesBuilder() {
            authoroties = new Authoroties();
        }

        public static AuthorotiesBuilder anAuthoroties() {
            return new AuthorotiesBuilder();
        }

        public AuthorotiesBuilder id(int id) {
            authoroties.setId(id);
            return this;
        }

        public AuthorotiesBuilder name(String name) {
            authoroties.setName(name);
            return this;
        }

        public AuthorotiesBuilder description(String description) {
            authoroties.setDescription(description);
            return this;
        }

        public AuthorotiesBuilder userAuthoroties(List<UserAuthorities> userAuthoroties) {
            authoroties.setUserAuthoroties(userAuthoroties);
            return this;
        }

        public AuthorotiesBuilder clientAuthorities(List<ClientAuthorities> clientAuthorities) {
            authoroties.setClientAuthorities(clientAuthorities);
            return this;
        }

        public Authoroties build() {
            return authoroties;
        }
    }
}
