package com.freelance.model;

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
public class Client {
    @Id
    @GeneratedValue(generator = "client_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "client_generator",sequenceName = "client_sequence",initialValue = 100,allocationSize = 100)
    private Integer clientId;
    private String clientName;
    private String email;
    /**
     * One Client have many no.of projects
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Set<Projects> projects;

    public Client(String clientName, String email, Set<Projects> projects) {
        this.clientName = clientName;
        this.email = email;
        this.projects = projects;
    }
}
