package br.com.geniustest.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "public_assessment_test" )
public class PublicAssessmentTest {
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
