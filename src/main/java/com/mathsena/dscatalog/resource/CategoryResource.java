package com.mathsena.dscatalog.resource;

import com.mathsena.dscatalog.model.Category;
import com.mathsena.dscatalog.model.dto.CategoryDTO;
import com.mathsena.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<CategoryDTO> findByid(@PathVariable("id") Long id){



        CategoryDTO dto = service.findByid(id);
        return ResponseEntity.ok().body(dto);
    }
}
