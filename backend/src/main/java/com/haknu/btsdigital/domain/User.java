package com.haknu.btsdigital.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "organization_id", unique = true)
    private Organization organization;

    @ManyToMany(mappedBy = "users")
    private List<Event> events;

    private String avatarURL;
}
