/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDateTime;

/**
 *
 * @author Chiara Diaz
 */
public abstract class Base {
    
    private long id;
    private boolean eliminado;
    private LocalDateTime createdAt;

    public Base(long id, LocalDateTime createdAt,boolean eliminado) {
        this.id = id;
        this.createdAt = createdAt;
        this.eliminado = eliminado;
    }


    
    
    
    @Override
    public abstract String toString();

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
}
