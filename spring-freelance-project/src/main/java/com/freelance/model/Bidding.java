package com.freelance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.id.IntegralDataTypeHolder;

import javax.persistence.*;
import java.time.LocalDateTime;

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
public class Bidding {
    @Id
    @GeneratedValue(generator = "bid_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "bid_generator",sequenceName = "bid_sequence",initialValue = 25,allocationSize = 25)
    @Column(name = "bid_id")
    private Integer bidId;
    private String payPerHour;
    private LocalDateTime bidDateTime;
    private String note;
    // TODO project and freelancer
    /**
     * one project can have many bidding's
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Projects projects;
    /**
     * single freelance can do multiple bidding's
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "freelance_id")
    @JsonIgnore
    private Freelance freelance;


    public Bidding(String payPerHour, String note) {
        this.payPerHour = payPerHour;
        this.note = note;
    }
}

// bid id -- 1 , 2 ,3
// freelancer id  -- 1 ,1 ,1