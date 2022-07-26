package br.com.geniustest.api.entity;


import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Companies {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



}
