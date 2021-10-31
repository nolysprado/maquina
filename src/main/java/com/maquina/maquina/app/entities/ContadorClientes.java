/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maquina.maquina.app.entities;

/**
 *
 * @author yohan
 */
public class ContadorClientes {
    private long total;
    private Client clien;

    public ContadorClientes(long total, Client clien) {
        this.total = total;
        this.clien = clien;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClien() {
        return clien;
    }

    public void setClien(Client clien) {
        this.clien = clien;
    }
    
}
