package cn.edu.neu.assignment.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity to keep information of individual athletes
 */
@Entity
@NamedEntityGraphs({@NamedEntityGraph(name = "individual.findById", attributeNodes = {
        @NamedAttributeNode("teams")
})})
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 32)
    private String name;

    @Column(nullable = false)
    private boolean sex;


    private Date birthday;

    @Column(nullable = false)
    private String description;

    private String photo;

    /**
     * Mapped to individual competition list
     */
    @OneToMany(mappedBy = "individual")
    @JSONField(serialize = false)
    private Set<IndividualCompetition> individualCompetitions = new HashSet<>();

    /**
     * Mapped to delegation of this athletes
     */
    @ManyToOne()
    @JoinColumn(name = "delegation_id")
    private Delegation delegations;

    /**
     * Mapped to the team list of this athletes
     */
    @ManyToMany()
    @JSONField(serialize = false)
    private Set<Team> teams = new HashSet<>();

    public Individual() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<IndividualCompetition> getIndividualCompetitions() {
        return individualCompetitions;
    }

    public void setIndividualCompetitions(Set<IndividualCompetition> individualCompetitions) {
        this.individualCompetitions = individualCompetitions;
    }

    public Delegation getDelegations() {
        return delegations;
    }

    public void setDelegations(Delegation delegations) {
        this.delegations = delegations;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
