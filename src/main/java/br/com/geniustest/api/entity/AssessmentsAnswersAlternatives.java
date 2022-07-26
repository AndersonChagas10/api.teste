package br.com.geniustest.api.entity;

import javax.persistence.*;


@Entity
@Table(name = "AssessmentsAnswersAlternatives")
public class AssessmentsAnswersAlternatives {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "assessment_answer_id")
    private AssessmentsAnswers assessmentsAnswers;

    @JoinColumn(name = "alternative_id")
    private Alternative alternative;

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

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }
}
