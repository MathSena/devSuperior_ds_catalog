package com.mathsena.dscatalog.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Category implements Serializable {
    private static final long serialVersionUID = 1l;

    private Long id;
    private String name;

}
