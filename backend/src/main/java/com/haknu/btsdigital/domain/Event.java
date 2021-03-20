package com.haknu.btsdigital.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "event")
public class Event {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ToString.Include
    @Column(unique = true,nullable = false,length = 100)
    private String name;

    private String avatarURL;

    @Column(nullable = false)
    private Long orgID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("organization_id")
    private Organization organization;


    @ManyToMany(mappedBy = "event")
    private Set<User> users;
}
