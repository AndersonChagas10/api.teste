package br.com.geniustest.api.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alternative")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean correct;

    private Question question;

    public Alternative() {
    }

    public Alternative(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getCorrect(boolean correct) {
        return this.correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;

    }

    public Question getQuestion(Question question) {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;


    }
}
