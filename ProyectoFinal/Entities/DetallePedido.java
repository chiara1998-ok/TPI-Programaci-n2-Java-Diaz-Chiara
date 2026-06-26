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
public class DetallePedido extends Base{
    
    private int cantidad;
    private double subtotal;
    private Producto producto;

    public DetallePedido(long id, LocalDateTime createdAt,boolean eliminado) {
        super(id, createdAt,eliminado);
    }
    
    public DetallePedido(int cantidad, Producto producto, long id, LocalDateTime createdAt,boolean eliminado) {
        super(id, createdAt,eliminado);
        this.cantidad = cantidad;
        this.producto = producto;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
  

     private double calcularSubtotal(){
        
        
        
        
        return  producto.getPrecio() * cantidad;
    } 

    @Override
    public String toString() {
        return "DetallePedido{" + " id: " + this.getId() + " cantidad= " + cantidad + " * "  + ", producto=" + producto + ", subtotal=" + getSubtotal() + '}';
    }

    

    public double getSubtotal() {
        
        this.subtotal = calcularSubtotal();
        return subtotal ;
    }

   

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
   
    
    
    
    
}
