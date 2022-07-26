package br.com.geniustest.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "candidate_id")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String email;

    public Long getId()
    {
        return this.id;
    }

    public String getFullname()
    {
        return this.fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;

    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;

    }
}
