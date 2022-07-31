package br.com.geniustest.api.entity;


import javax.persistence.*;

@Entity
@Table (name = "assessment_answer_metrics")
public class AssessmentAnswerMetric {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "assessments_answers_id")
    private AssessmentsAnswers assessmentsAnswers;
    private String metric;
    private String grade;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
