package com.mathsena.dscatalog.model.dto;

import com.mathsena.dscatalog.model.Category;
import com.mathsena.dscatalog.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1l;


    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Instant date;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
        this.date = product.getDate();
    }

    public ProductDTO(Product product, Set<Category> categorySet){
        this(product);
        categorySet.forEach(cat-> this.categories.add(new CategoryDTO(cat)));

    }

}
