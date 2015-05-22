package com.springapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(fetch=FetchType.EAGER, mappedBy = "team")
    private List<Submission> submissions;


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public List<Submission> getSubmissions() {
        return this.submissions;
    }

    public Integer getSubmissionsCount(){ return submissions.size();}
}