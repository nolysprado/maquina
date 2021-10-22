/*
 *  Servicio de Score
 */
package com.maquina.maquina.app.services;

import com.maquina.maquina.app.entities.Score;
import com.maquina.maquina.app.repositories.ScoreRepository;
import com.maquina.maquina.repositories.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yohan
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Score> getAll(){
        return repository.getAll();
    }
    
    /**
     * Buscar por ID
     * @param scoretId
     * @return 
     */
    public Optional<Score> getScore(int scoreId){
        return repository.getScore(scoreId);
    }
    
    /**
     * POST
     * @param client
     * @return 
     */
    public Score save(Score score){
        if(score.getIdScore()==null){
            return repository.save(score);
        }else{
            Optional<Score> resultado = repository.getScore(score.getIdScore());
            if(resultado.isPresent()){
                return score;
            }else{
                return repository.save(score);
            }
        }
    }
    
    /**
     * UPDATE
     * @param score
     * @return 
     */
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> resultado = repository.getScore(score.getIdScore());
            if(resultado.isPresent()){
                if(score.getMessageText()!=null){
                    resultado.get().setMessageText(score.getMessageText());
                } 
                if(score.getStars()!=null){
                    resultado.get().setStars(score.getStars());
                }
                 if(score.getReservation()!=null){
                    resultado.get().setReservation(score.getReservation());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    
    /**
     * DELETE
     * @param ScoreId
     * @return 
     */
    public boolean deleteScore(int scoreId) {
        Boolean aBoolean = getScore(scoreId).map(score -> {
            repository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    
    
}
