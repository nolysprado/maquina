/*
 * Controlador de Machine
 */
package com.maquina.maquina.app.controllers;

import com.maquina.maquina.app.entities.Machine;
import com.maquina.maquina.app.services.MachineService;
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
@RequestMapping("Machine")
@CrossOrigin(origins = "*")
public class MachineController {
    
    @Autowired
    private MachineService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Machine> getMachines(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param machine
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine) {
        return service.save(machine);
    }
    
    /**
     * PUT
     * @param machine
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine) {
        return service.update(machine);
    }
    
    /**
     * DELETE
     * @param machineId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return service.deleteMachine(machineId);
    }
    
}

