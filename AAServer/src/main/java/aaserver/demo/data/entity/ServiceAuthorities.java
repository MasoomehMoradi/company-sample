package aaserver.demo.data.entity;

/**
 * @author : Masoumeh Moradi
 * @Email : masoom.moradi2000@gmail.com
 * @Date : 8/15/2020
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "kcdcservicauth")
public class ServiceAuthorities {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "said")
    private int id;

    @Column(nullable = false, unique = true, name = "saname")
    private String serviceName;

    @Column (name = "saauthid")
    private int authId;

    @Column(name = "saurl")
    private String url;

    @Column(name = "sarsurcid")
    private String resourceId;

    @Column(name = "sadesc")
    private String serviceDesc;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "saauthid", referencedColumnName = "auid", insertable = false, updatable = false)
    })
    private Authoroties authoroties;


    public static final class ServiceAuthoritiesBuilder {
        private ServiceAuthorities serviceAuthorities;

        private ServiceAuthoritiesBuilder() {
            serviceAuthorities = new ServiceAuthorities();
        }

        public static ServiceAuthoritiesBuilder aServiceAuthorities() {
            return new ServiceAuthoritiesBuilder();
        }

        public ServiceAuthoritiesBuilder id(int id) {
            serviceAuthorities.setId(id);
            return this;
        }

        public ServiceAuthoritiesBuilder serviceName(String serviceName) {
            serviceAuthorities.setServiceName(serviceName);
            return this;
        }

        public ServiceAuthoritiesBuilder authId(int authId) {
            serviceAuthorities.setAuthId(authId);
            return this;
        }

        public ServiceAuthoritiesBuilder url(String url) {
            serviceAuthorities.setUrl(url);
            return this;
        }

        public ServiceAuthoritiesBuilder resourceId(String resourceId) {
            serviceAuthorities.setResourceId(resourceId);
            return this;
        }

        public ServiceAuthoritiesBuilder serviceDesc(String serviceDesc) {
            serviceAuthorities.setServiceDesc(serviceDesc);
            return this;
        }

        public ServiceAuthoritiesBuilder authoroties(Authoroties authoroties) {
            serviceAuthorities.setAuthoroties(authoroties);
            return this;
        }

        public ServiceAuthorities build() {
            return serviceAuthorities;
        }
    }
}
