package br.com.geniustest.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "public_opportunity")
public class PublicOpportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
