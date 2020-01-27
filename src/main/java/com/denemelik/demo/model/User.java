package com.denemelik.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String email;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;
    @Column
    private String phoneNumber;
    @Column
    private int age;
    @Column
    private GnlEnumDef.BloodType bloodType;
    @Column
    private boolean isNotified;
    @Column
    private GnlEnumDef.Distance distance;
}
