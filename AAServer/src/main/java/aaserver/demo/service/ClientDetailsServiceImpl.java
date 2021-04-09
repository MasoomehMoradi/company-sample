package aaserver.demo.service;


import aaserver.demo.data.entity.Authoroties;
import aaserver.demo.data.entity.ClientAuthorities;
import aaserver.demo.data.entity.CustomClientDetails;
import aaserver.demo.data.repository.CustClientDtlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author masoumeh moradi on 8/5/2020
 * Email: masoom.moradi2000@gmail.com
 */

@Service
//@Primary
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private CustClientDtlsRepository custClientDtlsRepository;


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails details = new BaseClientDetails();

        CustomClientDetails oauthClientdetails = custClientDtlsRepository.findByClientidcu(clientId);

        details.setClientId(clientId);
        details.setAuthorizedGrantTypes(Arrays.asList(oauthClientdetails.getAuthGrantType().split(",")));//(Arrays.asList(oauthClientdetails.getAuthGrant_type()));
        details.setScope(Arrays.asList(oauthClientdetails.getScope().split(",")));
        details.setRegisteredRedirectUri(Collections.singleton(oauthClientdetails.getRedirectUrl()));
       // details.setResourceIds(Arrays.asList(oauthClientdetails.getResource_ids().split(",")));
        details.setClientSecret(oauthClientdetails.getClient_secret());
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        List<ClientAuthorities> clientAuthoritiesList = oauthClientdetails.getClientAuthorities();
        if (clientAuthoritiesList != null && clientAuthoritiesList.size()>0){
            for (ClientAuthorities clientAuthorities : clientAuthoritiesList){
                Authoroties authoroties = clientAuthorities.getAuthoroties();
                authorities.add(new SimpleGrantedAuthority(authoroties.getName()));
            }

        }

        //authorities.add(new SimpleGrantedAuthority(oauthClientdetails.getAuthorities()));

        details.setAuthorities(authorities);
        details.setAccessTokenValiditySeconds(oauthClientdetails.getAccessTokenValidity());
        details.setRefreshTokenValiditySeconds(oauthClientdetails.getRefreshTokenValidity());

        return details;


    }
}



 /* public ClientDetailsService clientDetailsService() {
        return new ClientDetailsService() {
            @Override
            public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
                BaseClientDetails details = new BaseClientDetails();

                Oauth_client_details oauthClientdetails = oauthClientDetailsRepository.findByClientid(clientId).get(0);

                details.setClientId(clientId);
                details.setAuthorizedGrantTypes(Arrays.asList(oauthClientdetails.getAuthGrant_type()) );
                details.setScope(Arrays.asList(oauthClientdetails.getScope()));
                details.setRegisteredRedirectUri(Collections.singleton(oauthClientdetails.getRedirect_url()));
                details.setResourceIds(Arrays.asList(oauthClientdetails.getResource_ids()));
                Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority(oauthClientdetails.getAuthorities()));
                details.setAuthorities(authorities);
                return details;
            }
        };
    }*/