/*
 *  Servicio de Message
 */
package com.maquina.maquina.app.services;


import com.maquina.maquina.app.entities.Message;
import com.maquina.maquina.app.repositories.MessageRepository;
import com.maquina.maquina.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yohan
 */
@Service
public class MessageService {
    
   @Autowired
    private MessageRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Message> getAll(){
        return repository.getAll();
    }
    
    /**
     * Buscar por ID
     * @param messageId
     * @return 
     */
    public Optional<Message> getMessage(int messageId){
        return repository.getMessage(messageId);
    }
    
    /**
     * POST
     * @param message
     * @return 
     */
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return repository.save(message);
        }else{
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                return message;
            }else{
                return repository.save(message);
            }
        }
    }
    
    /**
     * UPDATE
     * @param message
     * @return 
     */
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                if(message.getMessageText()!=null){
                    resultado.get().setMessageText(message.getMessageText());
                }
                if(message.getMachine()!=null){
                    resultado.get().setMachine(message.getMachine());
                }
                if(message.getClient()!=null){
                    resultado.get().setClient(message.getClient());
                }
               
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    /**
     * DELETE
     * @param messageId
     * @return 
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            repository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
