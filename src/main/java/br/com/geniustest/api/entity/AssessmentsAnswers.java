package br.com.geniustest.api.entity;


import javax.persistence.*;

@Entity
@Table (name = "AssessmentsAnswers")
public class AssessmentsAnswers {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;
    @JoinColumn(name = "question_id")
    private Question question;
    private double grade;
    private String source_code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }
}
