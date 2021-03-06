/*
 * Respositorio de Machine
 */
package com.maquina.maquina.app.repositories;
import com.maquina.maquina.app.entities.Machine;
import com.maquina.maquina.repositories.crud.MachineCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yohan
 */
@Repository
public class MachineRepository 
 {
    @Autowired
    private MachineCrudRepository machineCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
        
        }
    
    /**
     * Insert
     * @param machine
     * @return 
     */
    public Machine save(Machine machine){
        return machineCrudRepository.save(machine);
    }
    
    /**
     * Buscar registro
     * @param machineId
     * @return 
     */
    public Optional<Machine> getMachine(int machineId){
        return machineCrudRepository.findById(machineId);
    }
    
    /**
     * Delete
     * @param machine 
     */
    public void delete(Machine machine){
        machineCrudRepository.delete(machine);
    }

}
