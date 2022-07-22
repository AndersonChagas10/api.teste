package br.com.geniustest.api.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String description;
    private Integer answerType;
    private Integer duration;
    private String language;
    private String expectedOutput;


   // private $category;
   // private $alternatives;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alternative_id")
    private Alternative alternative;

    private Skill skill;
    private Level level;
    private Collection alternatives;

    public Question(){

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAnswerType()
    {
        return this.answerType;
    }

    public void setAnswerType(String answerType)
    {
        this.answerType = Integer.valueOf(answerType);

    }

    public Integer getDuration()
    {
        return this.duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;


    }

    public String getLanguage()
    {
        return this.language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getExpectedOutput()
    {
        return this.expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput)
    {
        this.expectedOutput = expectedOutput;
     }

    public Skill getSkill()
    {
        return this.skill;
    }

    public void setSkill(Skill skill)
    {
        this.skill = skill;
    }

    public Level getLevel()
    {
        return this.level;
    }

    public void setLevel(Level level)
    {
        this.level = level;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(Category category)
    {
        this.category = category;

    }


    public Collection getAlternatives()
    {
        return this.alternatives;
    }

    public void addAlternative(Alternative alternative)
    {
        if (this.alternatives.contains(alternative)) {
            for (Object o : this.alternatives) {

            }

            alternative.setQuestion(this);
        }

    }

    public void removeAlternative(Alternative alternative)
    {
        if (this.alternatives.removeAll((Collection<?>) alternative)) {
            // set the owning side to null (unless already changed)
            if (alternative.getQuestion() == this) {
                alternative.setQuestion(null);
            }
        }

    }


}
