package br.com.geniustest.api.entity;

import javax.persistence.*;



@Entity
public class AssesmentSkillMetric {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "assessment" )
    private Assessment assessment;
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @JoinColumn(name = "categories_id")
    private Categories categories;
    @Column(name = "grade")
    private double grade;
    @JoinColumn(name = "level_id")
    private Level level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Assessment getAsseessment() {
        return getAsseessment();
    }

    public void setAsseessment(Assessment asseessment) {
        this.assessment = asseessment;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Categories getCategory() {
        return categories;
    }

    public void setCategory(Categories category) {
        this.categories = category;
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
