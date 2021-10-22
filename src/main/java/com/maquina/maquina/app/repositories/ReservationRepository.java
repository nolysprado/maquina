/*
 * Respositorio de reservatio
 */
package com.maquina.maquina.app.repositories;

import com.maquina.maquina.app.entities.Reservation;
import com.maquina.maquina.repositories.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yohan
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    /**
     * Select
     * @return 
     */
      public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();

}
     
    
    /**
     * Insert
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    /**
     * Buscar registro
     * @param reservationId
     * @return 
     */
    public Optional<Reservation> getReservation(int reservationId){
        return reservationCrudRepository.findById(reservationId);
    }
    
    /**
     * Delete
     * @param reservation 
     */
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    

}