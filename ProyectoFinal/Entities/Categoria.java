/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chiara Diaz
 */
public class Categoria extends Base {
    
    
    private String nombre;
    private String descripcion;
    private List<Producto> productos =new ArrayList<>();

    public Categoria(long id, LocalDateTime createdAt, boolean eliminado) {
        super(id, createdAt,eliminado);
    }

    public Categoria(String nombre, String descripcion, long id, LocalDateTime createdAt, boolean eliminado) {
        super(id, createdAt,eliminado);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

   

    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    public void agregarProducto(Producto producto){
    
        this.productos.add(producto);
    
    
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
