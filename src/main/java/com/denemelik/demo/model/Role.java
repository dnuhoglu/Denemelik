package com.denemelik.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    /*@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ROLE_PERMISSONS", joinColumns = {
            @JoinColumn(name = "ROLE_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "PERMISSION_ID")})
    private Set<Permission> permission;*/
}
