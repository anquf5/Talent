package com.talent.talent.company;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.talent.talent.role.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private long id;
    private String name;
    private String intro;
    private String link;
    private LocalDate createDate;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    @JoinColumn(name = "companyId")
    private List<Role> roles;

    @Transient
    private LocalDate duration;

    public Company() {
    }

    public Company(long id, String name, String intro, String link) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.link = link;
        this.createDate = LocalDate.now();
    }

    public Company(String name, String intro, String link) {
        this.name = name;
        this.intro = intro;
        this.link = link;
        this.createDate = LocalDate.now();
    }

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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getDuration() {
        return Period.between(this.createDate, LocalDate.now()).getDays();
    }

    public void setDuration(LocalDate duration) {
        this.duration = duration;
    }



    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
