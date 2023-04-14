package com.yate.springsecurity.model;


import com.yate.springsecurity.util.AuthorityName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "authorities")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {


    public Authority(AuthorityName name) {
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;


}
