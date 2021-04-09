package aaserver.demo.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author masoumeh moradi on 8/4/2020
 * Email: masoom.moradi2000@gmail.com
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "kcdcusrauthortes") //kcdcusrauthorities
public class UserAuthorities {

    @Id
    @Column(name = "uaid")
    private int id;

    @Column (name = "uausrid")
    private Long userId;

    @Column(name = "uaauthid")
    private int authorityId;

    @ManyToOne
    @JoinColumn(name="uausrid", nullable=false , updatable = false , insertable = false)
    private CustomUser user;

    @ManyToOne
    @JoinColumn(name="uaauthid", nullable=false , updatable = false ,insertable = false)
    private Authoroties authoroties;


    public static final class UserAuthoritiesBuilder {
        private UserAuthorities userAuthorities;

        private UserAuthoritiesBuilder() {
            userAuthorities = new UserAuthorities();
        }

        public static UserAuthoritiesBuilder anUserAuthorities() {
            return new UserAuthoritiesBuilder();
        }

        public UserAuthoritiesBuilder id(int id) {
            userAuthorities.setId(id);
            return this;
        }

        public UserAuthoritiesBuilder userId(Long userId) {
            userAuthorities.setUserId(userId);
            return this;
        }

        public UserAuthoritiesBuilder authorityId(int authorityId) {
            userAuthorities.setAuthorityId(authorityId);
            return this;
        }

        public UserAuthoritiesBuilder user(CustomUser user) {
            userAuthorities.setUser(user);
            return this;
        }

        public UserAuthoritiesBuilder authoroties(Authoroties authoroties) {
            userAuthorities.setAuthoroties(authoroties);
            return this;
        }

        public UserAuthorities build() {
            return userAuthorities;
        }
    }
}
