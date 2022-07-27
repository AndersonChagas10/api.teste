package br.com.geniustest.api.entity;



import javax.persistence.*;

@Entity
@Table(name = "AssessmentsSkillsMetrics")
public class AssessmentsSkillsMetrics {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @JoinColumn(name = "categories_id")
    private Category category;
    private double grade;
    @JoinColumn(name = "level_id")
    private Level level;

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
