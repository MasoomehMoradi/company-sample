package aaserver.demo.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Table(name = "kcdcusers")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usid")
    private int id;

    @Column(nullable = false, unique = true, name = "uusrname")
    private String username;

    @Column (name = "upassword")
    private String password;

    @Column(name = "uenabled")
    private boolean enabled;

    @Column(name = "uaccexpired")
    private boolean accountExpired;

    @Column(name = "uacclocked")
    private boolean accountLocked;

    @Column(name = "ucredexpired")
    private boolean credentialsExpired;

    @OneToMany(mappedBy="user")
    private List<UserAuthorities> userAuthorities = new ArrayList<>();


    public static final class CustomUserBuilder {
        private CustomUser customUser;

        private CustomUserBuilder() {
            customUser = new CustomUser();
        }

        public static CustomUserBuilder aCustomUser() {
            return new CustomUserBuilder();
        }

        public CustomUserBuilder id(int id) {
            customUser.setId(id);
            return this;
        }

        public CustomUserBuilder username(String username) {
            customUser.setUsername(username);
            return this;
        }

        public CustomUserBuilder password(String password) {
            customUser.setPassword(password);
            return this;
        }

        public CustomUserBuilder enabled(boolean enabled) {
            customUser.setEnabled(enabled);
            return this;
        }

        public CustomUserBuilder accountExpired(boolean accountExpired) {
            customUser.setAccountExpired(accountExpired);
            return this;
        }

        public CustomUserBuilder account_locked(boolean account_locked) {
            customUser.setAccountLocked(account_locked);
            return this;
        }

        public CustomUserBuilder credentialsExpired(boolean credentialsExpired) {
            customUser.setCredentialsExpired(credentialsExpired);
            return this;
        }

        public CustomUserBuilder userAuthorities(List<UserAuthorities> userAuthorities) {
            customUser.setUserAuthorities(userAuthorities);
            return this;
        }

        public CustomUser build() {
            return customUser;
        }
    }
}