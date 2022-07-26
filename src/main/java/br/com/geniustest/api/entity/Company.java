package br.com.geniustest.api.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "companies")
public class Company {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String slug;
    private String logoUrl;
    private String backgroundColor;
    private LocalDateTime logoUpdatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public LocalDateTime getLogoUpdatedAt() {
        return logoUpdatedAt;
    }

    public void setLogoUpdatedAt(LocalDateTime logoUpdatedAt) {
        this.logoUpdatedAt = logoUpdatedAt;
    }
}
