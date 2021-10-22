/*
 * Respositorio de Message
 */
package com.maquina.maquina.app.repositories;


import com.maquina.maquina.app.entities.Message;
import com.maquina.maquina.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yohan
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();

    }
    
      
    /**
     * Insert
     * @param message
     * @return 
     */
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    
    /**
     * Buscar registro
     * @param messageId
     * @return 
     */
    public Optional<Message> getMessage(int messageId){
        return messageCrudRepository.findById(messageId);
    }
    
    /**
     * Delete
     * @param message 
     */
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
    
    

}
