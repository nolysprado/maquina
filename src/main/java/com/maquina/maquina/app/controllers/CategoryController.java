/*
 * Controlador de Category
 */
package com.maquina.maquina.app.controllers;
import com.maquina.maquina.app.entities.Category;
import com.maquina.maquina.app.entities.Client;
import com.maquina.maquina.app.services.CategoryService;
import com.maquina.maquina.app.services.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author yohan
 */

@RestController
@RequestMapping("Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    
    @Autowired
    private CategoryService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Category> getCategorys(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param category
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }
    
   /**
     * PUT
     * @param category
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return service.update(category);
    }
    
    /**
     * DELETE
     * @param categoryId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return service.deleteCategory(categoryId);
    }
    

    
}
