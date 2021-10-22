/*
 * Respositorio de Score
 */
package com.maquina.maquina.app.repositories;

import com.maquina.maquina.app.entities.Score;
import com.maquina.maquina.repositories.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yohan
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    /**
     * Select
     * @return 
     */
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();

    
}
      
    /**
     * Insert
     * @param score
     * @return 
     */
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
    /**
     * Buscar registro
     * @param scoreId
     * @return 
     */
    public Optional<Score> getScore(int scoreId){
        return scoreCrudRepository.findById(scoreId);
    }
    /**
     * Delete
     * @param score 
     */
    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }
    
    
}
