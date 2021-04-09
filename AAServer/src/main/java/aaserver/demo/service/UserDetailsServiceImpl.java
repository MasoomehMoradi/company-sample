package aaserver.demo.service;



import aaserver.demo.data.entity.Authoroties;
import aaserver.demo.data.entity.CustomUser;
import aaserver.demo.data.entity.UserAuthorities;
import aaserver.demo.data.repository.UserAuthorotiesRepository;
import aaserver.demo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author masoumeh moradi on 8/4/2020
 * Email: masoom.moradi2000@gmail.com
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorotiesRepository userAuthorotiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        try{

            CustomUser user = userRepository.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException(username);
            }

            List<UserAuthorities> userAuthorities = user.getUserAuthorities();
            List<Authoroties>  authoroties = new ArrayList<>();
            for(UserAuthorities userAuthorities1 : userAuthorities){
                authoroties.add(userAuthorities1.getAuthoroties());
            }

            org.springframework.security.core.userdetails.User.UserBuilder builder = null;
            if (user != null) {
                builder = org.springframework.security.core.userdetails.User.withUsername(username);
                // builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
                builder.password(user.getPassword());
                builder.accountExpired(user.isAccountExpired());
                builder.accountLocked(user.isAccountLocked());
                builder.credentialsExpired(user.isCredentialsExpired());
                builder.disabled(! user.isEnabled());
                //builder.authorities(user.getUserAuthorities().get(0).getAuthoroties());
                builder.authorities(authoroties);

            } else {
                throw new UsernameNotFoundException("CustomUser not found.");
            }

            return builder.build();

        }catch (Exception ex){
            System.out.println(ex);
            return null;
        }

    }
}
