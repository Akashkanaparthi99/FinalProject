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
public class Freelance {

    @Id
    @GeneratedValue(generator = "freelancer_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "freelancer_generator",sequenceName = "freelancer_sequence",initialValue = 1,allocationSize = 50)
    private Integer freelancerId;

    private String freelancerName;
    private int noOfProjects;
    private double rating;
    /**
     * one freelancer have unique contact details
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private ContactDetails contactDetails;
    /**
     * One freelancer can have Knowledge in many category's
     *  as well as one category can be having by many freelancers
     */
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "freelancer_category",
            joinColumns = {@JoinColumn(name = "freelancer_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private Set<Category> category;
    /**
     * One freelancer can have many skills
     * as well as one skill can be having by many freelancers
     */
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "freelancer_skills",
        joinColumns = {@JoinColumn(name = "freelancer_id")},   // refers the owner entity
        inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> skills;
    /**
     *  One freelancer can do many bidding's
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "freelance_id")
    private Set<Bidding> biddings;

    public Freelance(String freelancerName, int noOfProjects, double rating, ContactDetails contactDetails, Set<Category> category, Set<Skill> skills, Set<Bidding> biddings) {
        this.freelancerName = freelancerName;
        this.noOfProjects = noOfProjects;
        this.rating = rating;
        this.contactDetails = contactDetails;
        this.category = category;

        this.skills = skills;
        this.biddings = biddings;
    }

    public Freelance(String freelancerName, int noOfProjects, double rating, ContactDetails contactDetails, Set<Category> category, Set<Skill> skills) {
        this.freelancerName = freelancerName;
        this.noOfProjects = noOfProjects;
        this.rating = rating;
        this.contactDetails = contactDetails;
        this.category = category;
        this.skills = skills;
    }
}
