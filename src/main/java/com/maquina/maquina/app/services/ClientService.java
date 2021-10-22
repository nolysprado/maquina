/*
// * Servicio de Client
 */
package com.maquina.maquina.app.services;


import com.maquina.maquina.app.entities.Client;
import com.maquina.maquina.app.repositories.ClientRepository;
import com.maquina.maquina.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yohan
 */
@Service
public class ClientService {
    
     @Autowired
    private ClientRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Client> getAll(){
        return repository.getAll();
    }
    
    /**
     * Buscar por ID
     * @param clientId
     * @return 
     */
    public Optional<Client> getClient(int clientId){
        return repository.getClient(clientId);
    }
    
    /**
     * POST
     * @param client
     * @return 
     */
    public Client save(Client client){
        if(client.getIdClient()==null){
            return repository.save(client);
        }else{
            Optional<Client> resultado = repository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                return client;
            }else{
                return repository.save(client);
            }
        }
    }
    
    /**
     * UPDATE
     * @param client
     * @return 
     */
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> resultado = repository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                if(client.getName()!=null){
                    resultado.get().setName(client.getName());
                }
                if(client.getAge()!=0){
                    resultado.get().setAge(client.getAge());
                }
                if(client.getEmail()!=null){
                    resultado.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    resultado.get().setPassword(client.getPassword());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    /**
     * DELETE
     * @param clientId
     * @return 
     */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
