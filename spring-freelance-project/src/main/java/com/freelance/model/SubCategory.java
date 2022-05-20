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
public class SubCategory {
  @Id
  @GeneratedValue(generator = "subcategory_generator",strategy = GenerationType.AUTO)
  @SequenceGenerator(name = "subcategory_generator",sequenceName = "subcategory_sequence",initialValue = 5,allocationSize = 5)
  @Column(name = "subcategory_id")
  private Integer subCategoryId;
  private String subCategoryName;

  public SubCategory(String subCategoryName) {
      this.subCategoryName = subCategoryName;
  }
 }
