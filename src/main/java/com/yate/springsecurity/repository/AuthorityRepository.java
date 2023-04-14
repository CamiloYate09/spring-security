package com.yate.springsecurity.repository;


import com.yate.springsecurity.model.Authority;
import com.yate.springsecurity.util.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
   Optional<Authority>   findByName(AuthorityName name);
}
