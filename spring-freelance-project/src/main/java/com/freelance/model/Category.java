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
public class Category {
    @Id
    @GeneratedValue(generator = "category_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "category_generator",sequenceName = "category_sequence",initialValue = 20,allocationSize = 10)
    private Integer categoryId;
    private String categoryType;
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Set<SubCategory> subCategories;

    public Category(String categoryType, Set<SubCategory> subCategories) {
        this.categoryType = categoryType;
        this.subCategories = subCategories;
    }
}
