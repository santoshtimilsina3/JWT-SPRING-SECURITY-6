package com.ons.securitylayerJwt.security;

import com.ons.securitylayerJwt.models.User;
import com.ons.securitylayerJwt.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = iUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found !"));
        return user;
    }


}
