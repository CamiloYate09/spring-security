package com.yate.springsecurity.services;


import com.yate.springsecurity.repository.UserRepository;
import com.yate.springsecurity.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.userRepository.findByUsername(username);
        if (optUser.isPresent()) {
            return new SecurityUser(optUser.get());
        }
        throw new UsernameNotFoundException("User not found" + username);
    }
}
