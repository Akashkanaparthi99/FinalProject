package com.freelance.model;

import lombok.*;

import javax.persistence.*;


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
public class ContactDetails {
    @Id
    @GeneratedValue(generator = "details_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "details_generator",sequenceName = "details_sequence",initialValue = 1,allocationSize = 50)
    private Integer detailsId;
    private String email;
    private String mobileNo;
    private String state;
    private String city;

    public ContactDetails(String email, String mobileNo, String state, String city) {
        this.email = email;
        this.mobileNo = mobileNo;
        this.state = state;
        this.city = city;
    }
}
