/*
 * Controlador de Admin
 */
package com.maquina.maquina.app.controllers;

import com.maquina.maquina.app.entities.Admin;
import com.maquina.maquina.app.entities.Client;
import com.maquina.maquina.app.services.AdminService;
import com.maquina.maquina.app.services.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("Admin")
@CrossOrigin(origins = "*")
public class AdminController {
    
    
     @Autowired
    private AdminService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param admin
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return service.save(admin);
    }
    
    /**
     * PUT
     * @param admin
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return service.update(admin);
    }
    
    /**
     * DELETE
     * @param adminId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminId) {
        return service.deleteAdmin(adminId);
    }
    
    
}
