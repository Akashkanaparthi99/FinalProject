package com.freelance.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author - Akash
 * @date - 18-05-2022
 * @project - E-Freelance-Website
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class BidDetailsView {
    @Id
    private int bidId;
    private LocalDateTime bidDateTime;
    private String payPerHour;
    private String note;
    private String projectName;
    private String freelancerName;
    private String email;

}
