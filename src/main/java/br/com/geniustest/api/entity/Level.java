package br.com.geniustest.api.entity;


import javax.persistence.*;

@Entity
@Table (name = "level")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer questions_per_teste;
}
