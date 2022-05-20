package com.freelance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * @author - Akash
 * @Date - 16-05-2022
 */
public class Projects {
    @Id
    @GeneratedValue(generator = "project_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "project_generator",sequenceName = "project_sequence",initialValue = 50,allocationSize = 1)
    @ToString.Exclude
    private Integer projectId;
    private String projectName;
    private double budget;
    private String duration;
    private String projectCategory;
    private String details;
    /**
     * One projects have many no.of bidding's
     */
    @OneToMany(mappedBy = "projects",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Bidding> bid;

    public Projects(String projectName, double budget, String duration, String projectCategory, String details, Set<Bidding> bid) {
        this.projectName = projectName;
        this.budget = budget;
        this.duration = duration;
        this.projectCategory = projectCategory;
        this.details = details;
        this.bid = bid;
    }

    public Projects(String projectName, double budget, String duration, String projectCategory, String details) {
        this.projectName = projectName;
        this.budget = budget;
        this.duration = duration;
        this.projectCategory = projectCategory;
        this.details = details;
    }
}
