package br.com.geniustest.api.entity;


import javax.persistence.*;


@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @JoinColumn(name =  "level_id")
    private Level level;
    @JoinColumn(name="categories_id")
    private Category category;
    private String answerType;
    private Integer duration;
    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Category getCategories() {
        return category;
    }

    public void setCategories(Category category) {
        this.category = category;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
