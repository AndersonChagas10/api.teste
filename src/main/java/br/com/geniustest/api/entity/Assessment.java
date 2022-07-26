package br.com.geniustest.api.entity;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity
@Table(name = "Assessment")
public class Assessment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "opportunity_ID")
    private Opportunity opportunity;
    private  String uuid;
    private  String situation;

    private DateTimeFormatter started_at ;

    private DateTimeFormatter finished_at ;

    private double overall_grade ;

    private DateTimeFormatter feedback_sent_at;
    private DateTimeFormatter sent_at;



    private Integer processed;
    private  Integer duration_in_seconds;


    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public DateTimeFormatter getStarted_at() {
        return started_at;
    }

    public void setStarted_at(DateTimeFormatter started_at) {
        this.started_at = started_at;
    }

    public DateTimeFormatter getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(DateTimeFormatter finished_at) {
        this.finished_at = finished_at;
    }

    public double getOverall_grade() {
        return overall_grade;
    }

    public void setOverall_grade(double overall_grade) {
        this.overall_grade = overall_grade;
    }

    public DateTimeFormatter getFeedback_sent_at() {
        return feedback_sent_at;
    }

    public void setFeedback_sent_at(DateTimeFormatter feedback_sent_at) {
        this.feedback_sent_at = feedback_sent_at;
    }

    public DateTimeFormatter getSent_at() {
        return sent_at;
    }

    public void setSent_at(DateTimeFormatter sent_at) {
        this.sent_at = sent_at;
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }

    public Integer getDuration_in_seconds() {
        return duration_in_seconds;
    }

    public void setDuration_in_seconds(Integer duration_in_seconds) {
        this.duration_in_seconds = duration_in_seconds;
    }


}