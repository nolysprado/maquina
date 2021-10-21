/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maquina.maquina.app.services;

import com.maquina.maquina.app.entities.Machine;
import com.maquina.maquina.app.repositories.MachineRepository;
import com.maquina.maquina.repositories.crud.MachineCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yohan
 */


@Service
public class MachineService {
    
   @Autowired
    private MachineRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Machine> getAll(){
        return repository.getAll();
    }
    
    /**
     * Buscar por ID
     * @param machineId
     * @return 
     */
    public Optional<Machine> getMachine(int machineId){
        return repository.getMachine(machineId);
    }
    
    /**
     * POST
     * @param machine
     * @return 
     */
    public Machine save(Machine machine){
        if(machine.getId()==null){
            return repository.save(machine);
        }else{
            Optional<Machine> resultado = repository.getMachine(machine.getId());
            if(resultado.isPresent()){
                return machine;
            }else{
                return repository.save(machine);
            }
        }
    }
    
    /**
     * UPDATE
     * @param machine
     * @return 
     */
    public Machine update(Machine machine){
        if(machine.getId()!=null){
            Optional<Machine> resultado = repository.getMachine(machine.getId());
            if(resultado.isPresent()){
                if(machine.getName()!=null){
                    resultado.get().setName(machine.getName());
                }
                if(machine.getBrand()!=null){
                    resultado.get().setBrand(machine.getBrand());
                }
                if(machine.getYear()!=0){
                    resultado.get().setYear(machine.getYear());
                }
                if(machine.getDescription()!=null){
                    resultado.get().setDescription(machine.getDescription());
                }
                 if(machine.getCategory()!=null){
                    resultado.get().setCategory(machine.getCategory());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return machine;
            }
        }else{
            return machine;
        }
    }
    
    /**
     * DELETE
     * @param machineId
     * @return 
     */
    public boolean deleteMachine(int machineId) {
        Boolean aBoolean =  getMachine(machineId).map(machine -> {
            repository.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
