package com.mathsena.dscatalog.services;

import com.mathsena.dscatalog.model.Category;
import com.mathsena.dscatalog.model.dto.CategoryDTO;
import com.mathsena.dscatalog.repositories.CategoryRepository;
import com.mathsena.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> list = repository.findAll();
        List<CategoryDTO> listDto = list.stream().map(x->new CategoryDTO(x)).collect(Collectors.toList());
        return listDto;
    }


    @Transactional(readOnly = true)
    public CategoryDTO findByid(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(()->new EntityNotFoundException("Category not found"));
        return new CategoryDTO(entity);
    }
}
