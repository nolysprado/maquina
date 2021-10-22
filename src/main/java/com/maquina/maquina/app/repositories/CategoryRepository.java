/*
 * Respositorio de Categoory
 */
package com.maquina.maquina.app.repositories;

import com.maquina.maquina.app.entities.Category;
import com.maquina.maquina.repositories.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yohan
 */
@Repository
public class CategoryRepository  {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();

    } 
    
     /**
     * Insert
     * @param category
     * @return 
     */
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
    
    /**
     * Buscar registro
     * @param categoryId
     * @return 
     */
    public Optional<Category> getCategory(int categoryId){
        return categoryCrudRepository.findById(categoryId);
    }

    
    /**
     * Delete
     * @param category 
     */
    public void delete(Category category){
       categoryCrudRepository.delete(category);
    }
}
