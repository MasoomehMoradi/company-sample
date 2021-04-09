package aaserver.demo.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Masoumeh Moradi
 * @Email : masoom.moradi2000@gmail.com
 * @Date : 8/15/2020
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "kcdcclintdtails") //kcdcouthclientdetails
public class CustomClientDetails {


    @Id
    @Column(name = "cdclientid")
    private String clientId;

    @Column(name = "cdclientsecrt")
    private String client_secret;

    @Column(name = "cdscop")
    private String scope;


    @Column(name = "cdresourcids")
    private String resourceIds;


    @Column(name = "cdgranttyp")
    private String authGrantType;


    @Column(name = "cdredirecturl")
    private String redirectUrl;


   /* @Column(name = "cdauthids")
    private String authIds;*/


    @Column(name = "cdacctokenvalidity")
    private int accessTokenValidity;


    @Column(name = "cdrefrshtoknvalidity")
    private int refreshTokenValidity;


    @Column(name = "cdaddinfo")
    private String additionalInf;


    @Column(name = "cdautoapprov")
    private String autoapprove;


    @OneToMany(mappedBy="clientDetails")
    private List<ClientAuthorities> clientAuthorities = new ArrayList<>();


    public static final class CustomClientDetailsBuilder {
        private CustomClientDetails customClientDetails;

        private CustomClientDetailsBuilder() {
            customClientDetails = new CustomClientDetails();
        }

        public static CustomClientDetailsBuilder aCustomClientDetails() {
            return new CustomClientDetailsBuilder();
        }

        public CustomClientDetailsBuilder clientid(String clientid) {
            customClientDetails.setClientId(clientid);
            return this;
        }

        public CustomClientDetailsBuilder client_secret(String client_secret) {
            customClientDetails.setClient_secret(client_secret);
            return this;
        }

        public CustomClientDetailsBuilder scope(String scope) {
            customClientDetails.setScope(scope);
            return this;
        }

        public CustomClientDetailsBuilder resourceIds(String resourceIds) {
            customClientDetails.setResourceIds(resourceIds);
            return this;
        }

        public CustomClientDetailsBuilder authGrantType(String authGrantType) {
            customClientDetails.setAuthGrantType(authGrantType);
            return this;
        }

        public CustomClientDetailsBuilder redirectUrl(String redirectUrl) {
            customClientDetails.setRedirectUrl(redirectUrl);
            return this;
        }

        public CustomClientDetailsBuilder accessTokenValidity(int accessTokenValidity) {
            customClientDetails.setAccessTokenValidity(accessTokenValidity);
            return this;
        }

        public CustomClientDetailsBuilder refreshTokenValidity(int refreshTokenValidity) {
            customClientDetails.setRefreshTokenValidity(refreshTokenValidity);
            return this;
        }

        public CustomClientDetailsBuilder additionalInf(String additionalInf) {
            customClientDetails.setAdditionalInf(additionalInf);
            return this;
        }

        public CustomClientDetailsBuilder autoapprove(String autoapprove) {
            customClientDetails.setAutoapprove(autoapprove);
            return this;
        }

        public CustomClientDetailsBuilder clientDetails(List<ClientAuthorities> clientDetails) {
            customClientDetails.setClientAuthorities(clientDetails);
            return this;
        }

        public CustomClientDetails build() {
            return customClientDetails;
        }
    }
}
