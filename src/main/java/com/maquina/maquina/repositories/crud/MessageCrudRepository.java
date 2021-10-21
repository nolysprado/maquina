/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maquina.maquina.repositories.crud;


import com.maquina.maquina.app.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author yohan
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
    
}
