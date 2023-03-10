package com.mathsena.dscatalog.services;

import com.mathsena.dscatalog.model.Category;
import com.mathsena.dscatalog.model.dto.CategoryDTO;
import com.mathsena.dscatalog.repositories.CategoryRepository;
import com.mathsena.dscatalog.services.exceptions.DataBaseException;
import com.mathsena.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest){
        Page<Category> list = repository.findAll(pageRequest);
        return list.map(x->new CategoryDTO(x));

    }


    @Transactional(readOnly = true)
    public CategoryDTO findByid(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(()->new EntityNotFoundException("Category not found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {

        try{
            Category entity = repository.getOne(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);

        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("id not found" + id);

        }

    }

    public void delete(Long id) {
        try{
            repository.deleteById(id);

        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("id not found for deletion " + id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("You can't delete this id because this id have a Integrity violation" + id);
        }

    }


}
