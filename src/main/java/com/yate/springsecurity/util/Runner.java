package com.yate.springsecurity.util;

import com.yate.springsecurity.model.Authority;
import com.yate.springsecurity.model.User;
import com.yate.springsecurity.repository.AuthorityRepository;
import com.yate.springsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;


    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        if (this.authorityRepository.count() == 0) {

            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE),
                    new Authority(AuthorityName.ADMIN)
            ));
        }

        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(List.of(
                    new User("jesus", "1234", List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("jose", "1234", List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                    new User("admin", new BCryptPasswordEncoder().encode("1234"), List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get())
                    )));
        }
    }
}
