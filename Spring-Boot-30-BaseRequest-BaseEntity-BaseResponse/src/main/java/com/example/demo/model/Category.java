package com.example.demo.model;

import com.example.demo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Category extends BaseEntity {

    @Id
    @SequenceGenerator(name = "sq_category_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_category_id")
    @Column(name = "category_id")
    private Long categoryId;

    // 1000 1001  1002
    private Integer categoryCode;

    // Kadın giyim, Erkek giyim
    private String categoryName;

    // 1000 - Kadın Giyim, 1001 - Erkek Giyim  1002 - Bilgisayar
    private String categoryCodeName;

    // 1000
    private Long parentCategoryId;


}
