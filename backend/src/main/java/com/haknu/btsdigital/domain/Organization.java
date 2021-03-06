package com.haknu.btsdigital.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "organization")
public class Organization {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ToString.Include
    @Column(unique = true,nullable = false,length = 100)
    private String name;
    private String ownerID;
    private String avatarURL;

    @OneToMany(mappedBy = "organization_id")
    private List<Event> events;
}

