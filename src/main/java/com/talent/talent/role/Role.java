package com.talent.talent.role;

import com.talent.talent.company.Company;
import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
@Entity
@Table
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Status status;
    private String location;
    private LocalDate post_date;
    private LocalDate update_date;

    @ManyToOne
    @JoinColumn(name = "companyId", insertable = false, updatable = false)
    private Company company;

    @Column (name = "companyId")
    private Long companyId;

    public Role(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.post_date = LocalDate.now();
        this.status = Status.ACTIVE;
    }

    public Role() {
        this.post_date = LocalDate.now();
        this.status = Status.ACTIVE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String position) {
        this.location = position;
    }

    public LocalDate getPost_date() {
        return post_date;
    }

    public void setPost_date(LocalDate post_date) {
        this.post_date = post_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDate update_date) {
        this.update_date = update_date;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}

enum Status {
    ACTIVE, INACTIVE
}
