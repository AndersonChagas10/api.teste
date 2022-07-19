package br.com.geniustest.api.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class Question {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String description;


}
