/*
 * Esta es la entidad de Admin
 */
package com.maquina.maquina.app.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yohan
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admin") 
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdmin;
    private String email;
    private String password;
    private String name;

    
    
    
}
