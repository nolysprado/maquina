/*
 *  Servicio de Reservation
 */
package com.maquina.maquina.app.services;

import com.maquina.maquina.app.entities.ContadorClientes;
import com.maquina.maquina.app.entities.Reservation;
import com.maquina.maquina.app.entities.StatusReservas;
import com.maquina.maquina.app.repositories.ReservationRepository;
import com.maquina.maquina.repositories.crud.ReservationCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author yohan
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Reservation> getAll(){
        return repository.getAll();
    }
    
    /**
     * Buscar por ID
     * @param reservationId
     * @return 
     */
    public Optional<Reservation> getReservation(int reservationId){
        return repository.getReservation(reservationId);
    }
    
    /**
     * POST
     * @param reservation
     * @return 
     */
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return repository.save(reservation);
        }else{
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                return reservation;
            }else{
                return repository.save(reservation);
            }
        }
    }
    
    /**
     * UPDATE
     * @param client
     * @return 
     */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if(resultado.isPresent()){
                if(reservation.getStartDate()!=null){
                    resultado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    resultado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    resultado.get().setStatus(reservation.getStatus());
                }
                if(reservation.getClient()!=null){
                    resultado.get().setClient(reservation.getClient());
                }
                if(reservation.getScore()!=null){
                    resultado.get().setScore(reservation.getScore());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    /**
     * DELETE
     * @param reservationId
     * @return 
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    public StatusReservas reporteStatusServicio (){
        List<Reservation>completed= repository.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= repository.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return repository.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     public List<ContadorClientes> reporteClientesServicio(){
            return repository.getClientesRepositorio();
        } 
    

}
