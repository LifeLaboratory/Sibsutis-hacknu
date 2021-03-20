package com.haknu.btsdigital.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ToString.Include
    @Column(unique = true,nullable = false,length = 100)
    private String username;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    private Long organization;

    private String avatarURL;
}
