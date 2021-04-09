package aaserver.demo.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author : Masoumeh Moradi
 * @Email : masoom.moradi2000@gmail.com
 * @Date : 8/15/2020
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "kcdcclintauths")
public class ClientAuthorities {

    @Id
    @Column(name = "caid")
    private int id;

    @Column (name = "caclintid")
    private String clientId;

    @Column(name = "caauthid")
    private int authorityId;

    @ManyToOne
    @JoinColumn(name="caclintid", nullable=false , updatable = false , insertable = false)
    private CustomClientDetails clientDetails;

    @ManyToOne
    @JoinColumn(name="caauthid", nullable=false , updatable = false ,insertable = false)
    private Authoroties authoroties;


    public static final class ClientAuthoritiesBuilder {
        private ClientAuthorities clientAuthorities;

        private ClientAuthoritiesBuilder() {
            clientAuthorities = new ClientAuthorities();
        }

        public static ClientAuthoritiesBuilder aClientAuthorities() {
            return new ClientAuthoritiesBuilder();
        }

        public ClientAuthoritiesBuilder id(int id) {
            clientAuthorities.setId(id);
            return this;
        }

        public ClientAuthoritiesBuilder clientId(String clientId) {
            clientAuthorities.setClientId(clientId);
            return this;
        }

        public ClientAuthoritiesBuilder authorityId(int authorityId) {
            clientAuthorities.setAuthorityId(authorityId);
            return this;
        }

        public ClientAuthoritiesBuilder clientDetails(CustomClientDetails clientDetails) {
            clientAuthorities.setClientDetails(clientDetails);
            return this;
        }

        public ClientAuthoritiesBuilder authoroties(Authoroties authoroties) {
            clientAuthorities.setAuthoroties(authoroties);
            return this;
        }

        public ClientAuthorities build() {
            return clientAuthorities;
        }
    }
}
