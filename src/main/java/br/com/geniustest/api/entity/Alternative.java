package br.com.geniustest.api.entity;


import javax.persistence.*;

@Entity
@Table(name = "alternatives")
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
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

    public Question getQuestion()
    {
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;


    }
}
