package br.com.geniustest.api.entity;


import javax.persistence.*;

@Entity
@Table(name = "AssessmentsAnswersMetrics")
public class AssessmentsAnswersMetrics {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "assessment_answer_id")
    private AssessmentsAnswers assessmentsAnswers;
    private String metric;
    private double grade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AssessmentsAnswers getAssessmentsAnswers() {
        return assessmentsAnswers;
    }

    public void setAssessmentsAnswers(AssessmentsAnswers assessmentsAnswers) {
        this.assessmentsAnswers = assessmentsAnswers;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
