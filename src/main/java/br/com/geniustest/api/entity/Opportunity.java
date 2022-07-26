package br.com.geniustest.api.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String uuid;


    private String description;

    private String situation;


    private String language;

    private LocalDateTime openedAt;


    private LocalDateTime closedAt;

    private LocalDateTime archivedAt;


    private Integer enabledToSend;

    private String feedbackType;
    @JoinColumn(name = "Company_id")
    private Company company;

    @JoinColumn(name = "opportunity_type_id")
    private OpportunityType opportunityType;
    @JoinColumn(name = "opportunity_skills_id")
    private OpportunitySkills opportunitySkills;

    private Integer totalCandidates;

    private Integer finishedCandidates;


    private float overallGrade;

    private String shareLink;
    @JoinColumn(name = "position")
    private Ranking ranking;
    @JoinColumn(name = "index")
    private SkillRanking skillRanking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }

    public LocalDateTime getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(LocalDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }

    public Integer getEnabledToSend() {
        return enabledToSend;
    }

    public void setEnabledToSend(Integer enabledToSend) {
        this.enabledToSend = enabledToSend;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public OpportunityType getOpportunityType() {
        return opportunityType;
    }

    public void setOpportunityType(OpportunityType opportunityType) {
        this.opportunityType = opportunityType;
    }

    public OpportunitySkills getOpportunitySkills() {
        return opportunitySkills;
    }

    public void setOpportunitySkills(OpportunitySkills opportunitySkills) {
        this.opportunitySkills = opportunitySkills;
    }

    public Integer getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Integer totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public Integer getFinishedCandidates() {
        return finishedCandidates;
    }

    public void setFinishedCandidates(Integer finishedCandidates) {
        this.finishedCandidates = finishedCandidates;
    }

    public float getOverallGrade() {
        return overallGrade;
    }

    public void setOverallGrade(float overallGrade) {
        this.overallGrade = overallGrade;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public SkillRanking getSkillRanking() {
        return skillRanking;
    }

    public void setSkillRanking(SkillRanking skillRanking) {
        this.skillRanking = skillRanking;
    }
}