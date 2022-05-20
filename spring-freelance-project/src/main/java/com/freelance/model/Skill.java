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

public class Skill {
    @Id
    @GeneratedValue(generator = "skill_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "skill_generator",sequenceName = "skill_sequence",initialValue = 10,allocationSize = 10)
    private Integer skillId;
    private String skillName;
    /**
     * Many Freelancers may have one skill
     */
    @ManyToMany(mappedBy = "skills",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Freelance> freelanceSet;

    public Skill(String skillName) {
        this.skillName = skillName;
    }
}
