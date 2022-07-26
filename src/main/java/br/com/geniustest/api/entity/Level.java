package br.com.geniustest.api.entity;


import javax.persistence.*;

@Entity
@Table (name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer questionsPerTeste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuestionsPerTeste() {
        return questionsPerTeste;
    }

    public void setQuestionsPerTeste(Integer questionsPerTeste) {
        this.questionsPerTeste = questionsPerTeste;
    }
}
