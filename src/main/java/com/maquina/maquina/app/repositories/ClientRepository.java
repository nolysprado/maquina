/*
 * Respositorio de Client
 */
package com.maquina.maquina.app.repositories;


import com.maquina.maquina.app.entities.Client;
import com.maquina.maquina.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yohan
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
   
}
    
    /**
     * Insert
     * @param client
     * @return 
     */
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    
    /**
     * Buscar registro
     * @param clientId
     * @return 
     */
    public Optional<Client> getClient(int clientId){
        return clientCrudRepository.findById(clientId);
    }

    
    /**
     * Delete
     * @param client 
     */
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }

}
