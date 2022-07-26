package br.com.geniustest.api.entity;


import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Json roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Json getRoles() {
        return roles;
    }

    public void setRoles(Json roles) {
        this.roles = roles;
    }
}
